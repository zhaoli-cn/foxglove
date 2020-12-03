package com.zhaol.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

/**
 * Spring Bean工具类
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/3 16:49
 */
public class SpringUtil implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(SpringUtil.class);
    private static ApplicationContext context;

    public SpringUtil() {
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.context = context;
    }
    
    /**
     * 获取Bean实例
     * @param clazz 类名
     * @return T
     * @author 赵力
     * @date 2020-12-03 16:52:59
    */
    public static <T> T getBean(Class<T> clazz) {
        return clazz == null ? null : context.getBean(clazz);
    }

    /**
     * 获取Bean实例
     * @param beanId 实例ID
     * @return T
     * @author 赵力
     * @date 2020-12-03 16:54:46
    */
    public static <T> T getBean(String beanId) {
        return beanId == null ? null : (T)context.getBean(beanId);
    }
    
    /**
     * 获取Bean实例
     * @param beanName 名称
     * @param clazz 类名
     * @return T
     * @author 赵力
     * @date 2020-12-03 16:56:34
    */
    public static <T> T getBean(String beanName, Class<T> clazz) {
        if (null != beanName && !"".equals(beanName.trim())) {
            return clazz == null ? null : context.getBean(beanName, clazz);
        } else {
            return null;
        }
    }

    /**
     * 获取context
     * @param 
     * @return org.springframework.context.ApplicationContext
     * @author 赵力
     * @date 2020-12-03 16:57:30
    */
    public static ApplicationContext getContext() {
        return context == null ? null : context;
    }

    /**
     * 发布事件
     * @param event
     * @return void
     * @author 赵力
     * @date 2020-12-03 16:58:26
    */
    public static void publishEvent(ApplicationEvent event) {
        if (context != null) {
            try {
                context.publishEvent(event);
            } catch (Exception var2) {
                log.error(var2.getMessage());
            }

        }
    }
    
}
