package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AtualizarProdutos {
	
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("informe o codigo do produto para atualizar");
		int cod = entrada.nextInt();
	 
	    
		Connection conexao = conectarBanco.getconexao();
		String sql = "select * from produto where codigo= ? ; ";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, cod);
		ResultSet resultado = stmt.executeQuery();
		
		ArrayList<Produto> listBuscarProduto = new ArrayList<>();
		
		if(resultado.next()) {
			int codigo = resultado.getInt(1);
			String descricao = resultado.getString(2);
			double preco = resultado.getDouble(3);
			listBuscarProduto.add(new Produto(codigo,descricao,preco));
			
			for(Produto p : listBuscarProduto) {
			System.out.println(p);
		}
			
			 System.out.println("Informe o novo preço:");
	         double pre = entrada.nextDouble();
	     
	     String update = "UPDATE PRODUTO SET preco =? WHERE CODIGO=? ; ";
		 PreparedStatement stmt2 = conexao.prepareStatement(update);
		 stmt2.setDouble(1, pre);
		 stmt2.setInt(2, cod);
		 stmt2.execute();
		System.out.println("Atualizado com sucesso!");
	     
		
		}else {
		 System.out.println("Produto não encontrado");
		}
		
		entrada.close();
		conexao.close();
	}

}
