package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardCopiesServiceImpl;

@RestController
@RequestMapping("/rest/cardCopies/api")
public class CardCopiesRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CardCopiesServiceImpl service;

    /**
     * Retourne toutes les card copies.
     * @return
     */
    @GetMapping("/all")
    public void getAll() {
        List<CardCopies> cardCopies = service.getCardCopies();
        System.out.println(cardCopies);
    }
}
