package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;
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
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = userService.getUsers();
        if (!users.isEmpty()) {
        	UserDTO userDto;
        	List<UserDTO> usersDto = new ArrayList<>();
        	for (User user : users) {
        		userDto = mapUserToUserDTO(user);
        		usersDto.add(userDto);
        	}
        	
        	return ResponseEntity.ok(usersDto);
        }

        return ResponseEntity.noContent().build();    
    }

	private UserDTO mapUserToUserDTO(User user) {
		ModelMapper mapper = new ModelMapper();
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}
}
