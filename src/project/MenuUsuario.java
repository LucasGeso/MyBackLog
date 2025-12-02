package project;

public enum MenuUsuario {
	
	CREAR_UN_USUARIO("1 - Registrarse"), LOGUEAR_UN_USUARIO("2 - Loguearse");
	
	private String mensaje;
	
	MenuUsuario(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String toString() {
		return mensaje;
	}
	

}
