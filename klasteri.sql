 use AdventureWorksOBP

 SELECT TOP 5 k.Ime, k.Prezime, COUNT(r.IDRacun) AS BrojRacuna
FROM Komercijalist k
JOIN Racun r ON k.IDKomercijalist = r.KomercijalistID
GROUP BY k.IDKomercijalist, k.Ime, k.Prezime
ORDER BY BrojRacuna DESC;

SELECT TOP 5 k.Ime, k.Prezime, COUNT(DISTINCT r.IDRacun) AS BrojRacuna,
SUM(s.Kolicina) AS UkupnaKolicina
FROM Komercijalist k
JOIN Racun r ON k.IDKomercijalist = r.KomercijalistID
JOIN Stavka s ON r.IDRacun = s.RacunID
GROUP BY k.IDKomercijalist, k.Ime, k.Prezime
ORDER BY BrojRacuna DESC ;

Select p.Boja, COUNT(p.IDProizvod) AS BrojProizvoda
FROM Proizvod p
GROUP BY p.Boja
ORDER BY BrojProizvoda DESC;

SELECT k.Ime, k.Prezime, COUNT(r.IDRacun) AS BrojRacuna
FROM Kupac k
JOIN Racun r ON k.IDKupac = r.KupacID
WHERE(r.KreditnaKarticaID IS NOT NULL)
GROUP BY k.Ime,k.Prezime
ORDER BY BrojRacuna DESC;



USE AdventureWorksOBP

SET STATISTICS IO ON;

SELECT DatumIzdavanja FROM Racun
WHERE DatumIzdavanja BETWEEN '20010702' AND '20010702 23:59:59'

CREATE NONCLUSTERED INDEX datumi_izdavanja
ON Racun(DatumIzdavanja)

DROP INDEX datumi_izdavanja ON Racun


SELECT IDRacun, DatumIzdavanja, Komentar FROM Racun
WHERE DatumIzdavanja BETWEEN '20010702' AND '20010702 23:59:59'

CREATE NONCLUSTERED INDEX datumi_izdavanja1 ON Racun(DatumIzdavanja) INCLUDE(Komentar)

DROP INDEX komentari ON Racun
