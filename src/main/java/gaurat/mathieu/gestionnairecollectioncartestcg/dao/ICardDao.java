package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;

@Repository
public interface ICardDao extends JpaRepository<Card, Integer> {
	
    @Query("SELECT c "
            + "FROM Card c "
            + "INNER JOIN c.game game "
            + "WHERE game.name = :gameName"
          )
    public List<Card> findByGame(@Param("gameName") String gameName);
    
    public List<Card> findAll();

}
