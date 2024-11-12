package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class CardCopiesDTO {
	
	private CardDTO cardDto;
	private CollectionDto collectionDto;
	private Integer copiesNumber;
	
	public CardDTO getCardDto() {
		return cardDto;
	}

	public void setCardDto(CardDTO cardDto) {
		this.cardDto = cardDto;
	}

	public CollectionDto getCollectionDto() {
		return collectionDto;
	}

	public void setCollectionDto(CollectionDto collectionDto) {
		this.collectionDto = collectionDto;
	}

	public Integer getCopiesNumber() {
		return copiesNumber;
	}
	
	public void setCopiesNumber(Integer copiesNumber) {
		this.copiesNumber = copiesNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardCopiesDTO other = (CardCopiesDTO) obj;
		return Objects.equals(cardDto, other.cardDto) && Objects.equals(collectionDto, other.collectionDto)
				&& Objects.equals(copiesNumber, other.copiesNumber);
	}

}
