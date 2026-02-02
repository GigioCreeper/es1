/**
 * 
 */
package it.unicam.cs.asdl2526.es1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Template: Luca Tesei, Implementation: Collettiva da Esercitazione a
 *         Casa
 *
 */
class EquazioneSecondoGradoModificabileConRisolutoreTest {
    /*
     * Costante piccola per il confronto di due numeri double
     */
    static final double EPSILON = 1.0E-15;

    @Test
    final void testEquazioneSecondoGradoModificabileConRisolutore() {
        // controllo che il valore 0 su a lanci l'eccezione
        assertThrows(IllegalArgumentException.class,
                () -> new EquazioneSecondoGradoModificabileConRisolutore(0, 1,
                        1));
        // devo controllare che comunque nel caso normale il costruttore
        // funziona
        EquazioneSecondoGradoModificabileConRisolutore eq = new EquazioneSecondoGradoModificabileConRisolutore(
                1, 1, 1);
        // Controllo che all'inizio l'equazione non sia risolta
        assertFalse(eq.isSolved());
    }

    @Test
    final void testGetA() {
        double x = 10;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(
                x, 1, 1);
        // controllo che il valore restituito sia quello che ho messo
        // all'interno
        // dell'oggetto
        assertTrue(x == e1.getA());
        // in generale si dovrebbe usare assertTrue(Math.abs(x -
        // e1.getA())<EPSILON) ma in
        // questo caso il valore che testiamo non ha subito manipolazioni quindi
        // la sua rappresentazione sarà la stessa di quella inserita nel
        // costruttore senza errori di approssimazione

    }

    @Test
    final void testSetA() {
        // TODO implementare *
        double x = 10;
        double y = 20;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(x, 2 ,3);
        e1.setA(y);
        assertEquals(y, e1.getA());
        assertThrows(IllegalArgumentException.class, () -> {
            EquazioneSecondoGradoModificabileConRisolutore e2 = new EquazioneSecondoGradoModificabileConRisolutore(2, 3, 4);
            e2.setA(0);
        });
    }

    @Test
    final void testGetB() {
        // TODO implementare *
        double x = 10;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(
                2, x, 1);
        assertEquals(x, e1.getB());
    }

    @Test
    final void testSetB() {
        // TODO implementare *
        double x = 10;
        double y = 20;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(2, x ,3);
        e1.setB(y);
        assertEquals(y, e1.getB());
    }

    @Test
    final void testGetC() {
        // TODO implementare *
        double x = 10;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(
                2, 2, x);
        assertEquals(x, e1.getC());
    }

    @Test
    final void testSetC() {
        // TODO implementare *
        double x = 10;
        double y = 20;
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(2, 2 ,x);
        e1.setC(y);
        assertEquals(y, e1.getC());
    }

    @Test
    final void testIsSolved() {
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(2, 2,2);
        assertFalse(e1.isSolved());
    }

    @Test
    final void testSolve() {
        EquazioneSecondoGradoModificabileConRisolutore e3 = new EquazioneSecondoGradoModificabileConRisolutore(
                1, 1, 3);
        // controllo semplicemente che la chiamata a solve() non generi errori
        e3.solve();
        // i test con i valori delle soluzioni vanno fatti nel test del metodo
        // getSolution()
    }

    @Test
    final void testGetSolution() {
        EquazioneSecondoGradoModificabileConRisolutore e1 = new EquazioneSecondoGradoModificabileConRisolutore(2, 3,1);
        assertThrows(IllegalStateException.class, () -> {e1.getSolution();});
        e1.solve();
        assertFalse(e1.getSolution().isOneSolution());
        assertFalse(e1.getSolution().isEmptySolution());

        assertTrue(e1.getSolution().getS1() == 0.5 || e1.getSolution().getS2() == -1);
        assertTrue(e1.getSolution().getS2() == 0.5 || e1.getSolution().getS2() == -1);
    }
}
