package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJDBC.SingleConnection;
import model.todoClass;

public class ClasPosDao {
	
	private Connection connection;
	
	public ClasPosDao() {
		
		connection = SingleConnection.getConnection();
		
	}
	
	public void salvar(todoClass todoclass) {
		try {
		String sql = "insert into titulo (id, nome, descricao) values(?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setLong(1, todoclass.getId());
		insert.setString(2, todoclass.getNome());
		insert.setString(3, todoclass.getDescricao());
		insert.execute();
		connection.commit(); // salva no banco
		System.out.println("inserido!");
		
		}catch(Exception e) {
			try {
				connection.rollback();//reverte operação
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public List<todoClass> listar() throws Exception{
		List<todoClass> list = new ArrayList<todoClass>();
		
		String sql = "select * from titulo";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			todoClass todoclass = new todoClass();
			todoclass.setId(resultado.getLong("id"));
			todoclass.setNome(resultado.getString("nome")); 
			todoclass.setDescricao(resultado.getString("descricao"));
			list.add(todoclass);
		}
		
		return list;
	}
	}

