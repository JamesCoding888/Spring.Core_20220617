package com.spring.core.session04.cglib;

//Echancer 增強
//子類別具有增強父類的特性
public class EnhancerHello extends Hello {

	@Override // 覆寫 / 攔截 (Interceptor)
	public String sayHello(String str) {
		String message = "請出示實聯 QRCode";
		return super.sayHello(str) + message;
	}
	
}