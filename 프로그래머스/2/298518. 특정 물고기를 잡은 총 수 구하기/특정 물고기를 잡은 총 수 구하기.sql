-- 코드를 작성해주세요
SELECT COUNT(i.FISH_TYPE) AS FISH_COUNT
FROM FISH_INFO AS i
INNER JOIN FISH_NAME_INFO AS ni
ON i.FISH_TYPE = ni.FISH_TYPE
WHERE ni.FISH_NAME = 'BASS' OR ni.FISH_NAME = 'SNAPPER';