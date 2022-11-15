package views;

import players.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.IOException;

/**
 * Class to represent a view default
 * A view has a player (instance of {@link Player}) and a boolean to indicate if
 * the game has started
 */
public class ViewDefault implements View {

    /* The player */
    private Player player;

    /* Indicates if the game has started */
    private AtomicBoolean started;

    /**
     * Constructor
     * 
     * @param name   the name of the player
     * @param socket the socket of the player
     * @throws IOException if an I/O error occurs creating the client
     */
    public ViewDefault(String name, Socket socket) throws IOException {
        player = new PlayerClient(name, socket);
        player.setView(this);
        started = new AtomicBoolean(false);
    }

    /**
     * Asks the user for an integer
     * 
     * @param question the question to ask
     * @return the integer entered by the user
     */
    @Override
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

    /**
     * Asks the user for a string
     * 
     * @param question the question to ask
     * @return the string entered by the user
     */
    @Override
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

    /**
     * Shows the user a message
     * 
     * @param message the message to show
     */
    @Override
    public void showText(String message) {
        if (message != null) {
            System.out.println(message);
        }
    }

    /**
     * Returns the player of the view
     * 
     * @return the player of the view
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * Updates if the game of the player has started
     */
    @Override
    public void startUpdate() {
        started = new AtomicBoolean(true);
    }

    /**
     * Returns if the game of the player that the view is associated with has
     * started
     * 
     * @return if the game has started
     */
    @Override
    public AtomicBoolean getStarted() {
        return started;
    }

}
