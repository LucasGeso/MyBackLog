package project;

import java.util.HashSet;
import java.util.Set;

public class Usuario {
	
	private String nombre;
	private String password;
	private String eMail;
	private Set<Juego> misJuegos;
	
	public Usuario() {
		this.misJuegos = new HashSet<Juego>();
	}
	

}
