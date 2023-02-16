package presentation.controleur;

import metier.authentification.IAuth;
import presentation.modele.Admin;
import presentation.vue.Palette.LoginView;
import presentation.vue.Palette.MyFrame;

public class Auth implements IAuth {
    String login;
    String pass;

    LoginView au = new LoginView("Banque");

    public Auth() {
        login = au.log();
        pass = au.pass();

    }


    @Override
    public void seConnecter() {
        String log = au.log();
        String pass = au.pass();
        if (log.equals(Admin.getInstance().getLogin()) && pass.equals(Admin.getInstance().getMotDePasse()))
            new MyFrame("Banque");
    else{


    }

}


    @Override
    public void SeDéconnecter() {

    }
}
