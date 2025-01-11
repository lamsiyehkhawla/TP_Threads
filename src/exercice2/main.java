package exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {


public static void main(String[] args) throws ExecutionException, InterruptedException {
    // Initialisation du tableau d'entiers
    int[] tableau = new int[1000];
    for (int i = 0; i < tableau.length; i++) {
        tableau[i] = i + 1; // Valeurs de 1 à 1000
    }

    // Définition du nombre de threads dans le pool
    int nombreThreads = 4;
    ExecutorService pool = Executors.newFixedThreadPool(nombreThreads);

    // Création des plages et des tâches
    int taillePlage = tableau.length / nombreThreads;
    List<Future<Sommeur>> futures = new ArrayList<>();
    List<Sommeur> sommeurs = new ArrayList<>();

    for (int i = 0; i < nombreThreads; i++) {
        int debut = i * taillePlage;
        int fin = (i == nombreThreads - 1) ? tableau.length : debut + taillePlage;

        Sommeur sommeur = new Sommeur(tableau, debut, fin);
        sommeurs.add(sommeur);
        futures.add(pool.submit(sommeur, sommeur));
    }

    // Attente des résultats
    int sommeTotale = 0;
    for (Future<Sommeur> future : futures) {
        Sommeur sommeur = future.get(); // Attente du résultat
        sommeTotale += sommeur.getSomme();
    }

    // Affichage du résultat
    System.out.println("Somme totale du tableau : " + sommeTotale);

    // Fermeture du pool
    pool.shutdown();
}
}

