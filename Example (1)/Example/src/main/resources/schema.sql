CREATE TABLE hardver (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    naziv VARCHAR(100),
    sifra VARCHAR(50) UNIQUE,
    cijena DECIMAL(10, 2),
    tip VARCHAR(20),
    kolicina_na_stanju INT
);
