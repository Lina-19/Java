package presentation.controleur;

import metier.authentification.IAuth;
import presentation.modele.Banque;
import presentation.modele.Client;

import java.util.Scanner;

public class MaBanque {
        static Auth loginService=new Auth();

        public static void main(String[] args) {

                Banque maBanque
                        = new Banque(   "BP",
                                        "Hassan Rabat",
                                        "212535224433",
                                        "bp@banquePop.ma");


                Scanner clavier = new Scanner(System.in);
                //loginService = new ServiceAuth(maBanque, clavier);
                loginService.seConnecter();

                clavier.close();

        }

}
