@echo off
@REM
@REM description: bes springboot dependency install 脚本
@REM
@REM Copyright (c)2023,宝兰德
@REM All rights reserved
@REM
@REM 此脚本的功能
@REM 安装BES springboot的依赖到本地库
@REM

setlocal

set groupId=com.bes.appserver
set version=9.5.2.012

set "libDir=%cd%/lib"
if not exist "%libDir%" (
  echo Directory %libDir% does not exist, please put jars into lib directory at first!
  goto :end
)

call mvn install:install-file -Dfile="%libDir%/bes-actuator-spring-boot-2.x-starter-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-actuator-spring-boot-starter -Dversion=%version% -Dpackaging=jar >> install.log
call :validateResult %groupId%:bes-actuator-spring-boot-starter:%version%

call mvn install:install-file -Dfile="%libDir%/bes-gmssl-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-gmssl -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult  %groupId%:bes-gmssl:%version%

call mvn install:install-file -Dfile="%libDir%/bes-jasper-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-jasper -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult %groupId%:bes-jasper:%version%

call mvn install:install-file -Dfile="%libDir%/bes-jdbcra-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-jdbcra -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult %groupId%:bes-jdbcra:%version%

call mvn install:install-file -Dfile="%libDir%/bes-jdbcra-spring-boot-starter-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-jdbcra-spring-boot-starter -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult %groupId%:bes-jdbcra-spring-boot-starter:%version%

call mvn install:install-file -Dfile="%libDir%/bes-lite-spring-boot-2.x-starter-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-lite-spring-boot-starter -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult %groupId%:bes-lite-spring-boot-starter:%version%

call mvn install:install-file -Dfile="%libDir%/bes-websocket-%version%.jar" -DgroupId=%groupId% -DartifactId=bes-websocket -Dversion=%version% -Dpackaging=jar  >> install.log
call :validateResult %groupId%:bes-websocket:%version%
goto :end

:validateResult
    if %errorlevel% == 0 (
      echo info: install %1 success.
    ) else (
       echo error: install %1 failed!
    )
goto:eof

endlocal
:end
