package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.List;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;

public interface ICardCopiesService {
	
	public List<CardCopies> getCardCopiesByCollection(Integer idCollection);
	
	public List<CardCopies> getCardCopies();

}
