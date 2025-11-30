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
	void queSePuedaAgregarUnJuegoALaListaDelUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido, JuegoYaAgregado {
		VideoJuego juego = new VideoJuego(1, "Ghost of Tsushima", 35, Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnJuegoATuLista(juego);
		
		Iterator<VideoJuego> iterador = user1.getLista().iterator();
		
		assertEquals(juego, iterador.next());
	}
	
	@Test
	void queSePuedaComprobarLaCantidadDeJuegosQuePoseeLaLista() throws PasswordInvalida, EmailInvalido, JuegoYaAgregado {
		VideoJuego juego = new VideoJuego(1, "Ghost of Tsushima", 35, Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnJuegoATuLista(juego);
		
		assertEquals(1, user1.getCantidadDeJuegosEnLaLista());
	}
	
	@Test
	void queSePuedaBorrarUnJuegoEnLaListaDelUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido, JuegoYaAgregado, NoEstaEnLaLista {
		VideoJuego juego = new VideoJuego(1, "Ghost of Tsushima", 35, Dificultad.FÁCIL, "2018-08-20");
		user1.agregarUnJuegoATuLista(juego);
		user1.borrarJuegoDeTuLista("ghost of tsushima");
		assertEquals(0, user1.getCantidadDeJuegosEnLaLista());
	}
	
	@Test
	void queNoSePuedaAgregarDosJuegosConElMismoIdALaLista() throws PasswordInvalida, EmailInvalido, JuegoYaAgregado {
		VideoJuego juego1 = new VideoJuego(1, "Ghost of Tsushima", 35, Dificultad.FÁCIL, "2018-08-20");
		VideoJuego juego2 = new VideoJuego(1, "Sekiro: Shadow Die Twice", 40, Dificultad.DIFÍCIL, "2016-07-11");
		user1.agregarUnJuegoATuLista(juego1);
		
		assertThrows(JuegoYaAgregado.class, () -> {
			user1.agregarUnJuegoATuLista(juego2);
		});
		
	}

}
