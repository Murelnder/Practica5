package practica5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class CartaTest {
    Carta carta;

    @BeforeEach
    public void setUP() {
        carta = new Carta(1, "spade", 'A');
    }

    @Test
    void testGetFace() {
        assertEquals('A', carta.getFace());
    }

    @Test
    void testGetSuit() {
        String suit = "spade";
        assertEquals(suit, carta.getSuit());
    }

    @Test
    void testGetValue() {
        assertEquals(1, carta.getValue());
    }

    @Test
    void testIsFace() {
        Carta carta2 = new Carta(5, "diamond", 'N');
        assertTrue(carta.isFace(carta.getValue(), carta.getFace()));
        assertFalse(carta2.isFace(carta2.getValue(), carta2.getFace()));
    }

    @Test
    void testSetFace() {
        carta.setFace('K');
        String cadena = "[K of:spade]\n";
        assertEquals(cadena, carta.toString());

    }

    @Test
    void testSetValue() {
        carta.setValue(5);
        String cadena = "[5 of:spade]\n";
        assertEquals(cadena, carta.toString());
    }

    @Test
    void testToString() {
        String cadena = "[A of:spade]\n";
        assertEquals(cadena, carta.toString());
    }
}
