select *
  from notices
 order by reg_date;

create sequence seq_notice_id_no
increment by 1
start with 1
nocache
nocycle;

insert into notices (notice_id, title, content, reg_date)
values (seq_notice_id_no.nextval, '임시공지', '임시로 만든 공지', sysdate);

insert into notices(notice_id, title, content, reg_date)
values (seq_notice_id_no.nextval, '임시공지2', '임시로 만든 공지', sysdate);

commit;