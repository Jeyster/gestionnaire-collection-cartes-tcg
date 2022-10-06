package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/card/api")
@Api(value = "Card Rest Controller: contains all operations for managing cards")
public class CardRestController {
	
    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CardServiceImpl cardService;
    
    /**
     * Retourne les cartes d'un jeu.
     * @param gameName
     * @return
     */
    @ApiOperation(value = "Get all cards from a game", response = CardDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded") })
    @GetMapping("/searchByGame")
    public ResponseEntity<List<CardDTO>> searchCardsByGame(@RequestParam("game") String gameName) {
        Set<Card> cards = cardService.getCardsByGame(gameName);
        if (!cards.isEmpty()) {
        	CardDTO cardDto;
        	List<CardDTO> cardsDto = new ArrayList<>();
        	for (Card card : cards) {
        		cardDto = mapCardToCardDTO(card);
        		cardsDto.add(cardDto);
        	}
        	
        	return ResponseEntity.ok(cardsDto);
        }

        return ResponseEntity.noContent().build();    }

    /**
     * Retourne toutes les cartes.
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all cards from all games", response = CardDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
            @ApiResponse(code = 204, message = "No Content: no result founded") })
    public ResponseEntity<List<CardDTO>> getAll() {
        List<Card> cards = cardService.getCards();

        if (!cards.isEmpty()) {
        	CardDTO cardDto;
        	List<CardDTO> cardsDto = new ArrayList<>();
        	for (Card card : cards) {
        		cardDto = mapCardToCardDTO(card);
        		cardsDto.add(cardDto);
        	}
        	
        	return ResponseEntity.ok(cardsDto);
        }

        return ResponseEntity.noContent().build();
    }
    
    /**
     * Transforme un entity Card en un POJO CardDTO
     * 
     * @param card
     * @return
     */
    private CardDTO mapCardToCardDTO(Card card) {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Card, CardDTO> propertyMapper = mapper.createTypeMap(Card.class, CardDTO.class);
        propertyMapper.addMapping(src -> src.getGame().getName(), CardDTO::setGameName);
        CardDTO cardDTO = mapper.map (card, CardDTO.class);
        return cardDTO;
    }

	/**
     * Transforme un POJO CardDTO en en entity Card
     * 
     * @param cardDTO
     * @return
     */
    private Card mapCardDTOToCard(CardDTO cardDTO) {
        ModelMapper mapper = new ModelMapper();
        Card card = mapper.map(cardDTO, Card.class);
        return card;
    }

}
