# Write your MySQL query statement below
with temp as (
select caller_id, recipient_id, call_time
    from Calls
    union all
    select recipient_id caller_id, caller_id recipient_id, call_time
    from Calls
)
select distinct t1.caller_id as user_id from 
(
    select caller_id, recipient_id, date_format(call_time, "%Y-%m-%d") as call_date
    from (
        select *,
        max(call_time) over (partition by caller_id, date_format(call_time, "%Y-%m-%d")) max_time
        from temp
    ) t
    where call_time=max_time
) t1
join
(
    select caller_id, recipient_id, date_format(call_time, "%Y-%m-%d") as call_date
    from (
        select *,
        min(call_time) over (partition by caller_id, date_format(call_time, "%Y-%m-%d")) min_time
        from temp
    ) t
    where call_time=min_time
) t2
on t1.caller_id=t2.caller_id and t1.recipient_id=t2.recipient_id and t1.call_date=t2.call_date
;