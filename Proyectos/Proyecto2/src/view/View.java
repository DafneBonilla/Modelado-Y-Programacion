package view;

import player.*;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;

public class View {

    private PlayerClient player;

    public View(String name, Socket socket) throws IOException {
        player = new PlayerClient(name, socket);
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
                // el while puede causar problemas
                while (scanner.hasNextLine()) {
                    text = scanner.nextLine();
                }
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
            // el while puede causar problemas
            while (scanner.hasNextLine()) {
                answer = scanner.nextLine();
            }
            if (answer.length() > 0) {
                invalid = false;
            } else {
                System.out.println("Entrada invalida");
            }
        }
        return answer;

    }

    public void showText(String message) {
        System.out.println(message);
    }

    public Player getPlayer() {
        return player;
    }

}
