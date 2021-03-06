--<ScriptOptions statementTerminator=";"/>

CREATE TABLE MESSAGES (
		USER_ID INTEGER NOT NULL,
		CONTENT VARCHAR(100) NOT NULL,
		CREATED_ON DATE,
		MESSAGE_ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1)
	);

CREATE TABLE USERS (
		ID INTEGER DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		EMAIL VARCHAR(50) NOT NULL,
		PASSWORD VARCHAR(50) NOT NULL,
		FIRST_NAME VARCHAR(30),
		LAST_NAME VARCHAR(30)
	);

CREATE INDEX SQL181011222718051 ON MESSAGES (USER_ID ASC);

CREATE UNIQUE INDEX SQL181011224746390 ON MESSAGES (MESSAGE_ID ASC);

CREATE UNIQUE INDEX SQL180920192639770 ON USERS (ID ASC);

ALTER TABLE MESSAGES ADD CONSTRAINT SQL181011224746390 PRIMARY KEY (MESSAGE_ID);

ALTER TABLE USERS ADD CONSTRAINT SQL180920192639770 PRIMARY KEY (ID);

ALTER TABLE MESSAGES ADD CONSTRAINT SQL181011222718051 FOREIGN KEY (USER_ID)
	REFERENCES USERS (ID);

