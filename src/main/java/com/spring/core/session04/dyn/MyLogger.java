package com.spring.core.session04.dyn;
import java.util.Arrays;

// Aspect 切面程式 (共用邏輯)
public class MyLogger {
	// Before: 前置通知(業務方法調用前要執行的程式)
	public static void before(Class cls, String methodName, Object[] args) {
		System.out.printf("MyLogger 前置通知: %s %s args=%s\n", cls, methodName, Arrays.toString(args));
	}

	// Exception: 例外異常通知(執行業務方法時發生例外所要執行的程式)
	public static void throwing(Class cls, Throwable throwable) {
		System.out.printf("MyLogger 例外異常通知: %s %s\n", cls, throwable);
	}

	// End: 後置通知(業務方法調用完畢後要執行的程式)
	public static void end(Class cls, String methodName, Object result) {
		System.out.printf("MyLogger 後置通知: %s %s result=%s\n", cls, methodName, result);
	}
}
