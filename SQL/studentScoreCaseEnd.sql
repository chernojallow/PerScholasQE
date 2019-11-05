select *,
case
	when score >= 90 and score <= 100 then "A"
	when score >= 80 and score < 90 then "B"
	when score >= 70 and score < 80 then "C"
	else "F"
end as grade
from studentscore;