
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class Main {

    private static int numMensajes;

    private static int tamanioBuzonesIntermedios;

    private static int tamanioBuzonesExtremos;



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de mensajes a enviar: ");
        numMensajes = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones intermedios: ");
        tamanioBuzonesIntermedios = sc.nextInt();

        System.out.println("Ingrese el tamaño de los buzones de los extremos: ");
        tamanioBuzonesExtremos = sc.nextInt();

        BuzonExtremo buzonInicial = new BuzonExtremo(tamanioBuzonesExtremos, " ");

        BuzonExtremo buzonFinal = new BuzonExtremo(tamanioBuzonesExtremos, " ");

        Proceso procesoI = new Proceso(0,0, buzonInicial, null, numMensajes);

        Proceso procesoF = new Proceso(4,0,null , buzonFinal, numMensajes);
        procesoI.start();
        procesoF.start();

        //Buzon buzonEntradaNivel2 = new Buzon(3, " ");

        //crea todos los procesos de nivel 1 y 2

        for (int i = 0; i < 3; i++) {

            Buzon buzonEntradaNivel1 = new Buzon(tamanioBuzonesIntermedios, " ");
            Buzon buzonEntradaNivel2 = new Buzon(tamanioBuzonesIntermedios, " ");


            Proceso nivelUno = new Proceso(1,i+1,buzonEntradaNivel1, buzonInicial,0);
            Proceso nivelDos = new Proceso(2,i+1,buzonEntradaNivel2,buzonEntradaNivel1,0 );
            Proceso nivelTres = new Proceso(3,i+1,buzonFinal, buzonEntradaNivel2,0);
            nivelUno.start();
            nivelDos.start();
            nivelTres.start();






        }

    }




}