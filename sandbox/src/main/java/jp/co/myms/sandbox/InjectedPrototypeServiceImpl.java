package jp.co.myms.sandbox;

public class InjectedPrototypeServiceImpl implements InjectedPrototypeService {

	@Override
	public void service() {
		System.out.println("InjectedPrototypeService : " + this.toString());
	}

}
