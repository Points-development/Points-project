#!/bin/bash

#configuration
backup_path=/opt/backup
backup_filename=BackupPointService.sql
backup_user=root
backup_user_passwd=Letmein123$%^
#by default will keep 3 days data
backup_days=3

date_0=`date +%Y%m%d`
date_to_delete=`date -d -${backup_days}day +%Y%m%d`

if [ ! -d "$backup_path" ]
then
	mkdir $backup_path
fi

if [ -f ${backup_path}/${backup_filename}.${date_to_delete} ]
then
	rm ${backup_path}/${backup_filename}.${date_to_delete}
fi

mysqldump -u${backup_user} -p${backup_user_passwd} pointService > ${backup_path}/BackupPointService.sql.${date_0}

#to restore, use uncomment below line and use right date
#mysql -u${backup_user} -p${backup_user_passwd} pointService < ${backup_path}/BackupPointService.sql.${date_0}