package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.List;
import java.util.Set;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;

public interface ICardService {
	
	public List<Card> getCards();
	
	public Set<Card> getCardsByGame(String gameName);

}
