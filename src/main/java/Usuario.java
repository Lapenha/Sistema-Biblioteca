public class Usuario {
    private String nome;
    private String senha;
    private String tipo;
    private String preferencia_livro_1;
    private String preferencia_livro_2;

    public Usuario(String nome, String senha, String tipo, String preferencia_livro_1, String preferencia_livro_2) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.preferencia_livro_1 = preferencia_livro_1;
        this.preferencia_livro_2 = preferencia_livro_2;
    }

    public Usuario() {
    }
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario(String nome) {
        this.nome = nome;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreferencia_livro_1() {
        return preferencia_livro_1;
    }

    public void setPreferencia_livro_1(String preferencia_livro_1) {
        this.preferencia_livro_1 = preferencia_livro_1;
    }

    public String getPreferencia_livro_2() {
        return preferencia_livro_2;
    }

    public void setPreferencia_livro_2(String preferencia_livro_2) {
        this.preferencia_livro_2 = preferencia_livro_2;
    }
    
}
