		select omd.doctor_id as doctorID, omd.user_id as userID, u.name as name
		  from omdoctor omd
		       join users u on u.user_ID = omd.user_id
		 where u.role_ID = 2;
         select * from omdoctor;
select *
  from reservations
 order by reservation_date, reservation_time;
select reservation_id, user_id, reservation_date, reservation_time, status, treatment_id
  from reservations
 where status = 'YES'
   and reservation_date between sysdate and sysdate+7
 order by reservation_date, reservation_time;

select *
  from users where role_id=1;
  commit;
alter table reservations
drop column doctor;
alter table reservations
add (doctor_id varchar2(50));
UPDATE reservations 
SET doctor_id = 'empty' 
WHERE doctor_id IS NULL;
ALTER TABLE reservations
ADD CONSTRAINT fk_doctor
FOREIGN KEY (doctor_id)
REFERENCES users(user_id);
select *
  from omdoctor;

update reservations
   set status = 'DONE'
 where reservation_date < sysdate;

select *
  from treatments;

alter table reservations
add (doctor varchar2(50) null);

create sequence seq_reserv_id_no
increment by 1
start with 1
nocache
nocycle;
select *
from reservations
where reservation_date = to_char(sysdate,'yyyy-mm-dd');
insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id, doctor_id)
values (seq_reserv_id_no.nextval, 'test_user4', '2024-12-17', '2024-12-17 17:45:00', 'YES', 2, 'test_doctor3');

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user3', '2024-12-11', '2024-12-11 15:45:00', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user4', '2024-12-11', '2024-12-11 16:00:00', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user', '2024-12-11', '2024-12-11 17:15:00', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user2', '2024-12-11', '2024-12-11 18:30:00', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user3', '2024-12-11', '2024-12-11 15:30:00', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user4', '2024-12-11', '2024-11-28', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user', '2024-12-11', '2024-11-29', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user3', '2024-12-11', '2024-12-03', 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user', sysdate, sysdate, 'YES', 2);

insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id)
values (seq_reserv_id_no.nextval, 'test_user', sysdate, sysdate, 'YES', 2);


select *
  from reservations;
alter table reservations
add (bed_id number);
SELECT 
    r.*, 
    d.name AS doctorName
FROM reservations r
JOIN omdoctor omd ON r.doctor = omd.user_id
JOIN users d ON omd.user_id = d.user_id
WHERE TO_CHAR(r.reservation_date, 'yyyy-mm-dd') = TO_CHAR(SYSDATE, 'yyyy-mm-dd')
ORDER BY r.reservation_time
;

alter table reservations
ADD CONSTRAINT fk_reservation_bed
FOREIGN KEY (bed_id)
REFERENCES beds(bed_id);
commit;