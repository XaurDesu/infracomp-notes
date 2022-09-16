package workshops.class_exercises.p1.ej2;

import java.util.ArrayList;

public class Persona {
    private ArrayList<Integer> position;
    public Persona(ArrayList<Integer> position) {
        this.position = position;
    }
    public ArrayList<Integer> getPos() {
        return this.position;
    }
}
