package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.User;

public class UserView extends User {
	public UserView() { }
	public UserView(User user) {
		ViewUtils.copyProperties(this, user);
	}
}
