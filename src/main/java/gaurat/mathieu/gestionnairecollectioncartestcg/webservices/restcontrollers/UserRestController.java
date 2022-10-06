package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers.interfaces.IDtoToEntityMapping;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.UserServiceImpl;

@RestController
@RequestMapping("/rest/user/api")
public class UserRestController implements IDtoToEntityMapping<UserDTO, User> {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private UserServiceImpl userService;

    /**
     * Get all users.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = userService.getUsers();
        if (!users.isEmpty()) {
        	UserDTO userDto;
        	List<UserDTO> usersDto = new ArrayList<>();
        	for (User user : users) {
        		userDto = mapEntityToDTO(user, UserDTO.class);
        		usersDto.add(userDto);
        	}
        	
        	return ResponseEntity.ok(usersDto);
        }

        return ResponseEntity.noContent().build();    
    }

}
