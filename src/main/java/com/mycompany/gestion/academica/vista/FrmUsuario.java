/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.CarreraController;
import com.mycompany.gestion.academica.controlador.EstudianteController;
import com.mycompany.gestion.academica.controlador.ProfesorController;
import com.mycompany.gestion.academica.modelo.Carrera;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ComboItem;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Registro unificado de estudiantes y profesores.
 */
public class FrmUsuario extends javax.swing.JFrame {

    private static final String TIPO_ESTUDIANTE = "Estudiante";
    private static final String TIPO_PROFESOR = "Profesor";

    private final EstudianteController estudianteController = new EstudianteController();
    private final ProfesorController profesorController = new ProfesorController();
    private final CarreraController carreraController = new CarreraController();
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    private String tipoSeleccionado = "";
    private int idSeleccionado;

    public FrmUsuario() {
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
                new String[]{"Tipo", "Código", "Nombre", "Dirección", "Teléfono", "Fecha nac.", "Carrera", "Profesión"}
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
        lblTipoUsuario = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblFechaNac = new javax.swing.JLabel();
        txtFechaNac = new javax.swing.JTextField();
        lblCarrera = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox<>();
        lblProfesion = new javax.swing.JLabel();
        txtProfesion = new javax.swing.JTextField();
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
        setTitle("Registro de Usuarios");
        setMinimumSize(new java.awt.Dimension(820, 560));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro de usuarios");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setText("Estudiantes y profesores en un solo módulo");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitulo)
                .addComponent(lblSubtitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del usuario"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblTipoUsuario.setText("Tipo de usuario:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblTipoUsuario, gbc);
        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-- Seleccione --", "Estudiante", "Profesor"}));
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbTipoUsuario, gbc);

        lblCodigo.setText("Código:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblCodigo, gbc);
        txtCodigo.setColumns(10);
        txtCodigo.setEditable(false);
        gbc.gridx = 1;
        pnlFormulario.add(txtCodigo, gbc);

        lblNombre.setText("Nombre:");
        gbc.gridx = 0; gbc.gridy = 2;
        pnlFormulario.add(lblNombre, gbc);
        txtNombre.setColumns(28);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtNombre, gbc);

        lblDireccion.setText("Dirección:");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblDireccion, gbc);
        txtDireccion.setColumns(28);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtDireccion, gbc);

        lblTelefono.setText("Teléfono:");
        gbc.gridx = 0; gbc.gridy = 4;
        pnlFormulario.add(lblTelefono, gbc);
        txtTelefono.setColumns(15);
        gbc.gridx = 1;
        pnlFormulario.add(txtTelefono, gbc);

        lblFechaNac.setText("Fecha de nacimiento:");
        gbc.gridx = 2;
        pnlFormulario.add(lblFechaNac, gbc);
        txtFechaNac.setColumns(12);
        txtFechaNac.setToolTipText("Formato: AAAA-MM-DD");
        gbc.gridx = 3;
        pnlFormulario.add(txtFechaNac, gbc);

        lblCarrera.setText("Carrera (estudiante):");
        gbc.gridx = 0; gbc.gridy = 5;
        pnlFormulario.add(lblCarrera, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlFormulario.add(cmbCarrera, gbc);

        lblProfesion.setText("Profesión (profesor):");
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblProfesion, gbc);
        txtProfesion.setColumns(22);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtProfesion, gbc);

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
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        btnGuardar.addActionListener(e -> guardarUsuario());
        btnModificar.addActionListener(e -> guardarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        cmbTipoUsuario.addActionListener(e -> actualizarCamposPorTipo());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarCombos() {
        try {
            DefaultComboBoxModel<ComboItem> modelo = new DefaultComboBoxModel<>();
            modelo.addElement(new ComboItem(0, "-- Seleccione --"));
            for (Carrera c : carreraController.listar()) {
                modelo.addElement(new ComboItem(c.getIdCarr(), c.getNomCarr()));
            }
            cmbCarrera.setModel(modelo);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void actualizarCamposPorTipo() {
        String tipo = (String) cmbTipoUsuario.getSelectedItem();
        boolean esEstudiante = TIPO_ESTUDIANTE.equals(tipo);
        boolean esProfesor = TIPO_PROFESOR.equals(tipo);
        txtFechaNac.setEnabled(esEstudiante);
        cmbCarrera.setEnabled(esEstudiante);
        txtProfesion.setEnabled(esProfesor);
    }

    private void cargarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (Estudiante e : estudianteController.listar()) {
                String carrera = e.getCarrera() != null ? e.getCarrera().getNomCarr() : "";
                String fecha = e.getFechNac() != null ? formatoFecha.format(e.getFechNac()) : "";
                modelo.addRow(new Object[]{TIPO_ESTUDIANTE, e.getCodE(), e.getNomE(), e.getDirE(), e.getTelE(), fecha, carrera, ""});
            }
            for (Profesor p : profesorController.listar()) {
                modelo.addRow(new Object[]{TIPO_PROFESOR, p.getIdP(), p.getNomP(), p.getDirP(), p.getTelP(), "", "", p.getProfesion()});
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void guardarUsuario() {
        String tipo = (String) cmbTipoUsuario.getSelectedItem();
        if (tipo == null || tipo.startsWith("--")) {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            if (TIPO_ESTUDIANTE.equals(tipo)) {
                Estudiante e = leerEstudiante();
                estudianteController.guardar(e);
            } else {
                Profesor p = leerProfesor();
                profesorController.guardar(p);
            }
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Usuario guardado correctamente.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarUsuario() {
        if (idSeleccionado <= 0 || tipoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar el registro seleccionado?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            if (TIPO_ESTUDIANTE.equals(tipoSeleccionado)) {
                estudianteController.eliminar(idSeleccionado);
            } else {
                profesorController.eliminar(idSeleccionado);
            }
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private Estudiante leerEstudiante() {
        Estudiante e = new Estudiante();
        e.setCodE(idSeleccionado);
        e.setNomE(txtNombre.getText().trim());
        e.setDirE(txtDireccion.getText().trim());
        e.setTelE(txtTelefono.getText().trim());
        e.setFechNac(estudianteController.parseFecha(txtFechaNac.getText().trim()));
        ComboItem carreraItem = (ComboItem) cmbCarrera.getSelectedItem();
        if (carreraItem != null && carreraItem.getId() > 0) {
            Carrera c = new Carrera();
            c.setIdCarr(carreraItem.getId());
            e.setCarrera(c);
        }
        return e;
    }

    private Profesor leerProfesor() {
        Profesor p = new Profesor();
        p.setIdP(idSeleccionado);
        p.setNomP(txtNombre.getText().trim());
        p.setDirP(txtDireccion.getText().trim());
        p.setTelP(txtTelefono.getText().trim());
        p.setProfesion(txtProfesion.getText().trim());
        return p;
    }

    private void cargarFilaSeleccionada(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        tipoSeleccionado = String.valueOf(modelo.getValueAt(fila, 0));
        idSeleccionado = (Integer) modelo.getValueAt(fila, 1);
        cmbTipoUsuario.setSelectedItem(tipoSeleccionado);
        txtCodigo.setText(String.valueOf(idSeleccionado));
        txtNombre.setText(String.valueOf(modelo.getValueAt(fila, 2)));
        txtDireccion.setText(modelo.getValueAt(fila, 3) != null ? String.valueOf(modelo.getValueAt(fila, 3)) : "");
        txtTelefono.setText(modelo.getValueAt(fila, 4) != null ? String.valueOf(modelo.getValueAt(fila, 4)) : "");
        if (TIPO_ESTUDIANTE.equals(tipoSeleccionado)) {
            txtFechaNac.setText(modelo.getValueAt(fila, 5) != null ? String.valueOf(modelo.getValueAt(fila, 5)) : "");
            txtProfesion.setText("");
            String nomCarrera = modelo.getValueAt(fila, 6) != null ? String.valueOf(modelo.getValueAt(fila, 6)) : "";
            seleccionarCarreraPorNombre(nomCarrera);
        } else {
            txtFechaNac.setText("");
            cmbCarrera.setSelectedIndex(0);
            txtProfesion.setText(modelo.getValueAt(fila, 7) != null ? String.valueOf(modelo.getValueAt(fila, 7)) : "");
        }
        actualizarCamposPorTipo();
    }

    private void seleccionarCarreraPorNombre(String nombre) {
        for (int i = 0; i < cmbCarrera.getItemCount(); i++) {
            ComboItem item = (ComboItem) cmbCarrera.getItemAt(i);
            if (item.getLabel().equals(nombre)) {
                cmbCarrera.setSelectedIndex(i);
                return;
            }
        }
        cmbCarrera.setSelectedIndex(0);
    }

    private void limpiarCampos() {
        tipoSeleccionado = "";
        idSeleccionado = 0;
        cmbTipoUsuario.setSelectedIndex(0);
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtFechaNac.setText("");
        cmbCarrera.setSelectedIndex(0);
        txtProfesion.setText("");
        tblDatos.clearSelection();
        actualizarCamposPorTipo();
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
    private javax.swing.JComboBox<ComboItem> cmbCarrera;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProfesion;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProfesion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
