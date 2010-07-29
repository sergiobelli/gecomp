package net.sb.gecomp.web.user;

import java.util.Date;

import org.sbelli.gecomp.orm.model.User;

public class GeCompUserHttpSession {
	
	private User loggedUser;
	public User getLoggedUser() { return loggedUser; }
	public void setLoggedUser(User loggedUser) { this.loggedUser = loggedUser; }

	private Date	expireDate;
	public Date getExpireDate() {return expireDate;}
	public void setExpireDate(Date expireDate) {this.expireDate = expireDate;}
	
}
