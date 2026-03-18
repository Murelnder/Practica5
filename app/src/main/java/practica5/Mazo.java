package practica5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * La clase Mazo representa un mazo de cartas estándar de 52 cartas.
 * 
 * Esta clase permite:
 * - Crear el mazo de cartas.
 * - Barajar las cartas.
 * - Reiniciar el mazo.
 * - Repartir cartas a los jugadores.
 * - Manejar cartas descartadas.
 * 
 * También mantiene listas de cartas para hasta 5 jugadores.
 * 
 * @author Guillen Aviles Eduardo
 * @version 1.0
 * 
 */
public class Mazo {
    /** Lista principal que contiene todas las cartas del mazo. */
    ArrayList<Carta> deck = new ArrayList<>();
    /** Cartas del jugador 1. */
    ArrayList<Carta> manoJugador;
    /** Representación de una carta tipo A */
    char ace;
    /** Valor numérico auxiliar */
    int value;

    /**
     * Constructor de la clase Mazo.
     * Inicializa el mazo con 52 cartas (4 palos y 13 valores).
     */
    public Mazo() {
        String[] suits = { "heart", "spade", "clubs", "diamond" };
        for (int j = 0; j <= 3; j++) {
            for (int i = 0; i <= 12; i++) {
                deck.add(new Carta(i + 1, suits[j], 'N'));

                if (i == 0) {
                    deck.get(deck.size() - 1).setFace('A');
                }
                if (i == 10) {
                    deck.get(deck.size() - 1).setFace('J');
                    deck.get(deck.size() - 1).setValue(10);
                }
                if (i == 11) {
                    deck.get(deck.size() - 1).setFace('Q');
                    deck.get(deck.size() - 1).setValue(10);
                }
                if (i == 12) {
                    deck.get(deck.size() - 1).setFace('K');
                    deck.get(deck.size() - 1).setValue(10);
                }
                deck.get(deck.size() - 1).setFace(deck.get(deck.size() - 1).getFace());
            }
        }
    }

    /**
     * Baraja las cartas del mazo de forma aleatoria.
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    /**
     * Este método extrae las primeras 5 cartas del mazo actual, las agrega a la
     * mano del jugador y las elimina del mazo para evitar duplicados.
     * 
     * @return Un ArrayList de objetos Carta que representa la mano del jugador.
     *         También quita esas 5 cartas del mazo.
     */
    public ArrayList<Carta> jugador5Cartas() {
        manoJugador = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            manoJugador.add(deck.get(0));
            deck.remove(0);
        }
        return manoJugador;
    }

    /**
     * Método que regresa el numero de cartas restantes en el mazo.
     * 
     * @return numero de cartas en el mazo.
     */
    public int getDeckCount() {
        return deck.size();
    }

    /**
     * Método toma una carta del mazo y regresa una carta.
     * 
     * @return objecto carta.
     */
    public Carta tomarCartaDelMazo() {
        Carta carta = deck.get(0);
        return carta;
    }

    /**
     * Método que recibe un objecto carta y la agrega al ArrayList deck
     * 
     * @param carta recibe el objecto Carta.
     */
    public void regresarCartaMazo(Carta carta) {
        deck.add(carta);
    }

    /**
     * Obtiene las cartas de un jugador especifico.
     * 
     * @param player numero del jugador.
     * @return lista de cartas del jugador.
     */
    public ArrayList<Carta> getPlayerDeck() {
        return manoJugador;
    }

    /**
     * Regresa el contenido del mazo.
     */
    public String toString() {
        String cadena = "";
        for (Carta c : deck) {
            cadena += c.toString();
        }
        return cadena;
    }

    /**
     * Método que busca el objeto recibido en el ArrayList.
     * 
     * @param card Objecto Carta
     * @return boolean variable encontrada.
     */
    public boolean buscarCarta(Carta card) {
        boolean encontrada = false;
        for (Carta carta : deck) {
            if (carta.toString().equalsIgnoreCase(card.toString()))
                ;
            encontrada = true;
        }
        return encontrada;
    }

    /**
     * Método que muestra las primeras 5 cartas del mazo.
     * 
     * @return regresa una cadena con la información de los objetos.
     */
    public String mostrar5Cartas() {
        String cadena = "";
        Carta carta;
        for (int i = 0; i < 5; i++) {
            carta = deck.get(i);
            cadena += carta.toString();
        }
        return cadena;
    }
}
