
package ejerciciosena;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EjercicioSena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String user     = "root";
        String password = "1628";
        String url      = "jdbc:mysql://localhost:3306/dbjavamysql";
                           
        //
        Connection conexion;
        Statement  statement;
        ResultSet    res;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjercicioSena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion  = DriverManager.getConnection(url, user, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIOS (USERNAME, USERPASSWORD)VALUES ('JUAN DIEGO', '1020202')");
            statement.execute("UPDATE USUARIOS"
                    + "           SET USERNAME = 'SARA' "
                    + "         WHERE USERNAME = 'SASHAM'");
            statement.executeUpdate("DELETE FROM USUARIOS WHERE USERNAME = 'SASHAM'");          
            res = statement.executeQuery("SELECT * FROM USUARIOS");
            res.next();
             do{
                 System.out.println(res.getInt("userid")+":"+res.getString("username"));
                 
             }
             while (res.next());
           
        } catch (SQLException ex) {
            Logger.getLogger(EjercicioSena.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
