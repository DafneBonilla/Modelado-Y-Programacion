package game;

import cards.*;
import player.Player;
import java.util.List;

public class GameRound extends GamePart {
    
    private int numRound;
    private int numTricks;
    private Color triumph;

    public GameRound(List<Player> players, Deck mainDeck, int numRound) {
        super(players, mainDeck);
        this.numRound = numRound;
        this.numTricks = 0;
    }

    public void start() {
        enviarMensajeTodos("La ronda " + numRonda + " va a empezar");
        mazo.shuffle();
        repartirCartas();
        defineTriunfo();
        defineApuestas();
        for (int i = 1; i <= numTrucos; i++) {
            Truco actual = new Truco(jugadores, mazo, triunfo, out, log);
            actual.iniciar();
            log = actual.getLog();
        }
        verPuntuacion();
        enviarMensajeTodos("Las puntaciones se ven asi...\n");
        for (Jugador jugador : jugadores) {
            enviarMensajeTodos("El jugador " + jugador.getNombre() + " tiene " + jugador.getPuntuacion() + " puntos\n");
        }
    }

    private void dealCards() {
        for (int i = 0; i < numRonda; i++) {
            for (Jugador jugador : jugadores) {
                Carta cartita = mazo.sacaCarta(0);
                jugador.recibirCarta(cartita);
            }
        }
    }

    private void defineTriumph() {
        if (!mazo.esVacio()) {
            Carta cartita = mazo.sacaCarta(0);
            Color triunfi = cartita.getColor();
            switch (triunfi.getMerito()) {
                case 5:
                    if (cartita.getValor().getNumero() == 0) {
                        enviarMensajeTodos("El palo de triunfo es " + triunfo);
                        mazo.agregaCarta(cartita);
                        return;
                    }
                    pedirTriunfo();
                    break;
                default:
                    triunfo = triunfi;
                    break;
            }
            mazo.agregaCarta(cartita);
            enviarMensajeTodos("El palo de triunfo es " + triunfo);
        }
    }

    private void askTriumph() {
        Jugador elegir = jugadores.buscarIndice(0);
        enviarMensajeJugador(elegir, "Jugador " + elegir.getNombre() + " elige el palo de triunfo");
        int i = validarTriunfo(elegir);
        triunfo = new Color(i);
    }

    private int validateTriumph(Player player) {
        enviarMensajeJugador(jugador,
                "Escribe el numero del palo de triunfo \n 1 para \u001B[91mrojo\u001B[0m \n 2 para \u001B[94mazul\u001B[0m \n 3 para \u001B[93mamarillo\u001B[0m \n 4 para \u001B[92mverde\u001B[0m (presiona \"h\" para ver todo el historial del juego)");
        String respuesta = jugador.leerJugador();
        try {
            int i = Integer.parseInt(respuesta);
            if (i < 1 || i > 4) {
                throw new NumberFormatException();
            }
            return i;
        } catch (NumberFormatException nfe) {
            if (respuesta.equals("h")) {
                enviarMensajeJugador(jugador, "Historial:");
                enviarMensajeJugador(jugador, log);
                return validarTriunfo(jugador);
            }
            enviarMensajeJugador(jugador, "No es un numero valido");
            return validarTriunfo(jugador);
        }
    }

    private void setBets() {
        for (Jugador jugador : jugadores) {
            enviarMensajeJugador(jugador, "Jugador " + jugador.getNombre() + " es tu turno de ver tus cartas.");
            enviarMensajeJugador(jugador, "Tu mano actual es\n" + jugador.verBarajaOrdenada());
            enviarMensajeJugador(jugador, "\nEl palo de triunfo es " + triunfo + "\n");
            int ap = pedirApuesta(jugador);
            jugador.setApuesta(ap);
            enviarMensajeTodos("El jugador " + jugador.getNombre() + " ha apostado " + ap);
        }
    }

    private int askBet(Player player) {
        enviarMensajeJugador(jugador, "Define tu apuesta (un numero entre 0 y " + numRonda + ") (presiona \"h\" para ver todo el historial del juego)");
        String cadenita = jugador.leerJugador();
        try {
            int apuesta = Integer.parseInt(cadenita);
            if (apuesta < 0 || apuesta > numRonda) {
                enviarMensajeJugador(jugador, "Apuesta invalida");
                return pedirApuesta(jugador);
            }
            return apuesta;
        } catch (NumberFormatException nfe) {
            if (cadenita.equals("h")){
                enviarMensajeJugador(jugador, "Historial:");
                enviarMensajeJugador(jugador, log);
                enviarMensajeJugador(jugador, "Jugador " + jugador.getNombre() + " es tu turno de ver tus cartas.");
                enviarMensajeJugador(jugador, "Tu mano actual es\n" + jugador.verBarajaOrdenada());
                enviarMensajeJugador(jugador, "\nEl palo de triunfo es " + triunfo + "\n");
                return pedirApuesta(jugador);
            }
            enviarMensajeJugador(jugador, "No ingresaste un numero");
            return pedirApuesta(jugador);
        }
    }

    private void score() {
        for (Jugador jugador : jugadores) {
            if (jugador.getApuesta() == jugador.getGanados()) {
                int punt = jugador.getPuntuacion();
                punt += 20 + 10 * jugador.getGanados();
                jugador.setPuntuacion(punt);
            } else {
                int gan = jugador.getGanados();
                int ap = jugador.getApuesta();
                if (gan > ap) {
                    int diferencia = gan - ap;
                    int punt = jugador.getPuntuacion();
                    punt -= diferencia * 10;
                    jugador.setPuntuacion(punt);
                } else {
                    int diferencia = ap - gan;
                    int punt = jugador.getPuntuacion();
                    punt -= diferencia * 10;
                    jugador.setPuntuacion(punt);
                }
            }
            jugador.setApuesta(0);
            jugador.setGanados(0);
        }
    }

}
