package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.IGameDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces.IGameService;

@Service("gameService")
@Transactional
public class GameServiceImpl implements IGameService {
	
	@Autowired
	private IGameDao dao;

	public List<Game> getGames() {
		return dao.findAll();
	}
	
}
