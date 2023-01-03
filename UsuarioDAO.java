package DAO;

import Connection.ConnectionReceitas;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
/**
 *
 * @author Marcus 29/12/2022
 */
public class UsuarioDAO {
    
    public PreparedStatement preparedStatement;
    public Connection conn;
    
    public void inserir(Usuario usuario){
        // usar o método de conexão
        conn = new ConnectionReceitas().getConexao();
               
        try {
            String sql = "INSERT INTO usuario"
                    + "(nome, email, senha)"
                    + "VALUES(?,?,?)";

                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getEmail());
                preparedStatement.setString(3, usuario.getSenha());
                preparedStatement.execute();
                preparedStatement.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO.inserir --> " + erro.getMessage());
        }
        
    }
        
    public ResultSet autenticar(Usuario usuario){
        
        conn = new ConnectionReceitas().getConexao();
        
        try { //comparar se login tem no banco
            String sql = "SELECT email, senha FROM usuario WHERE email = ? AND senha = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //pegar valor do objeto e joga na string sql: = ?
            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getSenha());
            
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
            
        } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "UsuarioDAO.autenticar --> " + erro.getMessage());
           return null;
        }
    }
    
}
