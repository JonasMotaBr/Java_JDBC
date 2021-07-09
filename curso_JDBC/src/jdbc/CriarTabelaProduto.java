package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaProduto {
	
	
	public static void main(String[] args) throws SQLException {
		
		
		Connection conexao = conectarBanco.getconexao();
		
		Statement stmt = conexao.createStatement();
		
		String sql="CREATE TABLE IF NOT EXISTS PRODUTO("
				+ "codigo int unsigned not null auto_increment,"
				+ "nome varchar(45),"
				+ "preco decimal(5,2),"
				+ "primary key(codigo)"
				+ "); ";
		
		stmt.execute(sql);
		
		
	}
	
	
	

}
