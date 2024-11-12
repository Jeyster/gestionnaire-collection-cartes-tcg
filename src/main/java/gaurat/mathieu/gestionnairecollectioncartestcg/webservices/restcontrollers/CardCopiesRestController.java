package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardCopiesDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers.CardCopiesMapper;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CardCopiesServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/cardCopies/api")
@Api(value = "Card Copies Rest Controller: contains all operations for managing cards copies")
public class CardCopiesRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CardCopiesServiceImpl service;

    /**
     * Get all the card copies.
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all cards copies", response = CardCopiesDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
    		@ApiResponse(code = 204, message = "No Content: no result founded") })
    public ResponseEntity<List<CardCopiesDTO>> getAll() {
        List<CardCopies> cardsCopies = service.getCardsCopies();
        if (!cardsCopies.isEmpty()) {
        	CardCopiesDTO cardCopiesDto;
        	List<CardCopiesDTO> cardsCopiesDto = new ArrayList<>();
        	for (CardCopies cardCopies : cardsCopies) {
        		cardCopiesDto = CardCopiesMapper.INSTANCE.cardCopiesToCardCopiesDto(cardCopies);
        		cardsCopiesDto.add(cardCopiesDto);
        	}
        	
        	return ResponseEntity.ok(cardsCopiesDto);
        }

        return ResponseEntity.noContent().build();        
    }
    
    /**
     * Add a card copy to an already existing CardCopies.
     * If does not exist, create a CardCopies with 1 copy.
     * 
     * @return
     */
    @PutMapping("/add")
    @ApiOperation(value = "Add a card copy. If a CardCopies is found for the requested Ids, increment the counter. If not, create a CardCopies.", response = CardCopiesDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: the CardCopies is successfully modified"),
            @ApiResponse(code = 201, message = "Created: the CardCopies is successfully inserted"),
            @ApiResponse(code = 304, message = "Not Modified: the CardCopies is unsuccessfully inserted") })
    public ResponseEntity<CardCopiesDTO> createOrUpdate(@RequestBody CardCopiesDTO cardCopiesDTORequest) {
    	CardCopiesDTO cardCopiesDTO;
    	CardCopies cardCopiesRequest;
    	CardCopies cardCopiesResponse;
    	
    	//CardCopies already exists => add one copy
    	cardCopiesRequest = service.getCardCopies(cardCopiesDTORequest.getCardDto().getIdCard(), cardCopiesDTORequest.getCollectionDto().getIdCollection());
        if (cardCopiesRequest != null) {
        	cardCopiesRequest.setCopiesNumber(cardCopiesRequest.getCopiesNumber() + 1);
            cardCopiesResponse = service.updateCardCopies(cardCopiesRequest);
        	cardCopiesDTO = CardCopiesMapper.INSTANCE.cardCopiesToCardCopiesDto(cardCopiesResponse);
        	return new ResponseEntity<CardCopiesDTO>(cardCopiesDTO, HttpStatus.OK);
        }
        
        //CardCopies does not exist => create it with copiesNumber = 1
        cardCopiesRequest = CardCopiesMapper.INSTANCE.cardCopiesDtoToCardCopies(cardCopiesDTORequest);
        cardCopiesRequest.setCopiesNumber(1);
        cardCopiesResponse = service.saveCardCopies(cardCopiesRequest);
        if (cardCopiesResponse != null) {
        	cardCopiesDTO = CardCopiesMapper.INSTANCE.cardCopiesToCardCopiesDto(cardCopiesResponse);
            return new ResponseEntity<CardCopiesDTO>(cardCopiesDTO, HttpStatus.CREATED);
        }
        
        return new ResponseEntity<CardCopiesDTO>(HttpStatus.NOT_MODIFIED);       
    }
    
    /**
     * Remove a card copy to an already existing CardCopies.
     * If the the counter goes to zero, delete the CardCopies.
     * 
     * @return
     */
    @PutMapping("/remove")
    @ApiOperation(value = "Remove a card copy. If a CardCopies is found for the requested Ids, decrement the counter. "
    		+ "Then if the counter goes to zero, delete the CardCopies.", response = CardCopiesDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: the CardCopies is successfully modified"),
            @ApiResponse(code = 204, message = "Deleted: the CardCopies is successfully deleted"),
            @ApiResponse(code = 304, message = "Not Modified: no CardCopies found") })
    public ResponseEntity<CardCopiesDTO> deleteOrUpdate(@RequestBody CardCopiesDTO cardCopiesDTORequest) {
    	CardCopiesDTO cardCopiesDTO;
    	CardCopies cardCopiesRequest;
    	CardCopies cardCopiesResponse;
    	
    	cardCopiesRequest = service.getCardCopies(cardCopiesDTORequest.getCardDto().getIdCard(), cardCopiesDTORequest.getCollectionDto().getIdCollection());
        if (cardCopiesRequest != null) {
        	Integer copiesNumber = cardCopiesRequest.getCopiesNumber();
        	if (copiesNumber == 1) {
        		service.deleteCardCopies(cardCopiesRequest);
            	return new ResponseEntity<CardCopiesDTO>(HttpStatus.NO_CONTENT);
        	} else {
        		cardCopiesRequest.setCopiesNumber(copiesNumber - 1);
        		cardCopiesResponse = service.updateCardCopies(cardCopiesRequest);
        		cardCopiesDTO = CardCopiesMapper.INSTANCE.cardCopiesToCardCopiesDto(cardCopiesResponse);
        		return new ResponseEntity<CardCopiesDTO>(cardCopiesDTO, HttpStatus.OK);        		
        	}
        }
        
        return new ResponseEntity<CardCopiesDTO>(HttpStatus.NOT_MODIFIED);       
    }
	
}
