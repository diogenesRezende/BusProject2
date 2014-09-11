--drop schema public cascade;

--create schema public;

create sequence seq_motorista;

create table motorista(
id integer not null default nextval('seq_motorista'),
nome varchar(50) not null,
celular varchar(20) not null,
categoriaCNH char,
constraint pk_motorista primary key(id)
);

create sequence seq_instituicao;

create table instituicao(
id integer not null default nextval('seq_instituicao'),
nome varchar(50) not null,
endereco varchar(50) not null,
num_end integer not null,
bairro varchar(30) not null,
cidade varchar(30) not null,
telefone varchar(20) not null,
email varchar(50) not null,
constraint pk_instituicao primary key(id)
);

create sequence seq_aluno;

create table aluno(
id integer not null default nextval('seq_aluno'),
id_instituicao integer not null,
nome varchar(50) not null,
endereco varchar(40) not null,
num_end int,
celular varchar(30) not null,
constraint pk_aluno primary key(id),
constraint fk_aluno_intituicao foreign key(id_instituicao) references instituicao(id)
);

create sequence seq_viagem;

create table viagem(
id integer not null default nextval('seq_viagem'),
data date not null default now(),
origem varchar(30) not null,
destino varchar(30) not null,
id_motorista integer not null,
constraint pk_viagem primary key(id),
constraint uk_viagem unique(data),
constraint fk_viagem_motorista foreign key(id_motorista) references motorista(id)
);

create table aluno_viagem(
id_aluno integer not null,
id_viagem integer not null,
constraint pk_aluno_viagem primary key(id_aluno,id_viagem),
constraint fk_aluno_viagem_aluno foreign key(id_aluno) references aluno(id),
constraint fk_aluno_viagem_viagem foreign key(id_viagem) references viagem(id)
);