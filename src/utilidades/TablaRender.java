/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author Usuario
 */
public class TablaRender extends DefaultTableCellRenderer {

    public TablaRender() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (row % 2 == 0) {

            setBackground(new Color(217, 226, 243));
            setForeground(Color.BLACK);
        } else {
            setBackground(Color.white);
            setForeground(Color.BLACK);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

}
