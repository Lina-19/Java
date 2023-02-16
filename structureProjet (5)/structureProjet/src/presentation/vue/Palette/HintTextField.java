package presentation.vue.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HintTextField extends JTextField {
    private static  final long serialVersionId=1L;
    Font gainfont =new Font("Optima",Font.BOLD,17);
    Font lostfont =new Font("Optima",Font.ITALIC,17);



    public HintTextField(final String hint){
        setText(hint);
        setFont(lostfont);
        setForeground(Color.GRAY);
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getText().equals(hint)){
                    setText("");
                    setFont(gainfont);

                }
                else {
                    setText(getText());
                    setFont(gainfont);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getText().equals(hint) || getText().length()==0){
                    setText(hint);
                    setFont(lostfont);
                    setForeground(new Color(186,85,211));
                }
                else {
                    setText(getText());
                    setFont(gainfont);
                    setForeground(new Color(186,85,211));

                }
            }
        });
    }
}

