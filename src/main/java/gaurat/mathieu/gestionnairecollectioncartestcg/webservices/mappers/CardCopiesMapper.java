package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.CardCopies;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CardCopiesDTO;

@Mapper
public interface CardCopiesMapper {
	
	CardCopiesMapper INSTANCE = Mappers.getMapper(CardCopiesMapper.class);
	
	@Mapping(source = "card", target = "cardDto")
	@Mapping(source = "collection", target = "collectionDto")
	CardCopiesDTO cardCopiesToCardCopiesDto(CardCopies cardCopies);
	
	@Mapping(source = "cardDto", target = "card")
	@Mapping(source = "collectionDto", target = "collection")
	CardCopies cardCopiesDtoToCardCopies(CardCopiesDTO cardCopiesDto);

}
