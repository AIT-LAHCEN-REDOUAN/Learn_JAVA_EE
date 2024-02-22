package MVC_JDBC.DAO;

import java.sql.Connection ;
import java.sql.DriverManager;


public class SingletonConnection {
    private static Connection connection ;
    static{
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/products","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection ;
    }
}