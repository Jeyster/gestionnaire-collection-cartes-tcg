package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.ICardCopiesDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces.ICardCopiesService;

@Service("cardCopiesService")
@Transactional
public class CardCopiesServiceImpl implements ICardCopiesService {
	
	@Autowired
	private ICardCopiesDao dao;

	@Override
	public List<CardCopies> getCardCopiesByCollection(Integer idCollection) {
		return dao.findByCollection(idCollection);
	}

	@Override
	public List<CardCopies> getCardCopies() {
		return dao.findAll();
	}

}
