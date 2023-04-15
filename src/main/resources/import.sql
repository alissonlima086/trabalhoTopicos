-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

-- insert into autor (id, nome) values(1, 'Stjepan Sejic');
-- insert into autor(id, nome) values(2, 'Darwyn Cooke');
--insert into autor(id, nome) values(3, 'Sean Murphy')


insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas) values(1, 1, 20, 'Harleen', 'Harleen #1-3', 'Ingles', 171, 208);
insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas) values(2, 1, 50, 'A Nova Fronteira', 'DC A Nova Fronteira edição definitiva', 'Portugues', 150, 526);
insert into quadrinho (id, encadernacao, estoque, nome, descricao, idioma, preco, quantpaginas) values(3, 2, 10, 'Batman White Knight', 'Batman White Knight #1-8', 'Ingles', 100, 250);