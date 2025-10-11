package banco_jdbc.banco_jdbc;

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
	    
	    todoclass.setId(7L);
	    todoclass.setNome("Pablo teste");
	    todoclass.setDescricao("Fazer compras");
	    
	    
	    clasposdao.salvar(todoclass);
	}

}
