insert into empresa (id, nome) select 1, 'BAHIAGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'BAHIAGÁS');

insert into empresa (id, nome) select 2, 'ALGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'ALGÁS');

insert into empresa (id, nome) select 3, 'Mitsui' 
where NOT EXISTS ( select id from empresa where nome like 'Mitsui');

insert into empresa (id, nome) select 4, 'CEGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'CEGÁS');

insert into empresa (id, nome) select 5, 'COMPAGAS' 
where NOT EXISTS ( select id from empresa where nome like 'COMPAGAS');

insert into empresa (id, nome) select 6, 'COPERGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'COPERGÁS');

insert into empresa (id, nome) select 7, 'PBGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'PBGÁS');

insert into empresa (id, nome) select 8, 'SCGÁS' 
where NOT EXISTS ( select id from empresa where nome like 'SCGÁS');

insert into empresa (id, nome) select 9, 'SERGAS' 
where NOT EXISTS ( select id from empresa where nome like 'SERGAS');

insert into papel (id, descricao) select 1, 'Administrador' 
where NOT EXISTS ( select id from papel where descricao like 'Administrador');

insert into papel (id, descricao) select 2, 'Operador' 
where NOT EXISTS ( select id from papel where descricao like 'Operador');

insert into usuario (id, nome, email, cpf, senha, papel_id, empresa_id, ativo) 
	select nextval('user_id_seq'), 'Administrador', 'pcpgas.mitsui@gmail.com', '466.761.274-66', 
	'$2a$10$FtDQels4VQlT9wU9mO1opucW0mQSNqohfwKKuZ7H642vcDszvBAl6', 1, 3, TRUE
where NOT EXISTS ( select id from usuario 
	where email like 'pcpgas.mitsui@gmail.com');

insert into sugestao_tipo (id, descricao) select 1, 'Inclusão de conta' where NOT EXISTS ( select id from sugestao_tipo where descricao like 'Inclusão de conta');
insert into sugestao_tipo (id, descricao) select 2, 'Alteração de conta' where NOT EXISTS (select id from sugestao_tipo where descricao like 'Alteração de conta');
insert into sugestao_tipo (id, descricao) select 3, 'Exclusão de conta' where NOT EXISTS (select id from sugestao_tipo where descricao like 'Exclusão de conta');
insert into sugestao_status (id, descricao) select 1, 'Pendente de Análise' where NOT EXISTS (select id from sugestao_status where descricao like 'Pendente de Análise');
insert into sugestao_status (id, descricao) select 2, 'Aprovada' where NOT EXISTS (select id from sugestao_status where descricao like 'Aprovada');
insert into sugestao_status (id, descricao) select 3, 'Rejeitada' where NOT EXISTS (select id from sugestao_status where descricao like 'Rejeitada');


commit;
