package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.UserServiceImpl;

@RestController
@RequestMapping("/rest/user/api")
public class UserRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private UserServiceImpl userService;

    /**
     * Retourne tous les users.
     * @return
     */
    @GetMapping("/all")
    public void getAll() {
        List<User> users = userService.getUsers();
        System.out.println(users);
    }
}
