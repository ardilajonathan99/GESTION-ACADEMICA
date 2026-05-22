/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.EstudianteController;
import com.mycompany.gestion.academica.controlador.NotaController;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.util.ComboItem;
import com.mycompany.gestion.academica.util.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Registro de notas de cursos ya inscritos.
 */
public class FrmNotas extends javax.swing.JFrame {

    private final NotaController notaController = new NotaController();
    private final EstudianteController estudianteController = new EstudianteController();
    private final List<InscripcionDetalle> cursosEstudiante = new ArrayList<>();
    private final List<InscripcionDetalle> registrosTabla = new ArrayList<>();
    private final boolean modoProfesor;

    private int codESeleccionado;
    private int codASeleccionado;
    private int idPSeleccionado;
    private String grupoSeleccionado = "";

    public FrmNotas() {
        modoProfesor = Sesion.esProfesor();
        initComponents();
        configurarTabla();
        configurarVistaPorRol();
        configurarEventos();
        if (!modoProfesor) {
            cargarCombos();
        }
        cargarTabla();
        setLocationRelativeTo(null);
    }

    private void configurarVistaPorRol() {
        if (modoProfesor) {
            lblSubtitulo.setText("Seleccione un registro en la tabla (solo sus cursos) para registrar notas");
            pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas del registro seleccionado"));
            lblEstudiante.setVisible(false);
            cmbEstudiante.setVisible(false);
            lblCursoInscrito.setVisible(false);
            cmbCursoInscrito.setVisible(false);
            btnNuevo.setVisible(false);
            btnCalcular.setVisible(false);
        }
    }

    private static class CursoInscritoItem {

        private final InscripcionDetalle detalle;

        CursoInscritoItem(InscripcionDetalle detalle) {
            this.detalle = detalle;
        }

        InscripcionDetalle getDetalle() {
            return detalle;
        }

        @Override
        public String toString() {
            return detalle.etiquetaCurso();
        }
    }

    private void configurarEventos() {
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnGuardar.addActionListener(e -> guardarNotas());
        btnModificar.addActionListener(e -> guardarNotas());
        btnEliminar.addActionListener(e -> limpiarNotas());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        if (!modoProfesor) {
            btnCalcular.addActionListener(e -> calcularDefinitiva());
            cmbEstudiante.addActionListener(e -> cargarCursosPorEstudiante());
            cmbCursoInscrito.addActionListener(e -> cargarNotasDelCurso());
        }
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarCombos() {
        try {
            DefaultComboBoxModel<ComboItem> estModel = new DefaultComboBoxModel<>();
            estModel.addElement(new ComboItem(0, "-- Seleccione --"));
            for (Estudiante e : estudianteController.listar()) {
                estModel.addElement(new ComboItem(e.getCodE(), e.getCodE() + " - " + e.getNomE()));
            }
            cmbEstudiante.setModel(estModel);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarCursosPorEstudiante() {
        ComboItem estItem = (ComboItem) cmbEstudiante.getSelectedItem();
        DefaultComboBoxModel<CursoInscritoItem> cursoModel = new DefaultComboBoxModel<>();
        cursosEstudiante.clear();
        txtN1.setText("");
        txtN2.setText("");
        txtN3.setText("");
        txtDefinitiva.setText("");
        if (estItem == null || estItem.getId() <= 0) {
            cmbCursoInscrito.setModel(cursoModel);
            return;
        }
        try {
            List<InscripcionDetalle> lista = notaController.listarPorEstudiante(estItem.getId());
            cursosEstudiante.addAll(lista);
            for (InscripcionDetalle d : lista) {
                cursoModel.addElement(new CursoInscritoItem(d));
            }
            cmbCursoInscrito.setModel(cursoModel);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarNotasDelCurso() {
        CursoInscritoItem item = (CursoInscritoItem) cmbCursoInscrito.getSelectedItem();
        if (item == null) {
            return;
        }
        cargarDetalleDesde(item.getDetalle());
    }

    private void cargarTabla() {
        try {
            registrosTabla.clear();
            registrosTabla.addAll(notaController.listarParaRegistro());
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (InscripcionDetalle d : registrosTabla) {
                modelo.addRow(new Object[]{
                    d.getNomEstudiante(),
                    d.etiquetaCurso(),
                    formatoNota(d.getN1()),
                    formatoNota(d.getN2()),
                    formatoNota(d.getN3()),
                    d.getDefinitiva() != null ? String.format("%.2f", d.getDefinitiva()) : ""
                });
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private String formatoNota(Double nota) {
        return nota != null ? String.format("%.2f", nota) : "";
    }

    private void guardarNotas() {
        if (codESeleccionado <= 0 || codASeleccionado <= 0 || idPSeleccionado <= 0 || grupoSeleccionado.isEmpty()) {
            String aviso = modoProfesor
                    ? "Seleccione un registro en la tabla."
                    : "Seleccione estudiante y curso inscrito.";
            JOptionPane.showMessageDialog(this, aviso, "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            double n1 = Double.parseDouble(txtN1.getText().trim());
            double n2 = Double.parseDouble(txtN2.getText().trim());
            double n3 = Double.parseDouble(txtN3.getText().trim());
            double definitiva = notaController.calcularDefinitiva(n1, n2, n3);
            notaController.registrarNotas(codESeleccionado, codASeleccionado, idPSeleccionado, grupoSeleccionado, n1, n2, n3);
            txtDefinitiva.setText(String.format("%.2f", definitiva));
            int filaGuardada = tblDatos.getSelectedRow();
            cargarTabla();
            if (filaGuardada >= 0 && filaGuardada < registrosTabla.size()) {
                tblDatos.setRowSelectionInterval(filaGuardada, filaGuardada);
                cargarDetalleDesde(registrosTabla.get(filaGuardada));
            } else if (!modoProfesor) {
                cargarCursosPorEstudiante();
            }
            JOptionPane.showMessageDialog(this, "Notas guardadas. Definitiva: " + String.format("%.2f", definitiva));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese notas numéricas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void limpiarNotas() {
        if (codESeleccionado <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            notaController.registrarNotas(codESeleccionado, codASeleccionado, idPSeleccionado, grupoSeleccionado, 0, 0, 0);
            cargarTabla();
            if (!modoProfesor) {
                cargarCursosPorEstudiante();
            }
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarFilaSeleccionada(int fila) {
        if (fila < 0 || fila >= registrosTabla.size()) {
            return;
        }
        if (modoProfesor) {
            cargarDetalleDesde(registrosTabla.get(fila));
            return;
        }
        try {
            InscripcionDetalle d = registrosTabla.get(fila);
            seleccionarCombo(cmbEstudiante, d.getCodE());
            cargarCursosPorEstudiante();
            for (int i = 0; i < cmbCursoInscrito.getItemCount(); i++) {
                CursoInscritoItem item = cmbCursoInscrito.getItemAt(i);
                if (item.getDetalle().getCodA() == d.getCodA()
                        && item.getDetalle().getIdP() == d.getIdP()
                        && item.getDetalle().getGrupo().equals(d.getGrupo())) {
                    cmbCursoInscrito.setSelectedIndex(i);
                    break;
                }
            }
            cargarNotasDelCurso();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarDetalleDesde(InscripcionDetalle d) {
        codESeleccionado = d.getCodE();
        codASeleccionado = d.getCodA();
        idPSeleccionado = d.getIdP();
        grupoSeleccionado = d.getGrupo();
        txtN1.setText(d.getN1() != null ? String.valueOf(d.getN1()) : "");
        txtN2.setText(d.getN2() != null ? String.valueOf(d.getN2()) : "");
        txtN3.setText(d.getN3() != null ? String.valueOf(d.getN3()) : "");
        if (d.getDefinitiva() != null) {
            txtDefinitiva.setText(String.format("%.2f", d.getDefinitiva()));
        } else {
            txtDefinitiva.setText("");
        }
    }

    private void seleccionarCombo(javax.swing.JComboBox<ComboItem> combo, int id) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (combo.getItemAt(i).getId() == id) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    private void limpiarCampos() {
        codESeleccionado = 0;
        codASeleccionado = 0;
        idPSeleccionado = 0;
        grupoSeleccionado = "";
        txtN1.setText("");
        txtN2.setText("");
        txtN3.setText("");
        txtDefinitiva.setText("");
        if (!modoProfesor) {
            cmbEstudiante.setSelectedIndex(0);
            cargarCursosPorEstudiante();
        }
        tblDatos.clearSelection();
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void calcularDefinitiva() {
        try {
            double n1 = Double.parseDouble(txtN1.getText().trim());
            double n2 = Double.parseDouble(txtN2.getText().trim());
            double n3 = Double.parseDouble(txtN3.getText().trim());
            double definitiva = notaController.calcularDefinitiva(n1, n2, n3);
            txtDefinitiva.setText(String.format("%.2f", definitiva));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese notas numéricas válidas.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Estudiante", "Curso inscrito", "N1", "N2", "N3", "Definitiva"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tblDatos.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlFormulario = new javax.swing.JPanel();
        lblEstudiante = new javax.swing.JLabel();
        cmbEstudiante = new javax.swing.JComboBox<>();
        lblCursoInscrito = new javax.swing.JLabel();
        cmbCursoInscrito = new javax.swing.JComboBox<>();
        lblN1 = new javax.swing.JLabel();
        txtN1 = new javax.swing.JTextField();
        lblN2 = new javax.swing.JLabel();
        txtN2 = new javax.swing.JTextField();
        lblN3 = new javax.swing.JLabel();
        txtN3 = new javax.swing.JTextField();
        lblDefinitiva = new javax.swing.JLabel();
        txtDefinitiva = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Notas");
        setMinimumSize(new java.awt.Dimension(860, 580));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro de notas");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setText("Definitiva = N1 x 35% + N2 x 35% + N3 x 30%");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitulo)
                .addComponent(lblSubtitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Notas del curso inscrito"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblEstudiante.setText("Estudiante:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblEstudiante, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbEstudiante, gbc);

        lblCursoInscrito.setText("Curso inscrito:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblCursoInscrito, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbCursoInscrito, gbc);

        lblN1.setText("Nota N1 (35%):");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblN1, gbc);
        txtN1.setColumns(6);
        txtN1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 1;
        pnlFormulario.add(txtN1, gbc);

        lblN2.setText("Nota N2 (35%):");
        gbc.gridx = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblN2, gbc);
        txtN2.setColumns(6);
        txtN2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 3;
        pnlFormulario.add(txtN2, gbc);

        lblN3.setText("Nota N3 (30%):");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblN3, gbc);
        txtN3.setColumns(6);
        txtN3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 1;
        pnlFormulario.add(txtN3, gbc);

        lblDefinitiva.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDefinitiva.setText("Definitiva:");
        gbc.gridx = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblDefinitiva, gbc);
        txtDefinitiva.setColumns(8);
        txtDefinitiva.setEditable(false);
        txtDefinitiva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDefinitiva.setFont(new java.awt.Font("Segoe UI", 1, 13));
        gbc.gridx = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 0.5;
        pnlFormulario.add(txtDefinitiva, gbc);

        btnNuevo.setText("Nuevo");
        btnGuardar.setText("Guardar");
        btnModificar.setText("Modificar");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");
        btnCalcular.setText("Calcular");

        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnLimpiar);
        pnlBotones.add(btnCalcular);

        tblDatos.setRowHeight(24);
        scrollTabla.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<CursoInscritoItem> cmbCursoInscrito;
    private javax.swing.JComboBox<ComboItem> cmbEstudiante;
    private javax.swing.JLabel lblCursoInscrito;
    private javax.swing.JLabel lblDefinitiva;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblN1;
    private javax.swing.JLabel lblN2;
    private javax.swing.JLabel lblN3;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtDefinitiva;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
    private javax.swing.JTextField txtN3;
    // End of variables declaration//GEN-END:variables
}
