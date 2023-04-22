package com.spm.ibooking.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.lang.Nullable;

public class BeanUtils extends org.springframework.beans.BeanUtils {

    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
 
        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
    
    private static <S, T> void copyProperties(S source, T target, @Nullable Boolean ignoreNull, CallBack<S, T> callBack) {
        if(ignoreNull == null || Boolean.FALSE.equals(ignoreNull)) copyProperties(source, target);
        else copyProperties(source, target, getNullPropertyNames(source));
        
        if (callBack != null) {
            callBack.callBack(source, target);
        }
    }
    // public static <S, T> void copyNotNullProperties(S source, T target) {
    //     copyNotNullProperties(source, target, null);
    // }

    // public static <S, T> void copyNotNullProperties(S source, T target, CallBack<S, T> callBack) {
    //     copyProperties(source, target, getNullPropertyNames(source));

    //     if (callBack != null) {
    //         callBack.callBack(source, target);
    //     }
    // }



    // public static <S, T> void listCopyNotNullProperties(List<S> sources, List<T> targets) {
    //     copyNotNullProperties(sources, targets, null); 
    // }

    // public static <S, T> void listCopyNotNullProperties(List<S> sources, List<T> targets, CallBack<S, T> callBack) {
    //     IntStream.range(0, Math.min(sources.size(), targets.size()))
    //         .forEach(i -> {
    //             S source = sources.get(i);
    //             T target = targets.get(i);
    //             copyNotNullProperties(source, target, callBack); 
    //         });
    // }

    // public static <S, T> void listCopyProperties(List<S> sources, List<T> targets, CallBack<S, T> callBack) {
    //     IntStream.range(0, Math.min(sources.size(), targets.size()))
    //         .forEach(i -> {
    //             S source = sources.get(i);
    //             T target = targets.get(i);
    //             copyProperties(source, target, callBack); 
    //         });
    // }
    
    public static <S, T> void copyTo(S source, T target) {
        CopyTo(source, target, null, null);
    }

    public static <S, T> void copyTo(S source, T target, Boolean ignoreNull) {
        CopyTo(source, target, ignoreNull, null);
    }

    public static <S, T> void copyTo(S source, T target, CallBack<S, T> callBack) {
        CopyTo(source, target, null, callBack);
    }

    public static <S, T> void CopyTo(S source, T target, Boolean ignoreNull, CallBack<S, T> callBack) {
        copyProperties(source, target, ignoreNull, callBack);
    }

    public static <S, T> void copyListTo(List<S> sources, List<T> targets) {
        CopyListTo(sources, targets, null, null);
    }

    public static <S, T> void copyListTo(List<S> sources, List<T> targets, Boolean ignoreNull) {
        CopyListTo(sources, targets, ignoreNull, null);
    }

    public static <S, T> void copyListTo(List<S> sources, List<T> targets, CallBack<S, T> callBack) {
        CopyListTo(sources, targets, null, callBack);
    }

    public static <S, T> void CopyListTo(List<S> sources, List<T> targets, Boolean ignoreNull, CallBack<S, T> callBack) {
        IntStream.range(0, Math.min(sources.size(), targets.size()))
            .forEach(i -> {
                S source = sources.get(i);
                T target = targets.get(i);
                copyProperties(source, target, ignoreNull, callBack); 
            });
    }

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier) {
        return convertTo(source, targetSupplier, null, null);
    }

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, Boolean ignoreNull) {
        return convertTo(source, targetSupplier, ignoreNull, null);
    }

    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, CallBack<S, T> callBack) {
        return convertTo(source, targetSupplier, null, callBack);
    }
    /**
     * 转换对象
     *
     * @param source         源对象
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象
     */
    public static <S, T> T convertTo(S source, Supplier<T> targetSupplier, Boolean ignoreNull, CallBack<S, T> callBack) {
        if (null == source || null == targetSupplier) {
            return null;
        }

        T target = targetSupplier.get();
        copyProperties(source, target, ignoreNull, callBack);
        return target;
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier) {
        return convertListTo(sources, targetSupplier, null, null);
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, Boolean ignoreNull) {
        return convertListTo(sources, targetSupplier, ignoreNull, null);
    }

    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, CallBack<S, T> callBack) {
        return convertListTo(sources, targetSupplier, null, callBack);
    }
    /**
     * 转换对象
     *
     * @param sources        源对象list
     * @param targetSupplier 目标对象供应方
     * @param callBack       回调方法
     * @param <S>            源对象类型
     * @param <T>            目标对象类型
     * @return 目标对象list
     */
    public static <S, T> List<T> convertListTo(List<S> sources, Supplier<T> targetSupplier, Boolean ignoreNull, CallBack<S, T> callBack) {
        if (null == sources || null == targetSupplier) {
            return null;
        }

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T target = targetSupplier.get();
            copyProperties(source, target, ignoreNull, callBack);
            list.add(target);
        }
        return list;
    }
    
    /**
     * 回调接口
     *
     * @param <S> 源对象类型
     * @param <T> 目标对象类型
     */
    @FunctionalInterface
    public interface CallBack<S, T> {
        void callBack(S t, T s);
    }
}
