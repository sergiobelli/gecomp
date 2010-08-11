package net.sb.gecomp.web.bridges.view;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class ViewUtils {

	public static void copyProperties(GecompModelObject dest, GecompModelObject orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}
