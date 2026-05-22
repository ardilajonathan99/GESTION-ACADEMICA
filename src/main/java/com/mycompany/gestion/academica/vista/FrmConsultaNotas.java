package com.mycompany.gestion.academica.vista;

import com.mycompany.gestion.academica.controlador.InscripcionController;
import com.mycompany.gestion.academica.dao.InscribeDAO.InscripcionDetalle;
import com.mycompany.gestion.academica.util.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Consulta de notas de los cursos inscritos (solo lectura, estudiante).
 */
public class FrmConsultaNotas extends javax.swing.JFrame {

    private final InscripcionController inscripcionController = new InscripcionController();
    private final List<InscripcionDetalle> misCursos = new ArrayList<>();

    public FrmConsultaNotas() {
        initComponents();
        configurarTabla();
        configurarEventos();
        configurarSoloLectura();
        cargarDatos();
        setLocationRelativeTo(null);
    }

    private void configurarTabla() {
        tblDatos.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Curso inscrito", "N1", "N2", "N3", "Definitiva"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        tblDatos.getTableHeader().setReorderingAllowed(false);
    }

    private void configurarEventos() {
        tblDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tblDatos.getSelectedRow() >= 0) {
                seleccionarFila(tblDatos.getSelectedRow());
            }
        });
    }

    private void configurarSoloLectura() {
        txtN1.setEditable(false);
        txtN2.setEditable(false);
        txtN3.setEditable(false);
        txtDefinitiva.setEditable(false);
        txtCursoInscrito.setEditable(false);
        lblEstudianteValor.setText(Sesion.getNombre() + " (cód. " + Sesion.getIdUsuario() + ")");
        lblSubtitulo.setText("Seleccione un curso en la tabla para ver el detalle de sus notas");
    }

    private void cargarDatos() {
        try {
            misCursos.clear();
            misCursos.addAll(inscripcionController.listarMisNotas());

            DefaultTableModel modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.setRowCount(0);

            for (InscripcionDetalle d : misCursos) {
                modelo.addRow(new Object[]{
                    d.etiquetaCurso(),
                    formatoNota(d.getN1()),
                    formatoNota(d.getN2()),
                    formatoNota(d.getN3()),
                    d.getDefinitiva() != null ? String.format("%.2f", d.getDefinitiva()) : "—"
                });
            }
            if (!misCursos.isEmpty()) {
                tblDatos.setRowSelectionInterval(0, 0);
                seleccionarFila(0);
            } else {
                limpiarDetalle();
            }
        } catch (Exception ex) {
            mostrarError(ex);
        }
    }

    private void seleccionarFila(int fila) {
        if (fila < 0 || fila >= misCursos.size()) {
            return;
        }
        InscripcionDetalle d = misCursos.get(fila);
        txtCursoInscrito.setText(d.etiquetaCurso());
        cargarDetalle(d);
    }

    private void cargarDetalle(InscripcionDetalle d) {
        txtN1.setText(d.getN1() != null ? String.format("%.2f", d.getN1()) : "—");
        txtN2.setText(d.getN2() != null ? String.format("%.2f", d.getN2()) : "—");
        txtN3.setText(d.getN3() != null ? String.format("%.2f", d.getN3()) : "—");
        txtDefinitiva.setText(d.getDefinitiva() != null ? String.format("%.2f", d.getDefinitiva()) : "—");
    }

    private void limpiarDetalle() {
        txtCursoInscrito.setText("Seleccione un curso en la tabla");
        txtN1.setText("");
        txtN2.setText("");
        txtN3.setText("");
        txtDefinitiva.setText("");
    }

    private String formatoNota(Double nota) {
        return nota != null ? String.format("%.2f", nota) : "—";
    }

    private void mostrarError(Exception ex) {
        String mensaje = ex.getMessage() != null ? ex.getMessage() : ex.toString();
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlFormulario = new javax.swing.JPanel();
        lblEstudiante = new javax.swing.JLabel();
        lblEstudianteValor = new javax.swing.JLabel();
        lblCursoInscrito = new javax.swing.JLabel();
        txtCursoInscrito = new javax.swing.JTextField();
        lblN1 = new javax.swing.JLabel();
        txtN1 = new javax.swing.JTextField();
        lblN2 = new javax.swing.JLabel();
        txtN2 = new javax.swing.JTextField();
        lblN3 = new javax.swing.JLabel();
        txtN3 = new javax.swing.JTextField();
        lblDefinitiva = new javax.swing.JLabel();
        txtDefinitiva = new javax.swing.JTextField();
        scrollTabla = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Notas");
        setMinimumSize(new java.awt.Dimension(820, 520));

        pnlTitulo.setBackground(new java.awt.Color(41, 98, 155));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 16, 12, 16));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Consulta de notas");
        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSubtitulo.setForeground(new java.awt.Color(220, 230, 245));
        lblSubtitulo.setText("Seleccione un curso en la tabla para ver el detalle");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblTitulo).addComponent(lblSubtitulo));
        pnlTituloLayout.setVerticalGroup(pnlTituloLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo));

        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del curso"));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.insets = new java.awt.Insets(6, 8, 6, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        lblEstudiante.setText("Estudiante:");
        gbc.gridx = 0; gbc.gridy = 0;
        pnlFormulario.add(lblEstudiante, gbc);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(lblEstudianteValor, gbc);

        lblCursoInscrito.setText("Curso seleccionado:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblCursoInscrito, gbc);
        txtCursoInscrito.setEditable(false);
        gbc.gridx = 1; gbc.gridwidth = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        pnlFormulario.add(txtCursoInscrito, gbc);

        lblN1.setText("Nota N1 (35%):");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = java.awt.GridBagConstraints.NONE; gbc.weightx = 0;
        pnlFormulario.add(lblN1, gbc);
        txtN1.setColumns(6);
        txtN1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 1;
        pnlFormulario.add(txtN1, gbc);

        lblN2.setText("Nota N2 (35%):");
        gbc.gridx = 2;
        pnlFormulario.add(lblN2, gbc);
        txtN2.setColumns(6);
        txtN2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 3;
        pnlFormulario.add(txtN2, gbc);

        lblN3.setText("Nota N3 (30%):");
        gbc.gridx = 0; gbc.gridy = 3;
        pnlFormulario.add(lblN3, gbc);
        txtN3.setColumns(6);
        txtN3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gbc.gridx = 1;
        pnlFormulario.add(txtN3, gbc);

        lblDefinitiva.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblDefinitiva.setText("Definitiva:");
        gbc.gridx = 2;
        pnlFormulario.add(lblDefinitiva, gbc);
        txtDefinitiva.setColumns(8);
        txtDefinitiva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDefinitiva.setFont(new java.awt.Font("Segoe UI", 1, 13));
        gbc.gridx = 3; gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; gbc.weightx = 0.5;
        pnlFormulario.add(txtDefinitiva, gbc);
        tblDatos.setRowHeight(24);
        scrollTabla.setViewportView(tblDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)));
        pack();
    }

    private javax.swing.JLabel lblCursoInscrito;
    private javax.swing.JLabel lblDefinitiva;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblEstudianteValor;
    private javax.swing.JLabel lblN1;
    private javax.swing.JLabel lblN2;
    private javax.swing.JLabel lblN3;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCursoInscrito;
    private javax.swing.JTextField txtDefinitiva;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
    private javax.swing.JTextField txtN3;
}
