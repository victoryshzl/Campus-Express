create view v_user_payment as
select u.id_card,u.real_name,count(b.payment) payment from sys_user u, order_info a, order_payment b
where u.id=a.courier_id and a.id=b.order_id and a.`status`='3' group by u.id_card;

create view v_user_order as
select u.id_card, u.real_name,
sum(case when a.`status`='1' then 1 else 0 end) wait_order ,
sum(case when a.`status`='2' then 1 else 0 end) ing_order,
sum(case when a.`status`='3' then 1 else 0 end) error_order,
sum(case when a.`status`='4' then 1 else 0 end) complete_order
from sys_user u, order_info a where u.id=a.courier_id GROUP BY u.id_card;

create view v_company_order as
select u.id,u.`name`,u.`code`,
sum(case when a.`status`='1' then 1 else 0 end) wait_order ,
sum(case when a.`status`='2' then 1 else 0 end) ing_order,
sum(case when a.`status`='3' then 1 else 0 end) error_order,
sum(case when a.`status`='4' then 1 else 0 end) complete_order
from data_company u, order_info a
where u.id=a.company group by u.id;