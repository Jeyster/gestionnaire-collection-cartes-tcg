package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCard {

	private static final Integer CARD_ID = 1;
	private static final String CARD_NAME = "Card Name";
	private static final Integer GAME1_ID = 1;
	private static final String GAME1_NAME = "Game1 Name";
	private static final Integer GAME2_ID = 2;
	private static final String GAME2_NAME = "Game2 Name";
	
	private static Card card1;
	private static Game game1;
	private static Game game2;
	
	@BeforeAll
	static void beforeAll() {
		game1 = new Game();
		game1.setIdGame(GAME1_ID);
		game1.setName(GAME1_NAME);
		
		game2 = new Game();
		game2.setIdGame(GAME2_ID);
		game2.setName(GAME2_NAME);
		
		card1 = new Card();
		card1.setIdCard(CARD_ID);
		card1.setName(CARD_NAME);
		card1.setGame(game1);
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(card1.equals(card1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(card1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(card1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		Card card2 = new Card();
		card2.setIdCard(CARD_ID);
		card2.setName(CARD_NAME);
		card2.setGame(game1);
		
		assertTrue(card1.equals(card2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		Card card2 = new Card();
		card2.setIdCard(2);
		card2.setName(CARD_NAME);
		card2.setGame(game1);
		
		Card card3 = new Card();
		card3.setIdCard(CARD_ID);
		card3.setName("toto");
		card3.setGame(game1);
		
		Card card4 = new Card();
		card4.setIdCard(CARD_ID);
		card4.setName(CARD_NAME);
		card4.setGame(game2);
		
		assertFalse(card1.equals(card2));
		assertFalse(card1.equals(card3));
		assertFalse(card1.equals(card4));
	}

}
