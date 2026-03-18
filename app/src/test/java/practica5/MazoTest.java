package practica5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class MazoTest {
    Mazo mazo;

    @BeforeEach
    public void setUp() {
        mazo = new Mazo();
    }

    @Test
    void testBuscarCarta() {
        Carta carta = new Carta(1, "spade", 'A');
        assertTrue(mazo.buscarCarta(carta));
    }

    @Test
    void testGetDeckCount() {
        assertEquals(52, mazo.getDeckCount());
    }

    @Test
    void testGetPlayerDeck() {
        ArrayList<Carta> manoJugador = mazo.jugador5Cartas();
        manoJugador = mazo.getPlayerDeck();
        assertEquals(5, manoJugador.size());
    }

    @Test
    void testJugador5Cartas() {
        ArrayList<Carta> jugador = mazo.jugador5Cartas();
        assertEquals(5, jugador.size());
    }

    @Test
    void testMostrar5Cartas() {
        String cadena = "";
        cadena = "[A of:heart]\n[2 of:heart]\n[3 of:heart]\n[4 of:heart]\n[5 of:heart]" + "\n";
        assertTrue(cadena.equalsIgnoreCase(mazo.mostrar5Cartas()));
    }

    @Test
    void testRegresarCartaMazo() {
        Carta randomCarta = new Carta(1, "heart", 'A');
        assertEquals(52, mazo.getDeckCount());
        mazo.regresarCartaMazo(randomCarta);
        assertEquals(53, mazo.getDeckCount());
    }

    @Test
    void testShuffleDeck() {
        Mazo mazoTest = new Mazo();
        assertEquals(mazo.toString(), mazoTest.toString());
        mazoTest.shuffleDeck();
        assertNotEquals(mazo.toString(), mazoTest.toString());
    }

    @Test
    void testToString() {
        String carta = "[A of:heart]";
        String cadena = mazo.toString();
        assertTrue(cadena.contains(carta));
    }

    @Test
    void testTomarCartaDelMazo() {
        Carta carta = mazo.tomarCartaDelMazo();
        String cartaDefinida = "[A of:heart]\n";
        assertEquals(cartaDefinida, carta.toString());
    }
}