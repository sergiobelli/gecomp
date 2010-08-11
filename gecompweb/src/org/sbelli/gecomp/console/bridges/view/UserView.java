package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.User;

public class UserView extends User {
	public UserView() { }
	public UserView(User user) {
		ViewUtils.copyProperties(this, user);
	}
}
