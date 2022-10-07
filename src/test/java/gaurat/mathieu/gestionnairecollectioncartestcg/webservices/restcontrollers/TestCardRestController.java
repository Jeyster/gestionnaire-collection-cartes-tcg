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
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestCardRestController {
	
	private static final String GAME1_NAME = "game1Name";
	private static final String GAME2_NAME = "game2Name";
	private static final String CARD1_NAME = "card1Name";
	private static final String CARD2_NAME = "card2Name";
	private static final String CARD3_NAME = "card3Name";
	
	@Mock
	private CardServiceImpl service;
	
	@InjectMocks
	private CardRestController restController;
	
	private static Game game1;
	private static Game game2;
	private static Card card1;
	private static Card card2;
	private static Card card3;
	private static List<Card> cards;
	private static CardDTO cardDTO1;
	private static CardDTO cardDTO2;
	private static CardDTO cardDTO3;
	private static List<CardDTO> cardsDTO;
	
	@BeforeAll
	public static void beforeAll() {
		game1 = new Game();
		game1.setName(GAME1_NAME);
		game2 = new Game();
		game2.setName(GAME2_NAME);
		
		card1 = new Card();
		card1.setGame(game1);
		card1.setName(CARD1_NAME);
		card2 = new Card();
		card2.setGame(game1);
		card2.setName(CARD2_NAME);
		card3 = new Card();
		card3.setGame(game2);
		card3.setName(CARD3_NAME);
		cards = new ArrayList<>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		
		cardDTO1 = new CardDTO();
		cardDTO1.setGameName(GAME1_NAME);
		cardDTO1.setName(CARD1_NAME);
		cardDTO2 = new CardDTO();
		cardDTO2.setGameName(GAME1_NAME);
		cardDTO2.setName(CARD2_NAME);
		cardDTO3 = new CardDTO();
		cardDTO3.setGameName(GAME2_NAME);
		cardDTO3.setName(CARD3_NAME);
		cardsDTO = new ArrayList<>();
		cardsDTO.add(cardDTO1);
		cardsDTO.add(cardDTO2);
		cardsDTO.add(cardDTO3);
	}
		
	@Test
	@DisplayName("mapEntityToDTO : Card is converted in CardDTO")
	void testMapEntityToDTO_conversionOk() {	
		CardDTO cardDTO = restController.mapEntityToDTO(card1, CardDTO.class);
		assertEquals(cardDTO1, cardDTO);
	}
	
	@Test
	@DisplayName("getAll : get all Card and returns OK")
	void testGetAll_returnsAllCardsOk() {
		ResponseEntity<List<CardDTO>> responseExpected = ResponseEntity.ok(cardsDTO);
		Mockito.when(service.getCards()).thenReturn(cards);
		assertEquals(responseExpected, restController.getAll());
	}
	
	@Test
	@DisplayName("getAll : get no Card and returns NO CONTENT")
	void testGetAll_returnsNoCardKo() {
		ResponseEntity<List<CardDTO>> responseExpected = ResponseEntity.noContent().build();
		Mockito.when(service.getCards()).thenReturn(new ArrayList<>());
		assertEquals(responseExpected, restController.getAll());
	}
	
	@Test
	@DisplayName("searchCardsByGame : get all Card from a Game and returns OK")
	void testSearchCardsByGame_returnsAllCardsOk() {
		ResponseEntity<List<CardDTO>> responseExpected = ResponseEntity.ok(cardsDTO);
		Mockito.when(service.getCardsByGame(GAME1_NAME)).thenReturn(cards);
		assertEquals(responseExpected, restController.searchCardsByGame(GAME1_NAME));
	}
	
	@Test
	@DisplayName("searchCardsByGame : get no Card and returns NO CONTENT")
	void testSearchCardsByGame_returnsNoCardKo() {
		ResponseEntity<List<CardDTO>> responseExpected = ResponseEntity.noContent().build();
		Mockito.when(service.getCardsByGame(GAME1_NAME)).thenReturn(new ArrayList<>());
		assertEquals(responseExpected, restController.searchCardsByGame(GAME1_NAME));
	}

}
