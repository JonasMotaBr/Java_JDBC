package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InserirProduto {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe a descrição:");
		String descricao = entrada.nextLine();
		
		System.out.println("Informe o preco, inserindo com virgula:");
		Double preco = entrada.nextDouble();
		
		
		/*
		 *forma nao confiavel
		 * Connection conexao = conectarBanco.getconexao(); 
		 * Statement stmt = conexao.createStatement(); 
		 * stmt.execute("insert into pessoas value"
		 *  +"(default,'"+nome+"');");
		 */
		Connection conexao = conectarBanco.getconexao();
		String sql = ("insert into produto (nome,preco) values (?,?) ");
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descricao);
		stmt.setDouble(2, preco);
		stmt.execute();
		System.out.println("Produto inserido com sucesso!!");		
		
	}

}
