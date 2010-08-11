package net.sb.gecomp.web.bridges.login;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.view.UserView;


public class UserBridge {

	public final UserView login(String username, String password) throws GeCompException {
		return new UserView(DbManagerFactory.getInstance().getUserDao().isAutheticated(username, password));
	}
	
}
