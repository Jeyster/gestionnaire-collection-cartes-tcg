package gaurat.mathieu.gestionnairecollectioncartestcg.restcontrollers;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations.CardServiceImpl;

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
        //, UriComponentsBuilder uriComponentBuilder
        Set<Card> cards = cardService.getCardsByGame(gameName);
        System.out.println(cards);
    }

    /**
     * Retourne toutes les cartes.
     * @return
     */
    @GetMapping("/all")
    public void getAll() {
        //, UriComponentsBuilder uriComponentBuilder
        List<Card> cards = cardService.getCards();
        System.out.println(cards);
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
    
//    /**
//     * Transforme un entity Customer en un POJO CustomerDTO
//     * 
//     * @param card
//     * @return
//     */
//    private CardDTO mapCardToCardDTO(Card card) {
//        ModelMapper mapper = new ModelMapper();
//        CustomerDTO customerDTO = mapper.map(card, CustomerDTO.class);
//        return customerDTO;
//    }
//
//    /**
//     * Transforme un POJO CustomerDTO en en entity Customer
//     * 
//     * @param customerDTO
//     * @return
//     */
//    private Customer mapCustomerDTOToCustomer(CustomerDTO customerDTO) {
//        ModelMapper mapper = new ModelMapper();
//        Customer customer = mapper.map(customerDTO, Customer.class);
//        return customer;
//    }

}
