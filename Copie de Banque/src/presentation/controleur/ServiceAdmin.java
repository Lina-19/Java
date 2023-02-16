package presentation.controleur;


import metier.admin.IServiceAdmin;
import presentation.modele.*;

import java.time.LocalDateTime;
import java.util.*;

public class ServiceAdmin implements IServiceAdmin {
    Banque bq=new Banque();


    ServiceAdmin(){}
    ServiceAdmin(Banque bq){
        this.bq=bq;
    }
    @Override
    public Client nouveauClient() {
        Scanner clavier=new Scanner(System.in);
        System.out.println("Donner le nom ");
        String  nom= clavier.next();
        System.out.println("Donner le prenom ");
        String  prenom= clavier.next();
        System.out.println("Donner l'email ");
        String  email= clavier.next();
        System.out.println("Donner le cin ");
        String  cin= clavier.next();
        System.out.println("Donner le login ");
        String  login= clavier.next();
        System.out.println("Donner le mdp ");
        String  mdp= clavier.next();
        System.out.println("Donner le tel ");
        String  tel= clavier.next();
        Sexe s= Sexe.FEMME;
        Client c=new Client(login,mdp,nom,prenom,email,cin,tel,s);
        bq.AjouterClientsDeBanque(c);
        for(int i=0;i<bq.getClientsDeBanque().size();i++){
            System.out.println(bq.getClientsDeBanque().get(i).toString());
        }
        return c;
    }

    @Override
    public Client nouveauCompteClientExistant() {
        Scanner clavier=new Scanner(System.in);
        System.out.println("Donner l'id du client");
        int  id= clavier.nextInt();
        System.out.println("Donner la somme du compte");
        Double mt=clavier.nextDouble();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getId()==id){
                Compte compte=new Compte(mt);
                compte.setPropriétaire(i);
                i.AjoutertComptesClient(compte);

            }
        }
        return null;
    }

    @Override
    public Client chercherClientParId(Long id) {
        Client c=new Client();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getId().equals(id)){
                c=i;
            }
        }
        return c;
    }

    @Override
    public List<Client> chercherClientParNom(String nom) {
        List<Client> c=new ArrayList<>();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getNom().equals(nom)){
                c.add(i);
            }
        }
        return c;
    }

    @Override
    public List<Client> chercherClientParPrénom(String prenom) {
        List<Client> c=new ArrayList<>();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getPrenom().equals(prenom)){
                c.add(i);
            }
        }
        return c;
    }

    @Override
    public Client chercherClientParCin(String cin) {
        Client c=new Client();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getCin().equals(cin)){
                c=i;
            }
        }
        return c;
    }

    @Override
    public Client chercherClientParEmail(String email) {
        Client c=new Client();
        for(Client i : bq.getClientsDeBanque()){
            if(i.getEmail().equals(email)){
                c=i;
            }
        }
        return c;
    }

    @Override
    public Compte chercherCompteParId(Long idCompte) {
        Compte c=new Compte();
        for(Client i : bq.getClientsDeBanque()){
            for(Compte x : i.getComptesClient()){
            if(x.getNumeroCompte().equals("b-co00"+idCompte)){
                c=x;
            }
        }}
        return c;

    }

    @Override
    public List<Compte> chercherCompteParSolde(double solde) {
        List<Compte> c=new ArrayList<>();
        for(Client i : bq.getClientsDeBanque()){
            for(Compte x : i.getComptesClient()){
                if(x.getSolde().equals(solde)){
                    c.add(x);
                }
            }}
        return c;

    }

    @Override
    public List<Compte> chercherCompteParDateCreation(LocalDateTime date) {
        return null;
    }

    @Override
    public List<Compte> chercherCompteParPropriétaire(Client propriétaire) {
        return null;
    }

    @Override
    public Client modifierClient(String filtre) {


        return null;
    }
public void AfficherClient(){
    System.out.println("Hello");
    System.out.println("size"+bq.getClientsDeBanque().size());
        for(Client c : bq.getClientsDeBanque()){
            System.out.println(c.toString() );
            for(Compte cc:     c.getComptesClient()){
                System.out.println(cc.toString());
            }
        }

}
    @Override
    public boolean supprimerClient(Long id) {
        for(Client i :bq.getClientsDeBanque()){
            if(i.getId().equals(id)){
                System.out.println("test");
                bq.getClientsDeBanque().remove(i);
            }
        }
            return true;
        }

    @Override
    public TableauDeBord calculerEtAfficherStatistiques() {
        return null;
    }

    @Override
    public List<Client> trierClientParNom() {
        List<Client>  clts = new ArrayList<>();
        clts = bq.getClientsDeBanque();
        Collections.sort(clts, Comparator.comparing(Utilisateur::getNom));
        return clts;
    }

    @Override
    public List<Client> trierClientParCin() {
        List<Client>  clts = new ArrayList<>();
        clts = bq.getClientsDeBanque();
        Collections.sort(clts, Comparator.comparing(Client::getCin));
        return clts;
    }

    @Override
    public List<Client> trierClientParEmail() {
        List<Client>  clts = new ArrayList<>();
        clts = bq.getClientsDeBanque();
        Collections.sort(clts, Comparator.comparing(Client::getEmail));
        return clts;
    }

    @Override
    public List<Client> trierClientParAdresse() {
        return null;
    }

    @Override
    public List<Client> trierClientParSoldeCompte() {

        return null;
    }

    @Override
    public List<Compte> trierComptesParSolde() {
        List<Compte>  c = new ArrayList<>();
        c = bq.getComptesDeBanque();
        Collections.sort(c, Comparator.comparing(Compte::getSolde));
        return c;
    }



    @Override
    public List<Compte> trierComptesParDateDeCreation() {
        return null;
    }

    @Override
    public List<Compte> trierComptesParNomPropriétaire() {
        return null;
    }
}
