package org.sbelli.gecomp.console.prestazioni.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.prestazioni.controllers.ValoreMisuraValidator;


public class ValoreMisuraConverter implements Converter {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String param) {
		Long valoreMisura = null;
		try {
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
			int total_seconds = (int)((Integer)object).intValue();
			int hours=(total_seconds)/(60*60); 
			int rem=(total_seconds)%(60*60); 
			int minutes=rem/60; 
			int seconds=rem%60; 
			String str_hours=""+hours; 
			String str_minutes=""+minutes;
			String str_seconds=""+seconds;

			if(hours<10){
				str_hours="0"+hours;
			}
			if(minutes<10){
				str_minutes="0"+minutes;
			}
			if(seconds<10){
				str_seconds="0"+seconds; 
			}
			return str_hours + ":" + str_minutes + ":" + str_seconds;

		} 
		catch (Exception exception) {
			throw new ConverterException(exception);
		}
	}

}
