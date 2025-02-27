-- july의 group by flavor, having sum(Total order)
-- flavor로 조인, group by flavor, having sum(total order)

-- JULY를 group by, having sum으로 total order를 만듬
-- 두 개의 테이블의 FLAVOR 기준으로, TOTAL_ORDER 합산으로 저장
-- TOTAL_ORDER DESC로 정렬

SELECT A.FLAVOR
FROM FIRST_HALF AS A
JOIN (SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
       FROM JULY
       GROUP BY FLAVOR
       HAVING SUM(TOTAL_ORDER)
     ) AS B
 ON A.FLAVOR = B.FLAVOR     
GROUP BY A.FLAVOR
ORDER BY (A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
LIMIT 3