CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;
CREATE TABLE IF NOT EXISTS class (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    start_date DATETIME NOT NULL,
    status BIT
);
CREATE TABLE IF NOT EXISTS student (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(50),
    phone VARCHAR(20),
    status BIT,
    class_id INT NOT NULL
);
CREATE TABLE IF NOT EXISTS subject (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
	credit TINYINT NOT NULL DEFAULT 1 CHECK (credit >= 1),
    student_status BIT DEFAULT 1
);
CREATE TABLE IF NOT EXISTS mark (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
subject_id INT NOT NULL,
student_id INT NOT NULL,
mark FLOAT DEFAULT 0 CHECK (mark BETWEEN 0 AND 100),
exam_times TINYINT DEFAULT 1,
UNIQUE (subject_id, student_id),
FOREIGN KEY (subject_id) REFERENCES subject (id),
FOREIGN KEY (student_id) REFERENCES student (id)
);