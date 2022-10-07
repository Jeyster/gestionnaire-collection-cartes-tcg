package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers.interfaces.IDTOToEntityMapping;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/user/api")
@Api(value = "User Rest Controller: contains all operations for managing users")
public class UserRestController implements IDTOToEntityMapping<UserDTO, User> {

    public static final Logger LOGGER = LoggerFactory.getLogger(CardRestController.class);
    
    @Autowired
    private UserServiceImpl service;

    /**
     * Get all users.
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all users", response = UserDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
    		@ApiResponse(code = 204, message = "No Content: no result founded") })
    public ResponseEntity<List<UserDTO>> getAll() {
        List<User> users = service.getUsers();
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
    
    /**
     * Create a new User.
     * If it already exists, returns a code that the creation is not completed.
     * @param userDTORequest
     * @return
     */
    @PostMapping("/addUser")
    @ApiOperation(value = "Create a new User", response = UserDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict: the user already exist"),
            @ApiResponse(code = 201, message = "Created: the user is successfully inserted"),
            @ApiResponse(code = 304, message = "Not Modified: the user is unsuccessfully inserted") })
    public ResponseEntity<UserDTO> createNewUser(@RequestBody UserDTO userDTORequest) {
        User existingUser = service.getUserByEmail(userDTORequest.getEmail());
        if (existingUser != null) {
            return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
        }
        User userRequest = mapDTOToEntity(userDTORequest, User.class);
        User userResponse = service.saveUser(userRequest);
        if (userResponse != null) {
            UserDTO userDTO = mapEntityToDTO(userResponse, UserDTO.class);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
    }

}
