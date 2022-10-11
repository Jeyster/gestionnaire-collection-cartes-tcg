package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.restcontrollers.interfaces;

import org.modelmapper.ModelMapper;

/**
 * Interface for converting DTO to Entity.
 * Implemented in RestControllers with 
 * S = DTO class and
 * T = Entity class.
 * 
 * @author mgaurat
 *
 * @param <S>
 * @param <T>
 */
public interface IDTOToEntityMapping<S, T> {
	
    /**
     * Entity to POJO DTO conversion
     * 
     * @param entity
     * @return
     */
    public default S mapEntityToDTO(T entity, Class<S> dtoClass) {
        ModelMapper mapper = new ModelMapper();
        addMappingsToTypeMap(mapper);
        S dto = mapper.map(entity, dtoClass);
        return dto;
    }

	/**
     * POJO DTO to entity conversion
     * 
     * @param dto
     * @return
     */
    public default T mapDTOToEntity(S dto, Class<T> entityClass) {
        ModelMapper mapper = new ModelMapper();
        addMappingsToTypeMap(mapper);
        T entity = mapper.map(dto, entityClass);
        return entity;
    }
    
    /**
     * Adding rules for mapping
     *  
     * @param mapper
     */
    public default void addMappingsToTypeMap(ModelMapper mapper) {}

}
