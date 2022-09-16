package workshops.class_exercises.p1.ej1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue q = new PriorityQueue();
    static ArrayList in = new ArrayList<Object>();

    public void addLector(Lector l) {
        q.add(l);
    }
    public void addEscritor(Escritor e) {
        q.add(e);
    }
    public void removeLector(Lector l) {
        q.remove(l);
    }

    public void removeEscritor(Escritor e) {
        q.remove(e);
    }
    public synchronized static void main(String[] args) {
        Lector l = new Lector();
        Escritor e = new Escritor();

        while(true){
            if (in.isEmpty()) {
                Object le = q.peek();
                q.remove(le);
                in.add(le);
            }
            else {
                if(in.get(0).getClass().isInstance(l)) {
                    //añadir lectores
                } else if (in.get(0).getClass().isInstance(e)) {
                    //añadir escritores
                }
            }

        }
    }
}
