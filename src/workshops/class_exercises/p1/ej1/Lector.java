package workshops.class_exercises.p1.ej1;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class Lector extends Reader {

    public int read(@NotNull CharBuffer target) throws IOException {
        target.get();
        //añadir lógica dependiendo del uso a dársele
        return 0;
    }

    @Override
    public int read(@NotNull char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {

    }
}
