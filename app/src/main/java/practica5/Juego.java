package practica5;

import java.util.Random;

/**
 * La clase Juego contiene el método principal del programa.
 * 
 * Aquí se controla la ejecución del juego de cartas:
 * - Se crea el mazo
 * - Se baraja el mazo
 * - Se solicita el número de jugadores
 * - Se reparten cartas a los jugadores
 * - Se muestran las manos de los jugadores
 * - Se muestra el estado final del mazo
 * 
 * Esta clase sirve como punto de inicio del programa.
 * 
 * @author Guillen Aviles Eduardo
 * @version 1.0
 */
public class Juego {
    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * Este método crea el mazo, muestra las primeras 5 cartas, luego las baraja y
     * muestra otravez las primeras 5 cartas.
     * Crea 3 jugadores.
     * Reparte cartas y muestra la información de los jugadores
     * y del mazo.
     * 
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        /** Nuevo mazo. */
        Mazo deckHand = new Mazo();
        /** declaracion de jugadores. */
        Jugador player1 = new Jugador("Eduardo");
        Jugador player2 = new Jugador("Jose");
        Jugador player3 = new Jugador("Carlos");
        Mazo mazo = new Mazo();
        Carta cartaAletoria;
        mazo.shuffleDeck();
        /** Se baraja el mazo */
        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO SIN BARAJAR:\n" + deckHand.mostrar5Cartas());
        /** Mostrar las cartas de los jugadores */
        deckHand.shuffleDeck();
        System.out.println("MOSTRANDO PRIMERAS 5 CARTAS DEL MAZO DESPUÉS DE BARAJAR:\n" + deckHand.mostrar5Cartas());
        System.out.println("CREANDO 3 JUGADORES:\n" + player1.displayName() + "\n" + player2.displayName() + "\n"
                + player3.displayName() + "\n");
        player1.inicializar(deckHand.jugador5Cartas());
        player2.inicializar(deckHand.jugador5Cartas());
        player3.inicializar(deckHand.jugador5Cartas());
        System.out.println("REPARTIENDO 5 CARTAS A CADA JUGADOR:\n" + player1.toString() + "\n" + player2.toString()
                + "\n" + player3.toString());
        System.out.println("CARTAS RESTANTES EN EL MAZO (DESPUÉS DE REPARTIR):\nQuedan " + deckHand.getDeckCount()
                + "cartas en el mazo");
        System.out.println("Primeras 5 cartas del mazo:\n" + deckHand.mostrar5Cartas());
        deckHand.regresarCartaMazo(player1.regresarCartaMazo(3));
        System.out.println("\nMAZO DESPUÉS DE RECIBIR CARTAS DEVUELTAS:\n" + deckHand.getDeckCount());
        cartaAletoria = mazo.tomarCartaDelMazo();
        System.out.println("\nBUSCANDO CARTA:" + cartaAletoria.toString() + "\n" + "La carta" + cartaAletoria.toString()
                + "está en posesión de:");
        if (deckHand.buscarCarta(cartaAletoria)) {
            System.out.println("El mazo\n");
        } else if (player1.buscarCartaJugador(cartaAletoria)) {
            System.out.println(player1.displayName() + "\n");
        } else if (player1.buscarCartaJugador(cartaAletoria)) {
            System.out.println(player2.displayName() + "\n");
        } else {
            System.out.println(player3.displayName() + "\n");
        }
        System.out.println(deckHand.toString());
    }
}