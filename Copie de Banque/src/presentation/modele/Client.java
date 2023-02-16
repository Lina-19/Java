package presentation.modele;

import java.util.*;


public class Client extends Utilisateur implements Comparable<Client>{

    private String email, cin, tel;
    private Sexe sexe;
    private List<Compte> comptesClient;



    public String       getCin() {
        return cin;
    }
    public String       getTel() {
        return tel;
    }
    public String       getEmail() {
        return email;
    }
    public List<Compte> getComptesClient() {
        return comptesClient;
    }
    public Sexe getSexe() {
        return sexe;
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public void         setEmail(String email) {
        this.email = email;
    }
    public void         setTel(String tel) {
        this.tel = tel;
    }
    public void         setCin(String cin) {
        this.cin = cin;
    }
    public void         setComptesClient(List<Compte> comptesClient) {
        this.comptesClient = comptesClient;
    }
    public void        AjoutertComptesClient(Compte c) {

        this.comptesClient.add(c);
    }
    public Client(){

        comptesClient = new ArrayList<>();
    }

    public Client(String login, String pass){
        super(login, pass, "Client");
        comptesClient = new ArrayList<>();

    }

    public Client(String login, String pass, String n, String p){
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        comptesClient = new ArrayList<>();
    }
    public Client(String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe){
        super(login, pass, "Client");
        setNom(n);
        setPrenom(p);
        setTel(tel);
        setEmail(mail);
        setCin(cin);
        setSexe(sexe);
        comptesClient = new ArrayList<Compte>();

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client)) {
            return false;
        } else {
            return this.id.equals(((Client)obj).id) ;
        }
    }
class SortedByCIN implements Comparator<Client>{

    @Override
    public int compare(Client o1, Client o2) {
        return  o1.getCin().compareTo(o2.getCin());
    }
}
    @Override
    public String toString() {

        String      clientStr  = "------------------------------------------------------\n";
                    clientStr += "| Identifiant du Client     : "   + this.id        + "\n";
                    clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
                    clientStr += "| Adresse email             : "   + this.email     + "\n" ;
                    clientStr += "| Numéro téléphone          : "   + this.tel       + "\n" ;
                    clientStr += "| Numéro de CIN             : "   + this.cin       + "\n" ;
                    clientStr += "------------------------------------------------------\n";

        return clientStr;
    }

public void afficher(){
   System.out.println("l'id "+ this.getId() +" le nom "+this.getNomComplet() + "son cin "+this.getCin());
}
    @Override
    public int compareTo(Client o) {
        if(this.nom.compareTo(o.nom)==0) {
            if(this.cin.compareTo(o.cin)==0){
                return this.email.compareTo(o.email);
            }
            else {
                return  this.cin.compareTo(o.cin);
            }
        }
        else
        return this.nom.compareTo(o.nom);
    }

    public List<Compte> trierComptesParSolde() {
        List<Compte>  c = new ArrayList<>();
        c = this.getComptesClient();
        Collections.sort(c, Comparator.comparing(Compte::getSolde));
        return c;
    }
}
