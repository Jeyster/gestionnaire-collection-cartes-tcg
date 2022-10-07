package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestGame {

	private static final Integer GAME1_ID = 1;
	private static final Integer GAME2_ID = 2;
	private static final String GAME1_NAME = "Game1 Name";
	private static final String GAME2_NAME = "Game2 Name";
	
	private static Game game1;
	
	@BeforeAll
	static void beforeAll() {
		game1 = new Game();
		game1.setIdGame(GAME1_ID);
		game1.setName(GAME1_NAME);
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(game1.equals(game1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(game1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(game1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		Game game2 = new Game();
		game2.setIdGame(GAME1_ID);
		game2.setName(GAME1_NAME);	
		
		assertTrue(game1.equals(game2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		Game game2 = new Game();
		game2.setIdGame(GAME2_ID);
		game2.setName(GAME1_NAME);
		
		Game game3 = new Game();
		game3.setIdGame(GAME1_ID);
		game3.setName(GAME2_NAME);
		
		assertFalse(game1.equals(game2));
		assertFalse(game1.equals(game3));
	}

}
