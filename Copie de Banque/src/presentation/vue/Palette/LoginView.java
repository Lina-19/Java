package presentation.vue.Palette;
import presentation.controleur.Auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {
    private Container myViewContainer;
    private JPanel titlePanel, formPanle,buttonsPanel;

    private JButton btn_login,btn_cancel;
    private JLabel lbl_title,lbl_login ,lbl_pass;
    private JTextField txt_login;
    private JPasswordField txt_pass;

    private void initButton(){
        //---------------Boutton Login-------------------//
        //initiamisation du boutton login
        btn_login =new JButton("Connecter");
        // personaliser du boutton login
        btn_login.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du button
        btn_login.setForeground(new Color(105,59,105,255));
        //alligner le boutton au centre
        btn_login.setHorizontalAlignment(JButton.CENTER);
        btn_login.setBorderPainted(false);
        btn_login.addActionListener(this);

        //ajouter un icon
        //lbl_title.setIcon(new ImageIcon(""));
        //---------------Boutton cancel-------------------//
        //initiamisation du boutton
        btn_cancel =new JButton("Annuler");
        // personaliser du boutton
        btn_cancel.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du button
        btn_cancel.setForeground(new Color(105,59,105,255));
        //alligner le boutton au centre
        btn_cancel.setHorizontalAlignment(JButton.CENTER);
        btn_cancel.setBorderPainted(false);
        btn_cancel.addActionListener(this);
    }
    private void initLabel(){
        //---------------titre-------------------//
        //initiamisation du label titre
        lbl_title =new JLabel("CONNEXION");
        // personaliser du label titre
        lbl_title.setFont(new Font("Optima",Font.BOLD,30));
        //modification de la couleur du texte
        lbl_title.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_title.setHorizontalAlignment(JLabel.CENTER);
        //ajouter un icon
        //lbl_title.setIcon(new ImageIcon(""));

        lbl_login=new JLabel("Username");
        lbl_login.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_login.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_login.setHorizontalAlignment(JLabel.LEFT);

        lbl_pass=new JLabel("PASSWORD");
        lbl_pass.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_pass.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_pass.setHorizontalAlignment(JLabel.LEFT);
    }
    private void initTextField(){

        txt_login =new JTextField("");
        // personaliser du label titre
        txt_login.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_login.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_login.setHorizontalAlignment(JLabel.CENTER);

        txt_pass =new JPasswordField("");
        // personaliser du label titre
        txt_pass.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_pass.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_pass.setHorizontalAlignment(JLabel.CENTER);
    }
    private void initPanel(){
        initLabel();
        //-------Panneau titre--------//
        titlePanel =new JPanel();
        //changer la couleur du fond de monpanneau
        titlePanel.setBackground(new Color(202,211,242,105));
        //ajouter un panding(10,0,10,0)
        titlePanel.setBorder(new EmptyBorder(10,0,10,0));
        //affecter un flowlayot a notre titrepanel pour ajouter les elems sous forme d'un flux horizentale

        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(lbl_title);
        // ----------Pneau du form-------------/
        initTextField();
        formPanle = new JPanel();
        //changer la couleur du fond de monpanneau
        formPanle.setBackground(new Color(255,255,255,255));
        //ajouter un panding(10,0,10,0)
        formPanle.setLayout(new BorderLayout());
        //formPanle.setLayout(new BoxLayout(formPanle,BoxLayout.Y_AXIS));
        formPanle.setBorder(new EmptyBorder(100,40,100,40));
        JPanel westPanel=new JPanel();
        westPanel.setBackground(new Color(255,255,255,255));
        westPanel.setLayout(new GridLayout(2,1,5,5));
        westPanel.setBorder(new EmptyBorder(0,0,0,20));
        westPanel.add(lbl_login);
        westPanel.add(lbl_pass);


        JPanel centrepanel=new JPanel();
        centrepanel.setBackground(new Color(255,255,255,255));
        centrepanel.setLayout(new GridLayout(2,1,5,5));
        centrepanel.add(txt_login);
        centrepanel.add(txt_pass);
        formPanle.add(westPanel,BorderLayout.WEST);
        formPanle.add(centrepanel,BorderLayout.CENTER);
        initButton();
        buttonsPanel = new JPanel();
        //changer la couleur du fond de monpanneau
        buttonsPanel.setBackground(new Color(202,211,242,105));
        //ajouter un panding(10,0,10,0)
        buttonsPanel.setBorder(new EmptyBorder(10,0,10,0));
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(btn_login);
        buttonsPanel.add(btn_cancel);
    }
    private void  initContainer(){
        //attacher (refferencer) notre conteneur de base par l'objet (refference) myViewContainer
        this.myViewContainer=this.getContentPane();
        //personnalisation de notre conteneur
        //affecter un BorderLayout a notre conteneur por le decouper sous forme de bords
        myViewContainer.setLayout(new BorderLayout());
        //ajouter les panneaux au bords correspondants


        initPanel();
        myViewContainer.add(titlePanel,BorderLayout.NORTH);
        myViewContainer.add(formPanle,BorderLayout.CENTER);
        myViewContainer.add(buttonsPanel,BorderLayout.SOUTH);
    }
    public LoginView(String titre){
        //inisiatilisation du conteneur principale
        initContainer();
        //titre
        setTitle(titre);
        //dimension
        setSize(400,500);
        //la mettre au milieu
        setLocationRelativeTo(null);
        //fermer appli en fermant la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fixer la taille de la fenetre
        setResizable(false);
        //rendre la fenetre visible
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginView("Connexion");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Auth loginService=new Auth();
        if(e.getSource()==btn_cancel){
            System.out.println("Au revoir ");
            System.exit(0);
        }  if (e.getSource()==btn_login) {
           new MyFrame("Banque");
            System.out.println("Login ");
        }
    }
}
