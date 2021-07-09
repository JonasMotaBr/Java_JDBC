package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class conectarBanco {
	
	public static Connection getconexao()  {
		
	    try {
	    	Properties prop =       getProperties();
	      	final String url =      prop.getProperty("banco.url");
	      	final String usuario =  prop.getProperty("banco.user");
	      	final String senha =    prop.getProperty("banco.password");
	    
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Metodo para acessar arquivo 
	 public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		//String caminho = "/conectar.properties";
		FileInputStream file = new FileInputStream("D:\\Arquivos\\Aquivos Java\\CursoJDBC\\ArquivoBancoCursoJava\\connected.properties");
		prop.load(file);
		return prop;

		
		/*nao funciona
		 * String caminho = System.getProperty("C:/Users/Eletronica");
		 * prop.load(conectarBanco.class.getResourceAsStream(caminho)); return prop;
		 */
	}

}
