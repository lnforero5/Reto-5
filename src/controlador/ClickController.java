/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import acceso.ArquitectoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ArquitectoModel;
import vista.Componentes;

/**
 *
 * @author Usuario
 */
public class ClickController implements ActionListener {

    private Componentes componestesView;

    /**
     * Constructor of the class
     *
     * @param controlsPanel
     */
    public ClickController(Componentes componestesView) {
        this.componestesView = componestesView;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == this.componestesView.getBtnConsultar()) {

            try {

                this.componestesView.getBtnGuardar().setEnabled(false);
                this.componestesView.getBtnModificar().setEnabled(true);
                this.componestesView.getBtnEliminar().setEnabled(true);
                String id = (String) this.componestesView.getTxtId().getText();
                ArquitectoDAO arquitectoDAO = new ArquitectoDAO();
                ArquitectoModel arquitecto = null;
                arquitecto = arquitectoDAO.preload(id);
                String nombres = arquitecto.getNombre();
                String apellidos = arquitecto.getApellido();
                String nacionalidad = arquitecto.getNacionalidad();

                this.componestesView.getTxtNombre().setText(nombres);
                this.componestesView.getTxtApellido().setText(apellidos);
                this.componestesView.getTxtNacionalidad().setText(nacionalidad);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No existe un registro con esos parametros");
                System.out.println(ex);
                this.componestesView.getTxtId().setText("");
                this.componestesView.getTxtNombre().setText("");
                this.componestesView.getTxtApellido().setText("");
                this.componestesView.getTxtNacionalidad().setText("");
            }

        }

        if (actionEvent.getSource() == this.componestesView.getBtnGuardar()) {

            String nombre = (String) this.componestesView.getTxtNombre().getText();
            String apellido = (String) this.componestesView.getTxtApellido().getText();
            String nacionalidad = (String) this.componestesView.getTxtNacionalidad().getText();

            if (nombre.isEmpty() || apellido.isEmpty() || nacionalidad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            } else {
                try {
                    ArquitectoDAO arquitectoDAO = new ArquitectoDAO();
                    ArquitectoModel aquitectoNuevo = new ArquitectoModel(nombre, apellido, nacionalidad);
                    arquitectoDAO.insertArquitecto(aquitectoNuevo);

                    ArquitectoData arquitectoData = new ArquitectoData();
                    this.componestesView.setTblResults(arquitectoData.getArquitectos());
                    this.componestesView.getTxtId().setText("");
                    this.componestesView.getTxtNombre().setText("");
                    this.componestesView.getTxtApellido().setText("");
                    this.componestesView.getTxtNacionalidad().setText("");
                    this.componestesView.getBtnGuardar().setEnabled(true);
                    this.componestesView.getBtnModificar().setEnabled(false);
                    this.componestesView.getBtnEliminar().setEnabled(false);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    System.out.println(ex);
                }
            }

        }
        if (actionEvent.getSource() == this.componestesView.getBtnModificar()) {

            String id = (String) this.componestesView.getTxtId().getText();
            String nombre = (String) this.componestesView.getTxtNombre().getText();
            String apellido = (String) this.componestesView.getTxtApellido().getText();
            String nacionalidad = (String) this.componestesView.getTxtNacionalidad().getText();

            if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || nacionalidad.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            } else {
                try {
                    ArquitectoDAO arquitectoDAO = new ArquitectoDAO();
                    ArquitectoModel aquitectoModificar = new ArquitectoModel(Integer.parseInt(id), nombre, apellido, nacionalidad);
                    arquitectoDAO.modify(aquitectoModificar);

                    ArquitectoData arquitectoData = new ArquitectoData();
                    this.componestesView.setTblResults(arquitectoData.getArquitectos());
                    this.componestesView.getTxtId().setText("");
                    this.componestesView.getTxtNombre().setText("");
                    this.componestesView.getTxtApellido().setText("");
                    this.componestesView.getTxtNacionalidad().setText("");
                    this.componestesView.getBtnGuardar().setEnabled(true);
                    this.componestesView.getBtnModificar().setEnabled(false);
                    this.componestesView.getBtnEliminar().setEnabled(false);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    System.out.println(ex);
                }

            }

        }

        if (actionEvent.getSource() == this.componestesView.getBtnEliminar()) {

            String id = (String) this.componestesView.getTxtId().getText();
            ArquitectoDAO arquitectoDAO = new ArquitectoDAO();
            arquitectoDAO.delete(id);
            ArquitectoData arquitectoData = new ArquitectoData();
            this.componestesView.setTblResults(arquitectoData.getArquitectos());
            this.componestesView.getTxtId().setText("");
            this.componestesView.getTxtNombre().setText("");
            this.componestesView.getTxtApellido().setText("");
            this.componestesView.getTxtNacionalidad().setText("");
            this.componestesView.getBtnGuardar().setEnabled(true);
            this.componestesView.getBtnModificar().setEnabled(false);
            this.componestesView.getBtnEliminar().setEnabled(false);

        }

        if (actionEvent.getSource() == this.componestesView.getBtnLimpiar()) {
            this.componestesView.getTxtId().setText("");
            this.componestesView.getTxtNombre().setText("");
            this.componestesView.getTxtApellido().setText("");
            this.componestesView.getTxtNacionalidad().setText("");
            JOptionPane.showMessageDialog(null, "Por favor no se equivoque");
        }

    }

}
