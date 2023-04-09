USE STUDENT_MANAGEMENT;
-- Hiển thị bảng student cho dễ nhìn
SELECT * FROM STUDENT;
-- Hiển thị số lượng sinh viên ở từng nơi
SELECT ADDRESS, COUNT(ID) AS 'Số lượng học sinh'
FROM STUDENT
GROUP BY ADDRESS;

-- Hiển thị bảng mark cho dễ nhìn
SELECT * FROM MARK;

-- Tính điểm trung bình các môn học của mỗi học viên
SELECT NAME, AVG(MARK) AS "Trung bình môn"
FROM STUDENT 
JOIN MARK ON STUDENT.ID = MARK.STUDENT_ID
GROUP BY NAME;

-- Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT NAME, AVG(MARK) AS "Trung bình môn"
FROM STUDENT 
JOIN MARK ON STUDENT.ID = MARK.STUDENT_ID
GROUP BY NAME
HAVING AVG(MARK) > 15;

-- Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT NAME, AVG(MARK) AS "TRUNG BÌNH MÔN"
FROM STUDENT
JOIN MARK ON STUDENT.ID = MARK.STUDENT_ID
GROUP BY NAME
HAVING AVG(MARK) >= ALL (
	SELECT AVG(MARK) 
    FROM MARK 
    GROUP BY MARK.STUDENT_ID
    );