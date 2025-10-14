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
	
	public todoClass buscar(Long id) throws Exception{
		todoClass retorno = new todoClass();
		
		String sql = "select * from titulo";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			todoClass todoclass = new todoClass();
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome")); 
			retorno.setDescricao(resultado.getString("descricao"));
			
		}
		
		return retorno;
	}
	
	public void atualizar(todoClass todoclass) {
		try {
			String sql = "update titulo set nome = ? where id = " + todoclass.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, todoclass.getNome());

			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
