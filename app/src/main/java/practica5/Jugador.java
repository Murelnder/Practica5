package practica5;

import java.util.ArrayList;

/**
 * La clase Jugador representa a un jugador dentro del juego de cartas.
 * 
 * Cada jugador tiene:
 * - un nombre
 * - una mano de cartas
 * 
 * Esta clase permite recibir cartas, eliminar cartas de la mano
 * y mostrar la información del jugador.
 * 
 * @author Guillen Aviles Eduardo
 * @version 1.0
 */
public class Jugador {
    /** Scanner para leer el nombre del jugador desde teclado. */
    /** Nombre del jugador. */
    String name = "";
    /** Lista de cartas asignadas al jugador. */
    ArrayList<Carta> cartas;

    /**
     * Constructor de la clase Jugador.
     * Solicita al usario ingresar su nombre.
     */
    public Jugador(String name) {
        this.name = name;
    }

    /**
     * Cambia el nombre del jugador.
     * 
     * @param name nuevo nombre del jugador.
     */
    public void changeName(String name) {
        this.name = name;
    }

    public void inicializar(ArrayList<Carta> primeras5Cartas) {
        cartas = primeras5Cartas;
    }

    /**
     * Asina una lista de cartas al jugador.
     * 
     * @param cards lista de cartas que recibira el jugador.
     */
    public void receiveCard(Carta card) {
        cartas.add(card);
    }

    /**
     * Elimina una scarta de la mano del jugador segun su posicion.
     * 
     * @param carta indice de la carta a eliminar.
     */

    /**
     * Regresa el nombre del jugador.
     * 
     * @return nombre del jugador.
     */
    public String displayName() {
        return name;
    }

    /**
     * Método que regresa el objeto Carta, dependiendo de la posición del usuario.
     * 
     * @param pos Esta variable recibe el método que es la posición del ArrayList de
     *            las cartas de la carta.
     * @return Regresa el objeto Carta del ArrayList del jugador.
     */
    public Carta regresarCartaMazo(int pos) {
        Carta cartaRegresada = cartas.get(pos);
        String cadena = "";
        cartas.remove(pos);
        System.out.println("El Jugador:" + name + "\nRegresa la carta:" + cartaRegresada.toString());
        for (Carta c : cartas) {
            cadena += c.toString();
        }
        System.out.println("Mano del jugador:\n" + cadena);
        return cartaRegresada;
    }

    /**
     * Método que regresa el tamaño de la mano del jugador.
     * 
     * @return regresa el tamaño numérico de las cartas del jugador.
     */
    public int getMazoSize() {
        int cantidad = 0;
        cantidad = cartas.size();
        return cantidad;
    }

    /**
     * Devuelve una representacion en texto del jugador
     * y las cartas que tiene en su mano.
     */
    public String toString() {
        String cadena;
        cadena = "Jugador:" + name + "\n" + "Mano:\n";
        for (Carta c : cartas) {
            cadena += c.toString();
        }
        return cadena;
    }

    /**
     * Método que regresa un booleano si encuentra el objeto carta que recibe.
     * 
     * @param card Este objeto es el de referencia que buscara en el ArrayList.
     * @return Este valor regresa dependiendo si el objeto fue encontrado o no.
     */
    public boolean buscarCartaJugador(Carta card) {
        boolean encontrada = false;
        for (Carta carta : cartas) {
            if (carta.toString().equalsIgnoreCase(card.toString())) {
                encontrada = true;
            }
        }
        return encontrada;
    }
}
