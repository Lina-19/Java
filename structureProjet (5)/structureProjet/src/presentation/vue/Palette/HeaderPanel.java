package presentation.vue.Palette;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private  JLabel lbl_logo;
    private JButton btn_toggleMenu;


    private void iniLabel(String text, Color color, Font font){
        lbl_logo=new JLabel(text);

        lbl_logo.setForeground(color);
        lbl_logo.setFont(font);
        lbl_logo.setHorizontalTextPosition(JLabel.CENTER);
        lbl_logo.setVerticalTextPosition(JLabel.BOTTOM);
    }

    private void iniButtons(String text, Color color, Font font){
        btn_toggleMenu=new JButton(text);

        btn_toggleMenu.setForeground(color);
        btn_toggleMenu.setFont(font);
        btn_toggleMenu.setHorizontalTextPosition(JLabel.CENTER);
        btn_toggleMenu.setVerticalTextPosition(JLabel.BOTTOM);
        btn_toggleMenu.setBorderPainted(false);

    }
    public HeaderPanel(Color bgcolor, String text, Color color,Font font
     , String text_btn, Color color_btn,Font font_btn){
        iniButtons(text_btn,color_btn,font_btn);
        iniLabel(text,color,font);
        setLayout(new BorderLayout());
        setBackground(bgcolor);

        add(btn_toggleMenu,BorderLayout.WEST);
        add(lbl_logo,BorderLayout.EAST);
    }
}
