package com.baidu.fsg.uid.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanUtil.class);

    private static ApplicationContext CONTEXT;

    public static <T> T getBean(Class<T> tClass) {
        return CONTEXT.getBean(tClass);
    }

    public static Object getBean(String name) {
        return CONTEXT.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
        return CONTEXT.getBean(name, tClass);
    }

    public static <T> Map<String, T> beansOfType(Class<T> tClass) {
        return BeanFactoryUtils.beansOfTypeIncludingAncestors(CONTEXT, tClass, false, false);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.CONTEXT = applicationContext;
    }

    public static Object getBeanByName(String beanName) {
        if (null == CONTEXT) {
            return null;
        }
        return CONTEXT.getBean(beanName);
    }
}
