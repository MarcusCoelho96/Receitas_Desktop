package DAO;

import Connection.ConnectionReceitas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Receita;

/**
 *
 * @author Marcus 29/12/2022
 */
public class ReceitaDAO {

    public ReceitaDAO() {
        conn = new ConnectionReceitas().getConexao();
    }

    public PreparedStatement preparedStatement;
    public Connection conn;
    public ResultSet resultSet;
    private ArrayList<Receita> lista = new ArrayList<>();

    public void inserir(Receita receita) {

        conn = new ConnectionReceitas().getConexao();

        String sql = "INSERT INTO receita"
                + "(nome, detalhe, data)"
                + "VALUES(?,?,?)";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, receita.getNome());
            preparedStatement.setString(2, receita.getDetalhe());
            preparedStatement.setString(3, receita.getData());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ReceitaDAO.inserir --> " + erro.getMessage());
        }
    }

    public void alterar(Receita receita) {

        conn = new ConnectionReceitas().getConexao();

        String sql = "UPDATE receita SET nome=?, detalhe=?, data=? WHERE idReceita=?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, receita.getNome());
            preparedStatement.setString(2, receita.getDetalhe());
            preparedStatement.setString(3, receita.getData());
            preparedStatement.setInt(4, receita.getIdReceita());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ReceitaDAO.alterar --> " + erro.getMessage());

        }
    }

    public ArrayList<Receita> listar() {

        conn = new ConnectionReceitas().getConexao();

        String sql = "SELECT * FROM receita";
        //pega do banco, joga no model e depois exibi na tela.
        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Receita receita = new Receita();
                receita.setIdReceita(resultSet.getInt("idReceita"));
                receita.setNome(resultSet.getString("nome"));
                receita.setDetalhe(resultSet.getString("detalhe"));
                receita.setData(resultSet.getString("data"));

                lista.add(receita);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ReceitaDAO.listar --> " + erro.getMessage());

        }
        return lista;
    }

    public void deletar(Receita receita) {

        String sql = "DELETE FROM receita WHERE idReceita = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setInt(1, receita.getIdReceita());
            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ReceitaDAO.deletar --> " + erro.getMessage());
        }
    }
}
