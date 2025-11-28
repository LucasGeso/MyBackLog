package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void crearUnUsuarioCorrectamente() throws PasswordInvalida, EmailInvalido {
		Usuario user1 = new Usuario("Jabock", "lucasgeso@live.com.ar", "MetalShow92!");
		assertNotNull(user1);
	}
	
	@Test
	void controlarQueSeGenereCorrectamenteElId() throws PasswordInvalida, EmailInvalido {
		Usuario user1 = new Usuario("Jabock", "lucasgeso@live.com.ar", "MetalShow92!");
		Usuario user2 = new Usuario("Johlu", "johanna.guardia@gmail.com", "Pupita1234!");
		assertEquals(1, user1.getId_usuario());
		assertEquals(2, user2.getId_usuario());
		
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnMaiSinSignoArroba() throws PasswordInvalida, EmailInvalido {
		assertThrows(EmailInvalido.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgesolive.com.ar", "MetalShow92!");
		});
	}
	
	@Test
	void queNoSePuedaCrearUnUsuarioConUnMaiSinPuntoCom() throws PasswordInvalida, EmailInvalido {
		assertThrows(EmailInvalido.class, () -> {
			Usuario nuevo = new Usuario("Jabock", "lucasgeso@live.ar", "MetalShow92!");
		});
	}
	

}
