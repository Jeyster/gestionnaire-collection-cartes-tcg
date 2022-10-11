package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardCopiesDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardCopiesServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestCardCopiesRestController {

	private static final Integer GAME_ID = 1;
	private static final String GAME_NAME = "gameName";
	private static final Integer CARD_ID = 1;
	private static final String CARD_NAME = "cardName";
	private static final Integer COLLECTION_ID = 1;
	private static final Integer USER_ID = 1;
	private static final String USER_NAME = "userName";
	private static final String USER_FORNAME = "userForname";
	private static final String USER_EMAIL = "userEmail";
	private static final Integer CARD_COPIES_ID = 1;
	private static final Integer CARD_COPIES_NUMBER = 4;

	
	@Mock
	private CardCopiesServiceImpl service;
	
	@InjectMocks
	private CardCopiesRestController restController;
	
	private static CardCopies cardCopies;
	private static List<CardCopies> cardsCopies;
	private static CardCopiesDTO cardCopiesDTO;
	private static List<CardCopiesDTO> cardsCopiesDTO;
	
	private static Game game;
	private static Card card;
	private static User user;
	private static Collection collection;

	@BeforeAll
	private static void beforeAll() {
		game = new Game();
		game.setIdGame(GAME_ID);
		game.setName(GAME_NAME);
		
		card = new Card();
		card.setIdCard(CARD_ID);
		card.setName(CARD_NAME);
		card.setGame(game);
		
		user = new User();
		user.setIdUser(USER_ID);
		user.setName(USER_NAME);
		user.setForname(USER_FORNAME);
		user.setEmail(USER_EMAIL);
		
		collection = new Collection();
		collection.setIdCollection(COLLECTION_ID);
		collection.setGame(game);
		collection.setUser(user);
		
		cardCopies = new CardCopies();
		cardCopies.setIdCardCopies(CARD_COPIES_ID);
		cardCopies.setCard(card);
		cardCopies.setCollection(collection);
		cardCopies.setCopiesNumber(CARD_COPIES_NUMBER);
		
		cardsCopies = new ArrayList<>();
		cardsCopies.add(cardCopies);
		
		cardCopiesDTO = new CardCopiesDTO();
		cardCopiesDTO.setIdCard(CARD_ID);
		cardCopiesDTO.setIdCollection(COLLECTION_ID);
		cardCopiesDTO.setCopiesNumber(CARD_COPIES_NUMBER);
		
		cardsCopiesDTO = new ArrayList<>();
		cardsCopiesDTO.add(cardCopiesDTO);
	}

	@Test
	@DisplayName("mapEntityToDTO : CardCopies is converted in CardCopiesDTO")
	void testMapEntityToDTO_conversionOk() {	
		CardCopiesDTO cardCopiesDTOToTest = restController.mapEntityToDTO(cardCopies, CardCopiesDTO.class);
		assertEquals(cardCopiesDTO, cardCopiesDTOToTest);
	}
	
	@Test
	@DisplayName("getAll : get all CardCopies and returns OK")
	void testGetAll_returnsAllCardCopiesOk() {
		ResponseEntity<List<CardCopiesDTO>> responseExpected = ResponseEntity.ok(cardsCopiesDTO);
		Mockito.when(service.getCardsCopies()).thenReturn(cardsCopies);
		assertEquals(responseExpected, restController.getAll());
	}
	
	@Test
	@DisplayName("getAll : get no CardCopies and returns NO CONTENT")
	void testGetAll_returnsNoCardCopiesKo() {
		ResponseEntity<List<CardCopiesDTO>> responseExpected = ResponseEntity.noContent().build();
		Mockito.when(service.getCardsCopies()).thenReturn(new ArrayList<>());
		assertEquals(responseExpected, restController.getAll());
	}

}
