package model;
/**
 *
 * @author Marcus 27/12/2022
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Receita {
    
    private int idReceita;
    private String nome;
    private String detalhe;
    private Date data;
    
    public Receita(){
        
    }
    
    public Receita(int idReceita, String nome, String detalhe, String data){
        this.idReceita = idReceita;
        this.nome = nome;
        this.detalhe = detalhe;
            try {
                this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "construtor formatar data --> " + erro.getMessage());
            }
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getData() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.data);
    }

    public void setData(String data) {
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "setDATA formatar data --> " + erro.getMessage());
        }
    }
}
