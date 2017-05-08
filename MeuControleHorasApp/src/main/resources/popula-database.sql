INSERT INTO tb_role(id, tp_role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO tb_role(id, tp_role) VALUES (2, 'ROLE_USER');

INSERT INTO tb_user(id, username, password, email)
VALUES (1                                                               ,
        'edneyRoldao'                                                   ,
        '$2a$10$zJAkdWPBYXfWQ/lKjU.6u.QzhfpoH/E9RmYN1P1p7rzcODuqhYJDC'  ,
        'edneyroldao@gmail.com');

INSERT INTO tb_user_role(ID_USER, ID_ROLE) VALUES (1, 1);
INSERT INTO tb_user_role(ID_USER, ID_ROLE) VALUES (1, 2);
