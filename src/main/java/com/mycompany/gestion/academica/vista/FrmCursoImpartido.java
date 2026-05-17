/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.AsignaturaController;
import com.mycompany.gestion.academica.controlador.ImparteController;
import com.mycompany.gestion.academica.controlador.ProfesorController;
import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ComboItem;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Cursos impartidos por profesores (tabla Imparte).
 */
public class FrmCursoImpartido extends javax.swing.JFrame {

    private final ImparteController imparteController = new ImparteController();
    private final ProfesorController profesorController = new ProfesorController();
    private final AsignaturaController asignaturaController = new AsignaturaController();

    private int idPSeleccionado;
    private int codASeleccionado;
    private String grupoSeleccionado = "";

    public FrmCursoImpartido() {
        initComponents();
        configurarTabla();
        configurarEventos();
        cargarCombos();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    private void configurarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID Prof.", "Profesor", "Cód. Asig.", "Asignatura", "Grupo", "Horario"}
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
        pnlFormulario = new javax.swing.JPanel();
        lblProfesor = new javax.swing.JLabel();
        cmbProfesor = new javax.swing.JComboBox<>();
        lblAsignatura = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        lblGrupo = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        lblHorario = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cursos Impartidos");
        setMinimumSize(new java.awt.Dimension(800, 520));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Cursos impartidos por profesores");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del curso"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblProfesor.setText("Profesor:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblProfesor, gbc);
        cmbProfesor.setPreferredSize(new java.awt.Dimension(300, 26));
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbProfesor, gbc);

        lblAsignatura.setText("Asignatura:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        pnlFormulario.add(lblAsignatura, gbc);
        cmbAsignatura.setPreferredSize(new java.awt.Dimension(300, 26));
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlFormulario.add(cmbAsignatura, gbc);

        lblGrupo.setText("Grupo:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblGrupo, gbc);
        txtGrupo.setColumns(10);
        gbc.gridx = 1;
        pnlFormulario.add(txtGrupo, gbc);

        lblHorario.setText("Horario:");
        gbc.gridx = 2;
        pnlFormulario.add(lblHorario, gbc);
        txtHorario.setColumns(25);
        gbc.gridx = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtHorario, gbc);

        btnNuevo.setText("Nuevo");
        btnGuardar.setText("Guardar");
        btnModificar.setText("Modificar");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnLimpiar);
        pnlBotones.add(btnCerrar);

        tblDatos.setRowHeight(24);
        scrollTabla.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void configurarEventos() {
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnGuardar.addActionListener(e -> guardarCurso());
        btnModificar.addActionListener(e -> guardarCurso());
        btnEliminar.addActionListener(e -> eliminarCurso());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarCombos() {
        try {
            DefaultComboBoxModel<ComboItem> profModel = new DefaultComboBoxModel<>();
            profModel.addElement(new ComboItem(0, "-- Seleccione profesor --"));
            for (Profesor p : profesorController.listar()) {
                profModel.addElement(new ComboItem(p.getIdP(), p.getIdP() + " - " + p.getNomP()));
            }
            cmbProfesor.setModel(profModel);

            DefaultComboBoxModel<ComboItem> asigModel = new DefaultComboBoxModel<>();
            asigModel.addElement(new ComboItem(0, "-- Seleccione asignatura --"));
            for (Asignatura a : asignaturaController.listar()) {
                asigModel.addElement(new ComboItem(a.getCodA(), a.getCodA() + " - " + a.getNomA()));
            }
            cmbAsignatura.setModel(asigModel);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarTabla() {
        try {
            List<CursoImpartido> lista = imparteController.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (CursoImpartido c : lista) {
                modelo.addRow(new Object[]{
                    c.getProfesor().getIdP(),
                    c.getProfesor().getNomP(),
                    c.getAsignatura().getCodA(),
                    c.getAsignatura().getNomA(),
                    c.getGrupo(),
                    c.getHorario()
                });
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void guardarCurso() {
        try {
            CursoImpartido curso = leerFormulario();
            if (idPSeleccionado > 0 && codASeleccionado > 0 && !grupoSeleccionado.isEmpty()) {
                imparteController.actualizar(curso, idPSeleccionado, codASeleccionado, grupoSeleccionado);
            } else {
                imparteController.guardar(curso);
            }
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Curso guardado correctamente.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarCurso() {
        if (idPSeleccionado <= 0 || codASeleccionado <= 0 || grupoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un curso de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar el curso seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            imparteController.eliminar(idPSeleccionado, codASeleccionado, grupoSeleccionado);
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private CursoImpartido leerFormulario() {
        ComboItem profItem = (ComboItem) cmbProfesor.getSelectedItem();
        ComboItem asigItem = (ComboItem) cmbAsignatura.getSelectedItem();
        Profesor p = new Profesor();
        p.setIdP(profItem.getId());
        Asignatura a = new Asignatura();
        a.setCodA(asigItem.getId());
        return new CursoImpartido(p, a, txtGrupo.getText().trim(), txtHorario.getText().trim());
    }

    private void cargarFilaSeleccionada(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        idPSeleccionado = (Integer) modelo.getValueAt(fila, 0);
        codASeleccionado = (Integer) modelo.getValueAt(fila, 2);
        grupoSeleccionado = String.valueOf(modelo.getValueAt(fila, 4));
        seleccionarCombo(cmbProfesor, idPSeleccionado);
        seleccionarCombo(cmbAsignatura, codASeleccionado);
        txtGrupo.setText(grupoSeleccionado);
        txtHorario.setText(String.valueOf(modelo.getValueAt(fila, 5)));
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
        idPSeleccionado = 0;
        codASeleccionado = 0;
        grupoSeleccionado = "";
        cmbProfesor.setSelectedIndex(0);
        cmbAsignatura.setSelectedIndex(0);
        txtGrupo.setText("");
        txtHorario.setText("");
        tblDatos.clearSelection();
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<ComboItem> cmbAsignatura;
    private javax.swing.JComboBox<ComboItem> cmbProfesor;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtHorario;

    // End of variables declaration//GEN-END:variables
}
