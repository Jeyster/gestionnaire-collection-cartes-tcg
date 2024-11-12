package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Game;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.GameDTO;

@Mapper
public interface GameMapper {

	GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);
	
	GameDTO gameToGameDTO(Game game);
	
	Game gameDTOToGame(GameDTO gameDto);	
}
