package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardCopiesDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers.interfaces.IDTOToEntityMapping;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardCopiesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/cardCopies/api")
@Api(value = "Card Copies Rest Controller: contains all operations for managing cards copies")
public class CardCopiesRestController implements IDTOToEntityMapping<CardCopiesDTO, CardCopies> {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CardCopiesServiceImpl service;

    /**
     * Retourne toutes les card copies.
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all cards copies", response = CardCopiesDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
    		@ApiResponse(code = 204, message = "No Content: no result founded") })
    public ResponseEntity<List<CardCopiesDTO>> getAll() {
        List<CardCopies> cardsCopies = service.getCardCopies();
        if (!cardsCopies.isEmpty()) {
        	CardCopiesDTO cardCopiesDto;
        	List<CardCopiesDTO> cardsCopiesDto = new ArrayList<>();
        	for (CardCopies cardCopies : cardsCopies) {
        		cardCopiesDto = mapEntityToDTO(cardCopies, CardCopiesDTO.class);
        		cardsCopiesDto.add(cardCopiesDto);
        	}
        	
        	return ResponseEntity.ok(cardsCopiesDto);
        }

        return ResponseEntity.noContent().build();        }
}
