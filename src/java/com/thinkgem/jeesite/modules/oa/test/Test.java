package com.thinkgem.jeesite.modules.oa.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException  {
		Object obj = AD.class.newInstance();
		Method m = AD.class.getMethod("foo", String.class);
		for (int i = 0; i < 16; i++) {
			m.invoke(obj, Integer.toString(i));
		}
	}
}
