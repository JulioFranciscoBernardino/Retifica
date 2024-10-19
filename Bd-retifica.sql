CREATE TABLE clientes(
	cpf VARCHAR(11) NOT NULL PRIMARY KEY,
	idendereco INT NOT NULL REFERENCES endereco(idendereco), 
	nome VARCHAR(30) NOT NULL,
	email VARCHAR(50) NOT NULL,
	telefone_celular VARCHAR(14) NOT NULL,
	telefone_fixo VARCHAR(8)
);


CREATE TABLE endereco(
	idendereco INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	rua VARCHAR(30) NOT NULL,
	bairro VARCHAR(20) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	complemento VARCHAR(20)
);


CREATE TABLE servico(
	idservico INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	nomeservico VARCHAR(40) NOT NULL,
	preco NUMERIC(10,2) CHECK(preco > 0) NOT NULL
);


CREATE TABLE peca(
	idpeca INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	tipopeca VARCHAR(40) NOT NULL,
	nomepeca VARCHAR(40) NOT NULL,
	preco NUMERIC(10,2) CHECK(preco > 0) NOT NULL
);

CREATE TABLE pedido(
	idpedido INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	cpf VARCHAR NOT NULL REFERENCES clientes(cpf),
	idservico INTEGER NOT NULL REFERENCES servico(idservico),
	idpeca INTEGER NOT NULL REFERENCES peca(idpeca),
	total NUMERIC(10,2) CHECK(total > 0) NOT NULL
);

CREATE TABLE pecapedido (
    idpeca INTEGER NOT NULL,
    idpedido INTEGER NOT NULL,
    CONSTRAINT pk_id_peca_pedido PRIMARY KEY (idpeca, idpedido),
    CONSTRAINT fk_id_peca FOREIGN KEY (idpeca) REFERENCES peca (idpeca) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_id_pedido FOREIGN KEY (idpedido) REFERENCES pedido (idpedido) ON DELETE CASCADE ON UPDATE CASCADE
);



