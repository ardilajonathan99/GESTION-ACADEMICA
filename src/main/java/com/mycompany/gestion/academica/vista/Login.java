/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.LoginController;
import com.mycompany.gestion.academica.modelo.TipoUsuario;
import com.mycompany.gestion.academica.servicio.AutenticacionService;
import javax.swing.JOptionPane;

/**
 * Pantalla de acceso al sistema.
 */
public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private final LoginController loginController = new LoginController();

    public Login() {
        initComponents();
        configurarEventos();
        actualizarEtiquetaUsuario();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenedor = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlCampos = new javax.swing.JPanel();
        lblTipoUsuario = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Académica - Acceso");
        setResizable(false);

        pnlContenedor.setBackground(new java.awt.Color(245, 247, 250));
        pnlContenedor.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 24, 20, 24));

        pnlEncabezado.setBackground(new java.awt.Color(41, 98, 155));
        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión Académica");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitulo.setText("Ingrese sus credenciales para continuar");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
            .addComponent(lblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo))
        );

        pnlCampos.setBackground(new java.awt.Color(255, 255, 255));
        pnlCampos.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 218, 228)),
                javax.swing.BorderFactory.createEmptyBorder(24, 24, 24, 24)));
        pnlCampos.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 4, 6, 4);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblTipoUsuario.setText("Tipo de usuario:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlCampos.add(lblTipoUsuario, gbc);
        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{
            "-- Seleccione --", "Administrador", "Estudiante", "Profesor"
        }));
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlCampos.add(cmbTipoUsuario, gbc);

        lblUsuario.setText("Usuario:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlCampos.add(lblUsuario, gbc);
        txtUsuario.setColumns(22);
        gbc.gridx = 0; gbc.gridy = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlCampos.add(txtUsuario, gbc);

        lblContrasena.setText("Contraseña:");
        gbc.gridx = 0; gbc.gridy = 4; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlCampos.add(lblContrasena, gbc);
        txtContrasena.setColumns(22);
        gbc.gridx = 0; gbc.gridy = 5; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlCampos.add(txtContrasena, gbc);

        btnIngresar.setBackground(new java.awt.Color(41, 98, 155));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFocusPainted(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        gbc.gridx = 0; gbc.gridy = 6; gbc.insets = new java.awt.Insets(16, 4, 4, 4);
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlCampos.add(btnIngresar, gbc);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        gbc.gridy = 7; gbc.insets = new java.awt.Insets(4, 4, 4, 4);
        pnlCampos.add(btnSalir, gbc);

        javax.swing.GroupLayout pnlContenedorLayout = new javax.swing.GroupLayout(pnlContenedor);
        pnlContenedor.setLayout(pnlContenedorLayout);
        pnlContenedorLayout.setHorizontalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlContenedorLayout.setVerticalGroup(
            pnlContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorLayout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            TipoUsuario tipo = LoginController.parsearTipo((String) cmbTipoUsuario.getSelectedItem());
            String usuario = txtUsuario.getText().trim();
            String clave = new String(txtContrasena.getPassword());
            loginController.ingresar(tipo, usuario, clave);
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            dispose();
        } catch (Exception ex) {
            String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
            JOptionPane.showMessageDialog(this, mensaje, "Acceso denegado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void configurarEventos() {
        cmbTipoUsuario.addActionListener(e -> actualizarEtiquetaUsuario());
    }

    private void actualizarEtiquetaUsuario() {
        String tipo = (String) cmbTipoUsuario.getSelectedItem();
        if ("Administrador".equals(tipo)) {
            lblUsuario.setText("Usuario (admin):");
            txtUsuario.setToolTipText("Usuario: " + AutenticacionService.ADMIN_USUARIO);
        } else if ("Estudiante".equals(tipo)) {
            lblUsuario.setText("Código de estudiante:");
            txtUsuario.setToolTipText("Código numérico registrado en Estudiantes");
        } else if ("Profesor".equals(tipo)) {
            lblUsuario.setText("ID de profesor:");
            txtUsuario.setToolTipText("ID numérico registrado en Profesores");
        } else {
            lblUsuario.setText("Usuario:");
            txtUsuario.setToolTipText(null);
        }
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
