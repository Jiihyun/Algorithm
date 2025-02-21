-- 코드를 입력하세요
SELECT c.CAR_ID, c.CAR_TYPE, ROUND(c.DAILY_FEE * 30 * ((100 - d.DISCOUNT_RATE)/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS c
INNER JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS d
ON c.CAR_TYPE = d.CAR_TYPE
WHERE c.CAR_TYPE IN ('세단', 'SUV')
AND c.CAR_ID NOT IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-11-30' AND END_DATE >= '2022-11-01'
)
AND c.DAILY_FEE * 30 * (100 - d.DISCOUNT_RATE)/100 BETWEEN 500000 AND 2000000
AND d.DURATION_TYPE = '30일 이상'
ORDER BY c.DAILY_FEE * 30 * (1- d.DISCOUNT_RATE*0.01) DESC, c.CAR_TYPE, c.CAR_ID DESC;
