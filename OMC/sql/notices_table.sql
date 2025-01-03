select *
  from notices
 order by reg_date;

create sequence seq_notice_id_no
increment by 1
start with 1
nocache
nocycle;

insert into notices (notice_id, title, content, reg_date)
values (seq_notice_id_no.nextval, '�ӽð���', '�ӽ÷� ���� ����', sysdate);

insert into notices(notice_id, title, content, reg_date)
values (seq_notice_id_no.nextval, '�ӽð���2', '�ӽ÷� ���� ����', sysdate);

commit;