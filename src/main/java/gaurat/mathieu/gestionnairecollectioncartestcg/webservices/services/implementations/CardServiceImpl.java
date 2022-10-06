package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.ICardDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces.ICardService;

@Service("cardService")
@Transactional
public class CardServiceImpl implements ICardService {
	
	@Autowired
	private ICardDao cardDao;
	
	@Override
	public List<Card> getCards() {
		return cardDao.findAll();
	}

	@Override
	public List<Card> getCardsByGame(String gameName) {
		return cardDao.findByGame(gameName);
	}

}
