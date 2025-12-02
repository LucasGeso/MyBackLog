package project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
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
			break;
		case LOGUEAR_UN_USUARIO:
			break;
		default:
			break;
		}

	}

	private static void MostrarMenuUsuario(MenuUsuario[] menu) {
		for(int i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}
		
	}


}
