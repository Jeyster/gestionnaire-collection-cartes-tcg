package gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.ICollectionDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.interfaces.ICollectionService;

@Service("collectionService")
@Transactional
public class CollectionServiceImpl implements ICollectionService {
	
	@Autowired
	private ICollectionDao collectionDao;

}
