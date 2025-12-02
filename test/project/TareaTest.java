package project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TareaTest {
	
	Tarea prueba1;
	Tarea prueba2;
	Tarea prueba3;
	
	@BeforeEach
	void setUp() {
		prueba1 = new Tarea("Renobar Registro", Dificultad.FÁCIL, "2025-12-20");
		prueba2 = new Tarea("Pagar El Agua", Dificultad.DIFÍCIL, "2025-12-26");
		prueba3 = new Tarea("Turno Traumatólogo", Dificultad.MEDIO, "2025-12-22"); 
	}

	@Test
	void QueSeGuardeUnaTareaCorrectamente() {
		assertNotNull(prueba1);
	}
	
	@Test
	void QueSeOrdenVariasTareasPorSuId() {
		
		Set<Tarea> listaPrueba = new TreeSet<Tarea>();
		
		listaPrueba.add(prueba2);
		listaPrueba.add(prueba3);
		listaPrueba.add(prueba1);
		
		Iterator<Tarea> juego = listaPrueba.iterator();
		
			assertEquals(prueba1,juego.next());
			assertEquals(prueba2,juego.next());
			assertEquals(prueba3,juego.next());
			assertFalse(juego.hasNext());
	}

}
