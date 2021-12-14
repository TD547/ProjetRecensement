package fr.epsi.b3.recensement;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MenuService extends Recensement{

    public MenuService() throws FileNotFoundException {
        super();
    }

    public void exec(){
        Scanner sc=new Scanner(System.in);
        int rep = 0;
        do
        {
            System.out.println("\n ----------------------------Recensement---------------------------");
            System.out.println("|           1. Population d’une ville donnée                       |");
            System.out.println("|           2. Population d’un département donné                   |");
            System.out.println("|           3. Population d’une région donnée                      |");
            System.out.println("|           4. Les 10  départements les plus peuplées              |");
            System.out.println("|           5. Les 10 régions les plus peuplés                     |");
            System.out.println("|           6. Les 10 villes les plus peuplées d’un département    |");
            System.out.println("|           7. Les 10 villes les plus peuplées d’une région        |");
            System.out.println("|           8. Les 10 villes les plus peuplées de France           |");
            System.out.println("|           9. Quitter                                             |");
            System.out.println(" ------------------------------------------------------------------");

            System.out.print("\nRentrez votre choix : ");
            try {
            rep=Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez respecter le menu! ");
                System.out.print("\nRentrez votre choix : ");
                try {
                rep=Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e2) {
                    System.out.println("Vous ne respectez pas le format requis !");
                    System.out.println("Fermeture de l'application");
                    System.exit(1);
                }
            }
            String repStr = "";
            int repInt = 0;
            String[] tab;
            switch(rep){
                case 1:
                    System.out.print("Entrez le nom de la ville souhaité : ");
                    repStr= sc.nextLine();
                    String s1 = repStr.substring(0, 1).toUpperCase();
                    repStr = s1 + repStr.substring(1);
                    repInt = this.getPopuVille(repStr);
                    if (repInt == -1){
                        System.out.println("Le ville " + repStr + " n'existe pas.");
                    } else {
                        System.out.println("La population de " + repStr + " est de : " + String.format("%,d", repInt) + ".\n");
                    }
                    break;
                case 2:
                    System.out.print("Entrez le code du département souhaité : ");
                    repStr= sc.nextLine();
                    repInt = this.getPopuDepartement(repStr);
                    if (repInt == -1){
                        System.out.println("Aucun code de département ne corespond à " + repStr + ".");
                    } else {
                        System.out.println("La population du département ayant le code " + repStr + " est de : " + String.format("%,d", repInt) + ".\n");
                    }
                    break;

                case 3:
                    System.out.print("Entrez le code de la région souhaité : ");
                    repInt= Integer.parseInt(sc.nextLine());
                    int res = this.getPopuRegion(repInt);
                    if (res == -1){
                        System.out.println("Aucun code de région ne corespond à " + repInt + ".");
                    } else {
                        System.out.println("La population de la région ayant le code " + repInt + " est de : " + String.format("%,d", res) + ".\n");
                    }
                    break;

                case 4:
                    tab = this.getTopPopuDepartement();

                    System.out.println("Top 10 des départements les plus peuplés : " + Arrays.toString(tab).substring( 1, Arrays.toString(tab).length() - 1 ) + ".\n");
                    break;

                case 5:
                    tab = this.getTopPopuRegion();

                    System.out.println("Top 10 des régions les plus peuplés : " + Arrays.toString(tab).substring( 1, Arrays.toString(tab).length() - 1 ) + ".\n");
                    break;

                case 6:
                    System.out.print("Entrez le code du département souhaité : ");
                    repStr = sc.nextLine();
                    tab = this.getTopPopuVilleFromDep(repStr);
                    if (tab[0] == null){
                        System.out.println("Aucun code de département ne corespond à " + repStr + ".");
                    } else {
                        System.out.println("Top 10 des villes les plus pleuplées du " + repStr + " : " + Arrays.toString(tab).substring( 1, Arrays.toString(tab).length() - 1 ) + ".\n");
                    }
                    break;

                case 7:
                    System.out.print("Entrez le code de la région souhaité : ");
                    repInt = Integer.parseInt(sc.nextLine());
                    tab = this.getTopPopuVilleFromReg(repInt);
                    if (tab[0] == null){
                        System.out.println("Aucun code de région ne corespond à " + repInt + ".");
                    } else {
                        System.out.println("Top 10 des villes les plus pleuplées de la région ayant le code " + repInt + " : " + Arrays.toString(tab).substring( 1, Arrays.toString(tab).length() - 1 ) + ".\n");
                    }
                    break;

                case 8:
                    tab = this.getTopPopuVilleFromFrance();
                    System.out.println("Top 10 des villes les plus pleuplées de France " + Arrays.toString(tab).substring( 1, Arrays.toString(tab).length() - 1 ) + ".\n");
                    break;

                case 9:
                    System.out.println("Bonne journée !");
                    break;

                default:
                    System.out.println("Veuillez respecter le menu!");
                    break;
            }
        }while(rep!=9);
    }
}
