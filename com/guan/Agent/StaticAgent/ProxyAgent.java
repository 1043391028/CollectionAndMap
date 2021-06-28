public class ProxyAgent implements SayHello {
    private SayHello proxyAgent = new Agent();
    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello" );
        proxyAgent.sayHello();
        System.out.println("After invoke sayHello");
    }
}
