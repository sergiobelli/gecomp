package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.User;

public class UserView extends User {
	public UserView() { }
	public UserView(User user) {
		ViewUtils.copyProperties(this, user);
	}
}
