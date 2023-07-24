/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    public boolean venderProduto(int id) {

        conectaDAO dao = new conectaDAO();

        Connection conn = dao.connectDB();

        String sql = "update produtos set produtos.status = ? where id = ?";

        try {

            PreparedStatement ptr = conn.prepareStatement(sql);

            ptr.setString(1, "Vendido");
            ptr.setInt(2, id);
            
           return  ptr.execute();

        } catch (Exception e) {
            
            System.out.println(e.getMessage() + "");

            return true;
            
        }
        

    }

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

    public ArrayList<ProdutosDTO> listarProdutos(boolean b) {

        ArrayList<ProdutosDTO> listagem = new ArrayList<>();

        conectaDAO dao = new conectaDAO();

        Connection conn = dao.connectDB();
        
         String sql = "SELECT * FROM Produtos";
        
        if (b == true){
                        
            sql = "SELECT * FROM Produtos WHERE Produtos.status = ?";
            
        }
        
        
        

        try {

            PreparedStatement ptr = conn.prepareStatement(sql);

            if (b == true) {
                
                ptr.setString(1, "Vendido");
                
            }
            
            ResultSet res = ptr.executeQuery();

            while (res.next()) {

                ProdutosDTO p = new ProdutosDTO();

                p.setId(res.getInt("ID"));
                p.setNome(res.getString("Nome"));
                p.setStatus(res.getString("Status"));
                p.setValor(res.getInt("Valor"));

                listagem.add(p);

            }

        } catch (SQLException e) {

            System.out.println("Erro: " + e.getMessage());
            conn.rollback();

        } finally {

            return listagem;

        }

    }

}
