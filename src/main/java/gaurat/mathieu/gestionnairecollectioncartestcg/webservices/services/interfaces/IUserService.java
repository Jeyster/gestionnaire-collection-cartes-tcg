package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.interfaces;

import java.util.List;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;

public interface IUserService {
	
	public List<User> getUsers();
	
	public User getUserByEmail(String email);
	
	public User saveUser(User userRequest);

}
