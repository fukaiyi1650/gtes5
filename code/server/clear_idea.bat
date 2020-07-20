@REM ####################################################################
@REM  Name: 递归删除指定的目录，请把此文件放在你希望执行的那个目录
@REM  Desciption: 删除Idea开发工具生成的项目文件(.idea, *.iml, target)
@REM  Author: amosryan
@REM  Date: 2010-11-01
@REM  Version: 1.0
@REM  Copyright: Up to you.
@REM ####################################################################

@echo on

setlocal enabledelayedexpansion

set WHAT_SHOULD_BE_DELETED=.idea

for /r . %%a in (!WHAT_SHOULD_BE_DELETED!) do (
  if exist %%a (
  echo "delete " %%a
  rd /s /q "%%a"
 )
)


set WHAT_SHOULD_BE_DELETED=target

for /r . %%a in (!WHAT_SHOULD_BE_DELETED!) do (
  if exist %%a (
  echo "delete " %%a
  rd /s /q "%%a"
 )
)


attrib -a -h -s -r *.iml /s
del *.iml /s


attrib -a -h -s -r *.iml /s
del *.iml /s