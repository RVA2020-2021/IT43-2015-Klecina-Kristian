INSERT INTO "fakultet"("id", "naziv", "sediste")
VALUES(nextval('fakultet_seq'), 'Fakultet Tehničkih Nauka', 'Novi Sad');
insert into "fakultet"("id", "naziv", "sediste")
values(nextval('fakultet_seq'), 'Prirodno Matematički Fakultet', 'Novi Sad');
insert into "fakultet"("id", "naziv", "sediste")
values(nextval('fakultet_seq'), 'FIMEK', 'Novi Sad');
insert into "fakultet"("id", "naziv", "sediste")
values(nextval('fakultet_seq'), 'Poljoprivredni Fakultet', 'Novi Sad');

insert into "fakultet"("id", "naziv", "sediste")
values(-100, 'TestFakultet', 'TestGrad');



insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Industrijsko inzenjerstvo i menadzment', 'IIM', 1);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za biologiju i ekologiju', 'DBE', 2);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za ekonomiju', 'DZE', 3);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za stočarstvo', 'DZE', 4);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za saobraćaj', 'DZS', 1);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za ratarstvo i povrtarstvo', 'RIP', 4);
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(nextval('departman_seq'), 'Departman za fiziku', 'DF', 2);

	 
insert into "departman"("id", "naziv", "oznaka", "fakultet")
values(-100, 'TestDepartman', 'TestOznaka', 1);

insert into "status"("id", "naziv", "oznaka")
values(nextval('status_seq'), 'budzet', 'b');
insert into "status"("id", "naziv", "oznaka")
values(nextval('status_seq'), 'samofinansiranje', 's');
insert into "status"("id", "naziv", "oznaka")
values(nextval('status_seq'), 'gostujući', 'g');
insert into "status"("id", "naziv", "oznaka")
values(nextval('status_seq'), 'posebne potrebe', 'pp');
insert into "status"("id", "naziv", "oznaka")
values(nextval('status_seq'), 'daljina', 'd');

insert into "status"("id", "naziv", "oznaka")
values(-100, 'TestStatus', 'TestOznaka');


insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Zoran', 'Mišković', 'IT15G2014', 1, 1);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Milan', 'Milanović', 'SS33G2018', 2, 5);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Tanja', 'Bošković', 'BE25G2010', 1, 2);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Aglaya', 'Tarasova', 'FF91G2019', 3, 7);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Tamaš', 'Pece', 'EE10G2014', 5, 3);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Dejan', 'Zarić', 'EE29G2011', 2, 3);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Dijana', 'Rodić', 'SP14G2016', 1, 4);
insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(nextval('student_seq'), 'Budimir', 'Trajković', 'RP68G2014', 2, 6);


insert into "student"("id", "ime", "prezime", "broj_indeksa", "status", "departman")
values(-100, 'TestIme', 'TestPrezime', 'TestBrIndx', 1, 1);


