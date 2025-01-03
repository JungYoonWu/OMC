commit;

select *
  from users;

select *
  from users
 where role_id = 2;

select *
  from omdoctor;
select *
  from doctor_schedule;
select *
  from reservations;
select *
  from roles;

insert into roles(role_id, role_name)
values (1, 'patient');
insert into roles(role_id, role_name)
values (2, 'doctor');
insert into roles(role_id, role_name)
values (3, 'admin');
update roles
set role_name = 'nurse'
where role_id = 3;
insert into roles(role_id, role_name)
values (4, 'admin');

create sequence seq_user_no
NOCACHE;

alter table users add (user_no number);

insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_user', 'yoon', 'test@naver.com', 'asdf', '010-1111-2222', '1', seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_user2', 'woo', 'test@gmail.com', '1234', '010-3333-2222', '1', seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_user3', 'young', 'test@daum.net', '1123', '010-3233-2222', '1', seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_user4', 'joong', 'test2@naver.com', '12345', '010-3533-2222', '1', seq_user_no.nextval);


insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_doctor1', 'whereis', 'test1@gmail.com', 'doctor', '010-5555-2222', 2, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_doctor2', 'mydoctor', 'test2@gmail.com', 'doctor', '010-5252-2222', 2, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_doctor3', 'faker', 'test3@gmail.com', 'doctor', '010-5252-2222', 2, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_doctor4', 'oner', 'test4@gmail.com', 'doctor', '010-5252-2222', 2, seq_user_no.nextval);

insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_nurse1', 'mynurse', 'test2@gmail.com', 'nurse', '010-5252-2222', 3, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_nurse2', 'mynurse', 'test2@gmail.com', 'nurse', '010-5252-2222', 3, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_nurse3', 'mynurse', 'test2@gmail.com', 'nurse', '010-5252-2222', 3, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_nurse4', 'mynurse', 'test2@gmail.com', 'nurse', '010-5252-2222', 3, seq_user_no.nextval);
insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('test_nurse5', 'mynurse', 'test2@gmail.com', 'nurse', '010-5252-2222', 3, seq_user_no.nextval);

insert into users (user_id, name, email, password, phone, role_id, user_no)
values ('admin', 'admin', 'admin@gmail.com', 'admin', '010-1234-5678', 4, seq_user_no.nextval);


select user_id, name, email, phone, m2.role_name, user_no
  from users m1
      join roles m2 on m2.role_id = m1.role_id
 where m1.role_id = 1;

select user_id, name, email, phone, m2.role_name, user_no
  from users m1
      join roles m2 on m2.role_id = m1.role_id
                   and m2.role_name = 'doctor';

select *
  from users
 where role_id = 2;
select *
  from omdoctor;

insert into omdoctor(doctor_id, user_id, license_no, specialty)
values(seq_doctor_id_no.nextval, 'test_doctor1', 111999, '한방내과');
insert into omdoctor(doctor_id, user_id, license_no, specialty)
values(seq_doctor_id_no.nextval, 'test_doctor2', 111888, '침구과');
insert into omdoctor(doctor_id, user_id, license_no, specialty)
values(seq_doctor_id_no.nextval, 'test_doctor3', 111777, '침구과');
insert into omdoctor(doctor_id, user_id, license_no, specialty)
values(seq_doctor_id_no.nextval, 'test_doctor4', 111666, '침구과');
create sequence seq_doctor_id_no
increment by 1
start with 1
nocache
nocycle;

update users
   set name = '안형욱'
 where user_id = 'test_doctor4';
 commit;
 select * from users where role_id = 2;