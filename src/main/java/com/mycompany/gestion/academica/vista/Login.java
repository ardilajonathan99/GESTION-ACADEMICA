/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.LoginController;
import com.mycompany.gestion.academica.modelo.TipoUsuario;
import javax.swing.JOptionPane;

/**
 * Pantalla de acceso al sistema.
 */
public class Login extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    private final LoginController loginController = new LoginController();

    public Login() {
        initComponents();
        configurarApariencia();
        configurarEventos();
        setLocationRelativeTo(null);
    }

    /** Colores en ejecución (Nimbus); tamaños y posición se editan en la pestaña Design. */
    private void configurarApariencia() {
        java.awt.Color azul = new java.awt.Color(41, 98, 155);
        cmbTipoUsuario.setBackground(java.awt.Color.WHITE);
        estilarBotonPrimario(btnIngresar, azul);
        btnSalir.setFocusPainted(false);
    }

    /** Look and feel usado al iniciar la aplicación (mismo criterio que el diseñador). */
    public static void aplicarLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            javax.swing.UIManager.put("ComboBox.background", java.awt.Color.WHITE);
            javax.swing.UIManager.put("ComboBox.foreground", java.awt.Color.BLACK);
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void estilarBotonPrimario(javax.swing.JButton boton, java.awt.Color fondo) {
        javax.swing.UIDefaults overrides = new javax.swing.UIDefaults();
        overrides.put("Button.background", new javax.swing.plaf.ColorUIResource(fondo));
        overrides.put("Button.foreground", new javax.swing.plaf.ColorUIResource(java.awt.Color.WHITE));
        overrides.put("Button[Enabled].textForeground", new javax.swing.plaf.ColorUIResource(java.awt.Color.WHITE));
        overrides.put("Button.contentAreaFilled", Boolean.TRUE);
        overrides.put("Button.opaque", Boolean.TRUE);
        boton.putClientProperty("Nimbus.Overrides", overrides);
        boton.putClientProperty("Nimbus.Overrides.InheritDefaults", true);

        boton.setContentAreaFilled(true);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setBackground(fondo);
        boton.setForeground(java.awt.Color.WHITE);
        boton.setFocusPainted(false);
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
        cmbTipoUsuario = new javax.swing.JComboBox();
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

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión Académica");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
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
        pnlCampos.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        lblTipoUsuario.setText("Tipo de usuario:");

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione --", "Administrador", "Estudiante", "Profesor" }));
        cmbTipoUsuario.setPreferredSize(new java.awt.Dimension(352, 28));

        lblUsuario.setText("Usuario:");

        txtUsuario.setColumns(22);
        txtUsuario.setPreferredSize(new java.awt.Dimension(352, 26));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        lblContrasena.setText("Contraseña:");

        txtContrasena.setColumns(22);
        txtContrasena.setPreferredSize(new java.awt.Dimension(352, 26));

        btnIngresar.setBackground(new java.awt.Color(41, 98, 155));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFocusPainted(false);
        btnIngresar.setPreferredSize(new java.awt.Dimension(72, 28));

        btnSalir.setText("Salir");
        btnSalir.setPreferredSize(new java.awt.Dimension(72, 28));

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cmbTipoUsuario, 0, 392, Short.MAX_VALUE)
            .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addComponent(lblTipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

    /** Enlaza botones aquí para que NetBeans no los quite al guardar el .form */
    private void configurarEventos() {
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        txtContrasena.addActionListener(this::btnIngresarActionPerformed);
        btnIngresar.setEnabled(true);
        btnIngresar.setFocusable(true);
    }

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    public static void main(String args[]) {
        aplicarLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbTipoUsuario;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
