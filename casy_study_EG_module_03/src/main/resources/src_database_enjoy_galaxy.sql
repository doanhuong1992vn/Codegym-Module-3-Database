CREATE DATABASE ENJOY_GALAXY;
USE ENJOY_GALAXY;
CREATE TABLE CINEMA (
	ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) UNIQUE NOT NULL,
    ADDRESS VARCHAR(200) UNIQUE NOT NULL
);
INSERT INTO CINEMA(TYPE, NAME, ADDRESS) VALUES 
("STANDARD", "EG Hùng Vương", "126 Hồng Bàng, Phường 12, Quận 5"),
("STANDARD", "EG Hoàng Văn Thụ", "415, Hoàng Văn Thụ, Phường 2, Quận Tân Bình"),
("STANDARD", "EG Sư Vạn Hạnh", "11 Sư Vạn Hạnh, Phường 12, Quận 10"),
("STANDARD", "EG Đồng Khởi", "72 Lê Thánh Tôn & 45A Lý Tự Trọng, Quận 1"),
("STANDARD", "EG Thủ Đức", "216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");

CREATE TABLE ROOM (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    NUMBER_ROW_SEAT INT DEFAULT 4 CHECK (NUMBER_ROW_SEAT > 0),
    NUMBER_COLUMN_SEAT INT DEFAULT 4 CHECK (NUMBER_COLUMN_SEAT > 0),
    ID_CINEMA BIGINT NOT NULL,
    FOREIGN KEY (ID_CINEMA) REFERENCES CINEMA(ID)
);
INSERT INTO ROOM(ID_CINEMA, TYPE, NAME) VALUES
(2,"4DX","Hoàng Hôn"),
(2,"3D","Hoàng Tử"),
(2,"2D","Hoàng Hậu"),
(2,"IMAX","Hoàng Thượng"),
(1,"2D","Hùng Hổ"),
(1,"3D","Hùng Hục"),
(1,"4DX","Hùng Bá"),
(1,"IMAX","Hùng Hồn"),
(3,"3D","Sư Cọ"),
(3,"2D","Sư Cô"),
(3,"IMAX","Sư Thầy Ông Nội"),
(3,"4DX","Sư Phạm"),
(4,"IMAX","Đồng Chí"),
(4,"3D","Đồng Không Mông Lạnh"),
(4,"2D","Đồng Bào"),
(4,"4DX","Đồng Đô La"),
(5,"4DX","Thủ Lợn"),
(5,"2D","Thủ Dam"),
(5,"3D","Thủ Phủ"),
(5,"IMAX","Thủ Thành");
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('21', '2D', 'Hoàng Phi Hồng', '8', '6', '2');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('22', '3D', 'Hoàng Thái Lọ', '7', '4', '2');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('23', '4DX', 'Sư Tử', '8', '5', '3');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('24', 'IMAX', 'Đồng Tiền Xương Máu', '6', '3', '4');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('25', '2D', 'Thủ Tục Hành Chính Nhưng Lại Chiếu Phim', '5', '5', '5');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('26', '3D', 'Đồng Đông Sơn', '6', '4', '4');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('27', 'IMAX', 'Đồng Việt Nam', '5', '7', '4');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('28', '4DX', 'Thủ Tiêu Bịt Đầu Mối', '9', '5', '5');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('29', '2D', 'Hoàng Anh Gia Lai', '7', '5', '2');
INSERT INTO `enjoy_galaxy`.`room` (`ID`, `TYPE`, `NAME`, `NUMBER_ROW_SEAT`, `NUMBER_COLUMN_SEAT`, `ID_CINEMA`) VALUES ('30', '3D', 'Hùng Dũng Oai Nghiêm', '8', '4', '1');

CREATE TABLE SHOWTIME (
	ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    START_TIME DATETIME NOT NULL,
    END_TIME DATETIME,
    ID_CINEMA BIGINT NOT NULL,
    FOREIGN KEY (ID_CINEMA) REFERENCES CINEMA(ID),
    ID_MOVIE BIGINT NOT NULL,
    FOREIGN KEY (ID_MOVIE) REFERENCES MOVIE(ID)
);