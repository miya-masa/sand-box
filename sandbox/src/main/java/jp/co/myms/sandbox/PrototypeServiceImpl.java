package jp.co.myms.sandbox;

import javax.inject.Inject;

public class PrototypeServiceImpl implements PrototypeService {

	@Inject
	private InjectedPrototypeService injectedPrototypeService;

	@Inject
	private InjectedSingletonService injectedSingletonService;

	@Override
	public void service() {
		System.out.println("PrototypeService : " + this.toString());
		injectedPrototypeService.service();
		injectedSingletonService.service();
	}

}
