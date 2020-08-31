package zsy.thinkinjava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test17 {
    public static void main(String[] args) {
        MyInterface1 myInterface1 =
                (MyInterface1) Proxy.newProxyInstance(MyInterface1.class.getClassLoader(), new Class[]{MyInterface1.class}, new DynamicProxyHandler());
        say(myInterface1);
    }

    public static void say(MyInterface1 myInterface1) {
        myInterface1.say("Hello");
    }
}

class DynamicProxyHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy starts....");
        System.out.println("================");
        System.out.println("There are parameters:");
        if (args != null) {
            for (int j = 0; j < args.length; j++) {
                args[j] += ("\t\t\t\t'Args[" + j + "]'");
            }
        }
        System.out.println("Real method is being invoked....");
        return method.invoke(new MyInterface1Impl(), args);
    }
}

interface MyInterface1 {
    void say(String text);
}

class MyInterface1Impl implements MyInterface1 {

    @Override
    public void say(String text) {
        System.out.println("MyInterface1Impl text:" + text);
    }
}