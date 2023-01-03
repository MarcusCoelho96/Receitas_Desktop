package Main;

import Connection.ConnectionReceitas;
import View.Tela_Login;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcus 28/12/2022
 */
public class Main {
    
    public static void main(String[] args) {
        
            ConnectionReceitas conexao = new ConnectionReceitas();
            conexao.getConexao();
            Tela_Login tela = new Tela_Login();
            tela.setVisible(true);
        
    }
    
}
