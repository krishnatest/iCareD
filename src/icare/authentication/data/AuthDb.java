package icare.authentication.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.catalina.connector.Request;

public class AuthDb {

    @SuppressWarnings("null")
    public String validateUserLogin (String username, String password) throws SQLException{
        Connection connection = null;
        ResultSet resultset = null;
        Statement stmt = null;
        String userName = null;

        String fullname = "";

        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3308/icare";
        String USER = "root";
        String PASS = "root";
        String QUERY = "SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USER,PASS);
            //resultset = statement.executeQuery(QUERY);
            
          //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = connection.createStatement();

            resultset = stmt.executeQuery(QUERY);
            //STEP 5: Extract data from result set
            while(resultset.next()){
               //Retrieve by column name
               userName = resultset.getString("username");
               //Display values
               System.out.print(", First: " + userName);
            }
        }   catch (Exception e){
            e.printStackTrace();
        }   finally {
            if (resultset != null)
                resultset.close();
            if (stmt != null)
            	stmt.close();
            if (connection != null)
                connection.close();
        }
        return userName;
    }
    
}