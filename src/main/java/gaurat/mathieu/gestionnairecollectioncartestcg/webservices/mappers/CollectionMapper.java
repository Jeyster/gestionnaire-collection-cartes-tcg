package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import gaurat.mathieu.gestionnairecollectioncartestcg.model.Collection;
import gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto.CollectionDto;

@Mapper
public interface CollectionMapper {
	
	CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);
	
	@Mapping(source = "user", target = "userDto")
	@Mapping(source = "game", target = "gameDto")
	CollectionDto collectionToCollectionDto(Collection collection);
	
	@Mapping(source = "userDto", target = "user")
	@Mapping(source = "gameDto", target = "game")
	Collection collectionDtoToCollection(CollectionDto collectionDto);	

}
