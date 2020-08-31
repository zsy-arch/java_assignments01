package zsy.thinkinjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test16 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("java.lang.Integer");
            Method[] methods = c.getMethods();
            int i = 0;
            for (Method method : methods) {
                System.out.println(method);
                i++;
            }
            System.out.println(i);
            i = 0;
            Field[] fields = c.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            System.out.println("=============");
            Constructor[] constructors = c.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
