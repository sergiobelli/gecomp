package net.sb.gecomp.web.controllers;

import org.apache.log4j.Logger;


public abstract class GenericController implements IGenericController {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
}
