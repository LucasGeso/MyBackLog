package project;

import java.time.LocalDate;

public class VideoJuego implements Comparable<VideoJuego>{
	
	private Integer id_videoJuego;
	private String nombre;
	private Integer duracionEnHoras;
	private Dificultad nivelDificultad;
	private LocalDate fechaDeLanzamiento;

	public VideoJuego(Integer id, String nombre, Integer duracion, Dificultad dif, String fecha){
		this.id_videoJuego = id;
		this.nombre = nombre;
		this.duracionEnHoras = duracion;
		this.nivelDificultad = dif;
		this.fechaDeLanzamiento = LocalDate.parse(fecha);
	}

	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(VideoJuego o) {
		return this.id_videoJuego.compareTo(o.id_videoJuego);
	}

}
