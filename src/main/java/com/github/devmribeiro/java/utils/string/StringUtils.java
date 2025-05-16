package com.github.devmribeiro.java.utils.string;

/**
 *
 * @author Michael Ribeiro
 */
public class StringUtils {

	/**
     * <p>Checks if a (trimmed) String is <code>null</code> or empty.</p>
     *
     * <p><strong>Note:</strong> In future releases, this method will no longer trim the input string such that it works
     * complementary to {@link #isNotEmpty(String)}. Code that wants to test for whitespace-only strings should be
     * migrated to use {@link #isBlank(String)} instead.</p>
     *
     * @param str the String to check
     * @return <code>true</code> if the String is <code>null</code>, or
     *         length zero once trimmed
     */
	public static boolean isEmpty(String value) {
		return ((value == null) || value.trim().length() == 0);
	}


	public static boolean isAnyEmpty(Object... values) {
	    if (values == null)
	        return true;

	    for (Object value : values) {
	        if (value == null)
	            return true;
	        if (value instanceof String && isEmpty((String) value))
	            return true;
	    }
	    return false;
	}

	public static String toKebab(String value) {
		return value.replaceAll("([^^])([A-Z][a-z])", "$1-$2").toLowerCase();
	}

	public static String toSnakeCase(String value) {
		return value.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
	}
}