package model;
/**
 *
 * @author Marcus 27/12/2022
 */
public class Usuario {
    
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(int idUsuario, String nome, String email, String senha){
        this(email, senha);
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
