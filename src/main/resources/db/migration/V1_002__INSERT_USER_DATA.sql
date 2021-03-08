-- pass:admin / pass:gestor / pass:123
INSERT INTO USERS (USERNAME, NAME, EMAIL, PASSWORD)
	 values   
	 ('admin','Administrator', 'admin@smp.com', '$2a$10$Bfy5iEUmivzTprNpLvHUXO9oUVblbIY4BgwaX0KHAn12X2NVV64/W'),
	 ('gestor','Gestor', 'gestor@smp.com', '$2a$04$C7Ibg./aMbycpIJBYRhaQe2WG3/AyUMdP89lE9Tuaqgc0lASRf0Ja'),
	 ('convidado','Convidado', 'convidado@smp.com', '$2a$04$z2KiCGHQLaLY8bD7eGr4sOCvfzkdJ7YlEr41fX/CWLfP7wP9f.QfO');