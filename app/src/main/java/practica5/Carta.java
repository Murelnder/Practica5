package practica5;

/**
 * La clase Carta representa una carta de un mazo estándar.
 * Cada carta tiene un valor numérico, un tipo de figura (faceValue)
 * y un palo (suit).
 * 
 * Ejemplo: As de corazones, 10 de picas, etc.
 * 
 * @author Guillen Aviles Eduardo
 * @version 1.0
 */
public class Carta {
    /* Valor numerico de la carta. */
    private int valor;
    /* La figura de la carta A, J, Q, K. */
    private char faceValue;
    /* El palo de la carta(Hearts,Spades,Clubs,Diamonds). */
    private String suit;

    /**
     * Constructor que inicializa los atributos de la carta.
     * 
     * @param valor     valor numerico de la carta.
     * @param suit      suit palo de la carta.
     * @param faceValue faceValue representación de la figura.
     */
    public Carta(int valor, String suit, char faceValue) {
        this.valor = valor;
        this.suit = suit;
        this.faceValue = faceValue;
    }
    /**
     * Método que modifica la figura de la carta.
     * 
     * @param face
     */
    public void setFace(char face) {
        this.faceValue = face;
    }

    /**
     * Método que modifica el valor de la carta.
     * 
     * @param valor
     */
    public void setValue(int valor) {
        this.valor = valor;
    }

    /**
     * Método que regresa el valor de la carta.
     * 
     * @return
     */
    public int getValue() {
        return valor;
    }

    /**
     * Método que regresa el palo de la carta.
     * 
     * @return
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Método que regresa la figura de la carta si cuenta con una.
     * 
     * @return
     */
    public char getFace() {
        return faceValue;
    }

    /**
     * Método que determina si es una cara valida.
     * 
     * @param value
     * @param cara
     * @return
     */
    public boolean isFace(int value, char cara) {
        boolean faceCarta = false;
        if (value == 10 && cara != 'N' || value == 1) {
            faceCarta = true;
        }
        return faceCarta;
    }

    /**
     * Método toString, regresa informacion sobre el objecto Carta.
     */
    public String toString() {
        String cadena = "[";

        if (getValue() == 1) {
            cadena += getFace() + " of:" + getSuit();

        } else if (getValue() == 10 && getFace() != 'N') {
            cadena += getFace() + " of:" + getSuit();

        } else {
            cadena += getValue() + " of:" + getSuit();
        }
        cadena += "]\n";
        return cadena;
    }

}
