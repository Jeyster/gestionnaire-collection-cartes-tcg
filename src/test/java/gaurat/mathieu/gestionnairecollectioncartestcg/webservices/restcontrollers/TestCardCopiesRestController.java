//package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
//import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
//import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;
//import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
//import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
//import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardCopiesDTO;
//import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardCopiesServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//class TestCardCopiesRestController {
//
//	private static final Integer GAME_ID = 1;
//	private static final String GAME_NAME = "gameName";
//	private static final Integer CARD_ID = 1;
//	private static final String CARD_NAME = "cardName";
//	private static final Integer COLLECTION_ID = 1;
//	private static final Integer USER_ID = 1;
//	private static final String USER_NAME = "userName";
//	private static final String USER_FORNAME = "userForname";
//	private static final String USER_EMAIL = "userEmail";
//	private static final Integer CARD_COPIES_ID = 1;
//	private static final Integer CARD_COPIES_NUMBER = 1;
//	private static final Integer CARD_COPIES_NUMBER_INCREMENTED = 2;
//
//	
//	@Mock
//	private CardCopiesServiceImpl service;
//	
//	@InjectMocks
//	private CardCopiesRestController restController;
//	
//	private static CardCopies cardCopies;
//	private static CardCopies cardCopiesIncremented;
//	private static List<CardCopies> cardsCopies;
//	private static CardCopiesDTO cardCopiesDTO;
//	private static CardCopiesDTO cardCopiesDTOIncremented;
//	private static List<CardCopiesDTO> cardsCopiesDTO;
//	
//	private static Game game;
//	private static Card card;
//	private static User user;
//	private static Collection collection;
//
//	@BeforeAll
//	private static void beforeAll() {
//		game = new Game();
//		game.setIdGame(GAME_ID);
//		game.setName(GAME_NAME);
//		
//		card = new Card();
//		card.setIdCard(CARD_ID);
//		card.setName(CARD_NAME);
//		card.setGame(game);
//		
//		user = new User();
//		user.setIdUser(USER_ID);
//		user.setName(USER_NAME);
//		user.setForname(USER_FORNAME);
//		user.setEmail(USER_EMAIL);
//		
//		collection = new Collection();
//		collection.setIdCollection(COLLECTION_ID);
//		collection.setGame(game);
//		collection.setUser(user);
//		
//		cardCopiesIncremented = new CardCopies();
//		cardCopiesIncremented.setIdCardCopies(CARD_COPIES_ID);
//		cardCopiesIncremented.setCard(card);
//		cardCopiesIncremented.setCollection(collection);
//		cardCopiesIncremented.setCopiesNumber(CARD_COPIES_NUMBER_INCREMENTED);
//		
//		cardCopiesDTO = new CardCopiesDTO();
//		cardCopiesDTO.setIdCard(CARD_ID);
//		cardCopiesDTO.setIdCollection(COLLECTION_ID);
//		cardCopiesDTO.setCopiesNumber(CARD_COPIES_NUMBER);
//		
//		cardCopiesDTOIncremented = new CardCopiesDTO();
//		cardCopiesDTOIncremented.setIdCard(CARD_ID);
//		cardCopiesDTOIncremented.setIdCollection(COLLECTION_ID);
//		cardCopiesDTOIncremented.setCopiesNumber(CARD_COPIES_NUMBER_INCREMENTED);
//		
//		cardsCopiesDTO = new ArrayList<>();
//		cardsCopiesDTO.add(cardCopiesDTO);
//	}
//	
//	@BeforeEach
//	private void beforeEach() {
//		cardCopies = new CardCopies();
//		cardCopies.setIdCardCopies(CARD_COPIES_ID);
//		cardCopies.setCard(card);
//		cardCopies.setCollection(collection);
//		cardCopies.setCopiesNumber(CARD_COPIES_NUMBER);
//		
//		cardsCopies = new ArrayList<>();
//		cardsCopies.add(cardCopies);
//	}
//
//	@Test
//	@DisplayName("mapEntityToDTO : CardCopies is converted in CardCopiesDTO")
//	void testMapEntityToDTO_conversionOk() {	
//		CardCopiesDTO cardCopiesDTOToTest = restController.mapEntityToDTO(cardCopies, CardCopiesDTO.class);
//		assertEquals(cardCopiesDTO, cardCopiesDTOToTest);
//	}
//	
//	@Test
//	@DisplayName("getAll : get all CardCopies and returns OK")
//	void testGetAll_returnsAllCardCopiesOk() {
//		ResponseEntity<List<CardCopiesDTO>> responseExpected = ResponseEntity.ok(cardsCopiesDTO);
//		Mockito.when(service.getCardsCopies()).thenReturn(cardsCopies);
//		assertEquals(responseExpected, restController.getAll());
//	}
//	
//	@Test
//	@DisplayName("getAll : get no CardCopies and returns NO CONTENT")
//	void testGetAll_returnsNoCardCopiesKo() {
//		ResponseEntity<List<CardCopiesDTO>> responseExpected = ResponseEntity.noContent().build();
//		Mockito.when(service.getCardsCopies()).thenReturn(new ArrayList<>());
//		assertEquals(responseExpected, restController.getAll());
//	}
//	
//	@Test
//	@DisplayName("createOrUpdate : add one copie and returns OK")
//	void testCreateOrUpdate_addOneCopieOk() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.ok(cardCopiesDTOIncremented);
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(cardCopies);
//		//TODO: replace any() by a spy of the cardCopies ?
//		Mockito.when(service.updateCardCopies(any())).thenReturn(cardCopiesIncremented);
//		ResponseEntity<CardCopiesDTO> response = restController.createOrUpdate(cardCopiesDTO);
//		assertEquals(responseExpected, response);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("createOrUpdate : create a CardCopie and returns CREATED")
//	void testCreateOrUpdate_createCardCopiesOk() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.status(HttpStatus.CREATED).body(cardCopiesDTO);
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(null);
//		//TODO: replace any() by a spy of the cardCopies ?
//		Mockito.when(service.saveCardCopies(any())).thenReturn(cardCopies);
//		ResponseEntity<CardCopiesDTO> response = restController.createOrUpdate(cardCopiesDTO);
//		assertEquals(responseExpected, response);
//		assertEquals(responseExpected.getStatusCode(), response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("createOrUpdate : do nothing and returns NOT_MODIFIED")
//	void testCreateOrUpdate_notModifiedOk() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(null);
//		//TODO: replace any() by a spy of the cardCopies ?
//		Mockito.when(service.saveCardCopies(any())).thenReturn(null);
//		ResponseEntity<CardCopiesDTO> response = restController.createOrUpdate(cardCopiesDTO);
//		assertEquals(responseExpected, response);
//		assertEquals(responseExpected.getStatusCode(), response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("deleteOrUpdate : remove one copie and returns OK")
//	void testDeleteOrUpdate_removeOneCopieOk() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.ok(cardCopiesDTO);
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(cardCopiesIncremented);
//		//TODO: replace any() by a spy of the cardCopies ?
//		Mockito.when(service.updateCardCopies(any())).thenReturn(cardCopies);
//		ResponseEntity<CardCopiesDTO> response = restController.deleteOrUpdate(cardCopiesDTOIncremented);
//		assertEquals(responseExpected, response);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("deleteOrUpdate : delete a CardCopie and returns NO_CONTENT")
//	void testDeleteOrUpdate_deleteCardCopiesNoContent() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(cardCopies);
//		ResponseEntity<CardCopiesDTO> response = restController.deleteOrUpdate(cardCopiesDTO);
//		assertEquals(responseExpected, response);
//		assertEquals(responseExpected.getStatusCode(), response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("deleteOrUpdate : do nothing and returns NOT_MODIFIED")
//	void testDeleteOrUpdate_notModifiedOk() {
//		ResponseEntity<CardCopiesDTO> responseExpected = ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//		Mockito.when(service.getCardCopies(any(), any())).thenReturn(null);
//		ResponseEntity<CardCopiesDTO> response = restController.deleteOrUpdate(cardCopiesDTO);
//		assertEquals(responseExpected, response);
//		assertEquals(responseExpected.getStatusCode(), response.getStatusCode());
//	}
//
//}
