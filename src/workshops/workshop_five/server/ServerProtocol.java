package workshops.workshop_five.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerProtocol {
    public static void process(BufferedReader pIn, PrintWriter pOut) throws IOException {
        String inputLine;
        String outputLine;
        //reads the line to be read
        inputLine = pIn.readLine();
        System.out.println("String to process: "+inputLine);

        //processes the exit message, you could do a bunch of stuff to it beforehand tho.
        outputLine = inputLine;

        pOut.println(outputLine);
        System.out.println("processed line: "+outputLine);
    }
}
