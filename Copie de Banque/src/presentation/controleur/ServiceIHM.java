package presentation.controleur;

import metier.authentification.IServiceIHM;
import presentation.modele.Banque;

import java.util.Scanner;

public class ServiceIHM implements IServiceIHM {

    Banque bq = new Banque();

    ServiceIHM(){}
    ServiceIHM(Banque bq){
        this.bq=bq;
    }
    @Override
    public int menuAdmin() {
        ServiceIHMAdmin IA=new ServiceIHMAdmin(bq);
        ServiceAdmin sc = new ServiceAdmin(bq);
        Scanner clavier=new Scanner(System.in);
        int i=-1;
        do{
            System.out.println("[1]-Menu Ajout");
            System.out.println("[2]- Menu Modification");
            System.out.println("[3]-Menu Recherche");
            System.out.println("[4]-Menu Informations");
            System.out.println("[5]-Menu Trie");
            System.out.println("[6]-Menu Suppression");
            System.out.println("[7]-Menu Tableau de bord");
            System.out.println("[8]-Afficher les client SUi");
            System.out.println("[9]-Se Deconnecter");
            System.out.println("entrer votre choix ");
            int choix= clavier.nextInt();
            switch (choix){
                case 1:
                    IA.menuAjout();
                    break;
                case 2:
                    IA.menuModification();
                    break;
                case 3:
                    IA.menuRecherche();
                    break;
                case 4:
                    IA.menuInformations();
                    break;
                case 5:
                    IA.menuTrie();
                    break;
                case 6:
                    IA.menuSuppression();
                    break;
                case 7:
                    IA.tableauDeBord();
                    break;
                case 8:
                    sc.AfficherClient();
                    break;
            }

        }while(i != 9);
        return 0;
    }

    @Override
    public int menuGlobal() {
        return 0;
    }
}
