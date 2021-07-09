package work7_9;

/**
 * Created with IntelliJ IDEA.
 * Description:复习单例模式
 * User: starry
 * Date: 2021 -07 -09
 * Time: 8:51
 */

/**
 * 懒汉模式
 */
class Singleton {
    //提供私有的构造方法
    private Singleton() {

    }

    //创建私有的类对象，并进行实例化
    private static Singleton singleton = new Singleton();

    //提供一个公共的获取实例的方法入口
    public static Singleton getInstance() {
        return singleton;
    }

}
//饿汉模式是线程安全的
//饿汉模式缺点：只要程序执行，就会构建这一个单例，但有可能没有用到此实例，所以会造成资源的浪费，性能的损耗
//那么我们是不是可以，等用到这个实例的时候，再进行实例化的操作呢？所以就有了懒汉模式。

/**
 * 懒汉模式——线程不安全版本
 */
class Singleton2 {
    private Singleton2() {

    }

    private static Singleton2 singleton2 = null;

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
//线程之所以不安全，是因为如果两个或多个线程同时获取这个未实例化的实例，那么走到singlenton2==null这里同时进入if里面，创建两个实例，所以线程不安全
//那怎么保证线程安全呢？需要解决的问题是第一次访问的时候保证线程安全就可以。

/**
 * 懒汉模式——线程安全，低性能
 */
class Singleton3 {
    private Singleton3() {

    }

    private static Singleton3 singleton3 = null;

    public static synchronized Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
//此版本在方法上加了synchronized锁，我们只需要保证第一次访问的时候线程安全，但是每次用到该实例都需要排队等待释放锁，无疑性能较低。

/**
 * 懒汉模式——性能更加
 */
class Singleton4 {
    private Singleton4() {

    }

    private static Singleton4 singleton4 = null;

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
//此版本性能就非常高，用了一个双重效验锁的方式来解决问题。
//因为它只将第一次访问的线程进行加锁，在里面创建实例，等创建完成后，别的线程进入锁后，再判是否为空，不为空就直接返回创建好的实例
//此版本还是会有指令重排序的问题。
//singleton4 = new Singleton4();看似只有一行代码，实际有三步执行方式，分别是
//1. 开辟内存空间
//2. 初始化
//3. 将对象的引用赋值给变量
//本来应该是123的执行顺序，但是由于指令重排序，会导致变成132的执行方式，并且在13执行完后，cpu的时间片用完了，暂停在此。
//此时如果另外一个线程来执行获取实例的方法，则在判空的时候拿到了半个对象，就直接进行返回了，获取到了这样一个未初始化的对象。

/**
 * 懒汉模式——完美
 */
class Singleton5 {
    private Singleton5() {

    }

    private static volatile Singleton5 singleton5 = null;

    public static Singleton5 getInstance() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                if (singleton5 == null) {
                    singleton5 = new Singleton5();
                }
            }
        }
        return singleton5;
    }
}
//此版本加volatile禁止了指令重排序，是懒汉模式最完美的版本




public class Work1 {
}
