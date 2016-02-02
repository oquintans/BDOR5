/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdor5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class BD {

    static Connection conn;
    ResultSet rs;

    public void conexion() {
        try {
            String driver = "jdbc:oracle:thin:";
            String host = "localhost.localdomain"; // tambien puede ser una ip como "192.168.1.14"
            String porto = "1521";
            String sid = "orcl";
            String usuario = "sys as sysdba";
            String password = "oracle";
            String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;

            conn = DriverManager.getConnection(url);
            System.out.println("Conexion establecida.");

        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listar() {
        try {
            PreparedStatement ps = conn.prepareStatement("select empregado.* from empregado");
            rs = (ResultSet) ps.executeQuery();

            while (rs.next()) {
                java.sql.Struct jqs = (java.sql.Struct) rs.getObject(1);
                Object[] x = jqs.getAttributes();
                String nombre = (String) x[0];
                java.math.BigDecimal num = (java.math.BigDecimal) x[1];
                System.out.println("Nombre: " + nombre + "\nNum: " + num + "\nEdad: " + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertLinea() {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO THE(SELECT P.pedido FROM pedido_tab P WHERE P.ordnum = ?) SELECT ?, REF(S), ?, ? FROM item_tab S WHERE S.itemnum = ?");
            ps.setInt(1, 4001);
            ps.setInt(2, 48);
            ps.setInt(3, 20);
            ps.setInt(4, 10);
            ps.setInt(5, 2004);

            rs = (ResultSet) ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateLinea() {
        try {
            PreparedStatement ps = conn.prepareStatement("update cliente_tab set clinomb=? where clinum=?");
            ps.setString(1, "Alvaro Luna");
            ps.setInt(2, 7);

            rs = (ResultSet) ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteLinea() {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from the(select pedido from pedido_tab where ordnum=?) where linum=?");
            ps.setInt(1, 4001);
            ps.setInt(2, 48);
            rs = (ResultSet) ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
