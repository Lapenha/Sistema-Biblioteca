/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vende
 */
public class Livro {

    private String nomeLivro;
    private String autorLivro;
    private String anoLIvro;
    private String tipoLivro;
    private String usuarioResponsavel;
    

    public String getNomeLivro() {
        return nomeLivro;
    }

   public Livro(){
       
   }
public Livro(String nome_livro, String nome_autor, String tipo_livro, String ano_livro, String usuario_responsavel) {
    this.nomeLivro = nome_livro;
    this.autorLivro = nome_autor;
    this.tipoLivro = tipo_livro;
    this.anoLIvro = ano_livro;
    this.usuarioResponsavel = usuario_responsavel;
}

    public Livro(String nomeLivro){
        this.nomeLivro = nomeLivro;
    }

   public void setNomeLivro(String nomeLivro) {
    this.nomeLivro = nomeLivro;
}


    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public String getAnoLIvro() {
        return anoLIvro;
    }

    public void setAnoLIvro(String anoLIvro) {
        this.anoLIvro = anoLIvro;
    }

    public String getTipoLivro() {
        return tipoLivro;
    }

    public void setTipoLivro(String tipoLivro) {
        this.tipoLivro = tipoLivro;
    }
    public String getUsuarioResponsavel(){
        return usuarioResponsavel;
    }
    public void setUsuarioResponsavel(String usuarioResponsavel){
        this.usuarioResponsavel = usuarioResponsavel;
    }
}
