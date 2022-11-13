package views;

import players.*;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;

public class View {

    private PlayerClient player;

    public View(String name, Socket socket, Socket socket2) throws IOException {
        player = new PlayerClient(name, socket, socket2);
        player.setView(this);
    }

    public int askInt(String question) {
        boolean invalid = true;
        int answer = -1;
        String text = "";
        Scanner scanner = new Scanner(System.in);
        while (invalid) {
            System.out.println(question);
            try {
                text = scanner.nextLine();
                answer = Integer.parseInt(text);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida");
            }
        }
        return answer;
    }

    public String askString(String question) {
        boolean invalid = true;
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        while (invalid) {
            System.out.println(question);
            answer = scanner.nextLine();
            if (answer.length() > 0) {
                invalid = false;
            } else {
                System.out.println("Entrada invalida");
            }
        }
        return answer;

    }

    public void showText(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }

    public Player getPlayer() {
        return player;
    }

}
