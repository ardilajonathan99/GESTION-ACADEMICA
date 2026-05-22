/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.AsignaturaController;
import com.mycompany.gestion.academica.controlador.EstudianteController;
import com.mycompany.gestion.academica.controlador.ImparteController;
import com.mycompany.gestion.academica.controlador.InscripcionController;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.modelo.Asignatura;
import com.mycompany.gestion.academica.modelo.CursoImpartido;
import com.mycompany.gestion.academica.modelo.Estudiante;
import com.mycompany.gestion.academica.modelo.Inscripcion;
import com.mycompany.gestion.academica.modelo.Profesor;
import com.mycompany.gestion.academica.util.ComboItem;
import com.mycompany.gestion.academica.util.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * El estudiante asigna los cursos que va a cursar.
 */
public class FrmAsignacionCursos extends javax.swing.JFrame {

    private final InscripcionController inscripcionController = new InscripcionController();
    private final EstudianteController estudianteController = new EstudianteController();
    private final AsignaturaController asignaturaController = new AsignaturaController();
    private final ImparteController imparteController = new ImparteController();

    private final List<CursoImpartido> cursosFiltrados = new ArrayList<>();
    private int codESeleccionado;
    private int codASeleccionado;
    private int idPSeleccionado;
    private String grupoSeleccionado = "";

    public FrmAsignacionCursos() {
        initComponents();
        configurarTabla();
        configurarEventos();
        configurarVistaPorRol();
        cargarCombos();
        cargarTabla();
        setLocationRelativeTo(null);
    }

    private void configurarVistaPorRol() {
        if (Sesion.esEstudiante()) {
            setTitle("Inscripciones");
            lblTitulo.setText("Mis inscripciones");
            lblSubtitulo.setText("Inscríbase en los cursos que desea cursar");
            pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Inscribirse a un curso"));
        } else {
            setTitle("Asignación de Cursos");
            lblTitulo.setText("Asignación de cursos");
            lblSubtitulo.setText("Asigne cursos impartidos a los estudiantes");
            pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Inscripción a curso"));
        }
    }

    private void configurarTabla() {
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Estudiante", "Asignatura", "Profesor", "Grupo", "Horario"}
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
        lblAsignatura = new javax.swing.JLabel();
        cmbAsignatura = new javax.swing.JComboBox<>();
        lblProfesor = new javax.swing.JLabel();
        cmbProfesor = new javax.swing.JComboBox<>();
        lblGrupo = new javax.swing.JLabel();
        cmbGrupo = new javax.swing.JComboBox<>();
        lblHorario = new javax.swing.JLabel();
        txtHorario = new javax.swing.JTextField();
        pnlBotones = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignación de Cursos");
        setMinimumSize(new java.awt.Dimension(820, 520));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Asignación de cursos");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setText("El estudiante selecciona los cursos a cursar");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitulo)
                .addComponent(lblSubtitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Inscripción a curso"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblEstudiante.setText("Estudiante:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblEstudiante, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbEstudiante, gbc);

        lblAsignatura.setText("Asignatura:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblAsignatura, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(cmbAsignatura, gbc);

        lblProfesor.setText("Profesor:");
        gbc.gridx = 0; gbc.gridy = 2;
        pnlFormulario.add(lblProfesor, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlFormulario.add(cmbProfesor, gbc);

        lblGrupo.setText("Grupo:");
        gbc.gridx = 0; gbc.gridy = 3;
        pnlFormulario.add(lblGrupo, gbc);
        cmbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"-- Seleccione --"}));
        gbc.gridx = 1;
        pnlFormulario.add(cmbGrupo, gbc);

        lblHorario.setText("Horario:");
        gbc.gridx = 2;
        pnlFormulario.add(lblHorario, gbc);
        txtHorario.setColumns(25);
        txtHorario.setEditable(false);
        gbc.gridx = 3;
        pnlFormulario.add(txtHorario, gbc);

        btnNuevo.setText("Nuevo");
        btnInscribir.setText("Inscribir");
        btnModificar.setText("Modificar");
        btnEliminar.setText("Eliminar");
        btnLimpiar.setText("Limpiar");

        pnlBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 8));
        pnlBotones.add(btnNuevo);
        pnlBotones.add(btnInscribir);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnLimpiar);

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

    private void configurarEventos() {
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnInscribir.addActionListener(e -> inscribir());
        btnModificar.setEnabled(false);
        btnEliminar.addActionListener(e -> eliminarInscripcion());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        cmbAsignatura.addActionListener(e -> cargarProfesoresPorAsignatura());
        cmbProfesor.addActionListener(e -> cargarGruposPorProfesor());
        cmbGrupo.addActionListener(e -> actualizarHorario());
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                cargarFilaSeleccionada(tblDatos.getSelectedRow());
            }
        });
    }

    private void cargarCombos() {
        try {
            DefaultComboBoxModel<ComboItem> estModel = new DefaultComboBoxModel<>();
            if (Sesion.esEstudiante()) {
                estModel.addElement(new ComboItem(
                        Sesion.getIdUsuario(),
                        Sesion.getIdUsuario() + " - " + Sesion.getNombre()));
                cmbEstudiante.setModel(estModel);
                cmbEstudiante.setEnabled(false);
                codESeleccionado = Sesion.getIdUsuario();
            } else {
                estModel.addElement(new ComboItem(0, "-- Seleccione --"));
                for (Estudiante e : estudianteController.listar()) {
                    estModel.addElement(new ComboItem(e.getCodE(), e.getCodE() + " - " + e.getNomE()));
                }
                cmbEstudiante.setModel(estModel);
            }

            DefaultComboBoxModel<ComboItem> asigModel = new DefaultComboBoxModel<>();
            asigModel.addElement(new ComboItem(0, "-- Seleccione --"));
            for (Asignatura a : asignaturaController.listar()) {
                asigModel.addElement(new ComboItem(a.getCodA(), a.getCodA() + " - " + a.getNomA()));
            }
            cmbAsignatura.setModel(asigModel);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarProfesoresPorAsignatura() {
        ComboItem asigItem = (ComboItem) cmbAsignatura.getSelectedItem();
        DefaultComboBoxModel<ComboItem> profModel = new DefaultComboBoxModel<>();
        profModel.addElement(new ComboItem(0, "-- Seleccione --"));
        cursosFiltrados.clear();
        cmbGrupo.setModel(new DefaultComboBoxModel<>(new String[]{"-- Seleccione --"}));
        txtHorario.setText("");
        if (asigItem == null || asigItem.getId() <= 0) {
            cmbProfesor.setModel(profModel);
            return;
        }
        try {
            List<CursoImpartido> cursos = imparteController.listarPorAsignatura(asigItem.getId());
            cursosFiltrados.addAll(cursos);
            List<Integer> profesoresAgregados = new ArrayList<>();
            for (CursoImpartido c : cursos) {
                int idP = c.getProfesor().getIdP();
                if (!profesoresAgregados.contains(idP)) {
                    profesoresAgregados.add(idP);
                    profModel.addElement(new ComboItem(idP, idP + " - " + c.getProfesor().getNomP()));
                }
            }
            cmbProfesor.setModel(profModel);
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarGruposPorProfesor() {
        ComboItem profItem = (ComboItem) cmbProfesor.getSelectedItem();
        DefaultComboBoxModel<String> grupoModel = new DefaultComboBoxModel<>();
        grupoModel.addElement("-- Seleccione --");
        txtHorario.setText("");
        if (profItem == null || profItem.getId() <= 0) {
            cmbGrupo.setModel(grupoModel);
            return;
        }
        for (CursoImpartido c : cursosFiltrados) {
            if (c.getProfesor().getIdP() == profItem.getId()) {
                grupoModel.addElement(c.getGrupo());
            }
        }
        cmbGrupo.setModel(grupoModel);
    }

    private void actualizarHorario() {
        ComboItem asigItem = (ComboItem) cmbAsignatura.getSelectedItem();
        ComboItem profItem = (ComboItem) cmbProfesor.getSelectedItem();
        String grupo = (String) cmbGrupo.getSelectedItem();
        if (asigItem == null || profItem == null || grupo == null || grupo.startsWith("--")) {
            txtHorario.setText("");
            return;
        }
        for (CursoImpartido c : cursosFiltrados) {
            if (c.getProfesor().getIdP() == profItem.getId() && c.getGrupo().equals(grupo)) {
                txtHorario.setText(c.getHorario() != null ? c.getHorario() : "");
                return;
            }
        }
    }

    private void cargarTabla() {
        try {
            List<InscripcionDetalle> lista = inscripcionController.listarDetalle();
            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);
            for (InscripcionDetalle d : lista) {
                modelo.addRow(new Object[]{d.getNomEstudiante(), d.getNomAsignatura(), d.getNomProfesor(), d.getGrupo(), d.getHorario()});
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void inscribir() {
        ComboItem estItem = (ComboItem) cmbEstudiante.getSelectedItem();
        ComboItem asigItem = (ComboItem) cmbAsignatura.getSelectedItem();
        ComboItem profItem = (ComboItem) cmbProfesor.getSelectedItem();
        String grupo = (String) cmbGrupo.getSelectedItem();
        int codE = Sesion.esEstudiante() ? Sesion.getIdUsuario() : (estItem != null ? estItem.getId() : 0);
        if (codE <= 0 || asigItem == null || asigItem.getId() <= 0 || profItem == null || profItem.getId() <= 0
                || grupo == null || grupo.startsWith("--")) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos de la inscripción.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Estudiante e = new Estudiante();
            e.setCodE(codE);
            Profesor p = new Profesor();
            p.setIdP(profItem.getId());
            Asignatura a = new Asignatura();
            a.setCodA(asigItem.getId());
            CursoImpartido curso = new CursoImpartido(p, a, grupo, txtHorario.getText());
            inscripcionController.inscribir(new Inscripcion(e, curso));
            cargarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Inscripción registrada correctamente.");
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void eliminarInscripcion() {
        if (codESeleccionado <= 0 || codASeleccionado <= 0 || idPSeleccionado <= 0 || grupoSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione una inscripción de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (JOptionPane.showConfirmDialog(this, "¿Eliminar la inscripción?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            inscripcionController.eliminar(codESeleccionado, codASeleccionado, idPSeleccionado, grupoSeleccionado);
            cargarTabla();
            limpiarCampos();
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void cargarFilaSeleccionada(int fila) {
        try {
            List<InscripcionDetalle> lista = inscripcionController.listarDetalle();
            InscripcionDetalle d = lista.get(fila);
            codESeleccionado = d.getCodE();
            codASeleccionado = d.getCodA();
            idPSeleccionado = d.getIdP();
            grupoSeleccionado = d.getGrupo();
            seleccionarCombo(cmbEstudiante, codESeleccionado);
            seleccionarCombo(cmbAsignatura, codASeleccionado);
            cargarProfesoresPorAsignatura();
            seleccionarCombo(cmbProfesor, idPSeleccionado);
            cargarGruposPorProfesor();
            cmbGrupo.setSelectedItem(grupoSeleccionado);
            txtHorario.setText(d.getHorario() != null ? d.getHorario() : "");
        } catch (Exception ex) {
            mostrarError(ex);
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
        codASeleccionado = 0;
        idPSeleccionado = 0;
        grupoSeleccionado = "";
        if (Sesion.esEstudiante()) {
            codESeleccionado = Sesion.getIdUsuario();
        } else {
            codESeleccionado = 0;
            cmbEstudiante.setSelectedIndex(0);
        }
        cmbAsignatura.setSelectedIndex(0);
        cargarProfesoresPorAsignatura();
        txtHorario.setText("");
        tblDatos.clearSelection();
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<ComboItem> cmbAsignatura;
    private javax.swing.JComboBox<ComboItem> cmbEstudiante;
    private javax.swing.JComboBox<String> cmbGrupo;
    private javax.swing.JComboBox<ComboItem> cmbProfesor;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblProfesor;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtHorario;
    // End of variables declaration//GEN-END:variables
}
