--1번
create table users (
    user_id varchar2(100) primary key,
    name varchar2(100) not null,
    email varchar2(100) not null,
    password varchar2(100) not null,
    phone varchar2(20) not null,
    role_id int
);

--2번
create table roles (
    role_id int primary key,
    role_name varchar2(50) not null
);
alter table users
add constraint fk_roles
foreign key (role_id)
references roles(role_id);

--3번
create table inquiries (
    inquiry_id int primary key,
    user_id varchar2(100),
    title VARCHAR2(200) not null,
    content clob not null,
    reg_date date default sysdate,
    status varchar2(20),
    CONSTRAINT fk_inquiry_user foreign key (user_id) references users(user_id)
);

--4번
create table replies (
    reply_id int primary key,
    inquiry_id int,
    admin_id varchar2(50),
    content clob not null,
    reg_date date default sysdate,
    constraint fk_reply_inquiry foreign key (inquiry_id) references inquiries(inquiry_id),
    constraint fk_reply_admin foreign key (admin_id) references users(user_id)
);

--5번
create table treatment_rooms (
    room_id int primary key,
    room_name varchar2(100) not null,
    room_location varchar2(100)
);

--6번
create table herbal_medicines (
    medicine_id int primary key,
    name varchar2(100) not null,
    description clob,
    seasonal_recommendation char(1) check (seasonal_recommendation in ('Y','N'))
);

--7번
create table treatments (
    treatment_id int primary key,
    name varchar2(100) not null,
    description clob,
    price decimal(10, 2) not null,
    room_id int,
    constraint fk_treatment_room foreign key (room_id) references treatment_rooms(room_id)
);

--8번
create table reservations (
    reservation_id int primary key,
    user_id varchar(50),
    reservation_date date not null,
    reservation_time TIMESTAMP not null,
    status varchar2(20),
    treatment_id int,
    constraint fk_reservation_user foreign key (user_id) references users(user_id),
    constraint fk_reservation_treatment foreign key (treatment_id) references treatments(treatment_id)
);

--9번
create table visit_history(
    visit_id int primary key,
    user_id varchar2(50),
    treatment_id int,
    visit_date date not null,
    remarks clob,
    constraint fk_visit_user foreign key (user_id) references users(user_id),
    constraint fk_visit_treatment foreign key (treatment_id) references treatments(treatment_id)
);

--10번
create table notices (
    notice_id int primary key,
    title varchar2(200) not null,
    content clob not null,
    reg_date date default sysdate
);

--11번
create table cart(
    cart_id int primary key,
    user_id varchar2(50),
    reg_date date default sysdate,
    constraint fk_cart_user foreign key (user_id) references users(user_id)
);

--12번
create table cart_items (
    cart_item_id int primary key,
    cart_id int,
    medicine_id int,
    quantity int not null,
    price decimal(10,2) not null,
    constraint fk_cart_item_cart foreign key (cart_id) references cart(cart_id),
    constraint fk_cart_item_medicine foreign key (medicine_id) references herbal_medicines(medicine_id)
);

--13번
create table orders(
    order_id int primary key,
    user_id varchar2(50),
    total_price DECIMAL(10,2) not null,
    order_date date default sysdate,
    status varchar2(20),
    delivery_address varchar2(200),
    contact_number varchar2(100),
    constraint fk_order_user foreign key (user_id) references users(user_id)
);

--14번
create table order_items (
    order_item_id int primary key,
    order_id int,
    medicine_id int,
    quantity int not null,
    price decimal(10,2) not null,
    constraint fk_order_item_order foreign key (order_id) references orders(order_id),
    constraint fk_order_item_medicine foreign key (medicine_id) references herbal_medicines(medicine_id)
);

--15번
create table payments (
    payment_id int primary key,
    order_id int,
    amount decimal(10,2) not null,
    payment_date date default sysdate,
    payment_method varchar2(50),
    status varchar2(20),
    constraint fk_payment_order foreign key (order_id) references orders(order_id)
);

--16번
CREATE TABLE shipping (
    shipping_id INT PRIMARY KEY,
    order_id INT,
    shipping_date DATE,
    tracking_number VARCHAR2(50),
    status VARCHAR2(20),
    delivery_company VARCHAR2(50),
    CONSTRAINT fk_shipping_order FOREIGN KEY (order_id) REFERENCES orders(order_id)
);

--17번
CREATE TABLE omdoctor (
    doctor_id INT PRIMARY KEY ,
    user_id varchar2(100) NOT NULL,
    license_no VARCHAR(50) NOT NULL,
    specialty VARCHAR(100),
    constraint fk_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

commit;

select *
  from users;