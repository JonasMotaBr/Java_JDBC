package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class banco {
	
	
	public static void main(String[] args) throws SQLException {

		
        
		Connection conexao = conectarBanco.getconexao();	

		
		Statement stmt = conexao.createStatement();
	     stmt.execute("truncate table produto;");
	    //System.out.println("Criado com sucesso!");
	    conexao.close();
	}

}
