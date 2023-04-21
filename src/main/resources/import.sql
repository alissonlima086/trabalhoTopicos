-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

insert into autor (id, nome, bio, cpf) values(1, 'Stjepan Sejic', 'Escritor e ilustrador', '22233344455');
insert into autor(id, nome, bio, cpf) values(2, 'Darwyn Cooke', 'Escritor e ilustrador', '22222222222');
insert into autor(id, nome, bio, cpf) values(3, 'Sean Murphy','Escritor e ilustrador', '11111111111');
insert into autor(id, nome, bio, cpf) values(4, 'Alan Moore','Escritor e mago', '44444444444');


insert into ilustrador(id, nome, bio, cpf) values(1, 'Jorge Jimenez', 'Ilustrador de quadrinhos', '11122233344');
insert into ilustrador(id, nome, bio, cpf) values(2, 'Sweeney Boo', 'Ilustradora de quadrinhos', '22233344444');
insert into ilustrador(id, nome, bio, cpf) values(3, 'Dave Gibbons', 'Ilustrador de quadrinhos', '99988877766');
insert into ilustrador(id, nome, bio, cpf) values(4, 'Sean Murphy', 'Escritor e Ilustrador', '11111111111');
insert into ilustrador(id, nome, bio, cpf) values(5, 'Stjepan Sejic', 'Escritor e ilustrador', '22233344455');
insert into ilustrador(id, nome, bio, cpf) values(6, 'Darwyn Cooke', 'Escritor e ilustrador', '22222222222');

insert into editora(id, nome) values(1, 'DC Comics');
insert into editora(id, nome) values(2, 'Marvel Comics');
insert into editora(id, nome) values(3, 'Image Comics');
insert into editora(id, nome) values(4, 'Panini Comics');

insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas, id_autor, id_ilustrador, id_editora) values(1, 1, 20, 'Harleen', 'Harleen #1-3', 'Ingles', 171, 208, 1, 5, 1);
insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas, id_autor, id_ilustrador, id_editora) values(2, 1, 50, 'A Nova Fronteira', 'DC A Nova Fronteira edição definitiva', 'Portugues', 150, 526, 2, 6, 4);
insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas, id_autor, id_ilustrador, id_editora) values(3, 2, 10, 'Batman White Knight', 'Batman White Knight #1-8', 'Ingles', 100, 224, 3, 4, 1);
insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas, id_autor, id_ilustrador, id_editora) values(4, 1, 20, 'Watchmen', 'Watchmen #1-12', 'Portugues', 150, 460, 4, 3, 4);

insert into estado(id, nome, sigla) values(1, 'Tocantins', 'TO');
insert into estado(id, nome, sigla) values(2, 'Sao Paulo', 'SP');
insert into estado(id, nome, sigla) values(3, 'Pará', 'PA');
insert into estado(id, nome, sigla) values(4, 'Bahia', 'BA');

insert into municipio(id, nome, id_estado) values(1, 'Palmas', 1);
insert into municipio(id, nome, id_estado) values(2, 'Caraguatatuba', 2);
insert into municipio(id, nome, id_estado) values(3, 'Araguaina', 1);

insert into usuario(id, nome, cpf, email, senha) values(1, 'Kazuma', '88822233345', 'kazzy@mail.com', '12345678');
insert into usuario(id, nome, cpf, email, senha) values(2, 'Luan', '66647383930', 'pluan@mail.com', '360486ga');

-- insert into endereco(id, isprincipal, logradouro, bairro, numero, complemento, estado, municipio, id_usuario) values(1, true, 'rua tal, quadra tal, lote ficticio', 2, 2, 2);

