#!/bin/bash

working_dir=`pwd`
#echo $working_dir

files=${working_dir}/*


for filename in $files
do
if [[ -f "$filename" ]]
then
echo -n `basename "$filename"` && echo -n " `wc -l < "$filename"` " && echo `wc -w < "$filename"`
fi
done
