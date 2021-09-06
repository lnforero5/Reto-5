/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ArquitectoData;
import controlador.ClickController;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.ArquitectoModel;

/**
 *
 * @author Usuario
 */
public class Componentes extends JPanel {

    private JLabel lblId;
    private JTextField textId;
    private JButton btnConsultar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblNacionalidad;
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textNacionalidad;
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;
    private JTable tblResults;

    public Componentes(ViewUnion resultsPanel) {
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 3));
        
        add(new JSeparator());
        add(new JSeparator());
        add(new JSeparator());

        this.lblId = new JLabel("Consultar ID");
        add(this.getLblId());

        this.textId = new JTextField(10);
        add(this.getTxtId());

        this.btnConsultar = new JButton("Consultar");
        add(this.btnConsultar);

        ClickController click = new ClickController(this);
        this.btnConsultar.addActionListener(click);
        
        
        this.lblNombre = new JLabel("Nombres");
        add(this.getLblNombre());

        this.lblApellido = new JLabel("Apellidos");
        add(this.getLblApellido());

        this.lblNacionalidad = new JLabel("Nacionalidad");
        add(this.getLblNacionalidad());

        this.textNombre = new JTextField();
        add(this.getTxtNombre());

        this.textApellido = new JTextField();
        add(this.getTxtApellido());

        this.textNacionalidad = new JTextField();
        add(this.getTxtNacionalidad());

        this.btnGuardar = new JButton("Guardar");
        add(this.btnGuardar);

        ClickController clickGuardar = new ClickController(this);
        this.btnGuardar.addActionListener(clickGuardar);

        this.btnModificar = new JButton("Modificar");
        add(this.btnModificar);

        this.btnModificar.setEnabled(false);

        ClickController clickModificar = new ClickController(this);
        this.btnModificar.addActionListener(clickModificar);

        this.btnEliminar = new JButton("Eliminar");
        add(this.btnEliminar);

        ClickController clickEliminar = new ClickController(this);
        this.btnEliminar.addActionListener(clickEliminar);

        this.btnEliminar.setEnabled(false);

        this.btnLimpiar = new JButton("Limpiar");
        add(this.btnLimpiar);

        ClickController clickLimpiar = new ClickController(this);
        this.btnLimpiar.addActionListener(clickLimpiar);

        setLayout(new GridLayout(6, 1));
        ArquitectoData arquitectoData = new ArquitectoData();
        // Informaciòn Arquitectos
        this.setTblResults(arquitectoData.getArquitectos());
        

    }

    /**
     * @return the lblId
     */
    public JLabel getLblId() {
        return lblId;
    }

    /**
     * @return the txtId
     */
    public JTextField getTxtId() {
        return textId;
    }

    /**
     * @return the btnConsultar
     */
    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    /**
     * @return the lblNombre
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * @return the lblApellido
     */
    public JLabel getLblApellido() {
        return lblApellido;
    }

    /**
     * @return the lblNacionalidad
     */
    public JLabel getLblNacionalidad() {
        return lblNacionalidad;
    }

    /**
     * @return the textNombre
     */
    public JTextField getTxtNombre() {
        return textNombre;
    }

    /**
     * @return the textApellido
     */
    public JTextField getTxtApellido() {
        return textApellido;
    }

    /**
     * @return the textNacionalidad
     */
    public JTextField getTxtNacionalidad() {
        return textNacionalidad;
    }

    /**
     * @return the btnGuardar
     */
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * @return the btnModificar
     */
    public JButton getBtnModificar() {
        return btnModificar;
    }

    /**
     * @return the btnGuardar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @return the btnGuardar
     */
    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param Arquitectos
     */
    public void setTblResults(ArrayList<ArquitectoModel> arquitecto) {
        String[] headers = {"Id", "Nombres", "Apellido", "Nacionalidad"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for (int i = 0; i < arquitecto.size(); i++) {
            tableModel.addRow(arquitecto.get(i).toArray());
        }
    }

}
