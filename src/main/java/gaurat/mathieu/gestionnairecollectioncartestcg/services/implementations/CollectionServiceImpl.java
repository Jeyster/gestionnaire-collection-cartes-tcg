package gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.ICollectionDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.interfaces.ICollectionService;

@Service("collectionService")
@Transactional
public class CollectionServiceImpl implements ICollectionService {
	
	@Autowired
	private ICollectionDao collectionDao;

	public List<Collection> getCollections() {
		return collectionDao.findAll();
	}

}
