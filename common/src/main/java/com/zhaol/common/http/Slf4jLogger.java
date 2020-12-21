package com.zhaol.common.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttp Slf4j logger
 *
 * @author L.cm
 */
@Slf4j
public class Slf4jLogger implements HttpLoggingInterceptor.Logger {

	public static final HttpLoggingInterceptor.Logger INSTANCE = new Slf4jLogger();

	@Override
	public void log(String message) {
		log.info(message);
	}
}
