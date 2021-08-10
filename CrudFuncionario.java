package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudFuncionario
{
    //cria o objeto do tipo conexão
    private Connection conexao;
    public CrudFuncionario(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create(int id_func, int id_cliente){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Funcionario VALUES("+id_func+", '"+id_cliente+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    

    
    
    public boolean read(int id_func){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Funcionario WHERE id_func = "+id_func);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            while (rs.next()) {
                Integer id = rs.getInt("id_func");
                Integer id_cliente = rs.getInt("id_cliente");

                System.out.println( id_func +" - " + id_cliente);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int id_func, String novocliente){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Funcionario SET nome ='"+novocliente+"' WHERE id_func ="+id_func);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int id_func){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Funcionario WHERE id_func ="+id_func+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
