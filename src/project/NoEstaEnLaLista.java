package project;

public class NoEstaEnLaLista extends Exception {
	
	public NoEstaEnLaLista(){
		super("Este juego no se encuentra en tu Backlog");
	}

}
