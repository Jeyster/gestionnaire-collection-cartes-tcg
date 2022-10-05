package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.GameDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.GameServiceImpl;

@RestController
@RequestMapping("/rest/game/api")
public class GameRestController {
	
    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private GameServiceImpl gameService;
    
    /**
     * Retourne tous les jeux.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<GameDTO>> getAll() {
        List<Game> games = gameService.getGames();
        
        if (!games.isEmpty()) {
        	GameDTO gameDto;
        	List<GameDTO> gamesDto = new ArrayList<>();
        	for (Game game : games) {
        		gameDto = mapGameToGameDTO(game);
        		gamesDto.add(gameDto);
        	}
        	
        	return ResponseEntity.ok(gamesDto);
        }

        return ResponseEntity.noContent().build();        
    }

	private GameDTO mapGameToGameDTO(Game game) {
        ModelMapper mapper = new ModelMapper();
        GameDTO gameDTO = mapper.map(game, GameDTO.class);
        return gameDTO;
	}
}
