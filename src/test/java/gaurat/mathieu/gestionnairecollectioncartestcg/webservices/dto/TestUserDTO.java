package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestUserDTO {

	private static final String NAME = "name";
	private static final String FORNAME = "forname";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	
	private static UserDTO userDTO1;
	
	@BeforeAll
	static void beforeAll() {
		userDTO1 = new UserDTO();
		userDTO1.setName(NAME);
		userDTO1.setForname(FORNAME);
		userDTO1.setLogin(LOGIN);
		userDTO1.setPassword(PASSWORD);
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(userDTO1.equals(userDTO1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(userDTO1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(userDTO1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setName(NAME);
		userDTO2.setForname(FORNAME);
		userDTO2.setLogin(LOGIN);
		userDTO2.setPassword(PASSWORD);
		
		assertTrue(userDTO1.equals(userDTO2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setName(NAME);
		userDTO2.setForname("toto");
		userDTO2.setLogin(LOGIN);
		userDTO2.setPassword(PASSWORD);
		
		assertFalse(userDTO1.equals(userDTO2));
	}

}
