package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;

@Repository
public interface ICardCopiesDao extends JpaRepository<CardCopies, Integer> {

    @Query("SELECT cc "
            + "FROM CardCopies cc "
            + "INNER JOIN cc.collection c "
            + "WHERE c.idCollection = :idCollection"
          )
    public List<CardCopies> findByCollection(@Param("idCollection") Integer idCollection);
    
    @Query("SELECT cc "
            + "FROM CardCopies cc "
            + "INNER JOIN cc.collection col "
            + "INNER JOIN cc.card card "
            + "WHERE col.idCollection = :idCollection "
            + "AND card.idCard = :idCard"
          )
    public CardCopies getCardCopies(@Param("idCard") Integer idCard, @Param("idCollection") Integer idCollection);
    
}
