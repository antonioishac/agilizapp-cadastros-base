create table tb_pessoa(
    id bigint auto_increment primary key,
    nome                 varchar(150),
    tipo                      char(1),
    site                 varchar(250),
    email                varchar(250),
    cliente                   char(1),
    fornecedor                char(1),
    transportadora            char(1),
    colaborador               char(1),
    contador                  char(1)
);

create table tb_nivel_formacao (
    id bigint auto_increment primary key,
    nome                 varchar(100),
    descricao            varchar(100)
);

create table tb_estado_civil(
    id bigint auto_increment primary key,
    nome                  varchar(50),
    descricao            varchar(250)
);

create table tb_pessoa_fisica(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    id_nivel_formacao             bigint,
    id_estado_civil               bigint,
    cpf                   varchar(11),
    rg                    varchar(20),
    orgao_rg              varchar(20),
    data_emissao                 date,
    data_nascimento              date,
    sexo                      char(1),
    raca                      char(1),
    nacionalidade        varchar(100),
    naturalidade         varchar(100),
    nome_pai             varchar(200),
    nome_mae             varchar(200),
    foreign key(id_pessoa) references tb_pessoa(id),
    foreign key(id_nivel_formacao) references tb_nivel_formacao(id),
    foreign key(id_estado_civil) references tb_estado_civil(id)
);

create table tb_pessoa_juridica(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    cnpj                  varchar(14),
    razao_social         varchar(100),
    nome_fantasia        varchar(100),
    inscricao_estadual    varchar(45),
    inscricao_municipal   varchar(45),
    data_constituicao            date,
    tipo_regime               char(1),
    crt                       char(1),
    foreign key (id_pessoa) references tb_pessoa(id)
);

create table tb_pessoa_endereco(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    logradouro           varchar(100),
    numero                varchar(10),
    bairro               varchar(100),
    municipio_ibge                int,
    uf                        char(2),
    cep                  varchar(100),
    cidade               varchar(100),
    complemento          varchar(100),
    principal                 char(1),
    entrega                   char(1),
    cobranca                  char(1),
    correspondecia            char(1),
    foreign key (id_pessoa) references tb_pessoa(id)
);

create table tb_pessoa_contato(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    nome                 varchar(150),
    email                varchar(250),
    observacao           varchar(250),
    foreign key(id_pessoa) references tb_pessoa(id)
);

create table tb_pessoa_teelfone(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    tipo                      char(1),
    numero                varchar(15),
    foreign key(id_pessoa) references tb_pessoa(id)
);

create table tb_contador(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    crc_inscricaon        varchar(15),
    crc_uf                    char(2),
    foreign key (id_pessoa) references tb_pessoa(id)
);

create table tb_cliente(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    desde                        date,
    data_cadastro                date,
    taxa_desconto       decimal(18,2),
    limite_credito      decimal(18,2),
    observacao           varchar(250),
    foreign key (id_pessoa) references tb_pessoa(id)
);

create table tb_fornecedor(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    desde                        date,
    data_cadastro                date,
    observacao           varchar(250),
    foreign key (id_pessoa) references tb_pessoa(id)
);

create table tb_transportadora(
    id bigint auto_increment primary key,
    id_pessoa                     bigint,
    data_cadastro                date,
    observacao           varchar(255),
    foreign key (id_pessoa) references tb_pessoa(id)
);
