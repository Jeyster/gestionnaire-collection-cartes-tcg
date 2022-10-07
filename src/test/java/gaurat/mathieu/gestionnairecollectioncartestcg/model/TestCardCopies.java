package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCardCopies {

	private static final Integer CARD1_ID = 1;
	private static final Integer CARD2_ID = 2;
	private static final String CARD_NAME = "Card Name";
	private static final Integer GAME1_ID = 1;
	private static final String GAME1_NAME = "Game1 Name";
	private static final String USER_NAME = "Name";
	private static final String USER_FORNAME = "Forname";
	private static final String USER_EMAIL = "Email";
	private static final Integer COLLECTION1_ID = 1;
	private static final Integer COLLECTION2_ID = 2;
	private static final Integer CARD_COPIES_ID = 1;
	private static final Integer CARD_COPIES_NUMBER4 = 4;
	private static final Integer CARD_COPIES_NUMBER3 = 3;
	
	private static Card card1;
	private static Card card2;
	private static Game game1;
	private static User user1;
	private static Collection collection1;
	private static Collection collection2;
	private static CardCopies cardCopies1;
	
	@BeforeAll
	static void beforeAll() {
		game1 = new Game();
		game1.setIdGame(GAME1_ID);
		game1.setName(GAME1_NAME);
		
		card1 = new Card();
		card1.setIdCard(CARD1_ID);
		card1.setName(CARD_NAME);
		card1.setGame(game1);
		
		card2 = new Card();
		card2.setIdCard(CARD2_ID);
		card2.setName(CARD_NAME);
		card2.setGame(game1);
		
		user1 = new User();
		user1.setForname(USER_FORNAME);
		user1.setName(USER_NAME);
		user1.setEmail(USER_EMAIL);
		
		collection1 = new Collection();
		collection1.setIdCollection(COLLECTION1_ID);
		collection1.setGame(game1);
		collection1.setUser(user1);
		
		collection2 = new Collection();
		collection2.setIdCollection(COLLECTION2_ID);
		collection2.setGame(game1);
		collection2.setUser(user1);
		
		cardCopies1 = new CardCopies();
		cardCopies1.setIdCardCopies(CARD_COPIES_ID);
		cardCopies1.setCollection(collection1);
		cardCopies1.setCard(card1);
		cardCopies1.setCopiesNumber(CARD_COPIES_NUMBER4);		
	}

	@Test
	@DisplayName("Test equals() entre un objet et lui-même")
	void testEquals_sameObject() {
		assertTrue(cardCopies1.equals(cardCopies1));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et null")
	void testEquals_nullObject() {
		assertFalse(cardCopies1.equals(null));
	}
	
	@Test
	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
	void testEquals_otherClass() {
		assertFalse(cardCopies1.equals(new Object()));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec même attributs")
	void testEquals_objectsWithSameAttributes() {	
		CardCopies cardCopies2 = new CardCopies();
		cardCopies2.setIdCardCopies(CARD_COPIES_ID);
		cardCopies2.setCollection(collection1);
		cardCopies2.setCard(card1);
		cardCopies2.setCopiesNumber(CARD_COPIES_NUMBER4);
		
		assertTrue(cardCopies1.equals(cardCopies2));
	}
	
	@Test
	@DisplayName("Test equals() entre 2 objets avec différents attributs")
	void testEquals_objectsWithDifferentAttributes() {
		CardCopies cardCopies2 = new CardCopies();
		cardCopies2.setIdCardCopies(2);
		cardCopies2.setCollection(collection1);
		cardCopies2.setCard(card1);
		cardCopies2.setCopiesNumber(CARD_COPIES_NUMBER4);
		
		CardCopies cardCopies3 = new CardCopies();
		cardCopies2.setIdCardCopies(CARD_COPIES_ID);
		cardCopies2.setCollection(collection2);
		cardCopies2.setCard(card1);
		cardCopies2.setCopiesNumber(CARD_COPIES_NUMBER4);
		
		CardCopies cardCopies4 = new CardCopies();
		cardCopies4.setIdCardCopies(CARD_COPIES_ID);
		cardCopies4.setCollection(collection2);
		cardCopies4.setCard(card2);
		cardCopies4.setCopiesNumber(CARD_COPIES_NUMBER4);
		
		CardCopies cardCopies5 = new CardCopies();
		cardCopies5.setIdCardCopies(CARD_COPIES_ID);
		cardCopies5.setCollection(collection2);
		cardCopies5.setCard(card2);
		cardCopies5.setCopiesNumber(CARD_COPIES_NUMBER3);
		
		assertFalse(cardCopies1.equals(cardCopies2));
		assertFalse(cardCopies1.equals(cardCopies3));
		assertFalse(cardCopies1.equals(cardCopies4));
		assertFalse(cardCopies1.equals(cardCopies5));
	}

}
