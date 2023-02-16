package presentation.vue.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientFrame extends JFrame {
    Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    Container container;
    TablePanel tablepanel;

    HeaderPanel header;
    SudeMenuPanel menuPanel;
    private void initpanel(){

        menuPanel=new SudeMenuPanel("verser","retirer");
        Font logoFont=new Font("Optima",Font.BOLD,15);
        header=new HeaderPanel(Color.WHITE,"agence",Color.black,logoFont,"Menu",Color.BLACK,logoFont);
        initAction();
    }
    private  void initContainer(){
        initpanel();
        container=getContentPane();
        container.setLayout(new BorderLayout());
        //  container.add(searchPnel,BorderLayout.NORTH);
      //  container.add(tablepanel,BorderLayout.CENTER);
        container.add(menuPanel,BorderLayout.WEST);
        container.add(header,BorderLayout.NORTH);
    }
    private  void initAction()
    {
        var buttons= menuPanel.getButtons();
//hadchi li ghadi ndiro c'est la fct lamda
        buttons.get("verser").addActionListener(event ->{
            System.out.println("btn verser cliqué");
        });
        buttons.get("retirer").addActionListener(event ->{
            System.out.println("btn retirer cliqué");
        });



        buttons.get("verser").addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent e) {
                buttons.get("verser").setForeground(Color.RED);
                buttons.get("verser").setFont(new Font("Optima",Font.ITALIC,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttons.get("retirer").setForeground(Color.BLUE);
                buttons.get("retirer").setFont(new Font("Optima",Font.BOLD,18));
            }
        });

    }
     public ClientFrame(){
         initContainer();

         setLocation(0,0);
         setSize(screenSize.width,screenSize.height-90);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
     }
}
