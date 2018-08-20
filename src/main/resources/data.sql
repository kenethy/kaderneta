
INSERT INTO tb_discipline(id, name, time) VALUES (1,'Português', 60);
INSERT INTO tb_discipline(id, name, time) VALUES (2,'Matemática', 60);
INSERT INTO tb_discipline(id, name, time) VALUES (3,'História', 60);
INSERT INTO tb_discipline(id, name, time) VALUES (4,'Geografia', 60);
INSERT INTO tb_discipline(id, name, time) VALUES (5,'Ciências', 60);

INSERT INTO tb_user(id, login, password, name, date, gender, office, obs, active, teacher, street, city, state, cep) 
VALUES (1, 'kfss-1', 'kfss-1', 'Kenedy', '1989-11-14', 'Masculino', 'Admin', '', true, false, 'Rua A, 1', 'Recife', 'PE', '123');
INSERT INTO tb_user(id, login, password, name, date, gender, office, obs, active, teacher, street, city, state, cep) 
VALUES (2, 'kfss-2', 'kfss-2', 'Felipe', '1989-11-14', 'Masculino', 'Professor', '', true, true, 'Rua B, 2', 'Recife', 'PE', '1234');
INSERT INTO tb_user(id, login, password, name, date, gender, office, obs, active, teacher, street, city, state, cep) 
VALUES (3, 'kfss-3', 'kfss-3', 'Santos', '1989-11-14', 'Masculino', 'Secretario', '', true, false, 'Rua C, 3', 'Recife', 'PE', '12345');
INSERT INTO tb_user(id, login, password, name, date, gender, office, obs, active, teacher, street, city, state, cep) 
VALUES (4, 'kfss-4', 'kfss-4', 'Silva', '1989-11-14', 'Masculino', 'Coordenador', '', true, false, 'Rua D, 4', 'Recife', 'PE', '123456');
INSERT INTO tb_user(id, login, password, name, date, gender, office, obs, active, teacher, street, city, state, cep) 
VALUES (5, 'kfss-5', 'kfss-5', 'Kenedy Felipe', '1989-11-14', 'Masculino', 'Diretor', '', true, false, 'Rua E, 5', 'Recife', 'PE', '1234567');

INSERT INTO tb_class(id, name) VALUES (1,'1ª ANO');
INSERT INTO tb_class(id, name) VALUES (2,'2ª ANO');
INSERT INTO tb_class(id, name) VALUES (3,'3ª ANO');
INSERT INTO tb_class(id, name) VALUES (4,'4ª ANO');
INSERT INTO tb_class(id, name) VALUES (5,'5ª ANO');

INSERT INTO tb_student(id, name, filiation1, filiation2, date, gender, pendencies, active, street, city, state, cep, classes_id)
VALUES (1, 'Joao', 'Maria', 'Jose', '2010-11-12', 'Masculino', 'Nenhuma', true, 'Rua K, 12 - Aldeia de Baixo', 'Camaragibe', 'PE', '123', 1);

INSERT INTO tb_student(id, name, filiation1, filiation2, date, gender, pendencies, active, street, city, state, cep, classes_id)
VALUES (2, 'Jose', 'Maria', 'Jose', '2010-11-12', 'Masculino', 'Nenhuma', true, 'Rua K, 12 - Aldeia de Baixo', 'Camaragibe', 'PE', '123', 2);

INSERT INTO tb_student(id, name, filiation1, filiation2, date, gender, pendencies, active, street, city, state, cep, classes_id)
VALUES (3, 'Joaquim', 'Maria', 'Jose', '2010-11-12', 'Masculino', 'Nenhuma', true, 'Rua K, 12 - Aldeia de Baixo', 'Camaragibe', 'PE', '123', 3);

INSERT INTO tb_student(id, name, filiation1, filiation2, date, gender, pendencies, active, street, city, state, cep, classes_id)
VALUES (4, 'Juliana', 'Maria', 'Jose', '2010-11-12', 'Feminino', 'Nenhuma', true, 'Rua K, 12 - Aldeia de Baixo', 'Camaragibe', 'PE', '123', 4);

INSERT INTO tb_student(id, name, filiation1, filiation2, date, gender, pendencies, active, street, city, state, cep, classes_id)
VALUES (5, 'Mariana', 'Maria', 'Jose', '2010-11-12', 'Feminino', 'Nenhuma', true, 'Rua K, 12 - Aldeia de Baixo', 'Camaragibe', 'PE', '123', 5);


INSERT INTO tb_student_dto(id, name, pendencies, active, classes_id)
VALUES (1, 'Joao', 'Nenhuma', true, 1);

INSERT INTO tb_student_dto(id, name, pendencies, active, classes_id)
VALUES (2, 'Maria', 'Nenhuma', true, 2);

INSERT INTO tb_student_dto(id, name, pendencies, active, classes_id)
VALUES (3, 'Joaquim', 'Nenhuma', true, 3);

INSERT INTO tb_student_dto(id, name, pendencies, active, classes_id)
VALUES (4, 'Juliana', 'Nenhuma', true, 4);

INSERT INTO tb_student_dto(id, name, pendencies, active, classes_id)
VALUES (5, 'Mariana', 'Nenhuma', true, 5);




