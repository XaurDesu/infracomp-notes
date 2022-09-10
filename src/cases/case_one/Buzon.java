import java.util.ArrayList;
import java.util.Stack;

public class Buzon {

    protected int tamanio;

    //private int cantidadDeMensajes;
    protected Stack<String> mensajes;


    public Buzon(int pTamanio, String pMensaje) {

        this.tamanio = pTamanio;
        this.mensajes = new Stack<String>();
        //mensajes.setSize(tamanio-1);
    }

    public int darTamanio() {

        return this.tamanio;
    }

    public Stack<String> darMensajes() {
        return this.mensajes;
    }

    public synchronized void depositarmensaje(String pMensaje)
    {
        while(this.mensajes.size()== this.tamanio )
        {
            try {
                System.out.println("El buzon esta lleno");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mensajes.push(pMensaje);
        //this.cantidadDeMensajes++;
        notifyAll();
    }

    public synchronized String retirarmensaje()
    {
        while(this.mensajes.size() == 0 )
        {
            try {
                System.out.println("El buzon esta vacio");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String mensaje = this.mensajes.pop();

        return mensaje;
    }

    public String retirarMensajePasivo() {

        while(this.mensajes.size() == 0 )
        {
            try {
                System.out.println("El buzon esta vacio");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String mensaje = this.mensajes.pop();
        return mensaje;
    }
    public synchronized void depositarMensajePasiva(String pMensaje)
    {
        while(this.mensajes.size()== this.tamanio )
        {
            try {
                System.out.println("El buzon esta lleno");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.mensajes.push(pMensaje);
        //this.cantidadDeMensajes++;
        notifyAll();
    }
}
