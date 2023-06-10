-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');


insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

insert into municipio (nome, id_estado) values( 'Palmas', 1);
insert into municipio (nome, id_estado) values( 'Paraiso do Tocantins', 1);

-------------------

insert into pessoa (nome) values('Goku');
insert into pessoa (nome) values('Fredson');

insert into pessoafisica(id, cpf, sexo) values (1, '111.111.111-11', 1);
insert into pessoafisica(id, cpf) values (2, '222.222.222-22');

insert into usuario (login, senha, id_pessoa_fisica) values('goku', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1);
insert into usuario (login, senha, id_pessoa_fisica) values('fredson', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2);

insert into perfis (id_usuario, perfil) values (1, 'Admin');
insert into perfis (id_usuario, perfil) values (1, 'User');
insert into perfis (id_usuario, perfil) values (2, 'User');


insert into telefone(codigoArea, numero) values ('63', '9999988888');
insert into telefone(codigoArea, numero) values ('63', '977774444');

-------------------------------

insert into endereco(id_usuario, principal, logradouro, bairro, cep, numero, complemento) values (1, 'TRUE', 'rua ficticia 1', 'Algum lugar', '77222-333', '1', 'Lugar tal');
insert into endereco(id_usuario, principal, logradouro, bairro, cep, numero, complemento) values (2, 'TRUE', 'rua ficticia 2', 'Lugar Algum', '77544-777', '2', 'ficticio');

-----------------------------------

insert into editora(nome) values('DC Comics');
insert into editora(nome) values('Marvel Comics');
insert into editora(nome) values('Image Comics');
insert into editora(nome) values('Panini Comics');

insert into autor(nome, bio) values('Fulano', 'Escritor e ilustrador');
insert into autor(nome, bio) values('Cicrano', 'Escritor de ficção');
insert into autor(nome, bio) values('Joao', 'Escritor de romance');
insert into autor(nome, bio) values('Ellen', 'Escritora de horror');

insert into quadrinho(nome, id_editora, estoque, quantPaginas, preco, descricao, idioma, encadernacao, id_autor) values
('Quadrinho 1', 1, 50, 200, 50, 'A historia de um valente...', 'PT-BR', 1, 1);

insert into quadrinho(nome, id_editora, estoque, quantPaginas, preco, descricao, idioma, encadernacao, id_autor) values
('Quadrinho 2', 2, 100, 100, 32, 'A jornada de tal...', 'PT-BR', 2, 2);

insert into quadrinho(nome, id_editora, estoque, quantPaginas, preco, descricao, idioma, encadernacao, id_autor) values
('Quadrinho 3', 4, 60, 400, 150, 'A comovente historia de...', 'PT-BR', 1, 3);

insert into quadrinho(nome, id_editora, estoque, quantPaginas, preco, descricao, idioma, encadernacao, id_autor) values
('Quadrinho 4', 3, 20, 90, 20, 'Ninguem está seguro quando...', 'PT-BR', 2, 4);

--------

insert into lista_produtos(id_usuario, id_produto) values(1, 1);

insert into itemcompra(quant, totalItem, idComprado, id_usuario, id_produto) values (5, 12.50, true , 2, 1);
insert into itemcompra(quant, totalItem, idComprado, id_usuario, id_produto) values (5, 12.50, false , 2, 2);

insert into formapagamento(valor, confirmacaoPagamento, dataConfirmacaoPagamento) values(5, 'TRUE', NOW());
insert into cartaocredito(id, numeroCartao, nomeCartao, bandeiraCartao, cpftitular) values(1, '7775-44433-2233-4433', 'Fulano de tal', 5, '473.443.555-94');

insert into compra(totalCompra, id_usuario, id_pagamento) values(5, 1, 1);