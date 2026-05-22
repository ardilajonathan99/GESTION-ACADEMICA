/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.util.Sesion;
import java.awt.GridLayout;

/**
 * Menú principal de navegación hacia los módulos del sistema.
 */
public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
        configurarMenuPorRol();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnCarreras = new javax.swing.JButton();
        btnAsignaturas = new javax.swing.JButton();
        btnRegistroUsuarios = new javax.swing.JButton();
        btnAsignaturaCarrera = new javax.swing.JButton();
        btnRequisitos = new javax.swing.JButton();
        btnCursosImpartidos = new javax.swing.JButton();
        btnAsignacionCursos = new javax.swing.JButton();
        btnInscripciones = new javax.swing.JButton();
        btnRegistroNotas = new javax.swing.JButton();
        btnConsultaNotas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión Académica - Menú Principal");
        setMinimumSize(new java.awt.Dimension(520, 480));

        pnlEncabezado.setBackground(new java.awt.Color(41, 98, 155));
        pnlEncabezado.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 20, 16, 20));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 22));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Sistema de Gestión Académica");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setText("Seleccione el módulo que desea administrar");

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSubtitulo)
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEncabezadoLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo))
        );

        pnlBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 24, 20, 24));

        java.awt.Dimension tamBoton = new java.awt.Dimension(220, 42);

        btnCarreras.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCarreras.setMinimumSize(tamBoton);
        btnCarreras.setPreferredSize(tamBoton);
        btnCarreras.setText("Carreras");
        btnCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrerasActionPerformed(evt);
            }
        });

        btnAsignaturas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnAsignaturas.setMinimumSize(tamBoton);
        btnAsignaturas.setPreferredSize(tamBoton);
        btnAsignaturas.setText("Asignaturas");
        btnAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignaturasActionPerformed(evt);
            }
        });

        btnRegistroUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnRegistroUsuarios.setMinimumSize(tamBoton);
        btnRegistroUsuarios.setPreferredSize(tamBoton);
        btnRegistroUsuarios.setText("Registro de Usuarios");
        btnRegistroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroUsuariosActionPerformed(evt);
            }
        });

        btnAsignaturaCarrera.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnAsignaturaCarrera.setMinimumSize(tamBoton);
        btnAsignaturaCarrera.setPreferredSize(tamBoton);
        btnAsignaturaCarrera.setText("Asignaturas por Carrera");
        btnAsignaturaCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignaturaCarreraActionPerformed(evt);
            }
        });

        btnRequisitos.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnRequisitos.setMinimumSize(tamBoton);
        btnRequisitos.setPreferredSize(tamBoton);
        btnRequisitos.setText("Requisitos de Asignaturas");
        btnRequisitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequisitosActionPerformed(evt);
            }
        });

        btnCursosImpartidos.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCursosImpartidos.setMinimumSize(tamBoton);
        btnCursosImpartidos.setPreferredSize(tamBoton);
        btnCursosImpartidos.setText("Cursos Impartidos");
        btnCursosImpartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosImpartidosActionPerformed(evt);
            }
        });

        btnAsignacionCursos.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnAsignacionCursos.setMinimumSize(tamBoton);
        btnAsignacionCursos.setPreferredSize(tamBoton);
        btnAsignacionCursos.setText("Asignación de Cursos");
        btnAsignacionCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignacionCursosActionPerformed(evt);
            }
        });

        btnRegistroNotas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnRegistroNotas.setMinimumSize(tamBoton);
        btnRegistroNotas.setPreferredSize(tamBoton);
        btnRegistroNotas.setText("Registro de Notas");
        btnRegistroNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroNotasActionPerformed(evt);
            }
        });

        btnInscripciones.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnInscripciones.setMinimumSize(tamBoton);
        btnInscripciones.setPreferredSize(tamBoton);
        btnInscripciones.setText("Inscripciones");
        btnInscripciones.addActionListener(evt -> abrirFormulario(new FrmAsignacionCursos()));

        btnConsultaNotas.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnConsultaNotas.setMinimumSize(tamBoton);
        btnConsultaNotas.setPreferredSize(tamBoton);
        btnConsultaNotas.setText("Consulta de Notas");
        btnConsultaNotas.addActionListener(evt -> abrirFormulario(new FrmConsultaNotas()));

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        pnlBotones.setLayout(new java.awt.GridLayout(4, 2, 12, 12));
        pnlBotones.add(btnCarreras);
        pnlBotones.add(btnAsignaturas);
        pnlBotones.add(btnRegistroUsuarios);
        pnlBotones.add(btnAsignaturaCarrera);
        pnlBotones.add(btnRequisitos);
        pnlBotones.add(btnCursosImpartidos);
        pnlBotones.add(btnAsignacionCursos);
        pnlBotones.add(btnRegistroNotas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrerasActionPerformed
        abrirFormulario(new FrmCarrera());
    }//GEN-LAST:event_btnCarrerasActionPerformed

    private void btnAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaturasActionPerformed
        abrirFormulario(new FrmAsignatura());
    }//GEN-LAST:event_btnAsignaturasActionPerformed

    private void btnRegistroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroUsuariosActionPerformed
        abrirFormulario(new FrmUsuario());
    }//GEN-LAST:event_btnRegistroUsuariosActionPerformed

    private void btnAsignaturaCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaturaCarreraActionPerformed
        abrirFormulario(new FrmAsignaturaCarrera());
    }//GEN-LAST:event_btnAsignaturaCarreraActionPerformed

    private void btnRequisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequisitosActionPerformed
        abrirFormulario(new FrmRequisitoAsignatura());
    }//GEN-LAST:event_btnRequisitosActionPerformed

    private void btnCursosImpartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosImpartidosActionPerformed
        abrirFormulario(new FrmCursoImpartido());
    }//GEN-LAST:event_btnCursosImpartidosActionPerformed

    private void btnAsignacionCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignacionCursosActionPerformed
        abrirFormulario(new FrmAsignacionCursos());
    }//GEN-LAST:event_btnAsignacionCursosActionPerformed

    private void btnRegistroNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroNotasActionPerformed
        abrirFormulario(new FrmNotas());
    }//GEN-LAST:event_btnRegistroNotasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Sesion.cerrar();
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void configurarMenuPorRol() {
        if (!Sesion.haySesion()) {
            return;
        }

        boolean admin = Sesion.esAdmin();
        boolean estudiante = Sesion.esEstudiante();
        boolean profesor = Sesion.esProfesor();

        btnCarreras.setVisible(admin);
        btnAsignaturas.setVisible(admin);
        btnRegistroUsuarios.setVisible(admin);
        btnAsignaturaCarrera.setVisible(admin);
        btnRequisitos.setVisible(admin);
        btnCursosImpartidos.setVisible(admin || profesor);
        btnAsignacionCursos.setVisible(admin);
        btnInscripciones.setVisible(estudiante);
        btnRegistroNotas.setVisible(admin || profesor);
        btnConsultaNotas.setVisible(estudiante);

        if (profesor) {
            btnCursosImpartidos.setText("Consulta de Cursos");
        } else {
            btnCursosImpartidos.setText("Cursos Impartidos");
        }

        lblSubtitulo.setText("Bienvenido, " + Sesion.getNombre()
                + " — " + etiquetaRol());

        reconstruirPanelBotones();
    }

    private String etiquetaRol() {
        if (Sesion.esAdmin()) {
            return "Administrador";
        }
        if (Sesion.esEstudiante()) {
            return "Estudiante";
        }
        if (Sesion.esProfesor()) {
            return "Profesor";
        }
        return "";
    }

    private void reconstruirPanelBotones() {
        pnlBotones.removeAll();
        pnlBotones.setLayout(new GridLayout(0, 2, 12, 12));

        javax.swing.JButton[] botones = {
            btnCarreras, btnAsignaturas, btnRegistroUsuarios, btnAsignaturaCarrera,
            btnRequisitos, btnCursosImpartidos, btnAsignacionCursos, btnInscripciones,
            btnRegistroNotas, btnConsultaNotas
        };
        int visibles = 0;
        for (javax.swing.JButton boton : botones) {
            if (boton.isVisible()) {
                pnlBotones.add(boton);
                visibles++;
            }
        }
        if (visibles == 0) {
            pnlBotones.setLayout(new GridLayout(1, 1));
        } else if (visibles == 1) {
            pnlBotones.setLayout(new GridLayout(1, 1, 12, 12));
        }
        pnlBotones.revalidate();
        pnlBotones.repaint();
    }

    private void abrirFormulario(javax.swing.JFrame formulario) {
        formulario.setLocationRelativeTo(this);
        formulario.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignacionCursos;
    private javax.swing.JButton btnConsultaNotas;
    private javax.swing.JButton btnInscripciones;
    private javax.swing.JButton btnAsignaturaCarrera;
    private javax.swing.JButton btnAsignaturas;
    private javax.swing.JButton btnCarreras;
    private javax.swing.JButton btnCursosImpartidos;
    private javax.swing.JButton btnRegistroNotas;
    private javax.swing.JButton btnRegistroUsuarios;
    private javax.swing.JButton btnRequisitos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEncabezado;
    // End of variables declaration//GEN-END:variables
}
