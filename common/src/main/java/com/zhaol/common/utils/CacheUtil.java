package com.zhaol.common.utils;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.util.StringUtils;

import java.util.concurrent.Callable;

/**
 * 缓存工具类
 *
 * @version 1.0
 * @author: 赵力
 * @创建时间:2020/12/3 16:34
 */
public class CacheUtil {

    private static CacheManager cacheManager;

    public CacheUtil() {
    }

    /**
     * 初始化缓存管理
     * @param
     * @return org.springframework.cache.CacheManager
     * @author 赵力
     * @date 2020-12-03 17:01:48
    */
    private static CacheManager getCacheManager() {
        if (cacheManager == null) {
            cacheManager = SpringUtil.getBean(CacheManager.class);
        }

        return cacheManager;
    }

    /**
     * 获取缓存对象
     * @param name
     * @return org.springframework.cache.Cache
     * @author 赵力
     * @date 2020-12-03 17:03:03
    */
    public static Cache getCache(String name) {
        return getCacheManager().getCache(name);
    }

    /**
     * 获取结果对象
     * @param cacheName
     * @param key
     * @return java.lang.Object
     * @author 赵力
     * @date 2020-12-03 17:13:50
    */
    public static Object get(String cacheName, String key) {
        if(StringUtils.isEmpty(cacheName) || StringUtils.isEmpty(key)) {
            return null;
        }
        Cache.ValueWrapper valueWrapper = getCache(cacheName).get(key);
        return valueWrapper == null ? null : valueWrapper.get();
    }

    /**
     * 获取结果实例对象
     * @param cacheName
     * @param key
     * @param type
     * @return T
     * @author 赵力
     * @date 2020-12-03 17:22:10
    */
    public static <T> T get(String cacheName, String key, Class<T> type) {
        if(StringUtils.isEmpty(cacheName) || StringUtils.isEmpty(key)) {
            return null;
        }
        return getCache(cacheName).get(key,type);
    }

    /**
     * 获取结果实例对象,如果缓存没有查询并返回
     * @param cacheName
     * @param key
     * @param valueLoader
     * @return T
     * @author 赵力
     * @date 2020-12-03 17:32:05
    */
    public static <T> T get(String cacheName, String key, Callable<T> valueLoader) {
        if(StringUtils.isEmpty(cacheName) || StringUtils.isEmpty(key)) {
            return null;
        }
        try {
            Cache.ValueWrapper valueWrapper = getCache(cacheName).get(key);
            T value = null;
            if (valueWrapper == null) {
                // 异步获取值
                T call = valueLoader.call();
                if (call != null) {
                    getCache(cacheName).put(key, call);
                    value = call;
                }
            } else {
                value = (T)valueWrapper.get();
            }

            return value;
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
    }

    /**
     * 存入缓存
     * @param cacheName
     * @param key
     * @param value
     * @return void
     * @author 赵力
     * @date 2020-12-03 18:00:25
    */
    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }

    /**
     * 删除缓存
     * @param cacheName
     * @param key
     * @return void
     * @author 赵力
     * @date 2020-12-03 18:03:11
    */
    public static void evict(String cacheName, String key) {
        if(StringUtils.isEmpty(cacheName) || StringUtils.isEmpty(key)) {
            return;
        }
        getCache(cacheName).evict(key);
    }

    /**
     * 删除缓存对象下的所有缓存
     * @param cacheName
     * @return void
     * @author 赵力
     * @date 2020-12-03 18:03:59
    */
    public static void clear(String cacheName) {
        if(StringUtils.isEmpty(cacheName)) {
            return;
        }
        getCache(cacheName).clear();
    }
}
