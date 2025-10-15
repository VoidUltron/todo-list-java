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
	    
	    todoclass.setNome("Pablo Henrique Gonçalves");
	    todoclass.setDescricao("Fazer compras online");
	    
	    
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

	@Test
	public void initAtualizar() {
		try {
			ClasPosDao dao = new ClasPosDao();

			todoClass objetoBanco = dao.buscar(5L);
			
			objetoBanco.setNome("Nome atualizado COM METODO");
			
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		ClasPosDao dao = new ClasPosDao();
		todoClass todoclass;
		try {
			todoclass = dao.buscar(6L);
			System.out.println(todoclass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void initDeletar() {
		
		try {
		    ClasPosDao dao = new ClasPosDao();
		    dao.deletar(1L);
		} catch (Exception e) {
			e.printStackTrace();		}
	}

}
