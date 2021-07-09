package jdbc;

public class Main {

	public static void main(String[] args) {
	
		Dao dao = new Dao();
		
		//dao.inserirProduto("Fonte Corsair 600w", 489);
		//System.out.println(dao.inserirProduto(new Produto("HD SEAGATE 1TB", 449)));
		dao.exibirTodos();
		
		

	}

}
