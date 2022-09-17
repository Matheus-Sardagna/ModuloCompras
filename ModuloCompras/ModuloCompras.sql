create database moduloCompra;

use moduloCompra;

create table pessoa(
  id bigint not null auto_increment primary key,
  nome varchar(50) not null,
  sobrenome varchar(200) not null,
  telefone varchar(20) not null,
  cpf varchar(11) not null,
  login varchar(100) not null,
  senha varchar(100) not null,
  ativo bit(1) not null default b'1'
);

ALTER TABLE pessoa ADD CONSTRAINT pessoa_un UNIQUE KEY (login);

create table empresa(
  id bigint not null auto_increment primary key,
  razao_social varchar(200) not null,
  cnpj varchar(14) not null,
  endereco varchar(255) not null,
  fornecedor bit(1) not null default b'0',
  id_gerente bigint not null, 
  foreign key (id_gerente) references pessoa(id)
);

create table funcionario_empresa(
  id bigint not null auto_increment primary key,
  id_empresa bigint not null,
  id_pessoa bigint not null,
  ativo bit(1) not null default b'1',
  foreign key (id_pessoa) references pessoa(id),
  foreign key (id_empresa) references empresa(id)
);

create table fornecedores_empresa(
  id bigint not null auto_increment primary key,
  ativo bit(1) not null default b'1',
  id_empresa bigint not null,
  id_fornecedor bigint not null,
  foreign key (id_empresa) references empresa(id),
  foreign key (id_fornecedor) references empresa(id)
);

create table item(
  id bigint not null auto_increment primary key,
  descricao varchar(200) not null,
  ativo bit(1) not null default b'1',
  id_empresa bigint not null,
  foreign key (id_empresa) references empresa(id)
);

create table orcamento(
  id bigint not null auto_increment primary key,
  descricao varchar(250) not null,
  id_empresa bigint not null,
  foreign key (id_empresa) references empresa(id)
);

create table orcamento_item(
  id bigint not null auto_increment primary key,
  valor_maximo decimal(8,6) not null,
  id_orcamento bigint not null,
  id_item bigint not null,
  foreign key (id_orcamento) references orcamento(id),
  foreign key (id_item) references item(id)
);

create table ordem_compra(
  id bigint not null auto_increment primary key,
  id_empresa bigint not null,
  id_orcamento bigint not null,
  foreign key (id_empresa) references empresa(id),
  foreign key (id_orcamento) references orcamento(id)
);

create table ordem_compra_item(
  id bigint not null auto_increment primary key,
  quantidade int not null,
  id_ordem_compra bigint not null,
  id_item bigint not null,
  foreign key (id_ordem_compra) references ordem_compra(id),
  foreign key (id_item) references item(id)
);

create table ordem_compra_item_cotacao(
  id bigint not null auto_increment primary key,
  valor decimal(8,6) not null,
  escolhida bit(1) not null default b'0',
  id_ordem_compra_item bigint not null,
  id_fornecedor bigint not null,
  foreign key (id_ordem_compra_item) references ordem_compra_item(id),
  foreign key (id_fornecedor) references empresa(id)
);



