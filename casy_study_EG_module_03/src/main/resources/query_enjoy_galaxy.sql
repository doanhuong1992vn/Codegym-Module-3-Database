CREATE DATABASE ENJOY_GALAXY;
USE ENJOY_GALAXY;
CREATE TABLE USER (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(20) NOT NULL,
    FULLNAME VARCHAR(50) NOT NULL,
    PHONE_NUMBER VARCHAR(10) UNIQUE NOT NULL,
    EMAIL VARCHAR(50) UNIQUE NOT NULL,
    PASSWORD VARCHAR(20) NOT NULL,
    WALLET DOUBLE CONSTRAINT CHECK_WALLET CHECK (WALLET >= 0),
    EDUCATION VARCHAR(50),
    JOBTITLE VARCHAR(50),
    SALARY DOUBLE CONSTRAINT CHECK_SALARY CHECK (SALARY >= 0),
    BIRTHDAY DATE,
    ADDRESS VARCHAR(300)
);
CREATE TABLE MOVIE (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(200) UNIQUE NOT NULL,
    DIRECTOR VARCHAR(100),
    ACTORS VARCHAR(500),
    GENRE VARCHAR(100),
    PREMIERE_DATE DATE,
    DURATION INT CONSTRAINT CHECK_DURATION CHECK (DURATION > 0),
    LANGUAGE VARCHAR(100),
    CONTENT VARCHAR(1000)
);
CREATE TABLE MOVIE_THEATER (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) UNIQUE NOT NULL,
    ADDRESS VARCHAR(200) UNIQUE NOT NULL
);
CREATE TABLE CINEMA (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    NUMBER_ROW_SEAT INT DEFAULT 4 CHECK (NUMBER_ROW_SEAT > 0),
    NUMBER_COLUMN_SEAT INT DEFAULT 4 CHECK (NUMBER_COLUMN_SEAT > 0),
    ID_MOVIE_THEATER BIGINT NOT NULL,
    FOREIGN KEY (ID_MOVIE_THEATER) REFERENCES MOVIE_THEATER(ID)
);
CREATE TABLE SHOWTIME (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    START_TIME DATETIME NOT NULL,
    END_TIME DATETIME,
    ID_CINEMA BIGINT NOT NULL,
    FOREIGN KEY (ID_CINEMA) REFERENCES CINEMA(ID),
    ID_MOVIE BIGINT NOT NULL,
    FOREIGN KEY (ID_MOVIE) REFERENCES MOVIE(ID)
);
CREATE TABLE SEAT (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TYPE VARCHAR(50) NOT NULL,
    CODE VARCHAR(3),
    READY BIT DEFAULT 1,
    ID_SHOWTIME BIGINT,
    FOREIGN KEY (ID_SHOWTIME) REFERENCES SHOWTIME(ID)
);
CREATE TABLE TICKET (
	ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PRICE DOUBLE NOT NULL CHECK (PRICE > 0),
    ID_USER BIGINT,
    FOREIGN KEY (ID_USER) REFERENCES USER(ID),
    ID_SEAT BIGINT,
    FOREIGN KEY (ID_SEAT) REFERENCES SEAT(ID),
    TIME_BOOKING DATETIME NOT NULL,
    PAID BIT DEFAULT 0,
    TIME_PAYMENT DATETIME,
    CHECKED BIT DEFAULT 0
);
INSERT INTO USER(TYPE, FULLNAME, PHONE_NUMBER, EMAIL, PASSWORD, WALLET) VALUES ("ADMIN", "Đoàn Hưởng", "0888442448",  "huong@gmail.com", "123", "1000000");
INSERT INTO MOVIE_THEATER(TYPE, NAME, ADDRESS) VALUES 
("STANDARD", "EG Hùng Vương", "126 Hồng Bàng, Phường 12, Quận 5"),
("STANDARD", "EG Hoàng Văn Thụ", "415, Hoàng Văn Thụ, Phường 2, Quận Tân Bình"),
("STANDARD", "EG Sư Vạn Hạnh", "11 Sư Vạn Hạnh, Phường 12, Quận 10"),
("STANDARD", "EG Đồng Khởi", "72 Lê Thánh Tôn & 45A Lý Tự Trọng, Quận 1"),
("STANDARD", "EG Thủ Đức", "216 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức");
ALTER TABLE `enjoy_galaxy`.`cinema` 
RENAME TO  `enjoy_galaxy`.`room` ;
ALTER TABLE `enjoy_galaxy`.`showtime` 
DROP FOREIGN KEY `showtime_ibfk_1`;
ALTER TABLE `enjoy_galaxy`.`showtime` 
CHANGE COLUMN `ID_CINEMA` `ID_ROOM` BIGINT NOT NULL ,
DROP INDEX `ID_CINEMA` ,
ADD INDEX `ID_ROOM` (`ID_ROOM` ASC) VISIBLE;
;
ALTER TABLE `enjoy_galaxy`.`showtime` 
ADD CONSTRAINT `showtime_ibfk_1`
  FOREIGN KEY (`ID_ROOM`)
  REFERENCES `enjoy_galaxy`.`room` (`ID`);
INSERT INTO ROOM(ID_MOVIE_THEATER, TYPE, NAME) VALUES
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
CREATE INDEX INDEX_ID_MOVIE_THEATER ON ROOM (ID_MOVIE_THEATER);
ALTER TABLE enjoy_galaxy.SEAT DROP CONSTRAINT `seat_ibfk_1`;
TRUNCATE TABLE SHOWTIME;
ALTER TABLE SEAT DROP CONSTRAINT `REFERENCES_SHOWTIME_ID`;
ALTER TABLE SEAT ADD CONSTRAINT `REFERENCES_SHOWTIME_ID` FOREIGN KEY (ID_SHOWTIME) REFERENCES SHOWTIME(ID);
CREATE INDEX INDEX_ID_ROOM ON SHOWTIME (ID_ROOM);
EXPLAIN SELECT * FROM SHOWTIME WHERE ID_ROOM = 5;
ALTER TABLE SHOWTIME DROP INDEX ID_ROOM;
ALTER TABLE SHOWTIME ADD COLUMN ROW_SEAT INT NOT NULL;
ALTER TABLE SHOWTIME ADD COLUMN COLUMN_SEAT INT NOT NULL;
ALTER TABLE SHOWTIME DROP COLUMN ROW_SEAT;
ALTER TABLE SHOWTIME DROP COLUMN COLUMN_SEAT;
SELECT * FROM SEAT;
EXPLAIN SELECT * FROM SEAT WHERE ID_SHOWTIME = 7;
CREATE INDEX INDEX_ID_SHOWTIME ON SEAT(ID_SHOWTIME);
ALTER TABLE movie_theater
RENAME TO  CINEMA;
ALTER TABLE `enjoy_galaxy`.`room` 
DROP FOREIGN KEY `room_ibfk_1`;
ALTER TABLE `enjoy_galaxy`.`room` 
CHANGE COLUMN `ID_MOVIE_THEATER` `ID_CINEMA` BIGINT NOT NULL ,
DROP INDEX `INDEX_ID_MOVIE_THEATER` ,
ADD INDEX `INDEX_ID_CINEMA` (`ID_CINEMA` ASC) VISIBLE;
;
ALTER TABLE `enjoy_galaxy`.`room` 
ADD CONSTRAINT FK_CINEMA
  FOREIGN KEY (`ID_CINEMA`)
  REFERENCES CINEMA (`ID`);
  ALTER TABLE `enjoy_galaxy`.`room` 
DROP FOREIGN KEY `room_ibfk_1`;
ALTER TABLE `enjoy_galaxy`.`room` 
ADD CONSTRAINT `FK_CINEMA`
  FOREIGN KEY (`ID_MOVIE_THEATER`)
  REFERENCES enjoy_galaxy.movie_theater (ID);
  ALTER TABLE enjoy_galaxy.seat 
ADD COLUMN CAPACITY INT NOT NULL DEFAULT 1 AFTER ID_SHOWTIME;
ALTER TABLE SEAT CHANGE COLUMN `ready` `IS_EMPTY` BIT(1) NULL DEFAULT b'1' ;
ALTER TABLE MOVIE ADD COLUMN URL_IMAGE VARCHAR(500) UNIQUE;
UPDATE MOVIE SET URL_IMAGE = "https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/1.jpg?alt=media&token=fbbed138-34ca-49d2-87f1-42581be57609"
WHERE ID = 1;
UPDATE MOVIE SET URL_IMAGE = "https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/2.jpg?alt=media&token=c02fa731-b3f0-4128-a1f6-a3f537c95508"
WHERE ID = 2;
UPDATE MOVIE SET URL_IMAGE = "https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/3.jpg?alt=media&token=0f0dc405-b240-4f94-b4ca-8647010c9839"
WHERE ID = 3;
ALTER TABLE `enjoy_galaxy`.`movie` 
CHANGE COLUMN `IMAGE` `URL_IMAGE` VARCHAR(500) UNIQUE ;
DELIMITER //
CREATE PROCEDURE GET_MAP_SHOWTIME(IN ID_MOVIE BIGINT)
	BEGIN
		SELECT CINEMA.ID AS ID_CINEMA, CINEMA.TYPE AS TYPE_CINEMA,  CINEMA.NAME AS NAME, CINEMA.ADDRESS AS ADDRESS, SHOWTIME.ID AS ID_SHOWTIME, SHOWTIME.START_TIME AS START_TIME, SHOWTIME.END_TIME AS END_TIME, SHOWTIME.ID_ROOM AS ID_ROOM, SHOWTIME.ID_MOVIE AS ID_MOVIE
			FROM SHOWTIME
			JOIN ROOM ON SHOWTIME.ID_ROOM = ROOM.ID
			JOIN CINEMA ON ROOM.ID_CINEMA = CINEMA.ID
			WHERE SHOWTIME.ID_MOVIE = ID_MOVIE;
	END //
    DELIMITER ;
CALL GET_MAP_SHOWTIME(2);
-- https://console.firebase.google.com/u/0/project/module-3-daf70/storage/module-3-daf70.appspot.com/files			: link hình ảnh movie
ALTER TABLE movie
CHANGE COLUMN CONTENT CONTENT VARCHAR(5000) NULL DEFAULT NULL ;
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Trong lần trở lại này, cậu chàng Shazam vẫn trăn trở cho rằng mình “không xứng đáng với năng lực này”. Thế giới có The Flash nhanh như chớp với bộ suit đỏ đặc trưng, Aquaman to cao lực lưỡng và cả Batman siêu ngầu. Trong khi đó, Shazam vẫn chỉ là Shazam chẳng có năng lực gì khác biệt… hoặc là Billy Batson, một cậu nhóc trung học trong thân hình một siêu anh hùng cao to già đời, không thể kiểm soát sức mạnh của mình.\n\n Nếu như các siêu anh hùng khác khiến khán giả không khỏi trầm trồ vì những năng lực siêu phàm có thể cứu thế giới thì “cậu nhóc” Shazam, mỗi khi dùng siêu năng lực vẫn hậu đậu như một “chú hề” lừng danh khiến người xem phải bật cười.' WHERE (`ID` = '1');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Sau trận chiến khốc liệt với anh em quỷ Thượng Huyền Lục Gyuutarou và Daki tại Phố Đèn Đỏ, Tanjiro cùng các kiếm sĩ diệt quỷ đều bị thương nặng và được đưa trở về trụ sở của Đội Diệt Quỷ để dưỡng thương và phục hồi. Sau trận chiến, thanh gươm của Tanjiro cũng bị hư hỏng nặng và lúc này, cậu cần một thanh gươm mới để tiếp tục lên đường làm nhiệm vụ. Cậu được đưa đến Làng Rèn Gươm, nơi phụ trách rèn vũ khí cho các kiếm sĩ của Đội Diệt Quỷ và chuẩn bị cho trận chiến mới với các thành viên mạnh nhất trong hàng Thượng Huyền của Thập Nhị Quỷ Nguyệt.' WHERE (`ID` = '2');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Sau khi thống trị thế giới quyền anh, Adonis Creed đã phát triển mạnh mẽ trong cả sự nghiệp và cuộc sống gia đình. Khi một người bạn thời thơ ấu và cựu thần đồng quyền anh, Damian (Jonathan Majors), tái xuất sau khi thụ án tù dài hạn, anh ta háo hức chứng minh rằng mình xứng đáng được trở lại võ đài. Cuộc chạm trán giữa những người bạn cũ không chỉ là một cuộc chiến trên võ đài thông thường. Để có thể chiến thắng, Adonis phải đặt tương lai của mình lên trên hết để chiến đấu với Damian — một võ sĩ không còn gì để mất.' WHERE (`ID` = '3');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'How To Save The Immortal là bộ phim về nhân vật phản diện nổi tiếng nhất trong truyện cổ tích Nga. Bộ phim được đạo diện bởi Roman Artemiev và sự tham gia sản xuất của Vadim Sotskov, Sergei Selyanov, and Sergei Zernov. Xoay quanh cuộc đời của nhân vật Drybone sở hữu sức mạnh bất tử, dù luôn trẻ trung và bảnh bao nhưng vẫn không thể tìm được cô dâu cho mình trong suốt 300 năm. Mặc cho anh ta đe dọa, bắt cóc hay thậm chí biến nhiều công chúa thành ếch thì kế hoạch tán tỉnh của Hoàng Tử Bóng Đêm cùng không thuộn buồm xuôi gió hơn. Trong khi đó thì tất cả những gì mà nữ chiến binh xinh đẹp và dũng cảm Barbara làm là chống lại những kẻ sắp theo đuổi cô trên đấu trường hay những kẻ cầu hôn chỉ vì thèm muốn của hồi môn của Barbara. Sự đối lập này vô tình đưa Drybone và Barbara vào cuộc gặp gỡ định mệnh và cùng chiến đấu với phe phản diện mới là Vua Lentil – kẻ nắm giữ cây kim có thể tước đoạt mạng sống của Hoàng Tử Bóng Đêm Drybone. Dù vậy, hắn không thể ngờ vẫn còn điều kỳ diệu ẩn chứa bên trong trái tim của Drybone giúp anh ấy sống sót.' WHERE (`ID` = '4');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Guess who’s back? WINNER đã trở lại cùng đội hình đầy đủ 4 thành viên và mang đến bộ phim tài liệu đầu tiên mang tên WINNER 2022 Concert The Circle: The Movie. Đây sẽ là nơi truyền tải những cảnh quay hậu trường, phỏng vấn độc quyền, sự chuẩn bị kỹ càng và cố gắng không ngừng nghỉ của các thành viên dành cho concert The Circle để đem đến cho Inner Circle một buổi trình diễn mãn nhãn sau hơn 2 năm chờ đợi..' WHERE (`ID` = '5');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Everything Everywhere All At Once - Cuộc Chiến Đa Vũ Trụ là một bộ phim hài viễn tưởng kể về một gia đình nhập cư đang vật lộn với cuộc sống ở nước Mỹ. Dương Tử Quỳnh đóng vai Evelyn Wang - một người mẹ gốc Hoa đang kiệt sức khi điều hành một tiệm giặt ủi cùng với ông chồng lấm lem và tất bật của bà - Waymond (Quan Kế Huy đóng)' WHERE (`ID` = '6');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Scott Lang và Hope Van Dyne trở lại tiếp tục cuộc phiêu lưu của họ với vai trò Người Kiến và Chiến binh Ong. Cùng với cha mẹ của Hope, họ sẽ có chuyến khám phá Lượng Tử Giới, gặp gỡ những sinh vật mới lạ và bắt đầu cuộc hành trình vào thế giới lượng tử.' WHERE (`ID` = '7');
UPDATE `enjoy_galaxy`.`movie` SET `CONTENT` = 'Nhóm du khách trẻ vô tình phá bỏ phong ấn của con quái vật khát máu khi đến tham quan một hòn đảo cấm không dân địa phương nào dám đặt chân đến. Liệu họ có thể bình an thoát khỏi hay đó sẽ là nơi chôn vùi tất cả?' WHERE (`ID` = '8');

INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('9', 'NGỤC TỐI & RỒNG: DANH DỰ CỦA KẺ TRỘM', 'John Francis Daley, Jonathan Goldstein', 'Chris Pine, Michelle Rodriguez, Regé-Jean Page', 'Hành Động, Phiêu Lưu, Thần thoại', '2023-04-21', '134', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Theo chân một tên trộm quyến rũ và một nhóm những kẻ bịp bợm nghiệp dư thực hiện vụ trộm sử thi nhằm lấy lại một di vật đã mất, nhưng mọi thứ trở nên nguy hiểm khó lường hơn bao giờ hết khi họ đã chạm trán nhầm người. Ngục Tối Và Rồng: Danh Dự Của Kẻ Trộm mang thế giới huyền ảo của trò chơi nhập vai huyền thoại lên màn ảnh rộng bằng một cuộc phiêu lưu tràn ngập các màn hành động đã mắt cùng màu sắc hài hước, vui nhộn.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F9.jpg?alt=media&token=ca836265-3da6-4248-a714-de26a8c8dba9');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('10', 'KHẾ ƯỚC', 'Guy Ritchie', 'Jake Gyllenhaal, Alexander Ludwig, Antony Starr,…', 'Hành Động, Hồi hộp, Tội phạm', '2023-04-21', '123', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Trong nhiệm vụ cuối cùng ở Afghanistan, Trung sĩ John Kinley cùng đội với phiên dịch viên bản địa Ahmed. Khi đơn vị của họ bị phục kích, Kinley và Ahmed là 2 người sống sót duy nhất. Bị kẻ địch truy đuổi, Ahmed liều mạng đưa Kinley đang bị thương băng qua nhiều dặm đường địa hình khắc nghiệt đến nơi an toàn. Trở về Mỹ, Kinley biết rằng Ahmed và gia đình không dc cấp giấy thông hành tới Mỹ như đã hứa. Quyết tâm bảo vệ bạn mình và đền ơn cứu mạng, Kinley trở lại chiến trường để giúp Ahmed và gia đình trước khi lực lượng phiến quân phát hiện ra họ.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F10.jpg?alt=media&token=9618947b-ac3d-40f5-8d56-6ac0fd09359e');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('11', 'ĐẦU GẤU ĐỤNG ĐẦU ĐẤT', 'Park Sung Kwang', 'Park Sung Woong, Lee Yi Kyung, Yeom Hye Ran, Choi Min Su, Oh Dal Soo', 'Hài, Hành Động', '2023-04-21', '98', 'Tiếng Hàn - Phụ đề tiếng Việt', 'Phim Đầu Gấu Đụng Đầu Đất dựa trên câu chuyện thần thoại nổi tiếng tại Hàn Quốc về hai chú gấu sinh đôi hoá thành người sau khi ăn tỏi và ngải cứu trong 100 ngày. Chú gấu ăn tỏi trở thành Na Woong-nam, được một cặp vợ chồng nhà khoa học mang về nuôi nấng, tuy chỉ mới 25 tuổi nhưng lại sở hữu “giao diện” của một ông chú 52 với cái “đầu đất” ngây thơ, hiền lành. Trong khi đó, chú gấu ăn ngải cứu trở thành “đầu gấu” Lee Jeong-hak, được một tên trùm tổ chức tội phạm mang về nuôi và bị lợi dụng như một món “vũ khí” phòng vệ. Trong một tình huống bất đắc dĩ, Na Woong-nam đã trực tiếp đối đầu cùng anh em song sinh Lee Jeong-hak để ngăn chặn một vụ khủng bố virus có tầm lây lan mạnh. Sức mạnh của loài gấu bộc phát sẽ đẩy cuộc đụng độ của cặp gấu song sinh hoá người đi đến hồi kết nào?', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F11.jpg?alt=media&token=987a782a-4ffc-4adc-9a13-91e89cc01cdb');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('12', 'PHIM ANH EM SUPER MARIO', 'Aaron Horvath, Michael Jelenic', 'Chris Pratt, Anya Taylor-Joy, Charlie Day, …', 'Hài, Hoạt Hình, Phiêu Lưu', '2023-04-07', '93', 'Tiếng Anh - Phụ đề Tiếng Việt; Lồng tiếng', 'Câu chuyện về cuộc phiêu lưu của anh em Super Mario đến vương quốc Nấm.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F12.jpg?alt=media&token=40d6a2cd-fd8f-4ab9-9faf-9918240fce42');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('13', 'ÂM VỰC CHẾT', 'Alessandro Antonaci, Stefano Mandalà, Daniel Lascar', 'Lucia Caporaso, Guido Carta, Chiara Casolari', 'Kinh Dị', '2023-04-21', '93', 'Tiếng Ý - Phụ đề Tiếng Việt', 'Sau cái chết của cha, Emma (Penelope Sangiorgi) vội vã bay từ New York về quê nhà ở Ý để lo hậu sự. Trong thời gian diễn ra tang lễ, Emma ở một mình trong căn nhà mà cha mẹ để lại. Lúc này, cô bị buộc phải đối mặt với một thực thể tà ác có khả năng kết nối thông qua một chiếc radio bị nguyền rủa. Để sống sót và bảo vệ những người mình yêu thương, Emma phải tìm ra bí mật đen tối ẩn sau chiếc radio ma quỷ kia…', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F13.jpg?alt=media&token=045d5978-7c26-4154-bede-70b7c246f18a');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('14', 'KHẮC TINH CỦA QUỶ', 'Julius Avery', 'Russell Crowe, Franco Nero…', 'Kinh Dị', '2023-04-14', '104', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Lấy cảm hứng từ những hồ sơ có thật của Cha Gabriele Amorth, Trưởng Trừ Tà của Vatican (Russell Crowe, đoạt giải Oscar®), bộ phim \"The Pope\'s Exorcist\" theo chân Amorth trong cuộc điều tra về vụ quỷ ám kinh hoàng của một cậu bé và dần khám phá ra những bí mật hàng thế kỷ mà Vatican đã cố gắng giấu kín.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F14.jpg?alt=media&token=c4e8f4d9-e6ec-4f73-9eb8-6c3e1262c0f5');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('15', 'CHUYỆN TÔI VÀ MA QUỶ THÀNH NGƯỜI MỘT NHÀ', 'Cheng Wei-hao', 'Greg Hsu, Austin Lin, Gingle Wang', 'Bí ẩn, Hài, Hành Động', '2023-04-07', '130', 'Tiếng Trung Quốc - Phụ đề Tiếng Việt', 'Ming-Han là một cảnh sát nhiệt huyết. Một ngày nọ, trong quá trình truy bắt tội phạm cùng người đồng nghiệp xinh đẹp Zi-Qing, Ming-Han vô tình nhặt được một phong bao màu đỏ, và một nhóm người bất ngờ nhảy ra gọi anh là \"con rể\". Họ yêu cầu anh ta kết hôn với đứa con đã chết của họ. Ming-Han không thể chấp nhận quyết định này. Tuy nhiên, anh ấy sau đó anh ta gặp phải vô số sự cố xui xẻo. Điều đáng sợ hơn nữa là anh ta bắt đầu nhìn thấy người chồng ma Mao-Mao của mình. Vì vậy, Ming-Han đã tìm đến thầy để tìm cách. Để thoát khỏi Mao-Mao, Ming-Han không còn cách nào khác ngoài việc giúp anh ta thực hiện mọi mong muốn của mình. Nếu không, Mao-Mao sẽ theo anh ta mãi mãi.Đồng thời, Mao-Mao cũng đóng vai trò là đối tác của Ming-Han để giúp anh ta điều tra vụ buôn lậu ma túy. Một cuộc hành trình giả tưởng đầy tiếng cười và nước mắt giữa một người đàn ông thẳng thắn và một con ma đồng tính đã bắt đầu.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F15.jpg?alt=media&token=55288daa-7c48-4288-aa4d-9715448dc5a4');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('16', 'CÚ ÚP RỔ ĐẦU TIÊN', 'Takehiko Inoue, Yasuyuki Ebara', 'Masaya Fukunishi, Yoshiaki Hasegawa, Katsuhisa Hoki, Tetsu Inada, Ryota Iwasaki, Shinichiro Kamio, Mitsuaki Kanuka, Jun Kasama, Subaru Kimura,..', 'Hài, Hoạt Hình', '2023-04-14', '124', 'Tiếng Nhật - Phụ đề Tiếng Việt & Tiếng Hàn', 'Bộ phim hoạt hình chuyển thể từ loạt truyện tranh “Slam Dunk” nổi tiếng của Takehiko Inoue, khắc họa quá trình trưởng thành cá nhân của những học sinh trung học cống hiến tuổi trẻ cho bóng rổ. Phim theo chân Ryota Miyagi, hậu vệ của đội bóng rổ trường trung học Shohoku. Anh có một người anh trai, Sota, hơn anh ba tuổi và là người đã truyền cảm hứng cho tình yêu bóng rổ của anh. Ryota và các đồng đội của mình là Hanamichi Sakuragi, Takenori Akagi, Hisashi Mitsui và Kaede Rukawa thách đấu nhà vô địch bóng rổ liên trường, đội bóng rổ trường trung học Sannoh. Tác giả nguyên tác Inoue phụ trách chỉ đạo và viết kịch bản.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F16.jpg?alt=media&token=13fe52f3-3c14-4e98-a3f7-f496ae39b654');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('17', 'RENFIELD TAY SAI CỦA QUỶ', 'Chris McKay', 'Nicolas Cage, Nicholas Hoult, Awkwafina', 'Hài, Kinh Dị', '2023-04-14', '92', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Trong câu chuyện quái vật hiện đại về người hầu trung thành của Dracula, Renfield (do Nicholas Hoult thủ vai), kẻ bề tôi đáng thương của ông chủ tự ái nhất lịch sử, Dracula (do Nicolas Cage thủ vai). Renfield bị buộc phải bắt con mồi về cho chủ nhân và thực hiện mọi mệnh lệnh, kể cả việc đó nhục nhã như thế nào. Nhưng giờ đây, sau nhiều thế kỷ làm nô lệ, Renfield đã sẵn sàng để khám phá cuộc sống bên ngoài cái bóng của Hoàng Tử Bóng Đêm. Liệu anh ấy có thể tìm được cách để thoát khỏi mỗi quan hệ độc hại này?', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F17.jpg?alt=media&token=6f0f7fbc-24ab-4c59-9393-28ab3d14ffea');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('18', 'CHÀNG TRAI XINH ĐẸP CỦA TÔI', 'Sakai Mai', 'Riku Hagiwara, Yûsei Yagi, Akira Takano,…', 'Tình cảm', '2023-04-14', '132', 'Tiếng Nhật - Phụ đề Tiếng Việt, tiếng Anh', 'Hira, một nam sinh 17 tuổi có một cuộc sống cô độc ở trường, không bao giờ muốn phơi bày tật nói lắp của mình với các bạn cùng lớp. Anh ấy nhìn thế giới qua ống kính máy ảnh của mình, cho đến một ngày Kiyoi Sou bước qua cửa lớp.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F18.jpg?alt=media&token=5dbab3c2-0f84-45ee-b0fa-843c9ec4c4f4');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('19', 'AIR - THEO ĐUỔI MỘT HUYỀN THOẠI', 'Ben Affleck', 'Matt Damon, Ben Affleck, Jason Bateman, Chris Messina, Matthew Maher, Marlon Wayans, Jay Mohr, Julius Tennon, Chris Tucker, Viola Davis', 'Tâm Lý', '2023-04-14', '112', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Từ đạo diễn đã từng đoạt giải thưởng Ben Affleck, AIR hé lộ mối quan hệ đột phá giữa huyền thoại Michael Jordan khi mới bắt đầu sự nghiệp và bộ phận bóng rổ còn non trẻ của Nike, đã làm thay đổi thế giới thể thao và văn hóa đương đại với thương hiệu Air Jordan. Câu chuyện cảm động này kể về sự đánh cược khi đặt lên bàn cân tình hình kinh doanh của cả công ty, tầm nhìn vĩ đại của một người mẹ biết giá trị và tài năng của con trai mình, và một siêu sao bóng rổ đã trở thành huyền thoại.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F19.jpg?alt=media&token=8fed8a7e-2e83-4eba-b85b-054f2b3edce6');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('20', 'MẶT NẠ QUỶ', 'Lawrence Fowler', 'Michaela Longden, Rebecca Phillipson, Tom Millen, Victor Mellors', 'Kinh Dị', '2023-04-14', '102', 'Tiếng Anh - Phụ đề Tiếng Việt', 'Bí ẩn về cái chết của em gái Evie 20 năm trước còn bỏ ngỏ, vào lúc 09:09 hằng đêm, hàng loạt cuộc chạm trán kinh hoàng xảy ra. Liệu Margot có biết được sự thật ai là kẻ giết em gái mình?', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F20.jpg?alt=media&token=c14e379c-1918-4676-b628-73f2ea251541');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('21', 'TÌNH CHỊ DUYÊN EM', 'Wanweaw Hongvivatana, Weawwan Hongvivatana', '  Thitiya Jirapornsilp, Anthony Buisseret,...', '  Hài, Tình cảm', '2023-04-07', '121', '  Tiếng Thái - Phụ đề tiếng Việt', 'Chuyện phim lấy bối cảnh năm 1999, khi thế giới đang chìm trong nỗi sợ hãi Y2K - sự cố khiến hệ thống máy tính sụp đổ và dự đoán có thể làm trái đất diệt vong khi bước sang năm 2000. Ngay lúc này, hai chị em sinh đôi giống hệt nhau là “You” và “Me” cũng đang lo lắng cho tương lai của họ về việc “làm sao sống mà có thể thiếu vắng nhau”. Cặp song sinh thân thiết với nhau đến mức có thể chia sẻ mọi khía cạnh cuộc sống cho nhau, kể cả nụ hôn đầu. Tình chị em tưởng chừng không thể rạn nứt cho đến khi chàng trai tên Mark chen vào giữa họ. Nếu ngay từ đầu, “lợi ích” của việc có ngoại hình giống hệt nhau được họ áp dụng để gian lận trong nhà hàng, rạp chiếu phim và trường học, thì sự xuất hiện của Mark khiến mọi thứ trở nên rối tung. Khi cặp song sinh phải đối mặt với “mối tình đầu không thể chia sẻ” như những thứ khác, cuộc xung đột nội tâm này sẽ dẫn họ bước sang giai đoạn mới của cuộc đời như thế nào?', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F21.jpg?alt=media&token=1b2b6c17-b6fd-4d85-a97e-bab186b4795a');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('22', 'TRI KỶ', '  Young-Keun Min', '  Kim Da-mi, Woo-Seok Byeon, Nam Yoon-Su, So-nee Jeon, Kim Soo Hyung', '  Hồi hộp, Tâm Lý', '2023-03-24', '124', '  Tiếng Hàn - Phụ đề tiếng Việt', 'Soulmate (tựa Việt: Tri Kỷ) là câu chuyện về Mi So (Kim Da Mi thủ vai) và Ha Eun (Jeon So Nee thủ vai) trong một mối quan hệ chồng chéo chất chứa những hạnh phúc, nỗi buồn, rung động và cả biệt ly. Từ giây phút đầu tiên gặp nhau dưới mái trường tiểu học, giữa hai cô gái đã hình thành một sợi dây liên kết đặc biệt. Và khi Ham Jin Woo (Byun Woo Seok thủ vai) bước vào giữa cả hai, đó cũng là lúc những vết nứt trong mối quan hệ của Mi So và Ha Eun xuất hiện.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F22.jpg?alt=media&token=2282513c-5b66-4dac-9b16-2576d13d3202');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('23', 'SIÊU LỪA GẶP SIÊU LẦY', '  Võ Thanh Hòa', '  Anh Tú, Mạc Văn Khoa, Ngọc Phước, Nhất Trung, NSƯT Mỹ Duyên, Đại Nghĩa, Lâm Vỹ Dạ, BB Trần, Cát Tường, Hứa Minh Đạt…', '  Hài, Hành Động', '2023-03-03', '112', '  Tiếng Việt - Phụ đề Tiếng Anh', 'Thuộc phong cách hành động – hài hước với các “cú lừa” thông minh và lầy lội đến từ bộ đôi Tú (Anh Tú) và Khoa (Mạc Văn Khoa), Siêu Lừa Gặp Siêu Lầy của đạo diễn Võ Thanh Hòa theo chân của Khoa – tên lừa đảo tầm cỡ “quốc nội” đến đảo ngọc Phú Quốc với mong muốn đổi đời. Tại đây, Khoa gặp Tú – tay lừa đảo “hàng real” và cùng Tú thực hiện các phi vụ từ nhỏ đến lớn. Cứ ngỡ sự ranh mãnh của Tú và sự may mắn trời cho của Khoa sẽ giúp họ trở thành bộ đôi bất khả chiến bại, nào ngờ lại đối mặt với nhiều tình huống dở khóc – dở cười. Nhất là khi băng nhóm của bộ đôi nhanh chóng mở rộng vì sự góp mặt của ông Năm (Nhất Trung) và bé Mã Lai (Ngọc Phước).', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F23.jpg?alt=media&token=09f6dcda-deaf-472b-9aa9-28c21d5e4e5d');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `ACTORS`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('24', 'BIỆT ĐỘI RẤT ỔN', '  Tạ Nguyên Hiệp', '  Lê Khánh, Hứa Vĩ Văn, Hoàng Oanh, Quang Tuấn, Võ Tấn Phát, Nguyên Thảo, Ngọc Phước, Ngọc Hoa, Lạc Hoàng Long', '  Hài', '2023-03-21', '104', 'Tiếng Việt - Phụ đề Tiếng Anh', 'BIỆT ĐỘI RẤT ỔN xoay quanh bộ đôi Quyên (Hoàng Oanh) và Phong (Hứa Vĩ Văn). Sau lần chạm trán tình cờ, bộ đôi lôi kéo Bảy Cục (Võ Tấn Phát), Bảy Súc (Nguyên Thảo), Quạu (Ngọc Phước), Quọ (Ngọc Hoa) tham gia vào phi vụ đặc biệt: Đánh tráo chiếc vòng đính hôn bằng kim cương quý giá và lật tẩy bộ mặt thật của Tuấn - chồng cũ của Quyên trong đám cưới giữa hắn và Tư Xoàn - nữ đại gia miền Tây sở hữu khối tài sản triệu đô. Màn kết hợp bất đắc dĩ của Biệt Đội Rất Ổn - Phong, Quyên và Gia Đình Cục Súc nhằm qua mắt “cô dâu, chú rể” tại khu resort sang chảnh hứa hẹn cực kỳ gay cấn, hồi hộp nhưng không kém phần hài hước, xúc động.', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F24.jpg?alt=media&token=f62c35b5-2ac6-4619-bdae-a5a34694b264');
INSERT INTO `enjoy_galaxy`.`movie` (`ID`, `NAME`, `DIRECTOR`, `GENRE`, `PREMIERE_DATE`, `DURATION`, `LANGUAGE`, `CONTENT`, `URL_IMAGE`) VALUES ('25', 'KHÓA CHẶT CỬA NÀO SUZUME', '  Makoto Shinkai', '  Hoạt Hình, Phiêu Lưu', '2023-03-10', '122', '  Tiếng Nhật - Phụ đề Tiếng Việt, tiếng Anh', '\"Khóa Chặt Cửa Nào Suzume\" kể câu chuyện khi Suzume vô tình gặp một chàng trai trẻ đến thị trấn nơi cô sinh sống với mục đích tìm kiếm \"một cánh cửa\". Để bảo vệ Nhật Bản khỏi thảm họa, những cánh cửa rải rác khắp nơi phải được đóng lại, và bất ngờ thay Suzume cũng có khả năng đóng cửa đặc biệt này. Từ đó cả hai cùng nhau thực hiện sự mệnh \"khóa chặt cửa\"!', 'https://firebasestorage.googleapis.com/v0/b/module-3-daf70.appspot.com/o/movie%2F25.jpg?alt=media&token=7c27fcad-6084-4009-b2df-ac9fb8ff5719');
ALTER TABLE `enjoy_galaxy`.`user` 
CHANGE COLUMN `WALLET` `WALLET` DOUBLE NULL DEFAULT 0 ;

ALTER TABLE SEAT ADD COLUMN PRICE DOUBLE;