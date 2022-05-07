 CREATE TABLE course (
     coursename VARCHAR(50) NOT NULL,
     PRIMARY KEY (coursename)
 );
 
 CREATE TABLE lecture (
     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
     coursename VARCHAR(50) NOT NULL,
     lecturetitle VARCHAR(50),
     PRIMARY KEY (id),
     FOREIGN KEY (coursename) REFERENCES course(coursename)
 );


 CREATE TABLE attachment (
     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
     filename VARCHAR(255) DEFAULT NULL,
     content_type VARCHAR(255) DEFAULT NULL,
     content BLOB DEFAULT NULL,
     lecture_id INTEGER DEFAULT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (lecture_id) REFERENCES lecture(id)
 );
 CREATE TABLE comment (
     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(255) DEFAULT NULL,
    comment VARCHAR(255) DEFAULT NULL,
     lecture_id INTEGER DEFAULT NULL,
     PRIMARY KEY (id),
     FOREIGN KEY (lecture_id) REFERENCES lecture(id)
 );

 CREATE TABLE pollquestion(
     question_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
     question VARCHAR(255),
     PRIMARY KEY (question_id)
 );

CREATE TABLE pollanswer(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    question_id INTEGER,
    answerId INTEGER,
    pollAnswer VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES pollquestion(question_id)
);
