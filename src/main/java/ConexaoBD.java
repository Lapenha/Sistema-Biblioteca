import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    
    private static String host    = "localhost";
    private static String porta   = "3306";
    private static String db      = "db_projetoa3";
    private static String usuario = "root";
    private static String senha   = "Password";
    
    public static Connection obtemConexao() {
        try {
            String url = String.format(
                "jdbc:mysql://%s:%s/%s?user=%s&password=%s&useTimezone=true&serverTimezone=America/Sao_Paulo",
                host, porta, db, usuario, senha
            );
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            System.err.println("Driver JDBC não encontrado no classpath.");
            e.printStackTrace();
            return null;
        } 
    }
    
}
