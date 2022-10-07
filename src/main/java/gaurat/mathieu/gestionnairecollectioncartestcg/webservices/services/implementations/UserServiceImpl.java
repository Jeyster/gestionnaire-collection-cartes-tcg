package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gaurat.mathieu.gestionnairecollectioncartestcg.dao.IUserDao;
import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces.IUserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	@Override
	public List<User> getUsers() {
		return dao.findAll();
	}
	
	@Override
	public User getUserByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User saveUser(User userRequest) {
		return dao.save(userRequest);
	}
	
}
