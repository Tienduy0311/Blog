package com.blog.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class BeanUtil {
    public static <T> T toModel(T model, HttpServletRequest request) {
        try {
            BeanUtils.populate(model, request.getParameterMap());
            return model;
        } catch (IllegalAccessException e) {
            e.getMessage();
        } catch (InvocationTargetException e) {
            e.getMessage();
        }
        return null;
    }
}
