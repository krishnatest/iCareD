package icare.authentication.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.apache.catalina.connector.Request;
import icare.connection.mysql.ConnectionDatabase;

public class AuthDb {

    @SuppressWarnings("null")
    public String validateUserLogin (String username, String password) throws SQLException {
        ResultSet resultset = null;
        Statement stmt = null;
        String userName = null;
        
        // call the Db connection method
        Connection connection = new ConnectionDatabase().getConnection();
        
        
        //	MySql query to check that user exist or not
        String QUERY = "SELECT * FROM users WHERE username = '"+username+"' AND password = '"+password+"'";
        try {
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = connection.createStatement();

            resultset = stmt.executeQuery(QUERY);
            //STEP 5: Extract data from result set
            while(resultset.next()) {
                //Retrieve by column name
                userName = resultset.getString("username");
                //Display values
                System.out.print("First: " + userName + " ");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
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