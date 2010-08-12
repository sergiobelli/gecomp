package net.sb.gecomp.web.bridges;

import org.apache.log4j.Logger;

public abstract class GenericBridge implements IGenericBridge {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
}
