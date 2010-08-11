package net.sb.gecomp.model;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author sbelli
 */
public class GecompModelObject implements java.io.Serializable {
	public String toString() { return ToStringBuilder.reflectionToString(this); }
}
