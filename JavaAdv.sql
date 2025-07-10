USE JavaADV

CREATE TABLE Polaznik(
IDPolaznik int CONSTRAINT polaznik_pk PRIMARY KEY IDENTITY,
ime nvarchar(100),
prezime nvarchar(100)
)

CREATE TABLE ProgramObrazovanja(
IDProgramObrazovanja int CONSTRAINT programObrazovanja_pk PRIMARY KEY IDENTITY,
Naziv nvarchar(100),
CSVET int 
)

CREATE TABLE Upis(
IDUpis int CONSTRAINT upis_pk PRIMARY KEY IDENTITY,
ProgramObrazovanjaID int CONSTRAINT programObrazovanja_fk FOREIGN KEY (ProgramObrazovanjaID) REFERENCES ProgramObrazovanja(IDProgramObrazovanja),
PolaznikID int CONSTRAINT polaznik_fk FOREIGN KEY (PolaznikID) REFERENCES Polaznik(IDPolaznik)
)

SELECT * FROM Upis
SELECT * FROM ProgramObrazovanja
SELECT *FROM Polaznik