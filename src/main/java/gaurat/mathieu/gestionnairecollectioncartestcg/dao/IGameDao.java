package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;

@Repository
public interface IGameDao extends JpaRepository<Game, Integer> {

}
