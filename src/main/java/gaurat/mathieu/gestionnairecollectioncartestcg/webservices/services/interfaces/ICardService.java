package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.List;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;

public interface ICardService {
	
	public List<Card> getCards();
	
	public List<Card> getCardsByGame(String gameName);

}
