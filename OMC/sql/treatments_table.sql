commit;
select *
  from treatments;
  
select *
  from treatment_rooms;

select *
  from beds;
select *
  from omdoctor;

alter table omdoctor
drop column
    work_end_time;

alter table beds
add (status varchar2(5) default 'empty');
alter table beds
drop column status;

create table doctor_schedule(
    schedule_id number primary key,
    doctor_id number,
    work_day varchar2(10),
    work_start_time date,
    work_end_time date,
    constraint fk_doctor_id foreign key (doctor_id) references omdoctor (doctor_id)
);
select *
  from doctor_schedule;
create sequence seq_schedule_id_no
increment by 1
start with 1
nocache
nocycle;
--의사1
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 2, 'Monday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 2, 'Tuesday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 2, 'Wednesday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 2, 'Friday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 2, 'Saturday', to_date('09:00:00', 'HH24:MI:SS'), to_date('15:00:00', 'HH24:MI:SS'));

--의사2
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 3, 'Monday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 3, 'Wednesday', to_date('11:00:00', 'HH24:MI:SS'), to_date('20:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 3, 'Thursday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 3, 'Friday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 3, 'Sunday', to_date('09:00:00', 'HH24:MI:SS'), to_date('15:00:00', 'HH24:MI:SS'));


--의사3
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 4, 'Monday', to_date('11:00:00', 'HH24:MI:SS'), to_date('20:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 4, 'Tuesday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 4, 'Thursday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 4, 'Friday', to_date('11:00:00', 'HH24:MI:SS'), to_date('20:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 4, 'Saturday', to_date('09:00:00', 'HH24:MI:SS'), to_date('15:00:00', 'HH24:MI:SS'));

--의사4
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 5, 'Tuesday', to_date('11:00:00', 'HH24:MI:SS'), to_date('20:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 5, 'Wednesday', to_date('09:00:00', 'HH24:MI:SS'), to_date('18:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 5, 'Thursday', to_date('11:00:00', 'HH24:MI:SS'), to_date('20:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 5, 'Saturday', to_date('09:00:00', 'HH24:MI:SS'), to_date('15:00:00', 'HH24:MI:SS'));
insert into doctor_schedule(schedule_id, doctor_id, work_day, work_start_time, work_end_time)
values(seq_schedule_id_no.nextval, 5, 'Sunday', to_date('09:00:00', 'HH24:MI:SS'), to_date('15:00:00', 'HH24:MI:SS'));

select *
  from reservations
 where to_char(reservation_date, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd');
 
select substr(reservation_time, 12, 2) as rh, substr(reservation_time, 15, 2) as rm
  from (
        select *
          from reservations
         where to_char(reservation_date, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd')  
        )
 where substr(reservation_time, 12, 2) > to_char(sysdate, 'HH24')
    or (substr(reservation_time, 12, 2) = to_char(sysdate, 'HH24') and substr(reservation_time, 15, 2) >= to_char(sysdate, 'MI'));

select substr(reservation_time, 12, 2) as rh, substr(reservation_time, 15, 2) as rm
  from (
        select *
          from reservations
         where to_char(reservation_date, 'yyyy-mm-dd') = to_char(sysdate, 'yyyy-mm-dd')  
        )
 where substr(reservation_time, 12, 2) < to_char(sysdate, 'HH24')
    or (substr(reservation_time, 12, 2) = to_char(sysdate, 'HH24') and substr(reservation_time, 15, 2) <= to_char(sysdate, 'MI'));
        
select *
  from doctor_schedule ds
       join omdoctor omd on omd.doctor_id = ds.doctor_id
 where omd.doctor_id = 5;
 
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 1);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 2);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 3);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 4);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 5);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 6);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 7);
insert into beds(bed_id, room_id, bed_number)
values (seq_bed_id_no.nextval, 1, 8);

update treatment_rooms
   set room_location = '1치료실'
 where room_id = 1;
  
select *
  from reservations;

create sequence seq_treatment_room_id_no
increment by 1
start with 1
nocache
nocycle
;
create sequence seq_treatment_id_no
increment by 1
start with 1
nocache
nocycle
;


insert into treatments (treatment_id, name, description, price, room_id)
values (seq_treatment_id_no.nextval, '침치료', '침으로치료', 5600, 1);

insert into treatment_rooms (room_id, room_name, room_location)
values (seq_treatment_room_id_no.nextval, '침방', '1치료실');
insert into treatment_rooms (room_id, room_name, room_location)
values (seq_treatment_room_id_no.nextval, '추나방', '2치료실');
insert into treatment_rooms (room_id, room_name, room_location)
values (seq_treatment_room_id_no.nextval, '상담방', '3치료실');
insert into treatment_rooms (room_id, room_name, room_location)
values (seq_treatment_room_id_no.nextval, '기구방', '4치료실');

drop table treatments;
alter table treatments
drop column room_id;

alter table treatments
add (bed_id number null);

alter table treatments
add constraint fk_treatment_bed foreign key (bed_id) references beds(bed_id);

create table beds(
    bed_id number primary key,
    room_id number not null,
    bed_number number not null,
    constraint fk_feds_room foreign key (room_id) references treatment_rooms(room_id)
);

create sequence seq_bed_id_no
increment by 1
start with 1
nocache
nocycle
;
select *
 from doctor_schedule;
        SELECT doctor_id 
        FROM omdoctor
        WHERE user_id = 'test_doctor2';
SELECT 
    ds.schedule_id AS scheduleID, 
    ds.doctor_id AS doctorID, 
    ds.work_day AS workDay,
    TO_CHAR(ds.work_start_time, 'HH24:MI:SS') AS workStartTime,
    TO_CHAR(ds.work_end_time, 'HH24:MI:SS') AS workEndTime
FROM doctor_schedule ds
     join omdoctor omd on omd.doctor_id = ds.doctor_id
--WHERE ds.doctor_id = 2
  where ds.work_day = 'Monday';
  
  SELECT 
    ds.schedule_id AS scheduleID, 
    ds.doctor_id AS doctorID, 
    ds.work_day AS workDay,
    TO_CHAR(ds.work_start_time, 'HH24:MI:SS') AS workStartTime,
    TO_CHAR(ds.work_end_time, 'HH24:MI:SS') AS workEndTime
FROM doctor_schedule ds
     JOIN omdoctor omd ON omd.doctor_id = ds.doctor_id 
WHERE ds.doctor_id = 2
  AND ds.work_day = 'Monday';
SELECT 
    omd.doctor_id AS omdDoctorID, 
    omd.user_id AS userID, 
    u.name AS doctorName
FROM omdoctor omd
JOIN users u ON omd.user_id = u.user_id
WHERE omd.work_day = 'Monday';

select omd.doctor_id omDoctorID, u.user_id userID, name doctorName
  from omdoctor omd
       join users u on omd.user_id = u.user_id
 where u.role_id = 2;
select *
  from beds;
  		select bed_id bedID, room_id roomID, bed_number bedNumber, status bedStatus
		  from (
				select *
				  from beds
				 where status = 'empty'
				 order by bed_number 
		        )
	        where rownum = 1