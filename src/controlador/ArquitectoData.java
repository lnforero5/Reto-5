/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import acceso.ArquitectoDAO;
import java.util.ArrayList;
import modelo.ArquitectoModel;

/**
 *
 * @author Usuario
 */
public class ArquitectoData {

    private ArrayList<ArquitectoModel> arquitecto = null;

    public ArquitectoData() {

        ArquitectoDAO arquitectoDAO = new ArquitectoDAO();
        this.arquitecto = arquitectoDAO.ListRorw();
    }

    /**
     * @return the arquitecto
     */
    public ArrayList<ArquitectoModel> getArquitectos() {
        return arquitecto;
    }

}
