package snippets.concurrency;

public class ConcurrentClass extends Thread{
    /*
    * This kind of class extends from thread, however, when
    * making a class with this kind of extension prevents
    * us from inheriting logic from other classes, so you should use it
    * only when you know for sure you aren't going to use logic from a class
    * through inheritance
    * */


    public synchronized void synchronizedMethod() {
        /*
        * This is a synchronized method, only one thread can run it at a time,
        * we should use these when we're accessing or modifying a critical area.
        * */
    }

    public void run() {
        /*
        * You call this class from the start() method. and while the definition of logic to
        * be called is on run(), calling the method run() itself will just result on a non-concurrent
        * execution of this class. Could be useful when we need a method but for whatever reason
        * we don't want to use concurrency (Embedded systems, maybe?), however, this is not recommended
        * */
    }


}
