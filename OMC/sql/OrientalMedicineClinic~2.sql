SELECT m1.user_id AS userID, m1.name, m1.email, m1.phone, m2.role_name AS roleName, m1.user_no AS userNo, m1.role_id AS roleID
  FROM users m1
       JOIN roles m2 ON m2.role_id = m1.role_id
       JOIN doctor_schedule ds ON ds.doctor_id = m1.user_id
 WHERE m1.role_id = 2
   AND ds.work_day = 'SunDay';
   
        select *
          from users u
               join omdoctor omd on omd.user_id = u.user_id
               join roles role on role.role_id = u.role_id
               join doctor_schedule ds on ds.doctor_id = omd.doctor_id
         where ds.work_day = 'Monday'
           and u.role_id = 2;
 select *
   from omdoctor;
select *
  from doctor_schedule;
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
        select * from beds;

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
    select * from beds;
    select * from reservations
    order by reservation_date desc;
    		select bed_id bedID, room_id roomID, bed_number bedNumber, status bedStatus
		  from beds;
select *
  from reservations
 where doctor_id = 'test_doctor2';