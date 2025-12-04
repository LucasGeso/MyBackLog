package project;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner teclado = new Scanner(System.in);
		
		UsuarioDOA user = new UsuarioDOA();
		
		MenuUsuario[] menu = MenuUsuario.values();
		MenuUsuario opcion = null;
		int numero;
		
		do {
		System.out.println("Seleccione una de las siguientes opciones");
		MostrarMenuUsuario(menu);
		numero = teclado.nextInt();
		} while(numero!=1 && numero!=2);
		
		opcion = menu[numero-1];
		
		switch(opcion) {
		case CREAR_UN_USUARIO:
			CrearUnUsuario(teclado, user);
			break;
		case LOGUEAR_UN_USUARIO:
			break;
		default:
			break;
		}

	}

	private static void CrearUnUsuario(Scanner teclado, UsuarioDOA user) throws SQLException {
		Usuario nuevo = null;
		do {
		System.out.println("Ingrese un nombre de usuario: ");
		String nombre = teclado.next();
		System.out.println("Ingrese un mail");
		String mail = teclado.next();
		System.out.println("Ingrese una contraseña -- Debe contener una mayúscula, un número y un símbolo");
		String password = teclado.next();
		
		try {
			nuevo = new Usuario(nombre, mail, password);
		} catch(PasswordInvalida e) {
			System.out.println(e.getMessage());
		} catch (EmailInvalido e) {
			System.out.println(e.getMessage());
		}
		} while(nuevo == null);
		
		try {
		user.guardarUsuario(nuevo);
		System.out.println("Usuario creado correctamente");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void MostrarMenuUsuario(MenuUsuario[] menu) {
		for(int i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}	
	}


}
