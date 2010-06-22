package org.sbelli.gecomp.console.prestazioni.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.utils.misure.TipoMisuraTempoHelper;

import org.sbelli.gecomp.console.prestazioni.controllers.ValoreMisuraValidator;


public class ValoreMisuraConverter implements Converter {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String param) {
		Long valoreMisura = null;
		try {
			logger.info("Valore misura in input = ", param);
			ValoreMisuraValidator.validate(param);
			
			String time[] = param.split(":");
			int seconds = 
				Integer.parseInt(time[0])*60*60 + 
				Integer.parseInt(time[1])*60+
				Integer.parseInt(time[2]);
			seconds = seconds * 1000;
			valoreMisura = new Long(seconds);
		} catch (Exception ex) {
			logger.error(ex, "errore in fase di conversione del valore misura");
			if (ex instanceof ValidatorException) {
				facesContext.addMessage( null , ((ValidatorException) ex).getFacesMessage());
			} else {
				facesContext.addMessage( null , new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errore in fase di conversione", "valore misura...."));//TODO:mettere in bundle
			}
		}
		return valoreMisura;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
		try {
			return TipoMisuraTempoHelper.parse(((Long)object));
		} catch (Exception ex) {
			logger.error(ex, "errore in fase di conversione del valore misura");
			throw new ConverterException(ex);
		}
	}

}
