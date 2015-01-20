/**
 * Created by S2D on 1/19/2015.
 */

package jconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    private static String url = "jdbc:mysql://localhost/rest";
    private static String user = "root";
    private static String pass = "";

    protected static Connection connect(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){e.printStackTrace();}

        return conn;
    }

}
