package com.spm.ibooking.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class UpdateUtil {
    
    /**
     * copy source's preperties that not null to target.
     *
     * @param source
     * @param target
     */
    public static void copyNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNotNullProperties(source));
    }
 
    /**
     * @param target 目标源数据
     * @return 将目标源中不为null的字段取出
     */
    private static String[] getNotNullProperties(Object target) {
        BeanWrapper srcBean = new BeanWrapperImpl(target);
        PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
        Set<String> notEmptyName = new HashSet<>();
        for (PropertyDescriptor p : pds) {
            Object value = srcBean.getPropertyValue(p.getName());
            if (Objects.isNull(value)) notEmptyName.add(p.getName());
        }
        String[] result = new String[notEmptyName.size()];
        return notEmptyName.toArray(result);
    }
}
