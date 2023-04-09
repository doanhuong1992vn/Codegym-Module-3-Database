CREATE DATABASE IF NOT EXISTS quan_ly_diem_thi;
CREATE TABLE IF NOT EXISTS student (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    birthday DATETIME,
    class VARCHAR(20),
    gender VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS subjects (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS transcript (
    id_student VARCHAR(20),
    id_subject VARCHAR(20),
    score INT,
    test_day DATETIME,
    PRIMARY KEY (id_student , id_subject),
    FOREIGN KEY (id_student)
        REFERENCES student (id),
    FOREIGN KEY (id_subject)
        REFERENCES subjects (id)
);
CREATE TABLE IF NOT EXISTS teacher(
id VARCHAR(20) PRIMARY KEY,
name VARCHAR(20),
phone_number VARCHAR(10)
);
ALTER TABLE subjects ADD id_teacher VARCHAR(20);
ALTER TABLE subjects ADD CONSTRAINT id_teacher_FK FOREIGN KEY (id_teacher) REFERENCES teacher(id);
