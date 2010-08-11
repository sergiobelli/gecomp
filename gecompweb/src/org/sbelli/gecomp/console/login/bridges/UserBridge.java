package org.sbelli.gecomp.console.login.bridges;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.bridges.view.UserView;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class UserBridge {

	public final UserView login(String username, String password) throws GeCompException {
		return new UserView(DbManagerFactory.getInstance().getUserDao().isAutheticated(username, password));
	}
	
}
