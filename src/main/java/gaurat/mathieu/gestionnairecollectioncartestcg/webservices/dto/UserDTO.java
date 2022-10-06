package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class UserDTO {

	private String name;
	private String forname;
	private String login;
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getForname() {
		return forname;
	}
	
	public void setForname(String forname) {
		this.forname = forname;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(forname, other.forname) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}
	
}
