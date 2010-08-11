package net.sb.gecomp.model;



/**
 * @author sbelli
 */
public class User extends GecompModelObject {

	private Long 	idUser;
	private String 	username;
	private String 	password;
	
	
	public Long getIdUser() {return idUser;}
	public void setIdUser(Long idUser) {this.idUser = idUser;}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



}
