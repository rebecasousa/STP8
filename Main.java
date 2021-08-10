package Conexao;


import Conexao.ConexaoSqlite;
import Conexao.CrudCliente;
import java.sql.Statement;
import java.sql.SQLException;

public class Main{
    public static void main(String args[])throws Exception{
        ConexaoSqlite conexao = new ConexaoSqlite();
        conexao.abrirConexao();
        CrudFuncionario crud = new CrudFuncionario(conexao.getConnection());
        
        //Inserindo cadastros no banco
        crud.create(4321,1234567891);
        crud.create(1234,1234567890);

        //Consultando uma linha no banco 
        //crud.read(1234567896);
        
        
        //Alterando um registro no banco
        //crud.update(1234567896, "Rebeca Silva Sousa");
        
        //Deletando um registro no banco
        crud.delete(1234567896);
        crud.delete(1234567891);
        crud.delete(1234567892);
        crud.delete(1234567893);
        crud.delete(1234567894);
        crud.delete(1234567899);
        crud.delete(1234567890);
        
        //boolean resposta;
        //resposta = crud.create(1234567896, "Rebeca Sousa");
        //System.out.println(resposta);
    
        
        
        conexao.fecharConexao();     
        
        
    }
}