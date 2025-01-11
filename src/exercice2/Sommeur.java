package exercice2;

public class Sommeur implements Runnable {
    private int[] tableau;
    private int debut, fin;
    private int somme = 0;

    // Constructeur
    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    // Méthode exécutée par le thread
    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
    }

    // Retourne la somme calculée
    public int getSomme() {
        return somme;
    }
}
