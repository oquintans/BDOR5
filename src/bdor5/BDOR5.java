/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdor5;

/**
 *
 * @author oracle
 */
public class BDOR5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BD bd = new BD();
        bd.conexion();
        //bd.listar();
       // bd.insertLinea();
       bd.updateLinea();

    }

}
