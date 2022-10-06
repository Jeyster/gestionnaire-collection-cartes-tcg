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

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.GameDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers.interfaces.IDTOToEntityMapping;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.GameServiceImpl;

@RestController
@RequestMapping("/rest/game/api")
public class GameRestController implements IDTOToEntityMapping<GameDTO, Game> {
	
    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private GameServiceImpl service;
    
    /**
     * Get all games.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<GameDTO>> getAll() {
        List<Game> games = service.getGames();
        
        if (!games.isEmpty()) {
        	GameDTO gameDto;
        	List<GameDTO> gamesDto = new ArrayList<>();
        	for (Game game : games) {
        		gameDto = mapEntityToDTO(game, GameDTO.class);
        		gamesDto.add(gameDto);
        	}
        	
        	return ResponseEntity.ok(gamesDto);
        }

        return ResponseEntity.noContent().build();        
    }

}
