package org.pkp.utlity;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class NullPropertyUtil {

    public static String[] getNullPropertyNames(Object source) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd : pds) {
            Object value = src.getPropertyValue(pd.getName());
            if (value == null) {
                emptyNames.add(pd.getName());
            }
        }

        return emptyNames.toArray(new String[0]);
    }
}