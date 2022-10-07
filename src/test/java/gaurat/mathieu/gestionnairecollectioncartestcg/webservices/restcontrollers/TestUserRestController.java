package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestUserRestController {
	
	private static final String NAME = "Name";
	private static final String FORNAME = "Forname";
	private static final String EMAIL = "Email";
	
	@Mock
	private UserServiceImpl service;
	
	@InjectMocks
	private UserRestController restController;
	
	private static User user;
	private static List<User> users;
	private static UserDTO userDTO;
	private static List<UserDTO> usersDTO;

	@BeforeAll
	private static void beforeAll() {
		user = new User();
		user.setName(NAME);
		user.setForname(FORNAME);
		user.setEmail(EMAIL);
		
		users = new ArrayList<>();
		users.add(user);
		
		userDTO = new UserDTO();
		userDTO.setName(NAME);
		userDTO.setForname(FORNAME);
		userDTO.setEmail(EMAIL);
		
		usersDTO = new ArrayList<>();
		usersDTO.add(userDTO);
	}

	@Test
	@DisplayName("mapEntityToDTO : User is converted in UserDTO")
	void testMapEntityToDTO_conversionOk() {	
		UserDTO userDTOToTest = restController.mapEntityToDTO(user, UserDTO.class);
		assertEquals(userDTO, userDTOToTest);
	}
	
	@Test
	@DisplayName("getAll : get all User and returns OK")
	void testGetAll_returnsAllUsersOk() {
		ResponseEntity<List<UserDTO>> responseExpected = ResponseEntity.ok(usersDTO);
		Mockito.when(service.getUsers()).thenReturn(users);
		assertEquals(responseExpected, restController.getAll());
	}
	
	@Test
	@DisplayName("getAll : get no User and returns NO CONTENT")
	void testGetAll_returnsNoUserKo() {
		ResponseEntity<List<CardDTO>> responseExpected = ResponseEntity.noContent().build();
		Mockito.when(service.getUsers()).thenReturn(new ArrayList<>());
		assertEquals(responseExpected, restController.getAll());
	}
	
	@Test
	@DisplayName("createNewUser : get the UserDTO and returns CREATED")
	void testCreateNewUser_creationOk_returnsUserDTO() {
		ResponseEntity<UserDTO> responseExpected = ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
		Mockito.when(service.getUserByEmail(any())).thenReturn(null);
		Mockito.when(service.saveUser(any())).thenReturn(user);
		assertEquals(responseExpected, restController.createNewUser(userDTO));
	}
	
	@Test
	@DisplayName("createNewUser : the user already exists")
	void testCreateNewUser_alreadyExists_returnsConflictStatus() {
		ResponseEntity<UserDTO> responseExpected = new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
		Mockito.when(service.getUserByEmail(any())).thenReturn(user);
		assertEquals(responseExpected, restController.createNewUser(userDTO));
	}
	
	@Test
	@DisplayName("createNewUser : error when saving the user")
	void testCreateNewUser_creationKo_returnsNotModifiedStatus() {
		ResponseEntity<UserDTO> responseExpected = new ResponseEntity<UserDTO>(HttpStatus.NOT_MODIFIED);
		Mockito.when(service.getUserByEmail(any())).thenReturn(null);
		Mockito.when(service.saveUser(any())).thenReturn(null);
		assertEquals(responseExpected, restController.createNewUser(userDTO));
	}

}
