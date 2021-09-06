/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import utilidades.TablaRender;

/**
 *
 * @author Usuario
 */
public class ViewUnion extends JPanel {

    private JTable tblResults;
    private JScrollPane jspPane;
    private JLabel lbtitle;

    public ViewUnion() {
        initComponents();
    }

    private void initComponents() {

        setLayout(new GridLayout(3, 1));
        setBackground(Color.DARK_GRAY);

        this.lbtitle = new JLabel();
        this.lbtitle.setFont(new java.awt.Font("Arial", 1, 14));
        this.lbtitle.setForeground(Color.white);
        String texto = "<html><body style='font-family: Serif; font-style: italic; font-size: 15px; padding: 0px; margin: 0px; "
                + "text-align: center; width: 600 px; height:10px;'>"
                + "Bienvenidos a InmobiTic: <p> 1.Listado de los arquitectos registrados. <p> 2.Opciones de CRUD"
                + "</body></html>";
        this.lbtitle.setText(texto);
        add(this.lbtitle);

        TablaRender tablaRender = new TablaRender();
        this.tblResults = new JTable();
        this.tblResults.setOpaque(true);
        this.tblResults.setDefaultRenderer(Object.class, tablaRender);
        JTableHeader TblHeader = this.tblResults.getTableHeader();
        TblHeader.setBackground(new Color(142, 170, 219));
        TblHeader.setForeground(Color.BLACK);
        this.jspPane = new JScrollPane(this.tblResults);
        add(jspPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(300, 800));

    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }

}
