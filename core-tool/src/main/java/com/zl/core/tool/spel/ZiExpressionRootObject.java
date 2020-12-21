package com.zl.core.tool.spel;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Method;

/**
 * ExpressionRootObject
 *
 * @author L.cm
 */
@Getter
@AllArgsConstructor
public class ZiExpressionRootObject {
	private final Method method;

	private final Object[] args;

	private final Object target;

	private final Class<?> targetClass;

	private final Method targetMethod;
}
