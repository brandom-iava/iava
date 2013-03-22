package com.iava.dp.behavioral.visitor.demo2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class Visitor {

    final public void visit(Object object) {
        Method method = getVisitMethod(object);
        try {
        	System.out.println("come in");
            method.invoke(this, new Object[] { object });
        } catch (Exception e) {
            String message = "invokeing method failed:visit("
                    + object.getClass().getName() + ")";
            throw new RuntimeException(message, e);
        }
    }

    private Map visitMethods = new HashMap();

    private Method getVisitMethod(Object object) {
        //return (Method) visitMethods.get(object.getClass());
        Iterator it = visitMethods.keySet().iterator();
        for (; it.hasNext();) {
            Class clazz = (Class) it.next();
            if (clazz.isAssignableFrom(object.getClass())) {
                return (Method) visitMethods.get(clazz);
            }
        }
        throw new RuntimeException("method: visit(" + object.getClass().getName()
                + ") undefined in the class");
    }

    private Method visitMethod;

    private void initVisitMethod() {
        Method[] methods = getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals("visit")) {
                Class[] paramTypes = methods[i].getParameterTypes();
                if (paramTypes.length == 1) {
                    visitMethods.put(paramTypes[0], methods[i]);
                }
            }
        }
    }

    {
        initVisitMethod();
    }
}
