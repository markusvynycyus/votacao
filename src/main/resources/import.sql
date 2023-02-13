insert into pauta(id,descricao) values (1,'pauta teste1');
insert into pauta(id,descricao) values (2,'pauta teste2');
insert into pauta(id,descricao) values (3,'pauta teste3');
insert into pauta(id,descricao) values (4,'pauta teste4');



insert into associado(id,nome,cpf) values(1,'João','111');
insert into associado(id,nome,cpf) values (2,'Maria','222');



insert into sessao_votacao(id,data_abertura,data_fechamento,pauta_id)values (1,'2022-02-10 21:10:00','2022-02-11 21:10:00',1);
insert into sessao_votacao(id,data_abertura,data_fechamento,pauta_id)values (2,'2022-02-11 21:10:00','2022-02-12 21:10:00',2);

insert into voto(id,opcao_voto,associado_id,sessao_votacao_id) values (1,'true',1,1);
