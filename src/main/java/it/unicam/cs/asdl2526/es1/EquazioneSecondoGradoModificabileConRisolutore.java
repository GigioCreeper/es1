/**
 * 
 */
package it.unicam.cs.asdl2526.es1;

/**
 * Un oggetto di questa classe permette di rappresentare una equazione di
 * secondo grado e di trovarne le soluzioni reali. I valori dei parametri
 * dell'equazione possono cambiare nel tempo. All'inizio e ogni volta che viene
 * cambiato un parametro la soluzione dell'equazione non esiste e deve essere
 * calcolata con il metodo <code>solve()</code>. E' possibile sapere se al
 * momento la soluzione dell'equazione esiste con il metodo
 * <code>isSolved()</code>. Qualora la soluzione corrente non esista e si tenti
 * di ottenerla verrà lanciata una eccezione.
 * 
 * @author Template: Luca Tesei, Implementation: Collettiva da Esercitazione a
 *         Casa
 *
 */
public class EquazioneSecondoGradoModificabileConRisolutore {
    /*
     * Costante piccola per il confronto di due numeri double
     */
    private static final double EPSILON = 1.0E-15;

    private double a;

    private double b;

    private double c;

    private boolean solved;

    private SoluzioneEquazioneSecondoGrado lastSolution;

    /**
     * Costruisce una equazione di secondo grado modificabile. All'inizio
     * l'equazione non è risolta.
     * 
     * 
     * @param a
     *              coefficiente del termine x^2, deve essere diverso da zero.
     * @param b
     *              coefficiente del termine x
     * @param c
     *              termine noto
     * @throws IllegalArgumentException
     *                                      se il parametro <code>a</code> è
     *                                      zero
     * 
     */
    public EquazioneSecondoGradoModificabileConRisolutore(double a, double b,
            double c) {
                if(a == 0){throw new IllegalArgumentException("a cannot be zero");}
                this.a = a;
                this.b = b;
                this.c = c;
                this.solved = false;
                this.lastSolution = null;
        // TODO implementare *
    }

    /**
     * @return il valore corrente del parametro a
     */
    public double getA() {
        return a;
    }

    /**
     * Cambia il parametro a di questa equazione. Dopo questa operazione
     * l'equazione andrà risolta di nuovo.
     * 
     * @param a
     *              il nuovo valore del parametro a
     * @throws IllegalArgumentException
     *                                      se il nuovo valore è zero
     */
    public void setA(double a) {
        // TODO implementare *
        if (a == 0){throw new IllegalArgumentException("A cannot be zero");}
        this.a = a;
        solved = false;
    }

    /**
     * @return il valore corrente del parametro b
     */
    public double getB() {
        return b;
    }

    /**
     * Cambia il parametro b di questa equazione. Dopo questa operazione
     * l'equazione andrà risolta di nuovo.
     * 
     * @param b
     *              il nuovo valore del parametro b
     */
    public void setB(double b) {
        // TODO implementare *
        this.b = b;
        solved = false;
    }

    /**
     * @return il valore corrente del parametro c
     */
    public double getC() {
        return c;
    }

    /**
     * Cambia il parametro c di questa equazione. Dopo questa operazione
     * l'equazione andrà risolta di nuovo.
     * 
     * @param c
     *              il nuovo valore del parametro c
     */
    public void setC(double c) {
        // TODO implementare *
        this.c = c;
        solved = false;
    }

    /**
     * Determina se l'equazione, nel suo stato corrente, è già stata risolta.
     * 
     * @return true se l'equazione è risolta, false altrimenti
     */
    public boolean isSolved() {
        return solved;
    }

    /**
     * Determina se due double sono uguali con tolleranza EPSILON
     * @param a primo double
     * @param b secondo double
     * @return true se sono uguali, false altrimenti
     */
    public boolean equalsDouble(double a, double b){
        return Math.abs(a - b) <= EPSILON;
    }

    /**
     * Risolve l'equazione risultante dai parametri a, b e c correnti. Se
     * l'equazione era già stata risolta con i parametri correnti non viene
     * risolta di nuovo.
     */
    public void solve() {
        // TODO implementare *
        if (!isSolved()) {
            double delta = (b*b) - (4 * a * c);
            if (delta < -EPSILON) {
                lastSolution = new SoluzioneEquazioneSecondoGrado(
                        new EquazioneSecondoGrado(a, b, c));
            } else if (Math.abs(delta) <= EPSILON) {
                double sol = -b / (2 * a);
                lastSolution = new SoluzioneEquazioneSecondoGrado(
                        new EquazioneSecondoGrado(a, b, c),
                        sol);
            } else {
                double sqrtDelta = Math.sqrt(delta);
                double s1 = (-b + sqrtDelta) / (2 * a);
                double s2 = (-b - sqrtDelta) / (2 * a);

                if (equalsDouble(s1, 0.0)) s1 = 0.0;
                if (equalsDouble(s2, 0.0)) s2 = 0.0;


                lastSolution = new SoluzioneEquazioneSecondoGrado(
                        new EquazioneSecondoGrado(a, b, c),
                        s1, s2);
            }
        }
        solved = true;
    }

    /**
     * Restituisce la soluzione dell'equazione risultante dai parametri
     * correnti. L'equazione con i parametri correnti deve essere stata
     * precedentemente risolta.
     * 
     * @return la soluzione
     * @throws IllegalStateException
     *                                   se l'equazione risulta non risolta,
     *                                   all'inizio o dopo il cambiamento di
     *                                   almeno uno dei parametri
     */
    public SoluzioneEquazioneSecondoGrado getSolution() {
        // TODO implementare *
        if(!isSolved()) {throw new IllegalStateException("The solution is not solved");}
        else return lastSolution;
    }

}
