package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DeletarProduto {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o codigo:");
		int cod = entrada.nextInt();
		
		
		Connection conexao = conectarBanco.getconexao();
		String select = "SELECT * FROM produto WHERE codigo=?; ";
		PreparedStatement stmt = conexao.prepareStatement(select);
		stmt.setInt(1, cod);
		stmt.execute();
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Produto> listProdutoDelet = new ArrayList<>();
		
		
		if(resultado.next()) {
			int codigo = resultado.getInt(1);
			String descricao = resultado.getString(2);
			double preco = resultado.getDouble(3);
			listProdutoDelet.add(new Produto(codigo,descricao,preco));
			
			for(Produto p : listProdutoDelet) {
			System.out.println(p);
		   }
		  
			System.out.println(cod);
		  Scanner entrada2 = new Scanner(System.in);	
		  System.out.println("Deletar produto? SIM | NAO");	
		  String  del_usu= entrada2.nextLine();
		  
		  if(del_usu.equalsIgnoreCase("sim")) {
          String delsql = "DELETE FROM produto where codigo=?;";
		  PreparedStatement stmt2 = conexao.prepareStatement(delsql);
		  stmt2.setInt(1, cod);
		  stmt2.execute();
			System.out.println("Produto excluido");  
		  }
		 
			
		}else {
			System.out.println("Produto não encontrado");
		}
		
		
		
		
		

	}

}
