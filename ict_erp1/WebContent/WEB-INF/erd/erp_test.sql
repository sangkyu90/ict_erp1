
/* Drop Triggers */

DROP TRIGGER TRI_Depat_Info_diNum;
DROP TRIGGER TRI_Level_Info_liNum;
DROP TRIGGER TRI_Member_Info_miNum;



/* Drop Tables */

DROP TABLE Member_Info CASCADE CONSTRAINTS;
DROP TABLE Depat_Info CASCADE CONSTRAINTS;
DROP TABLE Level_Info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Depat_Info_diNum;
DROP SEQUENCE SEQ_Level_Info_liNum;
DROP SEQUENCE SEQ_Member_Info_miNum;




/* Create Sequences */

CREATE SEQUENCE SEQ_Depat_Info_diNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Level_Info_liNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Member_Info_miNum INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Depat_Info
(
	diNum number(10,0) NOT NULL,
	-- 부서코드
	diCode char(6) NOT NULL,
	diName varchar2(100) NOT NULL,
	-- 부서설명
	diDsc varchar2(1000),
	PRIMARY KEY (diNum)
);


CREATE TABLE Level_Info
(
	-- 레벨정보 번호
	liNum number(10,0) NOT NULL,
	-- 실제레벨
	liLevel number(2,0) DEFAULT 1 NOT NULL UNIQUE,
	liMain varchar2(30) NOT NULL UNIQUE,
	-- 레벨권한에 대한 설명
	liDsc varchar2(300),
	PRIMARY KEY (liNum)
);


CREATE TABLE Member_Info
(
	miNum number(10,0) NOT NULL,
	miId varchar2(100) NOT NULL UNIQUE,
	miName varchar2(100) NOT NULL,
	-- 암호추가로직
	miPwd varchar2(100) NOT NULL,
	diCode number(10,0) NOT NULL,
	-- Level_Info테이블에 레벨번호
	liLevel number(2,0) DEFAULT 1 NOT NULL,
	miEmail varchar2(200) NOT NULL,
	miDsc varchar2(3000),
	miPhone char(20),
	mizipCode char(6),
	miAddress1 varchar2(150),
	miAddress2 varchar2(100),
	PRIMARY KEY (miNum, miId)
);



/* Create Foreign Keys */

ALTER TABLE Member_Info
	ADD FOREIGN KEY (diCode)
	REFERENCES Depat_Info (diNum)
;


ALTER TABLE Member_Info
	ADD FOREIGN KEY (liLevel)
	REFERENCES Level_Info (liLevel)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Depat_Info_diNum BEFORE INSERT ON Depat_Info
FOR EACH ROW
BEGIN
	SELECT SEQ_Depat_Info_diNum.nextval
	INTO :new.diNum
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Level_Info_liNum BEFORE INSERT ON Level_Info
FOR EACH ROW
BEGIN
	SELECT SEQ_Level_Info_liNum.nextval
	INTO :new.liNum
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_Member_Info_miNum BEFORE INSERT ON Member_Info
FOR EACH ROW
BEGIN
	SELECT SEQ_Member_Info_miNum.nextval
	INTO :new.miNum
	FROM dual;
END;

/




/* Comments */

COMMENT ON COLUMN Depat_Info.diCode IS '부서코드';
COMMENT ON COLUMN Depat_Info.diDsc IS '부서설명';
COMMENT ON COLUMN Level_Info.liNum IS '레벨정보 번호';
COMMENT ON COLUMN Level_Info.liLevel IS '실제레벨';
COMMENT ON COLUMN Level_Info.liDsc IS '레벨권한에 대한 설명';
COMMENT ON COLUMN Member_Info.miPwd IS '암호추가로직';
COMMENT ON COLUMN Member_Info.liLevel IS 'Level_Info테이블에 레벨번호';



