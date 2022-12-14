package gaurat.mathieu.gestionnairecollectioncartestcg.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GAME")
public class Game {
	
	private Integer idGame;
	private String name;
	
	private Set<Card> cards;
	private Set<Collection> collections;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_GAME")
	public Integer getIdGame() {
		return idGame;
	}
	
	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}
	
	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = CascadeType.ALL)
	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(idGame, other.idGame) && Objects.equals(name, other.name);
	}
	
	

}
