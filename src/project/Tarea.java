package project;

public class Tarea implements Comparable<Tarea>{
	
	private static Integer id =1;
	private Integer id_Tareas;
	private String nombre;
	private Dificultad nivelDificultad;
	private String fechaDeRealización;

	public Tarea(String nombre, Dificultad dif, String fecha){
		this.id_Tareas = id++;
		this.nombre = nombre;
		this.nivelDificultad = dif;
		this.fechaDeRealización = fecha;
	}

	
	public String getNombre() {
		return nombre;
	}

	public String getFechaDeRealización() {
		return fechaDeRealización;
	}

	public Integer getId_Tareas() {
		return id_Tareas;
	}


	@Override
	public int compareTo(Tarea o) {
		return this.id_Tareas.compareTo(o.id_Tareas);
	}

}
