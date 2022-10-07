package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class CardCopiesDTO {
	
	private Integer idCardCopies;
	private Integer idCard;
	private Integer idCollection;
	private Integer copiesNumber;
	
	public Integer getIdCardCopies() {
		return idCardCopies;
	}
	
	public void setIdCardCopies(Integer idCardCopies) {
		this.idCardCopies = idCardCopies;
	}
	
	public Integer getIdCard() {
		return idCard;
	}
	
	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}
	
	public Integer getIdCollection() {
		return idCollection;
	}
	
	public void setIdCollection(Integer idCollection) {
		this.idCollection = idCollection;
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
		return Objects.equals(copiesNumber, other.copiesNumber) && Objects.equals(idCard, other.idCard)
				&& Objects.equals(idCardCopies, other.idCardCopies) && Objects.equals(idCollection, other.idCollection);
	}
	
}
