package jp.co.myms.sandbox;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestRunner {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector();
		SingletonService singleton1 = injector.getInstance(SingletonService.class);
		SingletonService singleton2 = injector.getInstance(SingletonService.class);

		PrototypeService prototypeService1 = injector.getInstance(PrototypeService.class);
		PrototypeService prototypeService2 = injector.getInstance(PrototypeService.class);
		
		System.out.println("##########Singleton service#############");
		
		singleton1.service();
		singleton2.service();
		
		System.out.println("##########Prototype service#############");
		
		prototypeService1.service();
		prototypeService2.service();

	}
}
