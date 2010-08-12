package net.sb.gecomp.web.controllers;


import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;

public interface IGenericController<T extends GecompModelObject> {
	void checks (T element) throws GeCompException;
}
