package jp.co.myms.sandbox;

import com.google.inject.ImplementedBy;

@ImplementedBy(InjectedSingletonServiceImpl.class)
public interface InjectedSingletonService {

	void service();
}
