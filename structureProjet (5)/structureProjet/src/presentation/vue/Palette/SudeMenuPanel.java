package presentation.vue.Palette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SudeMenuPanel  extends JPanel {
//    pour acceder au icons
//    ClassLoader cl=getClass().getClassLoader();
    private LinkedHashMap<String, JButton> buttons;
    private Map<String,Icon> buttons_white_icon;

    public LinkedHashMap<String, JButton> getButtons() {
        return buttons;
    }

    private void initButtons(String... buttonsNames){
        buttons=new LinkedHashMap<>();

        List<String> btnNames=new ArrayList<>(Arrays.asList(buttonsNames));
        btnNames.forEach(nameOfButton ->{
            JButton btn =new JButton(nameOfButton);
            btn.setFont(new Font("Optima",Font.BOLD,17));
            btn.setForeground(Color.BLUE);
            btn.setHorizontalAlignment(JButton.CENTER);
            btn.setPreferredSize(new Dimension(150,50));
            btn.setMaximumSize(new Dimension(150,50));
            btn.setMargin(new Insets(5,5,0,5));
            //ci dessous si je travail les icons
//            btn.setHorizontalTextPosition(JButton.CENTER);
//            btn.setVerticalTextPosition(JButton.BOTTOM);
            buttons.put(nameOfButton,btn);

        });
    }


    public SudeMenuPanel(String... buttonsNames){
        initButtons(buttonsNames);
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBorder(new EmptyBorder(15,6,0,6));
        setBackground(Color.GRAY);
        buttons.forEach((names,btn)->{
            add(btn);

        });
        setVisible(false);
    }
}
