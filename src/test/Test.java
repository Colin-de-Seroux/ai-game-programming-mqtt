import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                System.err.println("test");
                System.err.flush();
                System.out.println(System.nanoTime());
                System.out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
