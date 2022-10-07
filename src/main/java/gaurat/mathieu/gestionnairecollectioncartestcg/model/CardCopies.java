package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import java.util.Objects;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARD_COPIES")
@AssociationOverrides({
@AssociationOverride(name = "card", joinColumns = @JoinColumn(name = "ID_CARD")),
@AssociationOverride(name = "collection", joinColumns = @JoinColumn(name = "ID_COLLECTION"))
})
public class CardCopies {
	
	private Integer idCardCopies;
	private Card card;
	private Collection collection;
	private Integer copiesNumber;
	
	public CardCopies() {
	}
	
	public CardCopies(Integer idCardCopies, Card card, Collection collection) {
		this.idCardCopies = idCardCopies;
		this.card = card;
		this.collection = collection;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CARD_COPIES")
	public Integer getIdCardCopies() {
		return idCardCopies;
	}

	public void setIdCardCopies(Integer idCardCopies) {
		this.idCardCopies = idCardCopies;
	}

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CARD", referencedColumnName = "ID_CARD")
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_COLLECTION", referencedColumnName = "ID_COLLECTION")
	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	@Column(name = "COPIES_NUMBER")
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
		CardCopies other = (CardCopies) obj;
		return Objects.equals(card, other.card) && Objects.equals(collection, other.collection)
				&& Objects.equals(copiesNumber, other.copiesNumber) && Objects.equals(idCardCopies, other.idCardCopies);
	}
	
}
