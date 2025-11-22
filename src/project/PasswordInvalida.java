package project;

public class PasswordInvalida extends Exception {
	public PasswordInvalida() {
		super("La contraseña ingresada es invalida, inténtelo nuevamente");
	}

}
