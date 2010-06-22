package org.sbelli.gecomp.console.utils.guimessages;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.MessageSeverity;



public class GuiMessageHandler {

	public static void addGUIMessage ( MessageSeverity severity, String messageKey, String descriptionKey ) {

		String bundleName = FacesContext.getCurrentInstance().getApplication().getMessageBundle();
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		String message = getMessageResourceString(bundleName, messageKey, null, locale);
		String description = getMessageResourceString(bundleName, descriptionKey, null, locale);

		if (severity == MessageSeverity.info) {
			FacesContext.getCurrentInstance().addMessage ( null, new FacesMessage( FacesMessage.SEVERITY_INFO, message, description ) );
		} else if (severity == MessageSeverity.warn) {
			FacesContext.getCurrentInstance().addMessage ( null, new FacesMessage( FacesMessage.SEVERITY_WARN, message, description ) );
		} else if (severity == MessageSeverity.error) {
			FacesContext.getCurrentInstance().addMessage ( null, new FacesMessage( FacesMessage.SEVERITY_ERROR, message, description ) );
		} else if (severity == MessageSeverity.fatal) {
			FacesContext.getCurrentInstance().addMessage ( null, new FacesMessage( FacesMessage.SEVERITY_FATAL, message, description ) );
		} else {
			FacesContext.getCurrentInstance().addMessage ( null, new FacesMessage( FacesMessage.SEVERITY_ERROR, message, description ) );
		}

	}

	private static ClassLoader getCurrentClassLoader(Object defaultObject){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if(Eval.isNull(loader)){
			loader = defaultObject.getClass().getClassLoader();
		}
		return loader;
	}

	
	
	
	public static String getMessageResourceString(String key) {
		return getMessageResourceString(
				FacesContext.getCurrentInstance().getApplication().getMessageBundle(), 
				key, 
				null, 
				FacesContext.getCurrentInstance().getViewRoot().getLocale());
	}
	
	/**
	 * 
	 * @param bundleName
	 * @param key
	 * @param params
	 * @param locale
	 * @return
	 * 
	 * Utils.getMessageResourceString(context.getApplication()
				.getMessageBundle(), "welcome", null, context.getViewRoot()
				.getLocale());
	 * 
	 * 
	 * 
	 */
	public static String getMessageResourceString(String bundleName, String key, Object params[], Locale locale){
		String text = null;
		if (Eval.isEmpty(bundleName)) {
			bundleName = FacesContext.getCurrentInstance().getApplication().getMessageBundle();
		}
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale, getCurrentClassLoader(params));
		try{
			text = bundle.getString(key);
		} catch(MissingResourceException e){
			text = "?? key " + key + " not found ??";
		}

		if(params != null){
			MessageFormat mf = new MessageFormat(text, locale);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

}
