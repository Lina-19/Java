package presentation.vue.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    Container container;
    TablePanel tablepanel;
    SearchPnel searchPnel;
    HeaderPanel header;
    SudeMenuPanel menuPanel;
    private void initpanel(){
        tablepanel=new TablePanel();
        searchPnel=new SearchPnel();
        menuPanel=new SudeMenuPanel("Chercher","Ajouter","Supprimer","Modifier");
        Font logoFont=new Font("Optima",Font.BOLD,15);
        header=new HeaderPanel(Color.WHITE,"agence",Color.black,logoFont,"Menu",Color.BLACK,logoFont);
        initAction();
    }
    private  void initContainer(){
        initpanel();
        container=getContentPane();
        container.setLayout(new BorderLayout());
      //  container.add(searchPnel,BorderLayout.NORTH);
        container.add(tablepanel,BorderLayout.CENTER);
        container.add(menuPanel,BorderLayout.WEST);
        container.add(header,BorderLayout.NORTH);
    }
    private  void initAction()
    {
    var buttons= menuPanel.getButtons();
//hadchi li ghadi ndiro c'est la fct lamda
    buttons.get("Ajouter").addActionListener(event ->{
        System.out.println("btn Ajouter cliqué");
    });
        buttons.get("Chercher").addActionListener(event ->{
            System.out.println("btn chercher cliqué");
        });
        buttons.get("Supprimer").addActionListener(event ->{
            System.out.println("btn Supprimer cliqué");
        });
        buttons.get("Modifier").addActionListener(event ->{
            System.out.println("btn Modifier cliqué");
        });


        buttons.get("Ajouter").addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent e) {
                  buttons.get("Ajouter").setForeground(Color.RED);
                  buttons.get("Ajouter").setFont(new Font("Optima",Font.ITALIC,20));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttons.get("Ajouter").setForeground(Color.BLUE);
                buttons.get("Ajouter").setFont(new Font("Optima",Font.BOLD,18));
            }
        });

    }

    public MyFrame(String title){
        initContainer();
        setTitle(title);
        setLocation(0,0);
        setSize(screenSize.width,screenSize.height-90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
