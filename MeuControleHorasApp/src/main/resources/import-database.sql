INSERT INTO TB_USER (id, username, password, firstname, enabled, lastPasswordResetDate) VALUES (1, 'edneyroldao@gmail.com.br', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'Edney Roldão', true, null);
INSERT INTO TB_USER (id, username, password, firstname, enabled, lastPasswordResetDate) VALUES (2, 'nadine@mail.com', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'Nadine Roldão', true, null);

INSERT INTO TB_ROLE (ID, ROLE) VALUES (1, 'ROLE_USER');
INSERT INTO TB_ROLE (ID, ROLE) VALUES (2, 'ROLE_ADMIN');

INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (2, 1);

INSERT INTO TB_USER_PROFILE (id, email, name, company, idPhoto) VALUES (1, 'edneyroldao@gmail.com.br', 'Edney Roldão', null, null);
INSERT INTO TB_USER_PROFILE (id, email, name, company, idPhoto) VALUES (2, 'nadine@mail.com', 'Nadine Roldão', null, null);
