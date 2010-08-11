package net.sb.gecomp.web.bridges.view;

import org.sbelli.gecomp.orm.model.User;

public class UserView extends User {
	public UserView() { }
	public UserView(User user) {
		ViewUtils.copyProperties(this, user);
	}
}
