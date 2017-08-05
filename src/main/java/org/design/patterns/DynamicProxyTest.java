package org.design.patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类或接口的功能说明
 *
 * @author liwenliang
 * @Date: 2017年07月26日 下午7:20:00
 * @History :
 * @Date: 2017年07月26日 下午7:20:00
 * @author: berchina-liwenliang
 * @Desc: 修改目的和修改方法
 **/
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        public void sayHello() {
            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader()
                    ,originalObj.getClass().getInterfaces(),this);
        }

        public Object invoke(Object proxy, Method method,Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj,args);
        }

        public static void main(String[] args) {
//            System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//            IHello hello = (IHello) new DynamicProxy().bind(new Hello());
//            hello.sayHello();


            Integer a = 1;
            Integer b = 2;
            Integer c = 3;
            Integer d = 3;
            Integer e = 128;
            Integer f = 128;
            Long g = 3L;
            System.out.println(c==d);
            System.out.println(e.equals(f));
            System.out.println(c==(a+b));
            System.out.println(g==(a+b));
            System.out.println(g.equals(a+b));
        }
    }

}
