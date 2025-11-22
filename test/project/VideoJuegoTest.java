package project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoJuegoTest {
	
	VideoJuego prueba1;
	VideoJuego prueba2;
	VideoJuego prueba3;
	
	@BeforeEach
	void setUp() {
		prueba1 = new VideoJuego(1, "Star Wars: Jedi Survivor", 25, Dificultad.FÁCIL, "2022-04-28");
		prueba2 = new VideoJuego(2, "Silent Hill 2", 35, Dificultad.DIFÍCIL, "2024-08-12");
		prueba3 = new VideoJuego(3, "Expedition 33: Clair´s Obscure", 30, Dificultad.MEDIO, "2025-03-22"); 
	}

	@Test
	void QueSeGuardeUnVideoJuegoCorrectamente() {
		assertNotNull(prueba1);
	}
	
	@Test
	void QueSeOrdenVariosJuegosPorSuId() {
		
		Set<VideoJuego> listaPrueba = new TreeSet<VideoJuego>();
		
		listaPrueba.add(prueba2);
		listaPrueba.add(prueba3);
		listaPrueba.add(prueba1);
		
		Iterator<VideoJuego> juego = listaPrueba.iterator();
		
			assertEquals(prueba1,juego.next());
			assertEquals(prueba2,juego.next());
			assertEquals(prueba3,juego.next());
			assertFalse(juego.hasNext());
	}

}
