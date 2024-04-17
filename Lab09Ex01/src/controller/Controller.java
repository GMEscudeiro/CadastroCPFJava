/**
* @author Guilherme Escudeiro
*/

package controller;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import model.Cadastro;
import model.Usuario;
import view.JanelaCadastro;
import view.ProcuraJanela;

public class Controller {
    private JanelaCadastro view;
    private ProcuraJanela procura;
    private Cadastro cadastro;
    
    public Controller(JanelaCadastro view) {
        this.view = view;
        cadastro = new Cadastro();
        procura = new ProcuraJanela(this);
    }
    
    public void controlBtCadastro(){
        String sexo;
        if(view.getMasculinoBt().isSelected()){
            sexo = "Masculino";
        }else{
            sexo = "Feminino";
        }
        String nome = view.getNomeTxt().getText();
        String sobrenome = view.getSobrenomeTxt().getText();
        String cpf = view.getCpfTxt().getText();
        int idade = parseInt(view.getIdadeTxt().getText());
        Usuario user = new Usuario(nome, sobrenome, cpf, sexo, idade);
        cadastro.cadastra(view.getUsuarios(), user);  
    }
    
    public void controlBtExibir(){
        procura.setVisible(true);
    }
    
    public void controlBtProcurar(){
        int user = cadastro.procurar(view.getUsuarios(), procura.getCpfTxt().getText());
        
        if (user == -1){
            procura.getUsuarioTxt().setText("Usuario nao encontrado");
        }else{
            Usuario usuario = view.getUsuarios().get(user);
            procura.getUsuarioTxt().setText("Nome: " + usuario.getNome() + 
                    " Sobrenome: " + usuario.getSobrenome() + " Idade: " + 
                    usuario.getIdade() + " Sexo: " + usuario.getSexo());
        }
    }
}
