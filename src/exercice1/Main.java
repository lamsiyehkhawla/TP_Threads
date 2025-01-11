package exercice1;

public class Main {

    public static void main(String[] args) {
        // Création de 10 instances de Thread, chacune prenant un objet Talkative

        for (int i = 1; i <= 10; i++) {
            Talkative talkative = new Talkative(i);
            Thread thread = new Thread(talkative);
            thread.start(); // Lancement de la méthode start
        }
    }

}