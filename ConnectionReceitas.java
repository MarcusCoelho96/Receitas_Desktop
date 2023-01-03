package Connection;

import java.sql.DriverManager;
import java.sql.Connection;

import javax.swing.JOptionPane;
/**
 *
 * @author Marcus 28/12/2022
 */
public class ConnectionReceitas {
    
    Connection conn = null;

    public Connection getConexao(){
        
        try { 
            String url = "jdbc:mysql://localhost:3306/receitas?user=root&password=";
            conn = DriverManager.getConnection(url);
            
           /* if(conn != null){
                JOptionPane.showMessageDialog(null, "Sucesso na conexão!");
            }
           */
            
        } catch (Exception erro) {   
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        return conn;
      
        
    }
    
}
