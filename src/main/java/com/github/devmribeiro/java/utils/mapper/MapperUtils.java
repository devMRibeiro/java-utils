package com.github.devmribeiro.java.utils.mapper;

import java.lang.reflect.Field;

/**
 * Utility class that provides functionality to map fields from one object to another 
 * of a different class type using reflection. It attempts to copy field values from 
 * the source object to a new instance of the target class.
 * 
 * @author Michael Ribeiro
 */
public class MapperUtils {
	/**
     * Maps fields from the source object to a new instance of the target class.
     * This method uses reflection to match fields with the same name and type
     * between the source and target objects. If a field in the source does not 
     * exist in the target, or if types are incompatible, appropriate messages are logged.
     *
     * @param source      The source object whose fields are to be copied.
     * @param targetClass The class of the target object to be created and populated.
     * @param <T>         The type of the target class.
     * @return A new instance of the target class with fields copied from the source object,
     *         or null if an error occurs during the mapping process.
     */
	public static <T> T map(Object source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Field[] sourceFields = source.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            if ("serialVersionUID".equals(sourceField.getName()))
                continue;

            sourceField.setAccessible(true);

            try {
                Field targetField = targetClass.getDeclaredField(sourceField.getName());
                targetField.setAccessible(true);

                if (sourceField.getType().equals(targetField.getType())) {
                    targetField.set(target, sourceField.get(source));
                } else {
                    System.out.println("Incompatible types:" + sourceField.getName());
                }
            } catch (NoSuchFieldException e) {
                System.out.println("Field not found in target: " + sourceField.getName());
            } catch (IllegalAccessException e) {
                System.out.println("Error accessing the field:" + sourceField.getName());
            }
        }
        return target;
    }
}