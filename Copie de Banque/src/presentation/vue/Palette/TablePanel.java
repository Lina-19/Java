package presentation.vue.Palette;

import presentation.modele.Client;
import presentation.modele.Sexe;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablePanel extends JPanel {
    private  JScrollPane scrollPane;



    private  TableModel tablemodel;
private JTableHeader tableHeader;

    private JTable table;
    private void initPanle(){

        tablemodel=new TableModel(
                "Id","Nom","Prenom","Login","Pass","Cin","Email","Telephone","Sexe"
        );
        List<Client> clients=new ArrayList<>(Arrays.asList(
                new Client("test","test","client1","clien1","client1@gmail.com","cin","tel", Sexe.HOMME),
                new Client("test2","test2","client2","clien2","client2@gmail.com","cin","tel", Sexe.FEMME)
        ));
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
    public TablePanel(){
        initPanle();
        setLayout(new BorderLayout());
        add(scrollPane,BorderLayout.CENTER);
    }

}
