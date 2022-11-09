# Write your MySQL query statement below
with temp as (
    select i.invoice_id, c.customer_name, i.price from Invoices i join Customers c on i.user_id=c.customer_id
)
select temp.*, t.contacts_cnt, t.trusted_contacts_cnt from
temp join (
    select invoice_id, count(*) contacts_cnt, count(if(contact_email in (select email from Customers), 1, null)) trusted_contacts_cnt
    from Invoices i join Contacts c on i.user_id=c.user_id
    group by invoice_id
    union all
    select invoice_id, 0, 0 from Invoices where user_id not in (select user_id from Contacts)
) t
on temp.invoice_id=t.invoice_id
order by invoice_id
;
