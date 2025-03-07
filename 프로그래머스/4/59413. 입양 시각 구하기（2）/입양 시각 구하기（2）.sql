-- 각 시간대 별로 입양 건수 조회
-- 0 ~ 23
-- 시간대 순으로 정렬

SET @i = -1;

SELECT (@i := @i +1) AS HOUR, (SELECT COUNT(*)
                              FROM ANIMAL_OUTS
                               WHERE HOUR(DATETIME) = @i) AS COUNT
FROM ANIMAL_OUTS
WHERE @i < 23;