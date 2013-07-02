package jp.co.myms.sandbox;

import com.google.inject.ImplementedBy;

@ImplementedBy(InjectedPrototypeServiceImpl.class)
public interface InjectedPrototypeService {

	void service();
}
