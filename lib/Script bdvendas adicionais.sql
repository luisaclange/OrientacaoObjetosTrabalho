/* USAR ESTE SCRIPT PARA ADICINAR FUNCIONALIDADES, CADASTROS E 
   AFINS NO BANDO DE DADOS PARA FACILITAR O SISTEMA DE VENDAS  */

use bdvendas;

insert into tb_funcionarios (nome,email,senha,nivel_acesso) 
values ("ADMINISTRADOR","admin@email.com","123","Administrador");

select * from tb_funcionarios where nome like "ADMINISTRADOR";

insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)
values ("Lucas V","124274265","04681895997","lucasvm01@gmail.com","123","Dev","Administrador","41991299119","41991010601","82820120",
"Rua Heitor Baggio Vidal",2678,"","Bairro Alto","Curitiba","PR");

/*
insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)
values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);

insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)
values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);
*/