package com.edutecno.procesaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConexionDB {
    protected Connection generaConexion() {
        Connection conn = null;
        String usr = "HR";
        String pwd = "admin";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usr, pwd);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
