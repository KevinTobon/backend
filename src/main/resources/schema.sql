
CREATE TABLE VEHICLE(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
	PLATE VARCHAR(30) NOT NULL UNIQUE,
	TYPE VARCHAR(30) NOT NULL,
	DISPLACEMENT INT NULL,
	ENTRY_DATE DATE NOT NULL
);




