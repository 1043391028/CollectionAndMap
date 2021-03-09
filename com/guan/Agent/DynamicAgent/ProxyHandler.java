package DynamicAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 动态代理底层实现
// 动态代理具体步骤：
//          *通过实现 InvocationHandler 接口创建自己的调用处理器；
//          *通过为 Proxy 类指定 ClassLoader 对象和一组 interface 来创建动态代理类；
//          *通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
//          *通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
//

public class ProxyHandler implements InvocationHandler {
    // 被代理的接口；
    private Object ob;
    // 构造
    public void setOb(Object ob){
        this.ob = ob;
    }
    // 获得代理类对象；
    //  动态代理的本质：反射；获得代理类唯一需要的参数就是ob(实际传入的接口类对象)
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),ob.getClass().getInterfaces(),this);
    }

    // 处理代理实例，返回代理类接口对象；
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在invoke方法前："+method.getName());
        this.sayHi();
        Object result = method.invoke(ob,args);
        System.out.println("在invoke方法后："+method.getName());
        return result;
    }
    // 新加方法；
    private void sayHi(){
        System.out.println("Hi Word!");
    }
}
