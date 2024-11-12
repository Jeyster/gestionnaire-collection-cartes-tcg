package gaurat.mathieu.gestionnairecollectioncartestcg.webservices.dto;

import java.util.Objects;

public class UserDTO {

	private String name;
	private String forname;
	private String email;

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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
		return Objects.equals(forname, other.forname) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}
	
}
