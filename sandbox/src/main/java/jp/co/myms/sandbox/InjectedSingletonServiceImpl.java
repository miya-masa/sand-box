package jp.co.myms.sandbox;

import com.google.inject.Singleton;

@Singleton
public class InjectedSingletonServiceImpl implements InjectedSingletonService {

	@Override
	public void service() {
		System.out.println("InjectedSingletonService : " + this.toString());
	}

}
