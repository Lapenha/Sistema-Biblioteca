import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {

    public static List<Usuario> exibirUsuarios() throws SQLException {
    List<Usuario> listaUsuarios;
        listaUsuarios = new ArrayList<>();

    String sql = "SELECT nome, tipo, senha, preferencia_livro_1, preferencia_livro_2 FROM table_usuarios";

    try (
        Connection conn = ConexaoBD.obtemConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()
    ) {
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNome(rs.getString("nome"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setSenha(rs.getString("senha"));
            usuario. setPreferencia_livro_1(rs.getString("preferencia_livro_1"));
            usuario. setPreferencia_livro_2(rs.getString("preferencia_livro_2"));

            listaUsuarios.add(usuario);
        }
    }

    return listaUsuarios;
}

    
    public static boolean existe(Usuario u) throws SQLException {
        // 1) SQL corrigido: agora puxando a coluna 'nome'
        String sql = "SELECT * FROM table_usuarios WHERE nome = ? AND senha = ?";

        // 2) Obter conexão: instanciando ConexaoBD (ou faça o método obtemConexao() ser estático)
        ConexaoBD conexaoBD = new ConexaoBD();
                                                                            
        try (Connection conn = conexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, u.getNome());
                ps.setString(2, u.getSenha());

            try (ResultSet rs = ps.executeQuery()) { //consultar
                return rs.next(); // existe se houver pelo menos um registro
            }
        }
    }
    public static void cadastraUsuario(Usuario u) throws SQLException{
        ConexaoBD conexaoBD2 = new ConexaoBD();
            String sql = "INSERT INTO table_usuarios VALUES (?, ?, ?, ?, ?)";
                try (Connection conn = conexaoBD2.obtemConexao();
                     PreparedStatement ps = conn.prepareStatement(sql)) {
                        ps.setString(1, u.getNome());
                        ps.setString(2, u.getTipo());
                        ps.setString(3, u.getSenha());
                        ps.setString(4, u.getPreferencia_livro_1());
                        ps.setString(5, u.getPreferencia_livro_2());
                        ps.execute(); //inserir
            }   
        }
    
    
   public static void removeUsuario(Usuario u) throws SQLException {
    ConexaoBD conexaoBD3 = new ConexaoBD();
    String sql = "DELETE FROM table_usuarios WHERE nome = ? ";

    try (Connection conn = conexaoBD3.obtemConexao();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setString(1, u.getNome());
        
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected == 0) {
            System.out.println("Nenhum usuário com nome '" + u.getNome() + "' foi encontrado.");
        } else {
            System.out.println("Usuário '" + u.getNome() + "' removido com sucesso.");
        }
    }
}
   

    public static boolean consultaUsuario(Usuario u) throws SQLException{
         String sql = "SELECT * FROM table_usuarios WHERE nome = ? AND senha = ?";

        // 2) Obter conexão: instanciando ConexaoBD (ou faça o método obtemConexao() ser estático)
        ConexaoBD conexaoBD = new ConexaoBD();
        
        try (Connection conn = conexaoBD.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, u.getNome());
                ps.setString(2, u.getSenha());
                try(ResultSet rs = ps.executeQuery()) {
                   if (rs.next()) {
                       u.setTipo(rs.getString(3));
                       
                       if (u.getTipo().equals("comum")){
                       u.setPreferencia_livro_1(rs.getString(4));
                       u.setPreferencia_livro_2(rs.getString(5));
                       }
                       
                       return true;
                   }else {
                       return false;
                   }
            }
        }
    }
    
    
}

