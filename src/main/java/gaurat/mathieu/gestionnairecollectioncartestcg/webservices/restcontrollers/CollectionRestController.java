package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.CollectionServiceImpl;

@RestController
@RequestMapping("/rest/collection/api")
public class CollectionRestController {
	
    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private CollectionServiceImpl service;

    /**
     * Retourne toutes les collections.
     * @return
     */
    @GetMapping("/all")
    public void getAll() {
        List<Collection> collections = service.getCollections();
        System.out.println(collections);
    }
}
