package guan.MultiThreading;

// 需求：用两个线程打印 1，2，A，3，4，B.....49,50,Z。

class Foo{
    public int num=1;
}

class T implements Runnable{
    private Foo foo;
    public T(Foo foo){
        this.foo = foo;
    }

    @Override
    public void run() {
        synchronized (foo){
            for(int i =1;i<=52;i++){
                while(foo.num !=1){
                    try {
                        foo.notifyAll();
                        foo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i);
                if(i%2 == 0){
                    foo.num = 2;
                }
            }
        }
    }
}

class S  implements Runnable{
    private Foo foo;
    public S(Foo foo){
        this.foo = foo;
    }

    @Override
    public void run() {
        synchronized (foo){
              for(int i='A';i<'Z';i++){
                  while(foo.num != 2){
                      try {
                          foo.notifyAll();
                          foo.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println((char)i);
                  foo.num =1;
              }
        }
    }
}

public class faceTest01 {

    public static void main(String[] args) {
        Foo foo = new Foo();
        T t = new T(foo);
        S s = new S(foo);
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(s);
        t1.start();
        t2.start();
    }
}
