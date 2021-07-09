package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultarTodosProdutos {

	public static void main(String[] args) throws SQLException {
		//conectando
		Connection conexao = conectarBanco.getconexao();
		Statement stmt = conexao.createStatement();
		String sql = "select * from produto;";
		ResultSet resultado = stmt.executeQuery(sql);
		
		ArrayList<Produto> listProdutos = new ArrayList<>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt(1);
			String descricao = resultado.getString(2);
			double preco = resultado.getDouble(3);
			listProdutos.add(new Produto(codigo,descricao,preco));
		}
		
		for(Produto p : listProdutos) {
			System.out.println(p);
		}
		
		
		
		
	}
	
}
