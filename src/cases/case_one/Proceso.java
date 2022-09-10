
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Proceso extends Thread
{

    private Buzon buzonEntrada = new Buzon(3, " ");

    private Buzon buzonSalida = new Buzon(3, " ");


    private String mensaje;

    private int nivel;

    private int numeroDeProceso;

    private int numMensajesIniciales;



    public Proceso(int pNivel, int pNumeroDeProceso, Buzon pEntrada, Buzon pSalida, int pNumMensajes) {
        this.nivel = pNivel;
        this.numeroDeProceso = pNumeroDeProceso;
        this.buzonEntrada = pEntrada;
        this.buzonSalida = pSalida;
        this.numMensajesIniciales = pNumMensajes;

    }

    public void run()
    {
        if(this.darNivel()==0)
        {
            for (int i = 0; i < numMensajesIniciales; i++)
            {
                mensaje = "M"+(i+1);

                while(this.buzonEntrada.darMensajes().size() == this.buzonEntrada.darTamanio())
                {
                    Thread.yield();
                }

                this.buzonEntrada.depositarmensaje(mensaje);

            }



        }
        else if (this.darNivel()==1 )
        {
            while(true)
            {
                /*while(this.buzonSalida.darMensajes().size() == 0)
                {
                    yield();
                }*/

                String msg = this.buzonSalida.retirarMensajePasivo();

                if(msg != null)
                {
                    System.out.println("Hilo " + this.darNumeroDeProceso() + ": Recibo mensaje: " + msg);

                    try
                    {
                        sleep(500);
                    } catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    String escritura = msg.concat("T" + Integer.toString(nivel) +Integer.toString(numeroDeProceso));

                    System.out.println("Hilo " + this.darNumeroDeProceso() + ": Envio mensaje: " + escritura);

                    this.buzonEntrada.depositarmensaje(escritura);
                }
            }



        }
        else if (this.darNivel()==2 )
        {
            while(true)
            {
                String msg = this.buzonSalida.retirarmensaje();

                System.out.println("Hilo " + this.darNumeroDeProceso() + ": Recibo mensaje: " + msg);

                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                String escritura = msg.concat("T" + Integer.toString(nivel) +Integer.toString(numeroDeProceso));

                System.out.println("Hilo " + this.darNumeroDeProceso() + ": Envio mensaje: " + escritura);

                this.buzonEntrada.depositarmensaje(escritura);
            }




        }
        else if (this.darNivel()==3)
        {
            while(true)
            {
                String msg = this.buzonSalida.retirarmensaje();

                System.out.println("Hilo " + this.darNumeroDeProceso() + ": Recibo mensaje: " + msg);

                try
                {
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                String escritura = msg.concat("T" + Integer.toString(nivel) +Integer.toString(numeroDeProceso));

                System.out.println("Hilo " + this.darNumeroDeProceso() + ": Envio mensaje: " + escritura);



                this.buzonEntrada.depositarMensajePasiva(escritura);
            }


        }
        else
        {
            String msgFinal ="";
            while(true) {

                while(this.buzonSalida.darMensajes().size() == 0 )
                {
                    Thread.yield();
                }

                String msg = this.buzonSalida.retirarmensaje();
                msgFinal = msgFinal.concat( msg+"HF");
                System.out.println("Hilo FINAL concateno mensaje: " + msgFinal);
            }



        }



    }


    public int darNivel()
    {

        return this.nivel;
    }

    public int darNumeroDeProceso()
    {

        return this.numeroDeProceso;
    }






}
