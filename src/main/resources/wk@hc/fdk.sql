select table_name,table_comment from information_schema.tables where table_schema='fdk_goods_v1s1';

select column_name,column_type,column_comment from information_schema.columns where table_schema='fdk_goods_v1s1';

SELECT t.TABLE_NAME,t.TABLE_COMMENT,c.COLUMN_NAME,c.COLUMN_TYPE,c.COLUMN_COMMENT
FROM information_schema.TABLES t,INFORMATION_SCHEMA.Columns c
WHERE c.TABLE_NAME=t.TABLE_NAME AND t.`TABLE_SCHEMA`='fdk_goods_v1s1';
