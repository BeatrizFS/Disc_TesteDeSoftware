INSERT INTO paciente (nome, cpf) VALUES ('Ana', '123.456.789-14')
INSERT INTO paciente (nome, cpf) VALUES ('Maria', '098.765.432.10')
INSERT INTO paciente (nome, cpf) VALUES ('Pedro', '234.567.890-11')

INSERT INTO telefone (ddd, numero, codigo_paciente) VALUES('45', '113456789100', (SELECT codigo FROM paciente WHERE cpf = '123.456.789-14'));
INSERT INTO telefone (ddd, numero, codigo_paciente) VALUES('45', '123456789100', (SELECT codigo FROM paciente WHERE cpf = '098.765.432.10'));
INSERT INTO telefone (ddd, numero, codigo_paciente) VALUES('45', '133456789100', (SELECT codigo FROM paciente WHERE cpf = '234.567.890-11'));

INSERT INTO consulta (medico, especialidade, hora, dataAgenda, dataConsulta, protocolo, codigo_paciente) 
    VALUES('Antonio', 'Odontopediatria', '11:10', '11/03/2022', '15/04/2022', '12345678901',  (SELECT codigo FROM paciente WHERE cpf = '123.456.789-14'));
INSERT INTO consulta (medico, especialidade, hora, dataAgenda, dataConsulta, protocolo, codigo_paciente) 
    VALUES('Antonio', 'Odonto-Revisão', '11:10', '11/03/2022', '15/04/2022', '12345678901',  (SELECT codigo FROM paciente WHERE cpf = '098.765.432.10'));
INSERT INTO consulta (medico, especialidade, hora, dataAgenda, dataConsulta, protocolo, codigo_paciente) 
    VALUES('Antonio', 'Odontocirugia', '11:10', '11/03/2022', '15/04/2022', '12345678901',  (SELECT codigo FROM paciente WHERE cpf = '234.567.890-11'));
