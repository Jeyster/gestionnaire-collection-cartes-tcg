package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.services.implementations.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class TestUserRestController {
	
	@Mock
	private UserServiceImpl service;
	
	@InjectMocks
	private UserRestController restController;
	
	private static User user;
	private static UserDTO userDTO;
	
	@BeforeAll
	private static void beforeAll() {
		user = new User();
		user.setForname("Mathieu");
		user.setName("Gaurat");
		user.setLogin("login");
		user.setPassword("password");
		
		userDTO = new UserDTO();
		userDTO.setForname("Mathieu");
		userDTO.setName("Gaurat");
		userDTO.setLogin("login");
		userDTO.setPassword("password");
	}

	@Test
	@DisplayName("mapEntityToDTO : User is converted in UserDTO")
	void testMapEntityToDTO_conversionOk() {	
		UserDTO userDTOToTest = restController.mapEntityToDTO(user, UserDTO.class);
		assertEquals(userDTO, userDTOToTest);
	}

}
