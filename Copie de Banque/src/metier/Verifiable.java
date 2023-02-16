package metier;

import presentation.modele.Admin;
import presentation.modele.Banque;
import presentation.modele.Client;

public interface Verifiable {
//   default Admin isAdmin(String lg, String pass , Banque bq){
//        return  Admin.getInstance()..filter(client -> {return Admin.getInstance().getLogin().equals(lg) && Admin.getInstance().getMotDePasse().equals(pass);}).findFirst().orElse(null);
//    }
    default Client isClient(String lg, String pass , Banque bq){
        return  bq.getClientsDeBanque().stream().filter(client -> {return client.getLogin().equals(lg) && client.getMotDePasse().equals(pass);}).findFirst().orElse(null);
    }

    default boolean isNumeric(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    default boolean isDecimal(String value){
        try {
            Double.parseDouble(value);
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
