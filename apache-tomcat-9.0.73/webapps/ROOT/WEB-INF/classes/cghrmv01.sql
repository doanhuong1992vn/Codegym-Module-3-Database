create database cghrmv01;

create table if not exists roles (
    id int not null auto_increment,
    name varchar(50) not null,
    description varchar(50) not null,
    constraint roles_pk primary key(id)
    );

insert into roles (name, description) values
('ROLE_ADMIN', 'Quản trị viên')
,('ROLE_USER', 'Nhân viên')
;

create table if not exists users (
    id int not null auto_increment,
    role_id int not null,
    fullname varchar(100) not null,
    username varchar(100) not null,
    password varchar(200) not null,
    email varchar(100) not null,
    address varchar(200) not null,
    phone varchar(12) not null,
    avatar varchar(200) not null,
    activated bool not null,
    remember_token varchar(200),
    constraint users_pk primary key (id),
    constraint users_uk unique (username, email, phone),
    constraint users_roles_fk foreign key (role_id) references roles (id)
);

insert into users (role_id, fullname, username, password, email, address, phone, avatar, activated, remember_token) values
(1, 'Nguyễn Bá Minh Đạo', 'daonguyenadmin', '$2a$10$aXGQKNTdX9.5E9zI2o/1zOy1MFBmHZ8owc6RaXJR89ymzx.CoLSMC', 'daonguyen.admin@gmail.com',
 'Hồ Chí Minh', '0908983906', 'avatar1.png', true, 'rAPHFeXDlQCjenQ6nffqe56hC9EulnyQTDKGzhuKjCIrVI4Cy0hWGEtsvJdA') -- password: Password1
,(2, 'Nguyễn Minh Châu', 'chaunguyenstaff', '$2a$10$oztyYOzexbKMwNQi.xfE4uOVjKByoNiuAHKO9zL83LMA0czAXtP3.', 'chaunguyen.staff@gmail.com',
'Hồ Chí Minh', '0985678910', 'avatar1.jpg', true, 'sDh9x4HXrBCOJzgBH5qeZwcjVgN8Uv4u1WZBVQsYbp0moh7eDG260xJe07dF') -- password: 123456
,(2, 'Nguyễn Văn Tèo', 'teonguyenstaff', '$2a$10$oztyYOzexbKMwNQi.xfE4uOVjKByoNiuAHKO9zL83LMA0czAXtP3.', 'teonguyen.staff@gmail.com',
'Hồ Chí Minh', '0981234567', 'avatar1.jpg', true, '2iV7Lpa1sgCafdEOkbh2wVeYKamoc7kAb0CF6kAQJSVymts7g1uHZO9iUMI7') -- password: 123456
;