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
@Table(name = "COLLECTION")
@AssociationOverrides({
@AssociationOverride(name = "user", joinColumns = @JoinColumn(name = "ID_USER")),
@AssociationOverride(name = "game", joinColumns = @JoinColumn(name = "ID_GAME"))
})
public class Collection {

	private Integer idCollection;
	private User user;
	private Game game;
	
	private Set<CardCopies> cardCopies;
	
	public Collection() {
	}
	
	public Collection(Integer idCollection, User user, Game game) {
		this.idCollection = idCollection;
		this.user = user;
		this.game = game;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_COLLECTION")
	public Integer getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(Integer idCollection) {
		this.idCollection = idCollection;
	}

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_GAME", referencedColumnName = "ID_GAME")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "collection", cascade = CascadeType.ALL)
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
		Collection other = (Collection) obj;
		return Objects.equals(game, other.game)
				&& Objects.equals(idCollection, other.idCollection) && Objects.equals(user, other.user);
	}
	
}
