select *
  from herbal_medicines;

commit;
drop sequence seq_herbal_id_no;
create sequence seq_herbal_id_no
NOCACHE
NOCYCLE;

insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약2', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약3', '이것은 임시한약이다', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약4', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약5', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약6', '이것은 임시한약이다', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약7', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약8', '이것은 임시한약이다', 'N');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약9', '이것은 임시한약이다', 'Y');
insert into herbal_medicines(medicine_id, name, description, seasonal_recommendation)
values (seq_herbal_id_no.nextval, '임시한약10', '이것은 임시한약이다', 'Y');

select *
  from herbal_medicines;

select *
  from herbal_medicines
 where seasonal_recommendation='Y';
 
select *
  from herbal_medicines
 where name like '%임시한약%';
