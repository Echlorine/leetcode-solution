# !/bin/bash
# Determine the number of files

determin(){
  Java_path="Java"
  Python_path="Python"
  leetcode_set=()
  i=0
  for file in $(ls ${Java_path})
  do
    leetcode_set[$i]=$(echo $file | awk -F. '{print $1}')
    let "i++"
  done
  [[ ${leetcode_set[@]/$1/} != ${leetcode_set[@]} ]] && echo  -e "你已经用\e[34mJava\e[0m做过\e[36m第$1题\e[0m了" || echo  -e "你没用\e[34mJava\e[0m做过第\e[36m$1\e[0m题"
  leetcode_set=()
  for file in $(ls ${Python_path})
  do
    leetcode_set[$i]=$(echo $file | awk -F. '{print $1}')
    let "i++"
  done
  [[ ${leetcode_set[@]/$1/} != ${leetcode_set[@]} ]] && echo  -e "你已经用\e[34mPython\e[0m做过\e[36m第$1题\e[0m了" || echo -e "你没用\e[34mPython\e[0m做过第\e[36m$1\e[0m题"
}

determin $1