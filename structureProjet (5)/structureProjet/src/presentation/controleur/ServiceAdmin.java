package presentation.controleur;

import metier.admin.IServiceAdmin;
import presentation.modele.*;
import presentation.vue.Palette.ClientFormView;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceAdmin implements IServiceAdmin {
    ClientFormView cl=new ClientFormView();
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    FileWriter file=null;

    //En-tête de fichier
    private static final String HEADER = "Nom,Prenom,Login,Password,Email,CIN,Tel,Sexe";
    Banque bq=new Banque();

   public List<Client> cli=new ArrayList<>();
    public  ServiceAdmin(){}
     public ServiceAdmin(Banque bq){
        this.bq=bq;
    }

    @Override
    public Client nouveauClient(String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe) throws IOException {
        Client client=new Client(login,pass,n,p,mail,cin,tel,sexe);
        System.out.println(client.toString());
        bq.getClientsDeBanque().add(client);
        try
        {
            file=new FileWriter("MyFiles/Client.csv");
            //Ajouter l'en-tête
            file.append(HEADER);
            //Ajouter une nouvelle ligne après l'en-tête
            file.append(SEPARATOR);
            //Itérer bookList
            Iterator it = bq.getClientsDeBanque().iterator();
            while(it.hasNext())
            {
                Client b = (Client) it.next();
                file.append(b.getNom());
                file.append(DELIMITER);
                file.append(b.getPrenom());
                file.append(DELIMITER);
                file.append(b.getLogin());
                file.append(DELIMITER);
                file.append(b.getMotDePasse());
                file.append(DELIMITER);
                file.append(b.getEmail());
                file.append(DELIMITER);
                file.append(b.getCin());
                file.append(DELIMITER);
                file.append(b.getTel());
                file.append(DELIMITER);
                file.append(String.valueOf(b.getSexe()));
                file.append(SEPARATOR);
                cli.add(b);
            }

            file.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return  client;
    }

    @Override
    public Client nouveauCompteClientExistant() {
        return null;
    }

    @Override
    public Client chercherClientParId(Long id) throws FileNotFoundException {
        List<Client> clients=new ArrayList<>();
        try {
            FileReader file = new FileReader("MyFiles/Client.csv");
            BufferedReader bf=new BufferedReader(file);
            String line=null;
            bf.readLine();
            while((line=bf.readLine())!=null){
                String[] cl=line.split(",");

                Client client=new Client(cl[2],cl[3],cl[0],cl[1],cl[5],cl[4],cl[6]);
//               client.setSexe(Sexe.valueOf(cl[7]));
                clients.add(client);
                for(Client x: clients){
                    if(x.getId()==id){
                        return x;
                    }
                }return null;}
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Client> chercherClientParNom(String nom) {
        return null;
    }

    @Override
    public List<Client> chercherClientParPrénom(String prenom) {
        return null;
    }

    @Override
    public Client chercherClientParCin(String cin) {
        return null;
    }

    @Override
    public Client chercherClientParEmail(String email) {
        return null;
    }

    @Override
    public Compte chercherCompteParId(Long idCompte) {
        return null;
    }

    @Override
    public List<Compte> chercherCompteParSolde(double solde) {
        return null;
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

    @Override
    public boolean supprimerClient(Long id) {
        return false;
    }

    @Override
    public TableauDeBord calculerEtAfficherStatistiques() {
        return null;
    }

    @Override
    public List<Client> trierClientParNom() {
        return null;
    }

    @Override
    public List<Client> trierClientParCin() {
        return null;
    }

    @Override
    public List<Client> trierClientParEmail() {
        return null;
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
        return null;
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
