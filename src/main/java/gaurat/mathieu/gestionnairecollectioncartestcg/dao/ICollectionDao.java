package gaurat.mathieu.gestionnairecollectioncartestcg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;

@Repository
public interface ICollectionDao extends JpaRepository<Collection, Integer> {

}
