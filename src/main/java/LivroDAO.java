
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vende
 */
public class LivroDAO {

    public static void cadastraLivro(Livro l) throws SQLException {
        ConexaoBD conexaoBD2 = new ConexaoBD();
        String sql = "INSERT INTO table_livros (nome_livro, autor, tipo_livro, ano_livro, usuario_responsavel) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = conexaoBD2.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getNomeLivro());
            ps.setString(2, l.getAutorLivro());
            ps.setString(3, l.getTipoLivro());
            ps.setString(4, l.getAnoLIvro());
            ps.setString(5, l.getUsuarioResponsavel());
            ps.execute(); //inserir
        }
    }

     public static List<Livro> exibirLivros() throws SQLException {
    List<Livro> listaLivros;
        listaLivros = new ArrayList<>();

    String sql = "SELECT nome_livro, autor, tipo_livro, ano_livro, usuario_responsavel FROM table_livros";

    try (
        Connection conn = ConexaoBD.obtemConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()
    ) {
        while (rs.next()) {
            Livro livro = new Livro();
            livro.setNomeLivro(rs.getString("nome_livro"));
            livro.setAutorLivro(rs.getString("autor"));
            livro.setTipoLivro(rs.getString("tipo_livro"));
            livro.setAnoLIvro(rs.getString("ano_livro"));
            livro.setUsuarioResponsavel(rs.getString("usuario_responsavel"));

            listaLivros.add(livro);
        }
    }

    return listaLivros; //parei aqui
}
    public static void deletaLivro(Livro l) throws SQLException {
        ConexaoBD conexaoBD4 = new ConexaoBD();
        String sql = "DELETE FROM table_livros WHERE nome_livro = ?";

        try (Connection conn = conexaoBD4.obtemConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, l.getNomeLivro());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Nenhum usuário com nome '" + l.getAnoLIvro() + "' foi encontrado.");
            } else {
                System.out.println("Usuário '" + l.getNomeLivro() + "' removido com sucesso.");
            }

        }
    }
}
