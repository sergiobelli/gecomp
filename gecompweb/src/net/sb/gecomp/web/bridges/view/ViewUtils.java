package net.sb.gecomp.web.bridges.view;

import java.lang.reflect.InvocationTargetException;

import net.sb.gecomp.model.GecompModelObject;

import org.apache.commons.beanutils.BeanUtils;

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
