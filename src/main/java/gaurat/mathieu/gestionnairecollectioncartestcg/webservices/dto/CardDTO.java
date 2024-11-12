package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class CardDTO {
	
	private Integer idCard;
	private GameDTO gameDto;
	private String name;
	
	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public GameDTO getGameDto() {
		return gameDto;
	}
	
	public void setGameDto(GameDTO gameDto) {
		this.gameDto = gameDto;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardDTO other = (CardDTO) obj;
		return Objects.equals(gameDto, other.gameDto) && Objects.equals(idCard, other.idCard)
				&& Objects.equals(name, other.name);
	}
	
}
