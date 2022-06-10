# !/bin/bash
# Read from the file file.txt and output the tenth line to stdout.

# backup IFS
ifs_old=$IFS
IFS=$'\n'

i=1
for line in $(cat file.txt)
do
    if [[ $i -eq 10 ]]; then
        echo $line
    fi
    let "i++"
done

# recovery IFS
IFS=$ifs_old