/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Feedback;
import br.com.sistema.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tampelini
 */
public class FeedbackDAO {

    private Connection con;

    public FeedbackDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrarFornecedores
    public void cadastrarFeedback(Feedback obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_feedback (data_feedback,descricao,cliente_id) "
                    + " values (?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getData_feedback());
            stmt.setString(2, obj.getDescricao());
            stmt.setInt(3, obj.getCliente().getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //metodo excluir fornecedor
    public void excluirFeedback(Feedback obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_feedback where cliente_id = ?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //metodo alterarFornecedor
    public void alterarFeedback(Feedback obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_feedback set cliente_id=?, data_feedback=?, descricao=? where id =?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
        
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_feedback());
            stmt.setString(3, obj.getDescricao());
            stmt.setInt(4, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }
    
    //Metodo listarFornecedores
     public List<Feedback> listarFeedbacks() {
        try {

            //1 passo criar a lista
            List<Feedback> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select date_format(f.data_feedback,'%d/%m/%Y') as data_formatada, c.id, c.nome, c.telefone, c.email, f.descricao from tb_feedback as f"
                    +" inner join tb_clientes as c on (f.cliente_id = c.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Feedback obj = new Feedback();
                Clientes c = new Clientes();
                
                c.setId(rs.getInt("c.id"));
                c.setNome(rs.getString("c.nome"));
                c.setTelefone(rs.getString("c.telefone"));
                c.setEmail(rs.getString("c.email"));
                obj.setData_feedback(rs.getString("data_formatada"));
                obj.setDescricao(rs.getString("f.descricao"));
                obj.setCliente(c);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
     
     //Metodo listarFornecedores
     public List<Feedback> listarFeedbacksPorNome(String nome) {
        try {

            //1 passo criar a lista
            List<Feedback> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select date_format(f.data_id,'%d/%m/%Y') as data_formatada, c.id, f.id, c.nome, c.telefone, c.email, f.descricao from tb_feedback as f"
                    +" inner join tb_clientes as c on (f.cliente_id = c.id) where c.nome like "+nome+";";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Feedback obj = new Feedback();
                Clientes c = new Clientes();
                
                c.setId(rs.getInt("c.id"));
                c.setNome(rs.getString("c.nome"));
                c.setTelefone(rs.getString("c.telefone"));
                c.setEmail(rs.getString("c.email"));
                obj.setId(rs.getInt("f.id"));
                obj.setData_feedback(rs.getString("data_formatada"));
                obj.setDescricao(rs.getString("f.descricao"));
                obj.setCliente(c);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

      //Metodo listarFornecedores
     public List<Clientes> listarNomes(String nome) {
        try {

            //1 passo criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select nome from tb_clientes where nome like ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();
                
                c.setNome(rs.getString("nome"));

                lista.add(c);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
}
