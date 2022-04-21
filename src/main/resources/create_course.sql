-- CREATE TABLE course (
--     coursename VARCHAR(50) NOT NULL,
--     PRIMARY KEY (coursename)
-- );
-- 
-- CREATE TABLE lecture (
--     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     coursename VARCHAR(50) NOT NULL,
--     lecturetitle VARCHAR(50),
--     PRIMARY KEY (id),
--     FOREIGN KEY (coursename) REFERENCES course(coursename)
-- );
-- 
-- INSERT INTO course VALUES ('COMP383F');
-- INSERT INTO lecture(coursename, lecturetitle) VALUES ('COMP383F', 'lecture1');
-- INSERT INTO lecture(coursename, lecturetitle) VALUES ('COMP383F', 'lecture2');
-- 
-- INSERT INTO course VALUES ('COMP384F');
-- INSERT INTO lecture(coursename, lecturetitle) VALUES ('COMP384F', 'lecture1');
-- INSERT INTO lecture(coursename, lecturetitle) VALUES ('COMP384F', 'lecture2');
-- 
-- CREATE TABLE attachment (
--     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     filename VARCHAR(255) DEFAULT NULL,
--     content_type VARCHAR(255) DEFAULT NULL,
--     content BLOB DEFAULT NULL,
--     lecture_id INTEGER DEFAULT NULL,
--     PRIMARY KEY (id),
--     FOREIGN KEY (lecture_id) REFERENCES lecture(id)
-- );
CREATE TABLE comment (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    username VARCHAR(255) DEFAULT NULL,
    comment VARCHAR(255) DEFAULT NULL,
    lecture_id INTEGER DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (lecture_id) REFERENCES lecture(id)
);
-- 
-- CREATE TABLE comment (
--     id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     lecturename VARCHAR(50),
--     comment VARCHAR (255),
--     PRIMARY KEY(id),
--     FOREIGN KEY (id) REFERENCES lecture(lecturename)
-- );
