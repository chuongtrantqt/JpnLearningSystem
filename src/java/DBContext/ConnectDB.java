/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBContext;

import static DBContext.DatabaseInfor.driverName;
import static DBContext.DatabaseInfor.pass;
import static DBContext.DatabaseInfor.url;
import static DBContext.DatabaseInfor.user;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Chuong
 */
public class ConnectDB implements DatabaseInfor{
    private static ConnectDB instance;

    public Connection openConnection() throws Exception {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, user, pass);
        return con;

    }

    //Get instance of dbms only one time
    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }  
}
