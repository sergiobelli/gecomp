package org.sbelli.gecomp.console.controllers;

import org.sbelli.gecomp.orm.model.GecompModelObject;

import net.sb.gecomp.exceptions.GeCompException;

public interface IGenericController<T extends GecompModelObject> {
	void checks (T element) throws GeCompException;
}
