package presentation.controleur;

import metier.admin.IServiceIHMAdmin;
import presentation.modele.Banque;
import presentation.modele.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceIHMAdmin implements IServiceIHMAdmin {

    Banque bq = new Banque();

    public ServiceIHMAdmin(){}
    public ServiceIHMAdmin(Banque bq){
        this.bq=bq;

    }
    ServiceAdmin A=new ServiceAdmin(bq);
    @Override
    public int menuModification() {
        int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]-Modifier un client");
            System.out.println("[2]-retourn er au menu preceddent");

            int choix=clavier.nextInt();
            switch (choix){
                case 1:
               //     A.modifierClient();
                    break;
                case 2:
                    menuAdmin();
                    break;
                default:
                    clavier.close();
            }
        }while(i!=3);
        return 0;
    }

    @Override
    public int menuRecherche() {
        int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]-Chercher client par cin");
            System.out.println("[2]-Chercher client par email");
            System.out.println("[3]-Chercher client par id");
            System.out.println("[4]-Chercher client par nom");
            System.out.println("[5]-Chercher client par prenom");
            System.out.println("[6]-retourner au menu precedent");

            int choix=clavier.nextInt();
            switch (choix){
                case 1:
                    System.out.println("Chercher client par cin");
                    String cin= clavier.next();
                    Client client = A.chercherClientParCin(cin);
                    System.out.println(client.toString());
                    break;
                case 2:
                    System.out.println("Chercher client par email");
                    String email= clavier.next();
                    Client client1 = A.chercherClientParEmail(email);
                    System.out.println(client1.toString());
                    break;
                case 3:
                    System.out.println("Chercher client par id");
                    Long id= clavier.nextLong();
                    Client client2 =A.chercherClientParId(id);
                    System.out.println(client2.toString());
                    break;
                case 4:
                    System.out.println("Chercher client par nom");
                    String nom= clavier.next();
                    List<Client> clients=new ArrayList<>();
                    clients.addAll(A.chercherClientParNom(nom));
                    for (int x=0;x<clients.size();x++){
                        System.out.println(clients.get(x).toString());
                }

                    break;
                case 5:
                    System.out.println("Chercher client par prenom");
                    String prenom= clavier.next();
                    List<Client> clients1=new ArrayList<>();
                    clients1.addAll(A.chercherClientParPrénom(prenom));
                    for (int x=0;x<clients1.size();x++){
                        System.out.println(clients1.get(x).toString());
                    }
                    break;
                case 6:
                  menuAdmin();
                    break;
                default:
                    clavier.close();
            }
        }while(i!=3);
        return 0;
    }

    @Override
    public int menuInformations() {
        A.AfficherClient();
        return 0;
    }

    @Override
    public int menuAjout() {
        int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]-Ajouter un nouveau client");
            System.out.println("[2]-Ajouter un nouveau compte a un client existant");
            System.out.println("[3]-Retourner au menu Admin");
            int choix;
            choix = clavier.nextInt();
            switch (choix){
                case 1:
                    A.nouveauClient();
                    break;
                case 2:
                    A.nouveauCompteClientExistant();
                    break;
                case 3:
                    menuAdmin();
                    break;
                default:
                    clavier.close();
            }
        }while(i!=4);
        return 0;
    }

    @Override
    public int menuSuppression() { int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]- Supprimer un client");
            System.out.println("[2]-retourn er au menu preceddent");

            int choix=clavier.nextInt();
            switch (choix){
                case 1:
                    System.out.println("Donner l'id du client que vous vouler supprimer");
                    long id= clavier.nextLong();
                    A.supprimerClient(id);
                    break;
                case 2:
                    menuAdmin();
                    break;
                default:
                    clavier.close();
            }
        }while(i!=3);

        return 0;
    }

    @Override
    public int tableauDeBord() {
        return 0;
    }

    @Override
    public int menuTrie() {
        int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]-Trier client par cin");
            System.out.println("[2]-Trier client par email");
            System.out.println("[3]-Trier client par nom");
            System.out.println("[4]-Trier comptes par solde");
            System.out.println("[5]-retour au menu precedent");
//            System.out.println("[6]-Trier client par date de creation");
//            System.out.println("[7]-Trier comptes par proprietere");
            int choix=clavier.nextInt();
            switch (choix){
                case 1:
                    for (Client c : A.trierClientParCin()){
                        System.out.println(c.toString());
                    }
                    break;
                case 2:
                    for(Client c:A.trierClientParEmail()) System.out.println(c.toString());
                    break;
                case 3:
                   for(Client c: A.trierClientParNom()) System.out.println(c.toString());
                    break;
                case 4:
                    A.trierComptesParSolde();
                    break;
                case 5:
                    menuAdmin();
                    break;
                case 6:
                    A.trierComptesParDateDeCreation();
                    break;
                case 7:
                    A.trierComptesParNomPropriétaire();
                    break;
                default:
                    clavier.close();
            }
        }while(i!=3);

        return 0;
    }

    @Override
    public int menuComptabilité() {
        return 0;
    }

    @Override
    public int menuAdmin() {
        ServiceIHMAdmin IA=new ServiceIHMAdmin(bq);
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

            System.out.println("entrer votre choix ");
            int choix= clavier.nextInt();
            switch (choix){
                case 1:
                    menuAjout();
                    break;
                case 2:
                    menuModification();
                    break;
                case 3:
                    menuRecherche();
                    break;
                case 4:
                    A.AfficherClient();
                    break;
                case 5:
                    menuTrie();
                    break;
                case 6:
                    menuSuppression();
                    break;
                case 7:
                    tableauDeBord();
                    break;



            }

        }while(i != 8);
        return 0;
    }

    @Override
    public int menuGlobal() {
        int i=-1;
        Scanner clavier=new Scanner(System.in);
        do{
            System.out.println("[1]-Verser");
            System.out.println("[2]-Retirer");
            System.out.println("[3]-Virement");
            System.out.println("Entrer voitre choix");
            int choix=clavier.nextInt();
            switch (choix){
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;

                default:
                    clavier.close();
            }
        }while(i!=3);
        return 0;
    }
}
