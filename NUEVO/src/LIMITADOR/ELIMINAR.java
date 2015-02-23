/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIMITADOR;

import BASE_DE_DATOS.ConexionMysql;

import javax.swing.text.PlainDocument;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ELIMINAR extends PlainDocument {


public  ELIMINAR(String valor) {

        
        String sql = "DELETE FROM contactos WHERE idpersona =("+valor+")" ; 
        ConexionMysql mysql = new ConexionMysql();
        Connection coneccion = (Connection) mysql.Conectar();
        try {
            Statement instruccion  = (Statement) coneccion.createStatement();
           boolean borrado = instruccion.execute(sql);
           
           if(borrado=true) {
              JOptionPane.showMessageDialog(null,"Se Ha Eliminado Exitosamente");
                }
           else {
               JOptionPane.showMessageDialog(null,"El ID Ingresado no Existe");
                 }
            }
        catch (SQLException ex){
        }
    }

    public ELIMINAR() {
    }

    public ELIMINAR(Content cntnt) {
        super(cntnt);
    }
}