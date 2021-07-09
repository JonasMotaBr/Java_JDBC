package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Dao {
	
	
		private Connection conexao;
		
		
		
		public  Connection getConnection(){
		try {
			if(conexao!=null && conexao.isClosed()) {
					return conexao;
				}
		} catch (SQLException e) {
		
		}
		  Connection conexao = conectarBanco.getconexao();
		  return conexao;
		 
		}
		//------------------------------------
		
		public int inserirProduto(Produto p)  {
			
			Connection conexao = getConnection();
			String sql = "INSERT INTO produto(nome,preco) VALUES(?,?);";
			PreparedStatement stmt;
			
			try {
				stmt = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setString(1, p.getDescricao());
			    stmt.setDouble(2, p.getPreco());
			    stmt.execute();
			    ResultSet codResultado = stmt.getGeneratedKeys();
			    if(codResultado.next()) {
			    	return codResultado.getInt(1);
			    }
			    
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return -1;
		}
		
	 public void exibirTodos() {
		 ArrayList<Produto> listProdutos = new ArrayList<>();
		 Connection conexao = getConnection();
		 try {
			Statement stmt = conexao.createStatement();
			String sql = "SELECT * FROM produto;";
			ResultSet resultado = stmt.executeQuery(sql);
			
			while(resultado.next()) {
				int codigo=resultado.getInt(1);
				String descricao=resultado.getString(2);
				double preco=resultado.getDouble(3);
				listProdutos.add(new Produto(codigo,descricao,preco));
			}
			for(Produto p : listProdutos) {
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
		
	
	

}
