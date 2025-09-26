SELECT concat("/home/grep/src/", board_id, "/", file_id, file_name, file_ext) as FILE_PATH
FROM used_goods_file 
NATURAL JOIN (SELECT board_id FROM used_goods_board ORDER BY views DESC LIMIT 1) m
ORDER BY file_id desc;