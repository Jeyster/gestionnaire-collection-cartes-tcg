package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.User;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDTO userToUserDTO(User user);
	
	User userDTOToUser(UserDTO userDto);

}
