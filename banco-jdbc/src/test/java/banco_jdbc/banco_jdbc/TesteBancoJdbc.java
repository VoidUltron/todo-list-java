package banco_jdbc.banco_jdbc;

import java.util.List;

import org.junit.Test;

import conexaoJDBC.SingleConnection;
import dao.ClasPosDao;
import junit.framework.TestCase;
import model.todoClass;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		ClasPosDao clasposdao = new ClasPosDao();
	    todoClass todoclass = new todoClass();
	    
	    todoclass.setId(9L);
	    todoclass.setNome("Pablo teste");
	    todoclass.setDescricao("Fazer compras");
	    
	    
	    clasposdao.salvar(todoclass);
	}
	
	@Test
	public void initListar() {
		ClasPosDao dao = new ClasPosDao();
		try {
			List<todoClass> list = dao.listar();
			for (todoClass todoClass : list) {
				System.out.println(todoClass);
				System.out.println("-----------------------------------");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
