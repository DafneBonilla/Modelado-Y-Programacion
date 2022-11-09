package game;

import player.Player;
import java.util.List;

import cards.Deck;
import cards.CardHolder;

public class GameMain extends GamePart {
    
    private int numRounds;
    private boolean continues;
    private long seed;

    public GameMain(int numPlayers, List<Player> players, CardHolder mainDeck) {
        super(players, mainDeck);
        this.numRounds = numPlayers;
        this.continues = true;
        this.seed = System.currentTimeMillis();
    }
    
    @Override
    public void start() {
        enviarMensajeTodos("El truco va a empezar");
        for (Player player : players) {
            enviarMensajeJugador(jugador, "Jugador " + jugador.getNombre() + " es tu turno de jugar una carta");
            enviarMensajeJugador(jugador, "El palo leader es " + leader);
            enviarMensajeJugador(jugador, "El palo de triunfo es " + triunfo);
            enviarMensajeJugador(jugador, "Tu mano actual es\n" + jugador.verBarajaOrdenada());
            int indice = validarCarta(jugador);
            Carta cartita = recibeCarta(jugador, indice);
            enviarMensajeTodos("El jugador " + jugador.getNombre() + " jugo la carta " + cartita);
            defineLider(cartita);
            jugadas.agregaFinal(cartita);
        }
        int ganador = cartaGanadora();
        Player player = players.buscarIndice(winner);
        int ganados = jug.getGanados();
        jug.setGanados(ganados + 1);
        enviarMensajeTodos("El jugador " + jug.getNombre() + " gana el truco");
        for (Carta carta : jugadas) {
            mazo.agregaCarta(carta);
        }
        actualizarLista(ganador);
    }

    private void end() {
        resultados();
        out.close();
    }

    private void sendTextDC(String text) {
        System.out.println(mensaje + "\n");
        out.write(mensaje);
        out.newLine();
        for (Jugador jugador : jugadores) {
            try {
                enviarMensajeJugador(jugador, mensaje);
            } catch (JugadorInactivo ji) {
                continue;
            }
        }
    }

    private void results() {
        String resultados = "Ahora se anunciara al ganador del juego...\n\n";
        resultados += ganador();
        enviarMensajeTodos(resultados);  
    }

    private void resultsDC() {
        String resultados = "Un jugador se pudo haber desconectado, terminando el juego...\n";
        resultados += "Ahora se anunciara al ganador del juego...\n\n";
        resultados += ganador();
        enviarMensajeTodosDesconecta(resultados);
        System.exit(0);
    }

    private String winner(List<Player> players) {
        return superior(jugadores);
    }

    private int higher(List<Player> players) {
        String winner = "Hubo un empate entre los Jugadores ";
        int posicion = mayor(lista);
        Jugador ganadorsito = lista.buscarIndice(posicion);
        int punt = ganadorsito.getPuntuacion();
        Lista<Jugador> resto = lista.clone();
        resto.delete2(posicion);
        boolean empate = false;
        for (Jugador jug : resto) {
            if (jug.getPuntuacion() == punt) {
                empate = true;
                winner += jug.getNombre() + ", ";
            }
        }
        if (empate) {
            winner = winner.substring(0, winner.length() - 2);
            winner += " y " + ganadorsito.getNombre();
            return winner + " todos con " + punt + " puntos\n";
        }
        return "El ganador es el Jugador " + ganadorsito.getNombre() + " con " + ganadorsito.getPuntuacion()
                + " puntos\n";
    }

    private void carryOn() {
        Lista<String> si = new Lista<>();
        Lista<String> no = new Lista<>();
        for (Jugador jugador : jugadores) {
            pedirRespuesta(jugador, si, no);
        }
        if (si.size() < no.size()) {
            sigue = false;
            return;
        } else if (si.size() == no.size()) {
            for (Jugador jugador : jugadores) {
                enviarMensajeJugador(jugador, "Hubo un empate, se realizara una nueva votacion");
            }
            seguir();
            return;
        }
    }

}
