
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Adm
 */
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;

        String url = "jdbc:mysql://localhost/leilaobdd";
        String user = "root";
        String passord = "wallace131703";

        try {

            conn = DriverManager.getConnection(url, user, passord);

        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
            
        }
        return conn;
    }

}
