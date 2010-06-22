package org.sbelli.gecomp.console.controllers;

import net.sb.gecomp.utils.logger.GeCompLogger;


public abstract class GenericController implements IGenericController {
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
}
