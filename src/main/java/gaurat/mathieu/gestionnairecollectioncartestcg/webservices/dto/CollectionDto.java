package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class CollectionDto {
	
	private Integer idCollection;
	private UserDTO userDto;
	private GameDTO gameDto;
	
	public Integer getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(Integer idCollection) {
		this.idCollection = idCollection;
	}

	public UserDTO getUserDto() {
		return userDto;
	}
	
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	
	public GameDTO getGameDto() {
		return gameDto;
	}
	
	public void setGameDto(GameDTO gameDto) {
		this.gameDto = gameDto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionDto other = (CollectionDto) obj;
		return Objects.equals(gameDto, other.gameDto) && Objects.equals(idCollection, other.idCollection)
				&& Objects.equals(userDto, other.userDto);
	}

}
