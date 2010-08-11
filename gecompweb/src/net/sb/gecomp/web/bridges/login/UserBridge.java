package net.sb.gecomp.web.bridges.login;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.bridges.view.UserView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class UserBridge {

	public final UserView login(String username, String password) throws GeCompException {
		return new UserView(DbManagerFactory.getInstance().getUserDao().isAutheticated(username, password));
	}
	
}
