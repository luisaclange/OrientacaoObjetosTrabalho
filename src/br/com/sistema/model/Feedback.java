/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistema.model;

/**
 *
 * @author Alunos
 */
public class Feedback {

    private int id;
    private Clientes cliente;
    private String descricao;
    private String data_feedback;
    
    //Métodos get
    public int getId() {
        return id;
    }
    
    public Clientes getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_feedback() {
        return data_feedback;
    }
    
    //Métodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setDescricao(String descricao_id) {
        this.descricao = descricao_id;
    }

    public void setData_feedback(String data_id) {
        this.data_feedback = data_id;
    }
    
}
