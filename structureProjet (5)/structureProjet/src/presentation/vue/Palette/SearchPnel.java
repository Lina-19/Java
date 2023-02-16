package presentation.vue.Palette;

import javax.swing.*;
import java.awt.*;

public class SearchPnel extends JPanel {

    JLabel lbl_search;
    JTextField txt_search;
    private void initLabel(){
        lbl_search=new JLabel("Search");


    }
    private void iniTextFieled(){
        txt_search=new JTextField();
        txt_search.setFont(new Font("Optima",Font.BOLD,17));
        txt_search.setForeground(Color.BLUE);
   //     txt_search.setHorizontalAlignment(JTextField.CENTER);

    }
    public SearchPnel(){
iniTextFieled();
        setLayout(new FlowLayout(FlowLayout.RIGHT));
         add(txt_search);
    }
}
