package practica5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class JugadorTest {
    Carta carta;
    Mazo mazo;
    Jugador jugador = new Jugador("Eduardo");
    ArrayList<Carta> manoJugador = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        mazo = new Mazo();
        carta = new Carta(1, "heart", 'A');
    }

    @Test
    void testBuscarCartaJugador() {
        Carta cartaInicial = new Carta(1, "heart", 'A');
        manoJugador = mazo.jugador5Cartas();
        String cadena = manoJugador.toString();
        assertTrue(cadena.contains(cartaInicial.toString()));
    }

    @Test
    void testChangeName() {
        String newName = "Jose";
        assertEquals("Eduardo", jugador.displayName());
        jugador.changeName(newName);
        assertEquals(newName, jugador.displayName());
    }

    @Test
    void testDisplayName() {
        assertEquals("Eduardo", jugador.displayName());
    }

    @Test
    void testGetMazoSize() {
        jugador.inicializar(mazo.jugador5Cartas());
        assertEquals(5, jugador.getMazoSize());
    }

    @Test
    void testInicializar() {
        jugador.inicializar(mazo.jugador5Cartas());
        String cadena = jugador.toString();
        assertTrue(cadena.contains(carta.toString()));
    }

    @Test
    void testReceiveCard() {
        jugador.inicializar(mazo.jugador5Cartas());
        jugador.receiveCard(mazo.tomarCartaDelMazo());
        assertEquals(6, jugador.getMazoSize());
    }

    @Test
    void testRegresarCartaMazo() {
        jugador.inicializar(mazo.jugador5Cartas());
        jugador.regresarCartaMazo((0));
        String cadena = jugador.toString();
        assertFalse(cadena.contains(carta.toString()));
        assertEquals(4, jugador.getMazoSize());
    }

    @Test
    void testToString() {
        Carta carta2 = new Carta(2, "heart", 'N');
        Carta carta3 = new Carta(3, "heart", 'N');
        Carta carta4 = new Carta(4, "heart", 'N');
        Carta carta5 = new Carta(5, "heart", 'N');
        jugador.inicializar(mazo.jugador5Cartas());
        String cadena = jugador.toString();
        assertTrue(cadena.contains(carta.toString()));
        assertTrue(cadena.contains(carta2.toString()));
        assertTrue(cadena.contains(carta3.toString()));
        assertTrue(cadena.contains(carta4.toString()));
        assertTrue(cadena.contains(carta5.toString()));
    }
}
