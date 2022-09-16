package workshops.class_exercises.p1.ej2;

import java.util.ArrayList;

public class Silla {
    private boolean ocupated;
    private Persona persona;
    private ArrayList<Integer> position;
    public ArrayList<Integer> getPosition() {
        return this.position;
    }

    public boolean getOccupated() {
        return this.ocupated;
    }
    public void setOccupated(boolean b) {
        this.ocupated = b;
    }

    public void setPersona(Persona p) {
        this.persona = p;
        this.setOccupated(false);
    }
    public void removePersona(Silla s) {
        s.setPersona(null);
        s.setOccupated(false);
    }

    public Silla(Persona persona) {

    }
}
