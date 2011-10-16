package net.sb.gecomp.commons.utils;

import java.util.Collection;

public class Eval {
    
    public static boolean isNumeric (String str) {
    	try {
    		Long.valueOf(str);
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
    public static boolean isNotNumeric (String str) {
    	return !isNumeric(str);
    }

    public static boolean isDouble (String str) {
    	try {
    		Double.valueOf(str);
    		return true;
    	} catch (Exception ex) {
    		return false;
    	}
    }
    public static boolean isNotDouble (String str) {
    	return !isDouble(str);
    }
    
    public static final boolean isNull(Object object) {
		return object == null ? true : false;
	}
	public static final boolean isNotNull(Object object) {
		return !isNull(object);
	}
	
	public static final boolean isEmpty(String string) {
		return (isNull(string) || string.length() == 0) ? true : false;
	}
	public static final boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
	public static final boolean isEmpty(Collection collection) {
		return (isNull(collection) || collection.isEmpty()) ? true : false;
	}
	public static final boolean isNotEmpty(Collection collection) {
		return !isEmpty(collection);
	}
	
	public static final boolean equals(Object arg1, Object arg2) {
		return (Eval.isNull(arg1)) ? false : arg1.equals(arg2);
	}
	
	public static final boolean equalsIgnoreCase(String arg1, String arg2) {
		return (Eval.isNull(arg1)) ? false : arg1.equalsIgnoreCase(arg2);
	}
}
