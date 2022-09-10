public class BuzonExtremo extends Buzon{


    public BuzonExtremo(int pTamanio, String pMensaje) {
        super(pTamanio, pMensaje);
    }

    public synchronized void depositarmensaje(String pMensaje)
    {

        if(this.darMensajes().size() != this.darTamanio())
        {

            this.mensajes.push(pMensaje);
            notifyAll();
            System.out.println("El mensaje: "+ pMensaje +" ha sido depositado en un buzon extremo");
        }
        else
        {
            System.out.println("El buzon esta lleno");
        }

    }

    public synchronized String retirarmensaje()
    {
        String mensaje = null;
        if(this.darMensajes().size() != 0)
        {
            mensaje = this.mensajes.pop();
            notifyAll();
        }
        else
        {
            System.out.println("El buzon esta vacio");
        }

        return mensaje;
    }

    public synchronized String retirarMensajePasivo() {
        return super.retirarMensajePasivo();
    }

    public synchronized void depositarMensajePasiva(String pMensaje)
    {
    super.depositarMensajePasiva(pMensaje);
    }

}
