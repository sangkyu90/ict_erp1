
/* Drop Triggers */

DROP TRIGGER TRI_Depart_Info_diNum;
DROP TRIGGER TRI_Level_Info_liNum;
DROP TRIGGER TRI_Member_Info_miNum;



/* Drop Tables */

DROP TABLE Member_Info CASCADE CONSTRAINTS;
DROP TABLE Depart_Info CASCADE CONSTRAINTS;
DROP TABLE Level_Info CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Depart_Info_diNum;
DROP SEQUENCE SEQ_Level_Info_liNum;
DROP SEQUENCE SEQ_Member_Info_miNum;




/* Create Sequences */

CREATE SEQUENCE SEQ_Depart_Info_diNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Level_Info_liNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Member_Info_miNum INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE Depart_Info
(
	-- 부서번호
	diNum number(10,0) NOT NULL,
	-- 부서코드
	diCode char(6) NOT NULL UNIQUE,
	-- 부서명
	diName varchar2(100) NOT NULL,
	-- 부서설명
	diDesc varchar2(1000),
	PRIMARY KEY (diNum)
);


CREATE TABLE Level_Info
(
	-- 레벨정보 번호
	liNum number(10,0) NOT NULL,
	-- Level_Info테이블의 레벨번호
	liLevel number(2,0) DEFAULT 1 NOT NULL UNIQUE,
	liName varchar2(30) NOT NULL UNIQUE,
	-- 레벨권한에대한 설명
	liDesc varchar2(300),
	PRIMARY KEY (liNum)
);


CREATE TABLE Member_Info
(
	miNum number(10,0) NOT NULL,
	miId varchar2(100) NOT NULL UNIQUE,
	miName varchar2(100) NOT NULL,
	-- SHA256 암호화로직 추가 예정
	miPwd varchar2(100) NOT NULL,
	-- Depart_Info테이블의 부서코드
	diCode char(6) NOT NULL,
	miEmail varchar2(200) NOT NULL,
	miDesc varchar2(3000),
	miPhone char(20),
	miZipCode char(6),
	miAddress1 varchar2(150),
	miAddress2 varchar2(100),
	-- Level_Info테이블의 실제레벨
	liLevel number(2,0) DEFAULT 1 NOT NULL,
	PRIMARY KEY (miNum)
);



/* Create Foreign Keys */

ALTER TABLE Member_Info
	ADD FOREIGN KEY (diCode)
	REFERENCES Depart_Info (diCode)
;


ALTER TABLE Member_Info
	ADD FOREIGN KEY (liLevel)
	REFERENCES Level_Info (liLevel)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_Depart_Info_diNum BEFORE INSERT ON Depart_Info
FOR EACH ROW
BEGIN
	SELECT SEQ_Depart_Info_diNum.nextval
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

COMMENT ON COLUMN Depart_Info.diNum IS '부서번호';
COMMENT ON COLUMN Depart_Info.diCode IS '부서코드';
COMMENT ON COLUMN Depart_Info.diName IS '부서명';
COMMENT ON COLUMN Depart_Info.diDesc IS '부서설명';
COMMENT ON COLUMN Level_Info.liNum IS '레벨정보 번호';
COMMENT ON COLUMN Level_Info.liLevel IS 'Level_Info테이블의 레벨번호';
COMMENT ON COLUMN Level_Info.liDesc IS '레벨권한에대한 설명';
COMMENT ON COLUMN Member_Info.miPwd IS 'SHA256 암호화로직 추가 예정';
COMMENT ON COLUMN Member_Info.diCode IS 'Depart_Info테이블의 부서코드';
COMMENT ON COLUMN Member_Info.liLevel IS 'Level_Info테이블의 실제레벨';


