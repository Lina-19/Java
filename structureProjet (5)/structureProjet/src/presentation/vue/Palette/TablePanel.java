package presentation.vue.Palette;

import presentation.controleur.ServiceAdmin;
import presentation.modele.Client;
import presentation.modele.Sexe;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TablePanel extends JPanel {
    private  JScrollPane scrollPane;

    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
  private ServiceAdmin sa;

    private  TableModel tablemodel;
private JTableHeader tableHeader;

    private JTable table;
    private void initPanle() throws FileNotFoundException {

        tablemodel=new TableModel(
                "Id","Nom","Prenom","Login","Pass","Cin","Email","Telephone","Sexe"
        );
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
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }


        tablemodel.initClientData(clients);
        table=new JTable(tablemodel);
        table.setFont(new Font("Optima",Font.BOLD,17));
        table.setForeground(new Color(105,40,157));
        table.setRowHeight(35);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tableHeader=table.getTableHeader();
        tableHeader.setFont(new Font("Optima",Font.BOLD,17));
        tableHeader.setForeground(new Color(253,0,79));
        ((DefaultTableCellRenderer)tableHeader.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

        scrollPane=new JScrollPane(table);
    }
    public TablePanel()  {

        try {
            initPanle();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        setLayout(new BorderLayout());
        add(scrollPane,BorderLayout.CENTER);
    }

}
