with recursive temp as (
    select task_id, 1 subtask_id from Tasks t
    union all
    select t1.task_id, subtask_id + 1 from temp t1 join Tasks t2 on t1.task_id=t2.task_id where subtask_id < t2.subtasks_count
)
select task_id, subtask_id from temp where (task_id, subtask_id) not in (select task_id, subtask_id from Executed);