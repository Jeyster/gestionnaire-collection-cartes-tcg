package gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.ICardCopiesDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.interfaces.ICardCopiesService;

@Service("cardCopiesService")
@Transactional
public class CardCopiesServiceImpl implements ICardCopiesService {
	
	@Autowired
	private ICardCopiesDao cardCopiesDao;

	@Override
	public Set<CardCopies> getCardCopiesByCollection(Integer idCollection) {
		return cardCopiesDao.findByCollection(idCollection);
	}

}
