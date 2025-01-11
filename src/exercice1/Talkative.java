package exercice1;

public class Talkative implements Runnable {
    private int value;

    // Constructeur qui initialise l'attribut value
    public Talkative(int value) {
        this.value = value;
    }
    // Méthode run qui affiche 100 fois la valeur de l'attribut value

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Value: " + value);
        }
    }
}
