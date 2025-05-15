package com.github.devmribeiro.java.utils.string;

/**
 *
 * @author Michael Ribeiro
 */
public class StringUtils {
	public static boolean isEmpty(String value) {
		return ((value == null) || value.trim().length() == 0);
	}

	public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }
}