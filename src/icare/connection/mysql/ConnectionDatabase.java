/**
 *	MySql Connection created for Database  
 */
/**
 * @author kkumar92
 *
 */
package icare.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

	@SuppressWarnings("null")
    public Connection getConnection() throws SQLException {
        Connection connection = null;

        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3308/icare";
        String USER = "root";
        String PASS = "root";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}