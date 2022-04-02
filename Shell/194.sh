#!/bin/bash
# Read from the file file.txt and print its transposed content to stdout.

# 确定列数
col=$(sed -n 1p file.txt | wc -w)

for i in `seq 1 $col`
do
awk -v arg=$i '{print $arg}' file.txt | xargs
done