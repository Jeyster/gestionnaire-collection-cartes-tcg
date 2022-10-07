package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

    @Query("SELECT u "
            + "FROM User u "
            + "WHERE u.email = :email"
          )
	User findByEmail(@Param("email") String email);

}
