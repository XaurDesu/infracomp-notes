package snippets.concurrency.semaphore;

public class Semaphore {
    // 0 = p() = wait
    // 1 = v() = ready
    int val = 0;

    //passering: pass/occupate
    public synchronized void p(int val) throws InterruptedException {
        val--;
        if(val <= 0){
            wait();
        }
    }

    //vrijgave: liberate
    public synchronized void v(int val) {
        val++;
    }
    public Semaphore() {
        //starts on ready
        this.val = 1;
    }
}
