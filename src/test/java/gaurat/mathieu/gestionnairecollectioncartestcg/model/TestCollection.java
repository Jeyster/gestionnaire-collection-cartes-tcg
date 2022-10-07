package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCollection {

	private static final Integer GAME1_ID = 1;
	private static final Integer GAME2_ID = 2;
	private static final String GAME1_NAME = "Game1 Name";
	private static final String GAME2_NAME = "Game2 Name";
	private static final String USER1_NAME = "Name1";
	private static final String USER2_NAME = "Name2";
	private static final String USER1_FORNAME = "Forname1";
	private static final String USER2_FORNAME = "Forname2";
	private static final String USER1_EMAIL = "Email1";
	private static final String USER2_EMAIL = "Email2";
	private static final Integer COLLECTION1_ID = 1;
	private static final Integer COLLECTION2_ID = 2;

	
	private static Game game1;
	private static Game game2;
	private static User user1;
	private static User user2;
	private static Collection collection1;
	
	@BeforeAll
	static void beforeAll() {
		game1 = new Game();
		game1.setIdGame(GAME1_ID);
		game1.setName(GAME1_NAME);
		
		game2 = new Game();
		game2.setIdGame(GAME2_ID);
		game2.setName(GAME2_NAME);
		
		user1 = new User();
		user1.setForname(USER1_FORNAME);
		user1.setName(USER1_NAME);
		user1.setEmail(USER1_EMAIL);
		
		user2 = new User();
		user2.setForname(USER2_FORNAME);
		user2.setName(USER2_NAME);
		user2.setEmail(USER2_EMAIL);
		
		collection1 = new Collection();
		collection1.setIdCollection(COLLECTION1_ID);
		collection1.setGame(game1);
		collection1.setUser(user1);	
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(collection1.equals(collection1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(collection1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(collection1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		Collection collection2 = new Collection();
		collection2.setIdCollection(COLLECTION1_ID);
		collection2.setGame(game1);
		collection2.setUser(user1);	
		
		assertTrue(collection1.equals(collection2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		Collection collection2 = new Collection();
		collection2.setIdCollection(COLLECTION2_ID);
		collection2.setGame(game1);
		collection2.setUser(user1);	
		
		Collection collection3 = new Collection();
		collection3.setIdCollection(COLLECTION1_ID);
		collection3.setGame(game2);
		collection3.setUser(user1);	
		
		Collection collection4 = new Collection();
		collection4.setIdCollection(COLLECTION1_ID);
		collection4.setGame(game1);
		collection4.setUser(user2);	
		
		assertFalse(collection1.equals(collection2));
		assertFalse(collection1.equals(collection3));
		assertFalse(collection1.equals(collection4));
	}
}
