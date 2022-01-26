/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.model;

import br.com.sistema.dao.FuncionariosDAO;
import java.util.List;

/**
 *
 * @author Tampelini
 */
public class Funcionarios extends Clientes {
    
    //Atributos
    private String senha;
    private String cargo;
    private String nivel_acesso;
    
    //Getters e Setters
    public String getSenha() {
        return senha;
    }
    
     public String getSenhaCriptografada() { 
         return "*****";
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
    
    @Override
    public boolean equalsCpf(String CPF){//verifica se ja existe pessoas com esse cpf
        
        FuncionariosDAO dao = new FuncionariosDAO();//cria conexão com o banco de dados
        List<Funcionarios> lista = dao.listarFuncionarios();// cria lista dos clientes 
        for (Funcionarios c : lista) {//percorre a lista
            if(CPF.equals(c.getCpf())){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
    public boolean equalsCpfId(String CPF, int id){//verifica se ja existe pessoas com esse cpf
        
       FuncionariosDAO dao = new FuncionariosDAO();//cria conexão com o banco de dados
        List<Funcionarios> lista = dao.listarFuncionarios();// cria lista dos clientes 
        for (Funcionarios c : lista) {//percorre a lista
            if(CPF.equals(c.getCpf()) && id != c.getId() ){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
}
