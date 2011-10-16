package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.GecompModelObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public class ViewUtils {

	public static void copyProperties(GecompModelObject dest, GecompModelObject orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			Logger.getLogger(ViewUtils.class).error("Errore durante loperazione di copia degli attributi...", e);
		}
	}
	
}
