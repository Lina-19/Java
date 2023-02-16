package presentation.controleur;

import metier.authentification.IAuth;
import presentation.modele.Admin;
import presentation.modele.Banque;
import presentation.modele.Utilisateur;

import java.util.Scanner;

public class Auth implements IAuth {


    @Override
    public void seConnecter() {
        Banque bq = new Banque();
        Scanner  clavier=new Scanner(System.in);
        System.out.println("Donner le login ");
        String login =clavier.next();
        System.out.println("Donner le mot de passe ");
        String mdp=clavier.next();

        
        if(Admin.getInstance().getLogin().equals(login) && Admin.getInstance().getMotDePasse().equals(mdp)){

            ServiceIHMAdmin I = new ServiceIHMAdmin(bq);
            I.menuAdmin();
        }
        else{
            ServiceIHMAdmin I = new ServiceIHMAdmin(bq);
              I.menuGlobal();
        }
    }

    @Override
    public void SeDéconnecter() {


    }


}
