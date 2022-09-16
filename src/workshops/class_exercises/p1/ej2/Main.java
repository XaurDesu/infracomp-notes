package workshops.class_exercises.p1.ej2;

import java.util.ArrayList;

public class Main {
    static ArrayList<ArrayList<Silla>> Sillas;
    static int cupo = Sillas.size() * Sillas.get(0).size() / 2;
    static int maxFamilia = Sillas.get(0).size()/2;

    public synchronized void registrarFamilia(Familia fam) throws Exception{
        for(Persona p: fam.getPersonas()) {
            ArrayList<Integer> pos = p.getPos();
            Integer x = pos.get(0);
            Integer y = pos.get(1);
            try {
                if(Sillas.get(x).get(y).getOccupated()){
                    throw new Exception();
                } else {
                    Sillas.get(x).get(y).setPersona(p);
                }
            } catch( Exception e ){
                e.printStackTrace();
            }
        }
    }
    public synchronized void quitarFamilia(Familia fam){
        for(Persona p: fam.getPersonas()) {
            ArrayList<Integer> pos = p.getPos();
            Integer x = pos.get(0);
            Integer y = pos.get(1);
            try {
                if(!Sillas.get(x).get(y).getOccupated()){
                    throw new Exception();
                } else {
                    Sillas.get(x).get(y).removePersona(Sillas.get(x).get(y));
                }
            } catch( Exception e ){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            //hacer threads de filas  para atender familias
        }
    }
}
