CREATE TABLE USERS (
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY 
    MINVALUE 1 MAXVALUE 9999999999999999999999999999 
    INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE NOKEEP NOSCALE 
    PRIMARY KEY NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    LAST_NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(100),
    PHONE_NUMBER VARCHAR2(20),
    IDENTIFICATION VARCHAR2(13) NOT NULL
);

CREATE TABLE ROLES (
    ID NUMBER GENERATED BY DEFAULT AS IDENTITY 
     MINVALUE 1 MAXVALUE 9999999999999999999999999999 
     INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE NOKEEP NOSCALE 
     PRIMARY KEY NOT NULL,
    ROL_NAME VARCHAR2(20)NOT NULL
);

CREATE TABLE USER_ROLES (
  USER_ID NUMBER,
  ROL_ID NUMBER,
  CONSTRAINT FK_USER_ROLES_USERS FOREIGN KEY (USER_ID) REFERENCES USERS (ID),
  CONSTRAINT FK_USER_ROLES_ROLES FOREIGN KEY (ROL_ID) REFERENCES ROLES (ID),
  CONSTRAINT PK_USER_ROLES PRIMARY KEY (USER_ID, ROL_ID)
);

CREATE TABLE "CAPACITACION"."OTP_CODES"(    
    "ID" NUMBER GENERATED BY DEFAULT AS IDENTITY 
    MINVALUE 1 MAXVALUE 9999999999999999999999999999 
    INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  
    NOCYCLE  NOKEEP  NOSCALE  NOT NULL PRIMARY KEY, 
    "D_CREATE" DATE NOT NULL, 
    "OTP" VARCHAR2(100 BYTE) NOT NULL, 
    "OPERATION" VARCHAR2(100 BYTE) NOT NULL, 
    "COMUNICATION" VARCHAR2(100 BYTE) NOT NULL, 
    "ID_USER" NUMBER NOT NULL,
    FOREIGN KEY (ID_USER) REFERENCES USERS(ID)
);