package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Card;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardDTO;

@Mapper
public interface CardMapper {
	
	CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
	
	@Mapping(source = "game", target = "gameDto")
	CardDTO cardToCardDTO(Card card);
	
	@Mapping(source = "gameDto", target = "game")
	Card cardDTOToCard(CardDTO cardDto);

}
