package controller;

import model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Neto
 */
@Named("loginController")
@ManagedBean
public class LoginController implements Serializable {
    private Usuario current;
    private UsuarioController controller;
    private String erro = "";
    private FacesContext fc;
    private ExternalContext ec;
    private HttpSession sessao;
    private Usuario userSystem;
    
    public LoginController(){
        current = new Usuario();
        controller = new UsuarioController();
        fc = FacesContext.getCurrentInstance();
        ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(true);
    }
    
    public void login(){   
        try{               
            userSystem = this.controller.getUser(this.current.getNome()); 
            if(userSystem!=null){
                if(current.getSenha().equals(userSystem.getSenha())){                   
                    sessao.setMaxInactiveInterval(100000); //1800000
                    sessao.setAttribute("sys_user", userSystem);                     
                    ec.redirect("consulta/List.xhtml");
                }else{
                    setErro("Usuário e/ou Senha inválidos.");
                }
            }
        } catch(IOException ex){
            System.out.println("error:" + ex.getMessage()); 
            setErro("Ocorreu um erro ao realizar o login.");
        }
    }
    
    public void logout() throws IOException{                
        sessao.setAttribute("sys_user", null);
        ec.redirect("../index.xhtml");
    }
    
    public Usuario getUserSystem(){
        if(userSystem==null){
            userSystem = (Usuario) sessao.getAttribute("sys_user");
        }
        return userSystem;
    }

    public Usuario getUsuario() {
        return current;
    }
    public void setUsuario(Usuario usuario) {
        this.current = usuario;
    }
    public String getErro() {
        return erro;
    }
    public void setErro(String erro) {
        this.erro = erro;
    }  
}
