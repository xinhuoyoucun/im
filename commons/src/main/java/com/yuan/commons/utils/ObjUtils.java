package com.yuan.commons.utils;

import java.lang.reflect.Field;

/**
 * @author by laiyuan
 * @Date 2020/3/27 4:22 下午
 * @Description: TODO
 * @Version 1.0
 */
public class ObjUtils {
    public static void cpoyObjAttr(Object sourceObj,Object targetObj, Class<?> clazz)throws Exception {
        if (sourceObj == null || targetObj == null) {
            throw new Exception("源对象和目标对象不能为null");
        }
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object sourceValue = fields[i].get(sourceObj);
            fields[i].set(targetObj, sourceValue);
        }
        if (clazz.getSuperclass() == Object.class) {
            return;
        }
        cpoyObjAttr(sourceObj, targetObj, clazz.getSuperclass());
    }

}
