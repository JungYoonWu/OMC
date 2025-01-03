select *
  from herbal_medicines;

commit;
drop sequence seq_herbal_id_no;
create sequence seq_herbal_id_no
NOCACHE
NOCYCLE;

insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�2', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�3', '�̰��� �ӽ��Ѿ��̴�', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�4', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�5', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�6', '�̰��� �ӽ��Ѿ��̴�', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�7', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�8', '�̰��� �ӽ��Ѿ��̴�', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�9', '�̰��� �ӽ��Ѿ��̴�', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '�ӽ��Ѿ�10', '�̰��� �ӽ��Ѿ��̴�', 'Y');

select *
  from herbal_medicines;

select *
  from herbal_medicines
 where seasonal_recommendation='Y';
 
select *
  from herbal_medicines
 where name like '%�ӽ��Ѿ�%';
