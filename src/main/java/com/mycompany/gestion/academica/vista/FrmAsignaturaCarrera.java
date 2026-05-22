/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.AsignaturaController;
import com.mycompany.gestion.academica.controlador.CarreraController;
import com.mycompany.gestion.academica.controlador.IncluyeController;
import com.mycompany.gestion.academica.dao.IncluyeDAO.IncluyeDetalle;
import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.modelo.Carrera;
import com.mycompany.gestion.academica.util.ComboItem;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Asociar asignaturas a carreras (tabla Incluye).
 */
public class FrmAsignaturaCarrera extends javax.swing.JFrame {

    private final IncluyeController incluyeController = new IncluyeController();
    private final CarreraController carreraController = new CarreraController();
    private final AsignaturaController asignaturaController = new AsignaturaController();

    private int idCarrSeleccionado;
    private int codASeleccionado;

    public FrmAsignaturaCarrera() {
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
                new String[]{"ID Carrera", "Carrera", "Cód. Asignatura", "Asignatura"}
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
        lblCarrera = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox<>();
        lblAsignatura = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        pnlBotones = new javax.swing.JPanel();
        btnAsociar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignaturas por Carrera");
        setMinimumSize(new java.awt.Dimension(720, 460));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Asignaturas incluidas en carreras");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblTitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Asociación"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(8, 10, 8, 10);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblCarrera.setText("Carrera:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblCarrera, gbc);
        cmbCarrera.setPreferredSize(new java.awt.Dimension(320, 26));
        gbc.gridx = 1; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbCarrera, gbc);

        lblAsignatura.setText("Asignatura:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblAsignatura, gbc);
        cmbAsignatura.setPreferredSize(new java.awt.Dimension(320, 26));
        gbc.gridx = 1; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbAsignatura, gbc);

        btnAsociar.setText("Asociar");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");

        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
        pnlBotones.add(btnAsociar);
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
        btnAsociar.addActionListener(e -> asociar());
        btnEliminar.addActionListener(e -> eliminarAsociacion());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarCombos() {
        try {
            DefaultComboBoxModel<ComboItem> carrModel = new DefaultComboBoxModel<>();
            carrModel.addElement(new ComboItem(0, "-- Seleccione carrera --"));
            for (Carrera c : carreraController.listar()) {
                carrModel.addElement(new ComboItem(c.getIdCarr(), c.getIdCarr() + " - " + c.getNomCarr()));
            }
            cmbCarrera.setModel(carrModel);

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
            List<IncluyeDetalle> lista = incluyeController.listar();
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (IncluyeDetalle d : lista) {
                modelo.addRow(new Object[]{d.getIdCarr(), d.getNomCarr(), d.getCodA(), d.getNomA()});
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void asociar() {
        ComboItem carrera = (ComboItem) cmbCarrera.getSelectedItem();
        ComboItem asignatura = (ComboItem) cmbAsignatura.getSelectedItem();
        if (carrera.getId() <= 0 || asignatura.getId() <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione carrera y asignatura.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            incluyeController.asociar(carrera.getId(), asignatura.getId());
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Asociación registrada.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarAsociacion() {
        if (idCarrSeleccionado <= 0 || codASeleccionado <= 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar la asociación?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            incluyeController.eliminar(idCarrSeleccionado, codASeleccionado);
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarFilaSeleccionada(int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
        idCarrSeleccionado = (Integer) modelo.getValueAt(fila, 0);
        codASeleccionado = (Integer) modelo.getValueAt(fila, 2);
        seleccionarCombo(cmbCarrera, idCarrSeleccionado);
        seleccionarCombo(cmbAsignatura, codASeleccionado);
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
        idCarrSeleccionado = 0;
        codASeleccionado = 0;
        cmbCarrera.setSelectedIndex(0);
        cmbAsignatura.setSelectedIndex(0);
        tblDatos.clearSelection();
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsociar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<ComboItem> cmbAsignatura;
    private javax.swing.JComboBox<ComboItem> cmbCarrera;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;

    // End of variables declaration//GEN-END:variables
}
