package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import java.util.Set;

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
    public Set<CardCopies> findByCollection(@Param("idCollection") Integer idCollection);
    
}
