package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.Set;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;

public interface ICardCopiesService {
	
	public Set<CardCopies> getCardCopiesByCollection(Integer idCollection);

}
