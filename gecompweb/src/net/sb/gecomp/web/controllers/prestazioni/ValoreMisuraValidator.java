package net.sb.gecomp.web.controllers.prestazioni;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;

import org.apache.log4j.Logger;


public class ValoreMisuraValidator implements Validator {

	protected static Logger logger = Logger.getLogger(ValoreMisuraValidator.class.getName());
	
	private static final String PATTERN = "[\\d]?\\d:[\\d]?\\d:[\\d]?\\d.(\\d\\d\\d)*";
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object object) throws ValidatorException {
		validate((String) object);
	}

	public static void validate(String valoreMisura) throws ValidatorException {
		logger.info("valore misura = "+ valoreMisura);
		
		FacesMessage message = 
			new FacesMessage(
					FacesMessage.SEVERITY_ERROR, 
					GuiMessageHandler.getMessageResourceString("message.prestazione.valore.misura.non.valorizzato"), 
					GuiMessageHandler.getMessageResourceString("message.prestazione.valore.misura.non.valorizzato"));

		if (Eval.isEmpty(valoreMisura)) {
			throw new ValidatorException(message);
		} else {
			//hh:mm:ss.xxx
			Pattern pattern = Pattern.compile(PATTERN);
			Matcher matcher = pattern.matcher(valoreMisura);
			if (!matcher.matches()) {
				message.setDetail("Pattern non rispettato");//TODO:mettere in bundle
				throw new ValidatorException(message);
			}
		}	
	}
//	public static void main (String [] args) {
//		Pattern pattern = Pattern.compile(ValoreMisuraValidator.PATTERN);
//		Matcher m = pattern.matcher("1:2:3.45");
//		while (m.find()) {
//			System.out.println(m.start() + " " + m.group());
//		}
//	}
	
}
