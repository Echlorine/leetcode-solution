# Write your MySQL query statement below
select patient_id, patient_name, conditions
from Patients
where conditions like '% DIAB1%' or conditions like 'DIAB1%';

/* Write your PL/SQL query statement below */
select patient_id, patient_name, conditions from Patients p
where regexp_like(conditions, '^DIAB1') or regexp_like(conditions, '^.* DIAB1')
;