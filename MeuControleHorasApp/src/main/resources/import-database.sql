INSERT INTO TB_USER (id, username, password, firstname, enabled, lastPasswordResetDate) VALUES (1, 'edney@mail.com', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'edney', true, null);
INSERT INTO TB_USER (id, username, password, firstname, enabled, lastPasswordResetDate) VALUES (2, 'nadine@mail.com', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'nadine', true, null);

INSERT INTO TB_ROLE (ID, ROLE) VALUES (1, 'ROLE_USER');
INSERT INTO TB_ROLE (ID, ROLE) VALUES (2, 'ROLE_ADMIN');

INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO TB_USER_ROLE (USER_ID, ROLE_ID) VALUES (2, 1);