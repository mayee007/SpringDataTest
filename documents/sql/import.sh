 mysql -u root -p test < mysqldump.txt

   Solution: open mysql prompt, mysql -u root -p test 
   set global net_buffer_length=1000000; 
   set global max_allowed_packet=1000000000;

