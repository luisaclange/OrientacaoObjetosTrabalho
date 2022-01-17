/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.model;

import br.com.sistema.dao.ClientesDAO;
import br.com.sistema.dao.FornecedoresDAO;
import java.util.List;

/**
 *
 * @author Tampelini
 */
public class Fornecedores extends  Clientes {
    
    //atributos
    private String cnpj;    
    
    //getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    @Override
    public String toString(){
        return this.getNome();        
    }
    public boolean equalsCnpj(String CNPJ){//verifica se ja existe pessoas com esse cpf
        
        FornecedoresDAO dao = new FornecedoresDAO();//cria conexão com o banco de dados
        List<Fornecedores> lista = dao.listarFornecedores();// cria lista dos clientes 
        for (Fornecedores c : lista) {//percorre a lista
            if(CNPJ.equals(c.getCnpj())){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
    public boolean equalsCnpjIn(String CNPJ, int id){//verifica se ja existe pessoas com esse cpf
        
        FornecedoresDAO dao = new FornecedoresDAO();//cria conexão com o banco de dados
        List<Fornecedores> lista = dao.listarFornecedores();// cria lista dos clientes 
        for (Fornecedores c : lista) {//percorre a lista
            if(CNPJ.equals(c.getCnpj()) && id != c.getId()){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
    
}
