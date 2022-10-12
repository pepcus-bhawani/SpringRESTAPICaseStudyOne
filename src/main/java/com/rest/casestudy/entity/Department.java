package com.rest.casestudy.entity;

import java.util.Arrays;

public enum Department {

	   QA("QA"),BE("BE"),FE("FE"),BA("BA");

	    private String label;

	    private Department(String label) {
	    this.label = label;
	    }

	    public static Department findByLabel(String byLabel) {
	        for (Department d : Department.values()) {
	            if (d.label.equalsIgnoreCase(byLabel))
	                return d;
	        }
	        return null;
	    }
	    
	    public static < E extends Enum < E >> boolean isInEnum(String value, Class < E > enumClass) {
			for (E e: enumClass.getEnumConstants()) {
				if (e.name().equals(value)) {
					return true;
				}
			}
			return false;
		}
	}



