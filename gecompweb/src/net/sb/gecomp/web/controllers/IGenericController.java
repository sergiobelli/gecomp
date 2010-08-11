package net.sb.gecomp.web.controllers;


import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.GecompModelObject;

public interface IGenericController<T extends GecompModelObject> {
	void checks (T element) throws GeCompException;
}
