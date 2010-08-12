package net.sb.gecomp.web.converters.prestazioni;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;

import net.sb.gecomp.commons.utils.misure.TipoMisuraTempoHelper;
import net.sb.gecomp.web.controllers.prestazioni.ValoreMisuraValidator;

import org.apache.log4j.Logger;



public class ValoreMisuraConverter implements Converter {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String param) {
		Long valoreMisura = null;
		try {
			logger.info("Valore misura in input = "+ param);
			ValoreMisuraValidator.validate(param);
			
			String time[] = param.split(":");
			String secs[] = time[2].split("[.]");
			int mseconds = 
				Integer.parseInt(time[0])*60*60 + 
				Integer.parseInt(time[1])*60+
				Integer.parseInt(secs[0]);
			mseconds = (mseconds * 1000) + Integer.parseInt(secs[1]);
			valoreMisura = new Long(mseconds);
		} catch (Exception ex) {
			logger.error("errore in fase di conversione del valore misura", ex);
			FacesMessage message = null;
			if (ex instanceof ValidatorException) {
				message =  ((ValidatorException) ex).getFacesMessage();
				facesContext.addMessage( null , message);
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errore in fase di conversione", "valore misura....");
				facesContext.addMessage( null , message);//TODO:mettere in bundle
			}
			throw new ConverterException(message);
		}
		return valoreMisura;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		try {
			return TipoMisuraTempoHelper.parse(((Long)object));
		} catch (Exception ex) {
			logger.error("errore in fase di conversione del valore misura", ex);
			throw new ConverterException(ex);
		}
	}

}
