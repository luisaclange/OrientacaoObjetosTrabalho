/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.model;

import br.com.sistema.dao.ClientesDAO;
import java.util.List;

/**
 *
 * @author Tampelini
 */
public class Clientes {
    
    //Atributos
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;
    private String celular;
    private String cep;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;   
 
    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public boolean equalsCpf(String CPF){//verifica se ja existe pessoas com esse cpf
        
        ClientesDAO dao = new ClientesDAO();//cria conexão com o banco de dados
        List<Clientes> lista = dao.listarClientes();// cria lista dos clientes 
        for (Clientes c : lista) {//percorre a lista
            if(CPF.equals(c.getCpf())){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
    public boolean equalsCpfId(String CPF, int id){//verifica se ja existe pessoas com esse cpf
        
        ClientesDAO dao = new ClientesDAO();//cria conexão com o banco de dados
        List<Clientes> lista = dao.listarClientes();// cria lista dos clientes 
        for (Clientes c : lista) {//percorre a lista
            if(CPF.equals(c.getCpf()) && id != c.getId() ){ //se encontrar o mesmo cpf retorna true
                return true;
            }
        } return false;       
    }
    
    
}
