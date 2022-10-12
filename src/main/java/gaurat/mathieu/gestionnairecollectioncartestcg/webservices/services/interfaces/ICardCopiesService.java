package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.List;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;

public interface ICardCopiesService {
	
	public List<CardCopies> getCardsCopiesByCollection(Integer idCollection);
	
	public List<CardCopies> getCardsCopies();
	
	public CardCopies getCardCopies(Integer idCard, Integer idCollection);
	
	public CardCopies saveCardCopies(CardCopies cardCopiesRequest);
	
	public void deleteCardCopies(CardCopies cardCopiesRequest);
	
	public CardCopies updateCardCopies(CardCopies cardCopiesRequest);
	
}
