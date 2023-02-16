package metier.admin;

import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;
import presentation.modele.TableauDeBord;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface IServiceAdmin {

    Client          nouveauClient(String login, String pass, String n, String p, String mail, String cin, String tel, Sexe sexe) throws IOException;
    Client          nouveauCompteClientExistant();

    Client          chercherClientParId(Long id) throws FileNotFoundException;
    List<Client>    chercherClientParNom(String nom);
    List<Client>    chercherClientParPrénom(String prenom);
    Client          chercherClientParCin(String cin);
    Client          chercherClientParEmail(String email);

    Compte          chercherCompteParId(Long idCompte);
    List<Compte>    chercherCompteParSolde(double solde);
    List<Compte>    chercherCompteParDateCreation(LocalDateTime date);
    List<Compte>    chercherCompteParPropriétaire(Client propriétaire);

    Client          modifierClient(String filtre);
    boolean         supprimerClient(Long id);

    TableauDeBord   calculerEtAfficherStatistiques();

    List<Client>    trierClientParNom();
    List<Client>    trierClientParCin();
    List<Client>    trierClientParEmail();
    List<Client>    trierClientParAdresse();
    List<Client>    trierClientParSoldeCompte();
    List<Compte>    trierComptesParSolde();
    List<Compte>    trierComptesParDateDeCreation();
    List<Compte>    trierComptesParNomPropriétaire();

}
