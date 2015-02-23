/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIMITADOR;

import BASE_DE_DATOS.ConexionMysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Paula
 */
public class BUSCAR extends PlainDocument{
    private DefaultTableModel modelo;
    private javax.swing.JTable tblDatos;{
    
}
    public BUSCAR(String valor) {
        String[] titulos = {"ID", "Nombre", "ApellidoP", "ApellidoM", "Calle", "#", "Col", "Del", "CP", "TEL"};
        String[] registro = new String[10];
        String sSQL = "";
        modelo = new DefaultTableModel(null, titulos);

        ConexionMysql mysql = new ConexionMysql();
        com.mysql.jdbc.Connection cn = (com.mysql.jdbc.Connection) mysql.Conectar();

        sSQL = "SELECT IDCliente,Nombres,ApellidoPaterno,ApellidoMaterno,Calle,Numero,Colonia,Delegacion,CP,Telefono FROM cliente "
                + "WHERE CONCAT(Nombres, ' ',ApellidoPaterno) LIKE '%" + valor + "%'";
        try {
            com.mysql.jdbc.Statement st = (com.mysql.jdbc.Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("IDCliente");
                registro[1] = rs.getString("Nombres");
                registro[2] = rs.getString("ApellidoPaterno");
                registro[3] = rs.getString("ApellidoMaterno");
                registro[4] = rs.getString("Calle");
                registro[5] = rs.getString("Numero");
                registro[6] = rs.getString("Colonia");
                registro[7] = rs.getString("Delegacion");
                registro[8] = rs.getString("CP");
                registro[9] = rs.getString("Telefono");
                modelo.addRow(registro);
            }
            tblDatos.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }
}
