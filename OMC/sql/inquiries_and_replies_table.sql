select *
  from inquiries;
  
select * 
  from replies;
commit;
create sequence seq_inquiry_no;
create sequence seq_reply_no;

insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '�ӽù�������', '�ӽù��ǳ���', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '�ӽù�������2', '�ӽù��ǳ���2', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '�ӽù�������3', '�ӽù��ǳ���3', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user', '�ӽù�������4', '�ӽù��ǳ���4', sysdate, '������');

insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '�ӽù�������5', '�ӽù��ǳ���5', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '�ӽù�������6', '�ӽù��ǳ���6', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '�ӽù�������7', '�ӽù��ǳ���7', sysdate, '������');
insert into inquiries (inquiry_id, user_id, title, content, reg_date, status)
values (seq_inquiry_no.nextval, 'test_user2', '�ӽù�������8', '�ӽù��ǳ���8', sysdate, '������');

select *
  from inquiries
 where user_id = '������';
 
delete from replies;
update inquiries
   set status='������'
 where status='����Ϸ�';
commit;
