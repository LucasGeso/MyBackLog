package project;

import java.util.Comparator;

public class OrdenarPorFecha implements Comparator<Tarea>{

	@Override
	public int compare(Tarea o1, Tarea o2) {
		int resultado = o1.getFechaDeRealización().compareToIgnoreCase(o2.getFechaDeRealización());
		
		if(resultado == 0) {
			resultado =  o1.getId_Tareas().compareTo(o2.getId_Tareas());
		}
		return resultado;
	}
}
