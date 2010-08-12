package net.sb.gecomp.web.delegates;

import org.apache.log4j.Logger;

public abstract class GenericDelegate implements IGenericDaoDelegate {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
}
