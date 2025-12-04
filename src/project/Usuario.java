package project;

import java.util.Set;
import java.util.TreeSet;

public class Usuario {
	private static Integer id = 1;
	
	private Integer id_usuario;
	private String nombre;
	private String password;
	private String eMail;
	private Set<Tarea> lista;

	public Usuario(String nombre, String mail, String pass) throws PasswordInvalida, EmailInvalido {
		setPassword(pass);
		setEmail(mail);
		this.id_usuario = id++;
		this.nombre = nombre;
		this.lista = new TreeSet<Tarea>();
	} 
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String geteMail() {
		return eMail;
	}

	public Integer getCantidadDeTareasEnLaLista() {
		return this.lista.size();
	}

	public Set<Tarea> getLista() {
		return lista;
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
	Boolean respuesta = pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}.+$");
		
	if(!respuesta || pass.contains(" ")){
		throw new PasswordInvalida();
	} 
	return respuesta;
	}

	
	public void agregarUnaTareaATuLista(Tarea juego) throws TareaYaAgregada {
		Boolean respuesta = lista.add(juego);

		if(!respuesta){
			throw new TareaYaAgregada();
		}
	}
	

	public void borrarTareaDeTuLista(String nombre) throws NoEstaEnLaLista {
		Boolean respuesta = false;

		for(Tarea juego : lista){
			if(juego.getNombre().equalsIgnoreCase(nombre)){
				lista.remove(juego);
				respuesta = true;
			}
		}

		if(!respuesta){
			throw new NoEstaEnLaLista();
		}
	}
	

	
	

}
