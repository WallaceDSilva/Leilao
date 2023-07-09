/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public boolean cadastrarProduto(ProdutosDTO produto) {

        conectaDAO dAO = new conectaDAO();

        Connection conn;

        conn = dAO.connectDB();

        String sql = "insert into produtos (nome,valor,status) values (?, ?, ?)";

        try {

            PreparedStatement ptr = conn.prepareStatement(sql);

            ptr.setString(1, produto.getNome());
            ptr.setInt(2, produto.getValor());
            ptr.setString(3, produto.getStatus());

          return ptr.execute();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());

            return true;
            
        }
        

    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        return listagem;
    }

}
