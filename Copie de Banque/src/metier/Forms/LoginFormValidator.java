package metier.Forms;

import metier.Verifiable;
import presentation.modele.Admin;
import presentation.modele.Banque;
import presentation.modele.Client;
import presentation.modele.Utilisateur;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginFormValidator implements Verifiable {
   private Map<String,String> errors=new HashMap<>();
   private String connexionmsg;

    public String getConnexionmsg() {
        return connexionmsg;
    }

    public void setConnexionmsg(String connexionmsg) {
        this.connexionmsg = connexionmsg;
    }

    private static final String CHAMP_LOGIN="login", CHAMP_PASS="pass";
private Banque banque;
    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(String fiel,String errormsg) {
        this.errors.put(fiel,errormsg);
    }
public LoginFormValidator(){}
    public LoginFormValidator(Banque bq){this.banque=bq;}
    private void verifierLogin(String login) throws FormException {
        if(login !=null && login.trim().length()!=0)  {
            if(login.trim().length()<4) throw new FormException("login doit avoir plus de 4 caractere");
//            else{
//                if(login.trim().startsWith("C_")) throw new FormException("Forma invalide du login");
//            }
        }
        else{
            throw new FormException("Login es un champ obligatoire");
        }
    }
    private void verifierMotDePass(String pass) throws  FormException{
        if(pass !=null && pass.trim().length()!=0)  {
            if(pass.trim().length()<4) throw new FormException("pass doit avoir plus de 4 caractere");
//            else{
//                if(login.trim().startsWith("C_")) throw new FormException("Forma invalide du login");
//            }
        }
        else{
            throw new FormException("pass es un champ obligatoire");
        }
    }
    private boolean validerlogin(String login,Utilisateur user){

        try {
            verifierLogin(login);
            user.setLogin(login);
            return  true;
        } catch (FormException e) {
          setErrors(CHAMP_LOGIN,e.getMessage());
          return false;
        }
    }
    private boolean validerPss(String pass,Utilisateur user){

        try {
            verifierMotDePass(pass);
            user.setMotDePasse(pass);
            return  true;
        } catch (FormException e) {
            setErrors(CHAMP_PASS,e.getMessage());
            return false;
        }
    }
//    public Utilisateur ValiderSesion(String login,String pass){
//        //Utilisateur session = null;
//        Utilisateur session=new Utilisateur();
//        validerlogin(login,session);
//        validerPss(pass,session);
//        if(errors.isEmpty()){
//            if(isAdmin(login,pass)){
//                session= Admin.getInstance();
//                setConnexionmsg("connexion reussite our l'admin",+ session.getNomComplet());
//            }
//            else{
//                session=isClient(login,pass,banque);
//                if(se)
//            }
//        }
//        else {
//
//        }
//        return session;
//    }



    public static void main(String[] args) {
        Scanner clavier=new Scanner(System.in);
        Banque bq=new Banque();
        LoginFormValidator loginforrm=new LoginFormValidator(bq);
        Utilisateur user=null;
        do{
            System.out.println("=>login   ");
            String login=clavier.next();
            System.out.println("=<pass    ");
            String pass=clavier.next();
            //user=loginforrm.val


        }while(true);
    }
}
