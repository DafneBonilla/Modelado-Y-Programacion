package player;

import cards.*;
import view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PlayerClient implements Player {
    
    private String name;

    private CardHolderIterator deck;

    private int score;

    private int bet;

    private int wins;

    private Socket socket;

    private View view;

    private OutputStream out;
    
    private InputStream in;

    public PlayerClient(String name, Socket socket) throws IOException {
        this.name = name;
        this.socket = socket;
        this.deck = null;
        this.score = 0;
        this.bet = 0;
        this.wins = 0;
        this.socket = socket;
        this.view = null;
        this.out = socket.getOutputStream();
        this.in = socket.getInputStream();
    }
    
}
