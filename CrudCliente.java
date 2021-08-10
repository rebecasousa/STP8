package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudCliente
{
    //cria o objeto do tipo conexão
    private Connection conexao;
    public CrudCliente(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(int id_cliente, String nome){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES("+id_cliente+", '"+nome+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    

    
    
    public boolean read(int id_cliente){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE id_cliente = "+id_cliente);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            while (rs.next()) {
                Integer id = rs.getInt("id_cliente");
                String nome = rs.getString("nome");

                System.out.println( id_cliente +" - " + nome);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int id_cliente, String novoNome){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Cliente SET nome ='"+novoNome+"' WHERE id_cliente ="+id_cliente);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int id_cliente){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Cliente WHERE id_cliente ="+id_cliente+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
