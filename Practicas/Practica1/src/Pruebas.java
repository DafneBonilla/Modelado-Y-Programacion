import java.util.concurrent.ThreadLocalRandom;

public class Pruebas {

    public static void main(String[] args) {

        int random = ThreadLocalRandom.current().nextInt(1, 3 + 1);
        System.out.println(random);

    }
}

// Desde Practica 1
// javac -d classes src/*.java
// java -cp classes Pruebas
