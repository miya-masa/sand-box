package jp.co.myms.sandbox;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SingletonServiceImpl implements SingletonService {

	@Inject
	private PrototypeService prototypeService;

	@Override
	public void service() {
		System.out.println("SingletonService : " + this.toString());
		prototypeService.service();
	}

}
