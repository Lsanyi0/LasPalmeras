package jReports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class MysqlConnection {
    public static Connection con;
    public static Connection MysqlConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laspalmeras1","root","resident00RE");
            System.out.println("OK!");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse con la base de datos /n Error: "+e, "Error",0);
        }
        return con;
    }
}
