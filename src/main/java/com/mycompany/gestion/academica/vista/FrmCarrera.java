/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.CarreraController;
import com.mycompany.gestion.academica.modelo.Carrera;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Vista: gestión de carreras. La lógica está en {@link CarreraController}.
 */
public class FrmCarrera extends javax.swing.JFrame {

    private final CarreraController carreraController = new CarreraController();
    private int idSeleccionado;

    public FrmCarrera() {
        initComponents();
        configurarTabla();
        configurarEventos();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    private void configurarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Régimen de calificación"}
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
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblRegimen = new javax.swing.JLabel();
        txtRegimen = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Carreras");
        setMinimumSize(new java.awt.Dimension(700, 480));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Carreras");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la carrera"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblId.setText("ID:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblId, gbc);
        txtId.setColumns(10);
        txtId.setEditable(false);
        gbc.gridx = 1;
        pnlFormulario.add(txtId, gbc);

        lblNombre.setText("Nombre:");
        gbc.gridx = 0; gbc.gridy = 1;
        pnlFormulario.add(lblNombre, gbc);
        txtNombre.setColumns(28);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtNombre, gbc);

        lblRegimen.setText("Régimen de calificación:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblRegimen, gbc);
        txtRegimen.setColumns(28);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtRegimen, gbc);

        btnNuevo.setText("Nuevo");
        btnGuardar.setText("Guardar");
        btnModificar.setText("Modificar");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");

        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnLimpiar);

        tblDatos.setRowHeight(24);
        scrollTabla.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE));
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurarEventos() {
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnGuardar.addActionListener(e -> guardarCarrera());
        btnModificar.addActionListener(e -> guardarCarrera());
        btnEliminar.addActionListener(e -> eliminarCarrera());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarTabla() {
        try {
            List<Carrera> carreras = carreraController.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (Carrera c : carreras) {
                modelo.addRow(new Object[]{c.getIdCarr(), c.getNomCarr(), c.getRegCalif()});
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void guardarCarrera() {
        try {
            Carrera carrera = leerFormulario();
            carreraController.guardar(carrera);
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Carrera guardada correctamente.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarCarrera() {
        if (idSeleccionado <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una carrera de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar la carrera seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            carreraController.eliminar(idSeleccionado);
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private Carrera leerFormulario() {
        Carrera carrera = new Carrera();
        carrera.setIdCarr(idSeleccionado);
        carrera.setNomCarr(txtNombre.getText().trim());
        carrera.setRegCalif(txtRegimen.getText().trim());
        return carrera;
    }

    private void cargarFilaSeleccionada(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        idSeleccionado = (Integer) modelo.getValueAt(fila, 0);
        txtId.setText(String.valueOf(idSeleccionado));
        txtNombre.setText(String.valueOf(modelo.getValueAt(fila, 1)));
        txtRegimen.setText(String.valueOf(modelo.getValueAt(fila, 2)));
    }

    private void limpiarCampos() {
        idSeleccionado = 0;
        txtId.setText("");
        txtNombre.setText("");
        txtRegimen.setText("");
        tblDatos.clearSelection();
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRegimen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegimen;
    // End of variables declaration//GEN-END:variables
}
