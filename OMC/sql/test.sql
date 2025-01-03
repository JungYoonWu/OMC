
delete from reservations
 where reservation_id = 235;
 select *
  from beds;
delete from reservations
 where to_char(reservation_time) = to_char(sysdate, 'yyyy-MM-dd HH:mm:ss');


select omd.doctor_id omdDoctorID
  from omdoctor omd
 where user_id = 'test_doctor2';
 desc reservations;
        SELECT 
            r.reservation_id reservationID, r.user_id userID
            , to_char(r.reservation_date, 'yyyy-mm-dd') as reservationDate
            , to_char(r.reservation_time, 'HH24:MI:SS') as reservationTime
            , r.status , r.treatment_id treatmentID, r.doctor_id doctorID 
            , d.name AS doctorName
        FROM reservations r
        JOIN omdoctor omd ON r.doctor_id = omd.user_id
        JOIN users d ON omd.user_id = d.user_id
        WHERE TO_CHAR(r.reservation_date, 'yyyy-mm-dd') = TO_CHAR(SYSDATE, 'yyyy-mm-dd')
        ORDER BY r.reservation_time;
select *
  from reservations
 where doctor_id = '3';
 

select * -- count(*)
  from reservations
 where status='YES';
update reservations
   set status = 'DONE';

select user_id, password
 from users
where role_id = 1;
select * 
  from reservations
 where to_char(reservation_date, 'yyyy-mm-dd') = to_char(sysdate+1, 'yyyy-mm-dd')
   --and status in ('YES', 'ING')
 order by  doctor_id, reservation_time desc;
select user_id, password
  from users
 where role_id = 1;
insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id, doctor_id)
values (seq_reserv_id_no.nextval, '±ò³¢', to_char(sysdate, 'yyyy-mm-dd'), '2024-12-30 15:30:00', 'YES', 2, 'test_doctor1');
insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id, doctor_id)
values (seq_reserv_id_no.nextval, 'test_user3', to_char(sysdate, 'yyyy-mm-dd'), '2024-12-30 15:15:00', 'YES', 2, 'test_doctor2');
insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id, doctor_id)
values (seq_reserv_id_no.nextval, 'test_user4', to_char(sysdate, 'yyyy-mm-dd'), '2024-12-30 14:45:00', 'YES', 2, 'test_doctor3');
insert into reservations (reservation_id, user_id, reservation_date, reservation_time, status, treatment_id, doctor_id)
values (seq_reserv_id_no.nextval, 'yoonwu', to_char(sysdate, 'yyyy-mm-dd'), '2024-12-26 13:00:00', 'YES', 2, 'test_doctor3');

select *
  from beds;
commit;

update beds
		   set status = 'empty'
		 where bed_id = 1;
  
update beds
   set status = 'empty';

delete from reservations
 where reservation_id = 165;

SELECT 
            r.reservation_id reservationID, r.user_id userID
            , to_char(r.reservation_date, 'yyyy-mm-dd') as reservationDate
            , to_char(r.reservation_time, 'yyyy-mm-dd HH24:MI:SS') as reservationTime
            , r.status , r.treatment_id treatmentID, r.doctor_id doctorID 
            , d.name AS doctorName
        FROM reservations r
        JOIN omdoctor omd ON r.doctor_id = omd.user_id
        JOIN users d ON omd.user_id = d.user_id
        WHERE TO_CHAR(r.reservation_date, 'yyyy-mm-dd') = TO_CHAR(SYSDATE, 'yyyy-mm-dd')
        ORDER BY r.reservation_time;
        
		select reservation_id reservationID, user_id userID, reservation_date reservationDate
		      ,reservation_time reservationTime, status, treatment_id treatmentID
		  from reservations
		 where status in ('YES', 'ING')
		 order by reservation_date, reservation_time;
commit;


select count(*)
  from reservations
 where user_id = 'ch830ok'
   and reservation_date = to_char(sysdate+1, 'yyyy-mm-dd');
   
   
   
   
   
   
   
select *
  from doctor_schedule;
   
   
   
   
   
select *
  from inquiries;

select *
  from replies;
select *
  from users;

select *
  from roles;
   
   