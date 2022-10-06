package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardDTO;

class TestCardRestController {
	
	private static final String GAME_NAME = "gameName";
	private static final String CARD_NAME = "cardName";
	
	@Test
	@DisplayName("Test qu'un Card est bien converti en CardDTO")
	void testMapEntityToDTO_conversionOk() {
		Game game = new Game();
		game.setName(GAME_NAME);
		Card card = new Card();
		card.setGame(game);
		card.setName(CARD_NAME);
		
		CardDTO cardDTOExpected = new CardDTO();
		cardDTOExpected.setGameName(GAME_NAME);
		cardDTOExpected.setName(CARD_NAME);
		
		CardRestController cardRestController = new CardRestController();
		CardDTO cardDTO = cardRestController.mapEntityToDTO(card, CardDTO.class);
		assertEquals(cardDTOExpected, cardDTO);
	}

}
