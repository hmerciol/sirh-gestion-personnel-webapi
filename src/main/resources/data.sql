INSERT INTO DEPARTEMENT (id,libelle)
	VALUES (1,'d1'),(2,'d2');
INSERT INTO COLLABORATEUR (id,matricule,nom,prenom,departement_id,libelle_Banque,bic,iban)
	VALUES (3,'m1','n1','p1',1,'b1','bc1','i1'),
		(4,'m2','n2','p2',1,'b1','bc2','i2'),
        (5,'m3','n3','p3',2,'b1','bc3','i3');
INSERT INTO COLLABORATEUR (id,matricule,nom,prenom,departement_id)
	VALUES (6,'m4','n4','p4',2);