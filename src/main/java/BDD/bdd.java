package BDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class bdd {

    private static Connection maConnexion;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/todolist_fx";
    private static String mySqlUser = "root";
    private static String mysqlPassword = "";


    public static Connection getConnection() throws Exception{
        if(maConnexion == null){
            Class.forName(driver);

            maConnexion = DriverManager.getConnection(url,mySqlUser,mysqlPassword);

        }
        return maConnexion;
    }



}