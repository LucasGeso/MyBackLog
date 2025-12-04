package project;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import conexion.Conexion;

import org.junit.jupiter.api.Test;



class ConexionTest {

	@Test
	void pruebaConexionSql() throws SQLException {
		 Connection con = Conexion.getConexion();

	      assertNotNull(con);
	}

}
