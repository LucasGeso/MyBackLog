package project;

import java.util.Set;
import java.util.TreeSet;

public class Usuario {
	private static Integer id = 0;
	
	private Integer id_usuario;
	private String nombre;
	private String password;
	private String eMail;
	private Set<VideoJuego> lista;

	public Usuario(String nombre, String mail, String pass) throws PasswordInvalida, EmailInvalido {
		setPassword(pass);
		setEmail(mail);
		this.id_usuario = ++id;
		this.nombre = nombre;
		this.lista = new TreeSet<VideoJuego>();
	} 
	
	public Integer getId_usuario() {
		return id_usuario;
	}

	private void setEmail(String mail) throws EmailInvalido {
		if(validarMail(mail)){
			this.eMail = mail;
		}
	}

	private Boolean validarMail(String mail) throws EmailInvalido{
		Boolean respuesta = false;
			if(mail.contains("@") && mail.contains(".com")){
				respuesta = true;
			}
				
			if(!respuesta){
				throw new EmailInvalido();
			} 
		return respuesta;
	}

	private void setPassword(String pass) throws PasswordInvalida {
		if(validarPassword(pass)){
			this.password = pass;
		}
	}

	
	private Boolean validarPassword(String pass) throws PasswordInvalida {	
	Boolean respuesta = pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^a-zA-Z0-9])\\S.{8,}$");
		
	if(!respuesta){
		throw new PasswordInvalida();
	} 
	return respuesta;
	}

	
	public void agregarUnJuegoATuLista(VideoJuego juego) throws JuegoYaAgregado {
		Boolean respuesta = lista.add(juego);

		if(!respuesta){
			throw new JuegoYaAgregado();
		}
	}
	

	public void borrarJuegoDeTuLista(String nombre) throws NoEstaEnLaLista {
		Boolean respuesta = false;

		for(VideoJuego juego : lista){
			if(juego.getNombre().toUpperCase().equals(nombre.toUpperCase())){
				lista.remove(juego);
				respuesta = true;
			}
		}

		if(!respuesta){
			throw new NoEstaEnLaLista();
		}

	}

}
