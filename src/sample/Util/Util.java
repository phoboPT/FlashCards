/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author miguel
 */
public class Util {

    private static Connection conn = null;

    public static Connection criarConexao() {

        if (conn != null) {
            return conn;
        } else {


            try {
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/teste", "postgres", "root");
                //conn.setAutoCommit(false);
            } catch (Exception e) {
                System.out.println("ERRO " + e);
                //javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(-2);
            }

            return conn;
        }
    }

}
