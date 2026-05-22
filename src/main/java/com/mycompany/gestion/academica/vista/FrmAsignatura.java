/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.AsignaturaController;
import com.mycompany.gestion.academica.modelo.Asignatura;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Vista: gestión de asignaturas.
 */
public class FrmAsignatura extends javax.swing.JFrame {

    private final AsignaturaController asignaturaController = new AsignaturaController();
    private int idSeleccionado;

    public FrmAsignatura() {
        initComponents();
        configurarTabla();
        configurarEventos();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    private void configurarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Código", "Nombre", "Intensidad horaria", "Créditos"}
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
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblIntensidad = new javax.swing.JLabel();
        txtIntensidad = new javax.swing.JTextField();
        lblCreditos = new javax.swing.JLabel();
        txtCreditos = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Asignaturas");
        setMinimumSize(new java.awt.Dimension(720, 500));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Asignaturas");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la asignatura"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblCodigo.setText("Código:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblCodigo, gbc);
        txtCodigo.setColumns(10);
        txtCodigo.setEditable(false);
        gbc.gridx = 1;
        pnlFormulario.add(txtCodigo, gbc);

        lblNombre.setText("Nombre:");
        gbc.gridx = 0; gbc.gridy = 1;
        pnlFormulario.add(lblNombre, gbc);
        txtNombre.setColumns(28);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtNombre, gbc);

        lblIntensidad.setText("Intensidad horaria:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblIntensidad, gbc);
        txtIntensidad.setColumns(10);
        gbc.gridx = 1;
        pnlFormulario.add(txtIntensidad, gbc);

        lblCreditos.setText("Créditos:");
        gbc.gridx = 2;
        pnlFormulario.add(lblCreditos, gbc);
        txtCreditos.setColumns(10);
        gbc.gridx = 3;
        pnlFormulario.add(txtCreditos, gbc);

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
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE));
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
        btnGuardar.addActionListener(e -> guardarAsignatura());
        btnModificar.addActionListener(e -> guardarAsignatura());
        btnEliminar.addActionListener(e -> eliminarAsignatura());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarTabla() {
        try {
            List<Asignatura> lista = asignaturaController.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (Asignatura a : lista) {
                modelo.addRow(new Object[]{a.getCodA(), a.getNomA(), a.getIntH(), a.getCreditos()});
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void guardarAsignatura() {
        try {
            asignaturaController.guardar(leerFormulario());
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Asignatura guardada correctamente.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarAsignatura() {
        if (idSeleccionado <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una asignatura de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar la asignatura seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            asignaturaController.eliminar(idSeleccionado);
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private Asignatura leerFormulario() {
        Asignatura a = new Asignatura();
        a.setCodA(idSeleccionado);
        a.setNomA(txtNombre.getText().trim());
        String intText = txtIntensidad.getText().trim();
        a.setIntH(intText.isEmpty() ? 0 : Integer.parseInt(intText));
        String credText = txtCreditos.getText().trim();
        a.setCreditos(credText.isEmpty() ? 0 : Double.parseDouble(credText));
        return a;
    }

    private void cargarFilaSeleccionada(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        idSeleccionado = (Integer) modelo.getValueAt(fila, 0);
        txtCodigo.setText(String.valueOf(idSeleccionado));
        txtNombre.setText(String.valueOf(modelo.getValueAt(fila, 1)));
        txtIntensidad.setText(String.valueOf(modelo.getValueAt(fila, 2)));
        txtCreditos.setText(String.valueOf(modelo.getValueAt(fila, 3)));
    }

    private void limpiarCampos() {
        idSeleccionado = 0;
        txtCodigo.setText("");
        txtNombre.setText("");
        txtIntensidad.setText("");
        txtCreditos.setText("");
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
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCreditos;
    private javax.swing.JLabel lblIntensidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtIntensidad;
    private javax.swing.JTextField txtNombre;

    // End of variables declaration//GEN-END:variables
}
