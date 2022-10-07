package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestUser {

	private static final Integer USER1_ID = 1;
	private static final Integer USER2_ID = 2;
	private static final String USER1_NAME = "User1 Name";
	private static final String USER2_NAME = "User2 Name";
	private static final String USER1_FORNAME = "User1 Forname";
	private static final String USER2_FORNAME = "User2 Forname";
	private static final String USER1_EMAIL = "User1 Email";
	private static final String USER2_EMAIL = "User2 Email";
	
	private static User user1;
	
	@BeforeAll
	static void beforeAll() {
		user1 = new User();
		user1.setIdUser(USER1_ID);
		user1.setName(USER1_NAME);
		user1.setForname(USER1_FORNAME);
		user1.setEmail(USER1_EMAIL);
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(user1.equals(user1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(user1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(user1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		User user2 = new User();
		user2.setIdUser(USER1_ID);
		user2.setName(USER1_NAME);	
		user2.setForname(USER1_FORNAME);
		user2.setEmail(USER1_EMAIL);
		
		assertTrue(user1.equals(user2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		User user2 = new User();
		user2.setIdUser(USER2_ID);
		user2.setName(USER1_NAME);	
		user2.setForname(USER1_FORNAME);
		user2.setEmail(USER1_EMAIL);
		
		User user3 = new User();
		user3.setIdUser(USER1_ID);
		user3.setName(USER2_NAME);	
		user3.setForname(USER1_FORNAME);
		user3.setEmail(USER1_EMAIL);
		
		User user4 = new User();
		user4.setIdUser(USER1_ID);
		user4.setName(USER1_NAME);	
		user4.setForname(USER2_FORNAME);
		user4.setEmail(USER1_EMAIL);
		
		User user5 = new User();
		user5.setIdUser(USER1_ID);
		user5.setName(USER1_NAME);	
		user5.setForname(USER1_FORNAME);
		user5.setEmail(USER2_EMAIL);
		
		assertFalse(user1.equals(user2));
		assertFalse(user1.equals(user3));
		assertFalse(user1.equals(user4));
		assertFalse(user1.equals(user5));
	}

}
