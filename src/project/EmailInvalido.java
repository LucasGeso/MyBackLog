package project;

public class EmailInvalido extends Exception {
	public EmailInvalido(){
		super("El Email ingresado no es valido, inténtelo de nuevo");
	}

}
