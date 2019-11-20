package controller;

import java.lang.reflect.Method;

public class ChamarMetodo implements ChamarMetodoInterface{

private Method method;
private Object obj;
private MenuWrapper wrapper;
@Override
public void invokeMethod() throws Exception {
	wrapper.ola = (String) method.invoke(obj);
}
public void setObj(Object obj) {
	this.obj=obj;
}
public void setWrapper(MenuWrapper wrapper) {
	this.wrapper=wrapper;
}
@Override
public void setMethod(Method method) {
    this.method = method;
}

}