package banco_jdbc.banco_jdbc;

import org.junit.Test;

import conexaoJDBC.SingleConnection;
import junit.framework.TestCase;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
