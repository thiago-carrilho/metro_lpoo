package controller;

import java.lang.reflect.Method;

public interface ChamarMetodoInterface {
	public void setMethod(Method method);
	public void invokeMethod() throws Exception;
	public void setObj(Object obj);
	public void setWrapper(MenuWrapper wrapper);

} 