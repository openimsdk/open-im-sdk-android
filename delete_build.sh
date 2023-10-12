#!/bin/bash

delete_build_folders() {
  # 遍历当前文件夹下的子文件夹，包括隐藏文件夹
  shopt -s dotglob
  for dir_name in "$1"/*; do
    if [ -d "$dir_name" ]; then
      if [ "$(basename "$dir_name")" = "build" ]||[ "$(basename "$dir_name")" = ".gradle" ]; then
        # 删除build文件夹
        rm -rf "$dir_name"
        echo "删除文件夹: $dir_name"
      else
        # 递归删除子文件夹中的build文件夹
        delete_build_folders "$dir_name"
      fi
    fi
  done
}

# 获取用户输入的文件夹路径
# shellcheck disable=SC2162
read -p "请输入要删除的文件夹路径: " folder_path

# 调用函数删除文件夹
delete_build_folders "$folder_path"

# 删除指定文件夹
rm -rf "$folder_path"
echo "删除文件夹: $folder_path"
echo "操作完成！"
