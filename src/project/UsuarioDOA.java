package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.Conexion;

public class UsuarioDOA {
	
	public void guardarUsuario(Usuario nuevo) throws SQLException {
		String sql = "INSERT INTO usuario(id_usuario, nombre, mail, password) VALUES(?, ?, ?, ?)";
		
		Connection con = Conexion.getConexion();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, nuevo.getId_usuario());
		ps.setString(2, nuevo.getNombre());
		ps.setString(3, nuevo.geteMail());
		ps.setString(4, nuevo.getPassword());
		
		ps.executeUpdate();
	}

}
