//package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class TestCardDTO {
//	
//	private static final String GAME_NAME = "gameName";
//	private static final String CARD_NAME = "cardName";
//	
//	private static CardDTO cardDTO1;
//	
//	@BeforeAll
//	static void beforeAll() {
//		cardDTO1 = new CardDTO();
//		cardDTO1.setGame(GAME_NAME);
//		cardDTO1.setName(CARD_NAME);
//	}
//
//	@Test
//	@DisplayName("Test equals() entre un objet et lui-même")
//	void testEquals_sameObject() {
//		assertTrue(cardDTO1.equals(cardDTO1));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre un objet et null")
//	void testEquals_nullObject() {
//		assertFalse(cardDTO1.equals(null));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
//	void testEquals_otherClass() {
//		assertFalse(cardDTO1.equals(new Object()));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre 2 objets avec même attributs")
//	void testEquals_objectsWithSameAttributes() {	
//		CardDTO cardDTO2 = new CardDTO();
//		cardDTO2.setGame(GAME_NAME);
//		cardDTO2.setName(CARD_NAME);
//		
//		assertTrue(cardDTO1.equals(cardDTO2));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre 2 objets avec différents attributs")
//	void testEquals_objectsWithDifferentAttributes() {
//		CardDTO cardDTO2 = new CardDTO();
//		cardDTO2.setGame(GAME_NAME);
//		cardDTO2.setName("toto");
//		
//		CardDTO cardDTO3 = new CardDTO();
//		cardDTO3.setGame("toto");
//		cardDTO3.setName(CARD_NAME);
//		
//		assertFalse(cardDTO1.equals(cardDTO2));
//		assertFalse(cardDTO1.equals(cardDTO3));
//	}
//
//}
