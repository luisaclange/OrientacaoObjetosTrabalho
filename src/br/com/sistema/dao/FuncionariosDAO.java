/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;

import br.com.sistema.model.Funcionarios;
import br.com.sistema.view.FrmLogin;
import br.com.sistema.view.FrmMenu;
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
public class FuncionariosDAO {

    //Conexao
    private Connection con;

    public FuncionariosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrar Funcionario
    public void cadastrarFuncionarios(Funcionarios obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo Alterar Funcionario
    public void alterarFuncionario(Funcionarios obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update tb_funcionarios  set  nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso =?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());

            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());

            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.setInt(17, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    //Metodo Excluir Funcionario
    public void excluirFuncionario(Funcionarios obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from tb_funcionarios  where id = ?";

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

    //Metodo Listar Todos Funcionarios
    public List<Funcionarios> listarFuncionarios() {
        try {

            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if(rs.getString("nome").equals("ADMINISTRADOR")){
                    break;
                }
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

    //metodo consultaCliente  por Nome
    public Funcionarios consultaPorNome(String nome) {
        try {
            //1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios  where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            return null;
        }
    }

    //Metodo listaFuncionarioPorNome - retorna uma lista
    public List<Funcionarios> listarFuncionariosPorNome(String nome) {
        try {

            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if(rs.getString("nome").equals("ADMINISTRADOR")){
                    break;
                }
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

    //Metodo efetuaLogin
    public boolean efetuaLogin(String email, String senha ) {
        try {

            //1 passo - SQL
            String sql = "select * from tb_funcionarios where email = ? and senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //Usuario logou

                //Caso o usuario seja do tipo admin
                if (rs.getString("nivel_acesso").equals("Administrador")) {

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela = new FrmMenu();
                    tela.setUsuarioLogado(rs.getString("nome"));
                    
                    tela.setVisible(true);  
                    return true;
                } 

//Caso o usuario seja do tipo limitado 
                else if (rs.getString("nivel_acesso").equals("Usuário")) {
                    
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema");
                    FrmMenu tela = new FrmMenu();
                    tela.setUsuarioLogado(rs.getString("nome"));
                    
                    //Desabilitar os menus /duvida
                    //tela.menu_posicao.setEnabled(false);
                    //tela.menu_controlevendas.setVisible(false);
                   
                    tela.setVisible(true);
                    return true;
                }

            } else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                //new FrmLogin().setVisible(true);
                return false;
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro : " + erro);
        }
        return false;
    }

    public void esqueciMinhaSenha(){
        try{
            String sql = "select senha from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "ADMINISTRADOR");
            
            ResultSet rs = stmt.executeQuery();
            
            String senha = null;
            while(rs.next()){
                 senha = rs.getString("senha");
            }

            String senhaAdm = JOptionPane.showInputDialog("Digite a senha do administrador para alterar o cadastro\n"
                                                                + "Login: admin@email.com");
            
            if(senhaAdm.equals(senha)){
                EmailCheck();
            }else{
                JOptionPane.showMessageDialog(null,"Senha incorreta");
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            //      return null;
        }
    }
    
    private void EmailCheck(){
        try{
            String email = JOptionPane.showInputDialog("Digite seu e-mail");

            String sql = "select email from tb_funcionarios where email like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            String emailCheck = null;
            while(rs.next()){
                emailCheck = rs.getString("email");
            }

            if(email.equals(emailCheck)){
                
                TrocaSenha(email);
                                
            }else{
                JOptionPane.showMessageDialog(null, "E-mail não cadastrado");
            }

        }catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            //      return null;
        }
    }
    
    private void TrocaSenha(String email){
        try{
            String novaSenha = JOptionPane.showInputDialog("Digite a nova senha");
                
            String sql = "update tb_funcionarios set senha = ? where email like ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, novaSenha);
            stmt.setString(2, email);

            JOptionPane.showMessageDialog(null, "Senha cadastrada com sucesso");
            
            stmt.execute();
            stmt.close();
                
        }catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            // return null;
        }
    }    

}
