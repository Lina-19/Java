package metier.Forms;

public class FormException  extends  Exception{
    String formName,fielName;
    public FormException(){super("Erreur dans le formulaire");}
    public FormException(String errormsg){super(errormsg);}
    public FormException(String formName,String fielName,String errormsg){
        super(errormsg);
        this.fielName=fielName;
        this.formName=formName;
    }
    public FormException(String formName,String fielName){
        this.fielName=fielName;
        this.formName=formName;
    }
}
