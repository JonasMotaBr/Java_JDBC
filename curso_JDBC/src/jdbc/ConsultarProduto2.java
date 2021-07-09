package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarProduto2 {
	
	
	public static void main(String[] args) throws SQLException {
		
		String busca=null;
		int cod = 0;
		String desc=null;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe a busca");
		busca = entrada.nextLine();
		
		
		//cod recebe busca se for int, ou desc se for String
	     try {
	    	  cod = Integer.parseInt(busca); 
	    	
	     }catch (NumberFormatException  e) {
	    	 desc = busca;
	    	
		}
	     
	     
		// System.out.println("Resultado busca: "+"int= "+cod +", String= "+desc);
		 
		 
		Connection conexao  =conectarBanco.getconexao();
		PreparedStatement stmt;
		if(cod>0) {
			String sql = "select * from produto where codigo= ? ; ";
			 stmt = conexao.prepareStatement(sql);
			 stmt.setInt(1, cod);
			 
		}else { 
		  String sql = "select * from produto where nome  like ?";
		   stmt = conexao.prepareStatement(sql);
		   stmt.setString(1, desc+"%");
		}
		
		
		ResultSet resultado = stmt.executeQuery();
		
        ArrayList<Produto> listBuscarProdutos = new ArrayList<>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt(1);
			String descricao = resultado.getString(2);
			double preco = resultado.getDouble(3);
			listBuscarProdutos.add(new Produto(codigo,descricao,preco));
		}
	
		
		for(Produto p : listBuscarProdutos) {
			System.out.println(p);
		}
	
		
		
	}
	

}
