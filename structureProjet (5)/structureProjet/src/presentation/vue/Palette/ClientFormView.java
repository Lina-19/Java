package presentation.vue.Palette;
import presentation.controleur.ServiceAdmin;
import presentation.modele.Sexe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientFormView extends JFrame implements ActionListener {
    private Container myViewContainer;
    private JPanel titlePanel, formPanle,buttonsPanel;
    private JComboBox comboBox;
    private JButton btn_effacer,btn_cancel,btn_ajouter;
    private JLabel lbl_title,lbl_login ,lbl_pass,lbl_Nom,lbl_Prenom,lbl_Confirmation,lbl_CIN,lbl_Email,lbl_Tel,lbl_Sexe,lbl_IdAgence;
    private JTextField txt_login,txt_Nom,txt_Prenom,txt_CIN,txt_Email,txt_Tel,txt_Sexe,txt_IdAgence;
    private JPasswordField txt_pass,txt_Confirmation;


    private void initCombo(){

        comboBox=new JComboBox(Sexe.values());
        comboBox.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        comboBox.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre

    }
    private void initButton(){
        //---------------Boutton Login-------------------//
        //initiamisation du boutton effacer
        btn_effacer =new JButton("Retour");
        // personaliser du boutton
        btn_effacer.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du button
        btn_effacer.setForeground(new Color(105,59,105,255));
        //alligner le boutton au centre
        btn_effacer.setHorizontalAlignment(JButton.CENTER);
        btn_effacer.setBorderPainted(false);
        btn_effacer.addActionListener(this);


        btn_ajouter =new JButton("Ajouter");
        // personaliser du boutton login
        btn_ajouter.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du button
        btn_ajouter.setForeground(new Color(105,59,105,255));
        //alligner le boutton au centre
        btn_ajouter.setHorizontalAlignment(JButton.CENTER);
        btn_ajouter.setBorderPainted(false);
        btn_ajouter.addActionListener(this);




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
        lbl_title =new JLabel("Formulaire Client");
        // personaliser du label titre
        lbl_title.setFont(new Font("Optima",Font.BOLD,30));
        //modification de la couleur du texte
        lbl_title.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_title.setHorizontalAlignment(JLabel.CENTER);
        //ajouter un icon
        //lbl_title.setIcon(new ImageIcon(""));





        lbl_Nom=new JLabel("Nom");
        lbl_Nom.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Nom.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Nom.setHorizontalAlignment(JLabel.LEFT);


        lbl_Prenom=new JLabel("Prenom");
        lbl_Prenom.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Prenom.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Prenom.setHorizontalAlignment(JLabel.LEFT);





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

        lbl_Confirmation=new JLabel("Confirmation du mot de passe");
        lbl_Confirmation.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Confirmation.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Confirmation.setHorizontalAlignment(JLabel.LEFT);


        lbl_CIN=new JLabel("CIN");
        lbl_CIN.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_CIN.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_CIN.setHorizontalAlignment(JLabel.LEFT);

        lbl_Email=new JLabel("Email");
        lbl_Email.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Email.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Email.setHorizontalAlignment(JLabel.LEFT);

        lbl_Tel=new JLabel("Telephone");
        lbl_Tel.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Tel.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Tel.setHorizontalAlignment(JLabel.LEFT);


        lbl_Sexe=new JLabel("Sexe");
        lbl_Sexe.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        lbl_Sexe.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        lbl_Sexe.setHorizontalAlignment(JLabel.LEFT);



    }
    private void initTextField(){
        txt_Nom =new JTextField("");
        // personaliser du label titre
        txt_Nom.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_Nom.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_Nom.setHorizontalAlignment(JLabel.CENTER);

        txt_Prenom =new JTextField("");
        // personaliser du label titre
        txt_Prenom.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_Prenom.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_Prenom.setHorizontalAlignment(JLabel.CENTER);

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


        txt_Confirmation =new JPasswordField("");
        // personaliser du label titre
        txt_Confirmation.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_Confirmation.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_Confirmation.setHorizontalAlignment(JLabel.CENTER);

        txt_CIN =new JPasswordField("");
        // personaliser du label titre
        txt_CIN.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_CIN.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_CIN.setHorizontalAlignment(JLabel.CENTER);

        txt_Email =new JTextField("");
        // personaliser du label titre
        txt_Email.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_Email.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_Email.setHorizontalAlignment(JLabel.CENTER);

        txt_Tel =new JTextField("");
        // personaliser du label titre
        txt_Tel.setFont(new Font("Optima",Font.BOLD,17));
        //modification de la couleur du texte
        txt_Tel.setForeground(new Color(105,59,105,255));
        //alligner le texte au centre
        txt_Tel.setHorizontalAlignment(JLabel.CENTER);



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
        westPanel.setLayout(new GridLayout(9,1,5,5));
        westPanel.setBorder(new EmptyBorder(0,0,0,20));
        westPanel.add(lbl_Nom);
        westPanel.add(lbl_Prenom);
        westPanel.add(lbl_login);
        westPanel.add(lbl_pass);
        westPanel.add(lbl_Confirmation);
        westPanel.add(lbl_CIN);
        westPanel.add(lbl_Email);
        westPanel.add(lbl_Tel);
        initCombo();
        westPanel.add(lbl_Sexe);


        JPanel centrepanel=new JPanel();
        centrepanel.setBackground(new Color(255,255,255,255));
        centrepanel.setLayout(new GridLayout(9,1,5,5));
        centrepanel.add(txt_Nom);
        centrepanel.add(txt_Prenom);
        centrepanel.add(txt_login);
        centrepanel.add(txt_pass);
        centrepanel.add(txt_Confirmation);
        centrepanel.add(txt_CIN);
        centrepanel.add(txt_Email);
        centrepanel.add(txt_Tel);
        centrepanel.add(comboBox);
        formPanle.add(westPanel,BorderLayout.WEST);
        formPanle.add(centrepanel,BorderLayout.CENTER);
        initButton();
        buttonsPanel = new JPanel();
        //changer la couleur du fond de monpanneau
        buttonsPanel.setBackground(new Color(202,211,242,105));
        //ajouter un panding(10,0,10,0)
        buttonsPanel.setBorder(new EmptyBorder(10,0,10,0));
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsPanel.add(btn_ajouter);
        buttonsPanel.add(btn_effacer);
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
    public ClientFormView(){
        //inisiatilisation du conteneur principale
        initContainer();
        //titre

        //dimension
        setSize(800,800);
        //la mettre au milieu
        setLocationRelativeTo(null);
        //fermer appli en fermant la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fixer la taille de la fenetre
        setResizable(false);
        //rendre la fenetre visible
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_ajouter){
            String nom=txt_Nom.getText();
            String prenom=txt_Prenom.getText();
            String login=txt_login.getText();
            String pass=txt_pass.getText();
            String confirm=txt_Confirmation.getText();
            String email=txt_Email.getText();
            String tel=txt_Tel.getText();
            String cin=txt_CIN.getText();
            Sexe sexe= (Sexe) comboBox.getSelectedItem();
            ServiceAdmin sa=new ServiceAdmin();
            try {
                sa.nouveauClient(login,pass,nom,prenom,email,cin,tel,sexe);
                new ClientFrame();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("client ajouté");
        }
if(e.getSource()==btn_effacer){

}
    }
}
