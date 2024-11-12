//package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class TestCardCopiesDTO {
//
//	private static final Integer CARD1_ID = 1;
//	private static final Integer CARD2_ID = 2;
//	private static final Integer COLLECTION1_ID = 1;
//	private static final Integer COLLECTION2_ID = 2;
//	private static final Integer CARD_COPIES_NUMBER4 = 4;
//	private static final Integer CARD_COPIES_NUMBER3 = 3;
//	
//	private static CardCopiesDTO cardCopiesDTO1;
//	
//	@BeforeAll
//	static void beforeAll() {	
//		cardCopiesDTO1 = new CardCopiesDTO();
//		cardCopiesDTO1.setIdCollection(COLLECTION1_ID);
//		cardCopiesDTO1.setIdCard(CARD1_ID);
//		cardCopiesDTO1.setCopiesNumber(CARD_COPIES_NUMBER4);		
//	}
//
//	@Test
//	@DisplayName("Test equals() entre un objet et lui-même")
//	void testEquals_sameObject() {
//		assertTrue(cardCopiesDTO1.equals(cardCopiesDTO1));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre un objet et null")
//	void testEquals_nullObject() {
//		assertFalse(cardCopiesDTO1.equals(null));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre un objet et un objet d'une autre classe")
//	void testEquals_otherClass() {
//		assertFalse(cardCopiesDTO1.equals(new Object()));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre 2 objets avec même attributs")
//	void testEquals_objectsWithSameAttributes() {	
//		CardCopiesDTO cardCopiesDTO2 = new CardCopiesDTO();
//		cardCopiesDTO2.setIdCollection(COLLECTION1_ID);
//		cardCopiesDTO2.setIdCard(CARD1_ID);
//		cardCopiesDTO2.setCopiesNumber(CARD_COPIES_NUMBER4);	
//		
//		assertTrue(cardCopiesDTO1.equals(cardCopiesDTO2));
//	}
//	
//	@Test
//	@DisplayName("Test equals() entre 2 objets avec différents attributs")
//	void testEquals_objectsWithDifferentAttributes() {	
//		CardCopiesDTO cardCopiesDTO2 = new CardCopiesDTO();
//		cardCopiesDTO2.setIdCollection(COLLECTION2_ID);
//		cardCopiesDTO2.setIdCard(CARD1_ID);
//		cardCopiesDTO2.setCopiesNumber(CARD_COPIES_NUMBER4);
//		
//		CardCopiesDTO cardCopiesDTO3 = new CardCopiesDTO();
//		cardCopiesDTO3.setIdCollection(COLLECTION1_ID);
//		cardCopiesDTO3.setIdCard(CARD2_ID);
//		cardCopiesDTO3.setCopiesNumber(CARD_COPIES_NUMBER4);
//		
//		CardCopiesDTO cardCopiesDTO4 = new CardCopiesDTO();
//		cardCopiesDTO4.setIdCollection(COLLECTION1_ID);
//		cardCopiesDTO4.setIdCard(CARD1_ID);
//		cardCopiesDTO4.setCopiesNumber(CARD_COPIES_NUMBER3);
//		
//		assertFalse(cardCopiesDTO1.equals(cardCopiesDTO2));
//		assertFalse(cardCopiesDTO1.equals(cardCopiesDTO3));
//		assertFalse(cardCopiesDTO1.equals(cardCopiesDTO4));
//	}
//
//}
