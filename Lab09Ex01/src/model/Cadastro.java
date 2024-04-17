/**
* @author Guilherme Escudeiro
*/

package model;

import java.util.ArrayList;

public class Cadastro {
    public void cadastra(ArrayList<Usuario> p, Usuario user){
        p.add(user);
    }
    
    public int procurar(ArrayList<Usuario> p, String cpf){
        for(Usuario u : p){
            if (u.getCpf().equals(cpf)){
                return p.indexOf(u);
            }
        }
        return -1;
    }
}
