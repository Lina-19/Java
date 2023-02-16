package presentation.vue.Palette;

import presentation.modele.Client;
import presentation.modele.Compte;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private String[] columnsNames;//le header
    private  Object[][] data;//body

    public void initClientData(List<Client> clients){
        data = new Object[clients.size()][columnsNames.length];
        int i=0;
        for(Client client:clients){
            data[i][0]=client.getId();
            data[i][1]=client.getNom();
            data[i][2]=client.getPrenom();
            data[i][3]=client.getLogin();
            data[i][4]=client.getMotDePasse();
            data[i][5]=client.getCin();
            data[i][6]=client.getEmail();
            data[i][7]=client.getTel();
            data[i][8]=client.getSexe();
            i++;
            this.fireTableDataChanged();
        }
    }
//
//    public static void main(String[] args) {
//        TableModel model=new TableModel("Id","Nom");
//        model.initClientData(new );
//    }
    private void initAccountData(List<Compte> comptes){
         data=new Object[comptes.size()][columnsNames.length];
         int i=0;
         for(Compte compte:comptes){
             data[i][0]=compte.getNumeroCompte();
             data[i][1]=compte.getSolde();
             data[i][2]=compte.getDateCreation();
             data[i][3]=compte.getPropriétaire();
         }
    }
    public TableModel(String... names){
        columnsNames=new String[names.length];
        for(int i=0;i< names.length;i++){
            columnsNames[i]=names[i];
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public String getColumnName(int col) {
        return columnsNames[col];//hna pour donner les nom du colonnes par nous meme sinon(avec super) ca va donner a b c ...
    }
}
