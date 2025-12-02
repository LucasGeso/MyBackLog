package project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	
	Usuario user1;
	Usuario user2;
	
	@BeforeEach
	void setUp() throws PasswordInvalida, EmailInvalido {
		user1 = new Usuario("Jabock", "lucasgeso@live.com.ar", "MetalShow92!");
		user2 = new Usuario("Johlu", "johanna.guardia@gmail.com", "Pupita1234!");
	
	}

	@Test
	void crearUnUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido {
		assertNotNull(user1);
	}
	
	@Test
	void controlarQueSeGenereCorrectamenteElId() throws PasswordInvalida, EmailInvalido {
		assertEquals(7, user1.getId_usuario());
		assertEquals(8, user2.getId_usuario());
		
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnMailSinSignoArroba() throws PasswordInvalida, EmailInvalido {
		assertThrows(EmailInvalido.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgesolive.com.ar", "MetalShow92!");
		});
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnMailSinPuntoCom() throws PasswordInvalida, EmailInvalido {
		assertThrows(EmailInvalido.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.ar", "MetalShow92!");
		});
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnaPasswordSinMayuscula() throws PasswordInvalida, EmailInvalido{
		assertThrows(PasswordInvalida.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.com.ar", "metalshow92!");
		});
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnaPasswordSinNumero() {
		assertThrows(PasswordInvalida.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.com.ar", "Metalshow!");
		});
		
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnaPasswordSinSigno() {
		assertThrows(PasswordInvalida.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.com.ar", "Metalshow92");
		});
	}
	

	@Test
	void queNoSePuedaCrearUnUsuarioConUnaPasswordConEspacio() {
		assertThrows(PasswordInvalida.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.com.ar", "Panic Show92!");
		});
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnaPasswordConMenosDeOchoCaracteres() {
		assertThrows(PasswordInvalida.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.com.ar", "Show92!");
		});
	}
	
	@Test
	void queSePuedaAgregarUnaTareaALaListaDelUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido, TareaYaAgregada {
		Tarea juego = new Tarea("Ghost of Tsushima", Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnaTareaATuLista(juego);
		
		Iterator<Tarea> iterador = user1.getLista().iterator();
		
		assertEquals(juego, iterador.next());
	}
	
	@Test
	void queSePuedaComprobarLaCantidadDeTareasQuePoseeLaLista() throws PasswordInvalida, EmailInvalido, TareaYaAgregada {
		Tarea juego = new Tarea("Ghost of Tsushima", Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnaTareaATuLista(juego);
		
		assertEquals(1, user1.getCantidadDeTareasEnLaLista());
	}
	
	@Test
	void queSePuedaBorrarUnaTareaEnLaListaDelUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido, TareaYaAgregada, NoEstaEnLaLista {
		Tarea juego = new Tarea("Ghost of Tsushima", Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnaTareaATuLista(juego);
		user1.borrarTareaDeTuLista("ghost of tsushima");
		assertEquals(0, user1.getCantidadDeTareasEnLaLista());
	}
	
	@Test
	void queNoSePuedaAgregarDosTareasConElMismoIdALaLista() throws PasswordInvalida, EmailInvalido, TareaYaAgregada {
		Tarea juego1 = new Tarea("Ghost of Tsushima", Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnaTareaATuLista(juego1);
		
		assertThrows(TareaYaAgregada.class, () -> {
			user1.agregarUnaTareaATuLista(juego1);
		});
		
	}

}
