package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARD")
@AssociationOverrides({
@AssociationOverride(name = "game", joinColumns = @JoinColumn(name = "ID_GAME"))
})
public class Card {
	
	private Integer idCard;
	private Game game;
	private String name;
	
	private Set<CardCopies> cardCopies;
	
	public Card( ) {
	}
	
	public Card(Integer idCard, Game game, String name) {
		this.idCard = idCard;
		this.game = game;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CARD")
	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GAME", referencedColumnName = "ID_GAME")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card", cascade = CascadeType.ALL)
	public Set<CardCopies> getCardCopies() {
		return cardCopies;
	}

	public void setCardCopies(Set<CardCopies> cardCopies) {
		this.cardCopies = cardCopies;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(game, other.game)
				&& Objects.equals(idCard, other.idCard) && Objects.equals(name, other.name);
	}

}
