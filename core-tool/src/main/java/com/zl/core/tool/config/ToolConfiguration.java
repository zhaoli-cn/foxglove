package com.zl.core.tool.config;


import com.zl.core.tool.utils.SpringUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 工具配置类
 *
 * @author Chill
 */
@Configuration
public class ToolConfiguration {

	/**
	 * Spring上下文缓存
	 */
	@Bean
	public SpringUtil springUtil() {
		return new SpringUtil();
	}

}
