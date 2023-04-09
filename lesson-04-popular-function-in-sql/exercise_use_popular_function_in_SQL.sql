USE STUDENT_MANAGEMENT;

-- Hiển thị bảng subject cho dễ nhìn
SELECT * FROM SUBJECT;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
SELECT * 
FROM SUBJECT
HAVING CREDIT >= ALL (
	SELECT CREDIT
    FROM SUBJECT 
    );

-- Hiển thị bảng MARK cho dễ nhìn
SELECT * FROM MARK;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
SELECT SUBJECT.ID, NAME, MARK
FROM SUBJECT 
JOIN MARK ON SUBJECT.ID = MARK.SUBJECT_ID
HAVING MARK >= ALL (
	SELECT MARK 
    FROM MARK
    );

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
SELECT STUDENT.ID, STUDENT.NAME, AVG(MARK) AS "ĐIỂM TRUNG BÌNH"
FROM STUDENT
JOIN MARK ON STUDENT.ID = MARK.STUDENT_ID 
GROUP BY STUDENT.ID 
ORDER BY AVG(MARK) ASC;
