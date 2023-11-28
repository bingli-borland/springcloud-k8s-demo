package com.bingli.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author msh01
 * @version 1.0.0
 * @createTime 2023年11月27日 15:15:00
 */
public class OpengaussTest{
    public static void main(String[] args) {

        getConnect();
        getConnect2();
        getConnect3();
    }

    public static Connection getConnect() {
        String driver = "org.opengauss.Driver";
        String sourceURL = "jdbc:opengauss://10.0.0.19:35432/postgres?user=gaussdb&password=Enmo@123";
        Properties info = new Properties();
        Connection conn = null;
        try {
            Class.forName(driver);
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
        try {
            conn = DriverManager.getConnection(sourceURL);
            System.out.println("连接成功！");
            return conn;
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    /*DriverManager.getConnection(String url, Properties info);*/

    public static Connection getConnect2() {
        String driver = "org.opengauss.Driver";
        String sourceURL = "jdbc:opengauss://10.0.0.19:35432/postgres";
        Properties info = new Properties();
        info.setProperty("user","gaussdb");
        info.setProperty("password","Enmo@123");
        Connection conn = null;
        try {
            Class.forName(driver);
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
        try {
            conn = DriverManager.getConnection(sourceURL, info);
            System.out.println("连接成功！");
            return conn;
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    /*DriverManager.getConnection(String url, String user, String password);*/

    public static Connection getConnect3() {
        String driver = "org.opengauss.Driver";
        String sourceURL = "jdbc:opengauss://10.0.0.19:35432/postgres";
        String username="gaussdb";
        String passwd="Enmo@123";
        Connection conn = null;
        try {
            Class.forName(driver);
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
        try {
            conn = DriverManager.getConnection(sourceURL, username, passwd);
            System.out.println("连接成功！");
            return conn;
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }
}
