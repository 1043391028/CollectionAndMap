package guan.Agent.DynamicAgent;

public class Test {
    public static void main(String[] args) {
        // 新建实际对象
        SayHello agent = new Agent();
        // 代理角色
        ProxyHandler proxyHandler = new ProxyHandler();
        //  调用函数来处理我们要调用的接口对象（实际对像）；
        proxyHandler.setOb(agent);
        //  生成代理类对象；（动态生成的）
        SayHello proxyAgent = (SayHello) proxyHandler.getProxy();
        proxyAgent.sayHello();
    }
}
