/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ArquitectoModel;
import utilidades.ConnectionDB;

/**
 *
 * @author Usuario
 */
public class ArquitectoDAO {

    private Connection conn;

    public ArrayList<ArquitectoModel> ListRorw() {

        ArrayList<ArquitectoModel> arquitectos = new ArrayList<ArquitectoModel>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT * FROM arquitecto;";
            Statement statement = conn.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                ArquitectoModel arquitecto = new ArquitectoModel(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                arquitectos.add(arquitecto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código: " + e.getErrorCode()
                    + "\nError: " + e.getMessage());
        }

        return arquitectos;
    }

    public ArquitectoModel preload(String id) {
        ArquitectoModel arquitecto = null;
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT id, nombre, apellido, nacionalidad FROM arquitecto  where id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                arquitecto = new ArquitectoModel(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
                break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return arquitecto;

    }

    public void insertArquitecto(ArquitectoModel arquitecto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "INSERT INTO arquitecto (nombre, apellido, nacionalidad)"
                    + "VALUES (?,?,?);";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, arquitecto.getNombre());
            statement.setString(2, arquitecto.getApellido());
            statement.setString(3, arquitecto.getNacionalidad());
            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue insertado exitosamente !");
            } else {
                System.out.println("Hubo un error");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código: " + e.getErrorCode()
                    + "\nError: " + e.getMessage());
        }
    }

    public void modify(ArquitectoModel arquitecto) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE arquitecto set nombre =?, apellido =?,nacionalidad = ? WHERE id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, arquitecto.getNombre());
            statement.setString(2, arquitecto.getApellido());
            statement.setString(3, arquitecto.getNacionalidad());
            statement.setInt(4, arquitecto.getId());

            int rowsUpdate = statement.executeUpdate();
            if (rowsUpdate > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Código : " + e.getErrorCode()
                    + "\nError :" + e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection();
            }

            String sql = "DELETE FROM arquitecto WHERE id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
