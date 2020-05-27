# to export complete database 
mysqldump -u root -padmin test  --max_allowed_packet=100M > mysqldump.txt

# to export only the table structure 
mysqldump --no-data --tables  -u root -padmin test >> table_structure.sql 

# to export only the data
mysqldump --no-create-info --max_allowed_packet=32M -u root -padmin test >> data_only.sql 

# if there is a complain about max_allowed_packet, in a seperate mysql session, execute these statements, and keep the session open 
mysql> set global net_buffer_length=1000000; 
mysql> set global max_allowed_packet=1000000000; 
