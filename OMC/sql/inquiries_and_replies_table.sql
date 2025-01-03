select *
  from inquiries;
  
select * 
  from replies;
commit;
create sequence seq_inquiry_no;
create sequence seq_reply_no;

insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '임시문의제목', '임시문의내용', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '임시문의제목2', '임시문의내용2', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '임시문의제목3', '임시문의내용3', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '임시문의제목4', '임시문의내용4', sysdate, '미응답');

insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '임시문의제목5', '임시문의내용5', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '임시문의제목6', '임시문의내용6', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '임시문의제목7', '임시문의내용7', sysdate, '미응답');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '임시문의제목8', '임시문의내용8', sysdate, '미응답');

select *
  from inquiries
 where user_id = '유누눙';
 
delete from replies;
update inquiries
   set status='미응답'
 where status='응답완료';
commit;
