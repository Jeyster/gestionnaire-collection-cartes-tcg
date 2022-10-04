package gaurat.mathieu.gestionnairecollectioncartestcg.services.implementations;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.IUserDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.services.interfaces.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
}
