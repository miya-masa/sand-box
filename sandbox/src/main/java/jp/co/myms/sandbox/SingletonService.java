package jp.co.myms.sandbox;

import com.google.inject.ImplementedBy;

@ImplementedBy(SingletonServiceImpl.class)
public interface SingletonService {

	void service();
}
