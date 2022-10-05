package gaurat.mathieu.gestionnairecollectioncartestcg.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations.GameServiceImpl;

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
    public void getAll() {
        List<Game> games = gameService.getGames();
        System.out.println(games);
    }
}
