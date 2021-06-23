package guan.Agent.DynamicAgent;

import guan.Agent.DynamicAgent.SayHello;

public class Agent implements SayHello {
    @Override
    public void sayHello() {
        System.out.println("Hello,word!");
    }
}
