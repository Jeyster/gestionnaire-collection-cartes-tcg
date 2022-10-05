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

@RestController
@RequestMapping("/rest/card/api")
public class CardRestController {
	
    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CardServiceImpl cardService;
    
    /**
     * Retourne les cartes d'un jeu.
     * @param gameName
     * @return
     */
    @GetMapping("/searchByGame")
    public void searchCardsByGame(@RequestParam("game") String gameName) {
        Set<Card> cards = cardService.getCardsByGame(gameName);
        System.out.println(cards);
    }

    /**
     * Retourne toutes les cartes.
     * @return
     */
    @GetMapping("/all")
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
    
//    /**
//     * Retourne le client ayant l'adresse email passée en paramètre.
//     * @param gameName
//     * @return
//     */
//    @GetMapping("/searchByGame")
//    public ResponseEntity<Set<CardDTO>> searchCardsByGame(@RequestParam("game") String gameName) {
//        //, UriComponentsBuilder uriComponentBuilder
//        Set<Card> cards = cardService.getCardsByGame(gameName);
//        if (cards != null) {
//        	CardDTO cardDTO = mapCustomerToCustomerDTO(cards);
//            return new ResponseEntity<CustomerDTO>(cardDTO, HttpStatus.OK);
//        }
//        return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
//    }
    
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
