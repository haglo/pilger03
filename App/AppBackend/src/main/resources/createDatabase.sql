CREATE DATABASE pilgerdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'pilgeruser'@'localhost' IDENTIFIED BY '123atgfd';
GRANT ALL ON pilgerdb.* TO 'pilgeruser'@'localhost' IDENTIFIED BY '123atgfd' WITH GRANT OPTION;