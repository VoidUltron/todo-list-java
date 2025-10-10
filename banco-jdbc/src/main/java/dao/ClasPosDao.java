package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaoJDBC.SingleConnection;
import model.todoClass;

public class ClasPosDao {
	
	private Connection connection;
	
	public ClasPosDao() {
		
		connection = SingleConnection.getConnection();
		
	}
	
	public void salvar(todoClass todoclass) {
		try {
		String sql = "insert into titulo (id, nome) values(?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, todoclass.getId());
		insert.setString(2, todoclass.getNome());
		insert.execute();
		connection.commit(); // salva no banco
		System.out.println("inserido!");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
