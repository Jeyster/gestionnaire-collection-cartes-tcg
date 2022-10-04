package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

}
