package jp.co.myms.sandbox;

import com.google.inject.ImplementedBy;

@ImplementedBy(PrototypeServiceImpl.class)
public interface PrototypeService {

	void service();
}
