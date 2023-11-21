#!/bin/sh
# description: bes springboot dependency install 脚本
#########################################################################################
#Copyright (c)2023,宝兰德
#All rights reserved
#
#此脚本的功能
#安装BES springboot的依赖到本地库
#
#########################################################################################

lpwd=`dirname $0`
if [ "$lpwd" = "" -o "$lpwd" = "." -o "$lpwd" = "./" ];then
  lpwd=`pwd`
fi

####### constants #########
groupId=com.bes.appserver
version=9.5.2.012

############# methods ##################
validateResult() {
  if [ $? -ne 0 ]; then
    echo -e "error: install $1 failed!"
    exit 1;
  else
    echo -e "info: install $1 success."
  fi
}

###### install springboot dependencies #########
libDir="${lpwd}/lib"
if [ ! -d "$libDir" ]; then
  echo "Directory $libDir does not exist, please put jars into lib directory at first!"
  exit 1
fi

mvn install:install-file -Dfile="$libDir/bes-actuator-spring-boot-2.x-starter-$version.jar" -DgroupId=$groupId -DartifactId=bes-actuator-spring-boot-starter -Dversion=$version -Dpackaging=jar >> install.log
validateResult $groupId:bes-actuator-spring-boot-starter:$version

mvn install:install-file -Dfile="$libDir/bes-gmssl-$version.jar" -DgroupId=$groupId -DartifactId=bes-gmssl -Dversion=$version -Dpackaging=jar  >> install.log
validateResult  $groupId:bes-gmssl:$version

mvn install:install-file -Dfile="$libDir/bes-jasper-$version.jar" -DgroupId=$groupId -DartifactId=bes-jasper -Dversion=$version -Dpackaging=jar  >> install.log
validateResult $groupId:bes-jasper:$version

mvn install:install-file -Dfile="$libDir/bes-jdbcra-$version.jar" -DgroupId=$groupId -DartifactId=bes-jdbcra -Dversion=$version -Dpackaging=jar  >> install.log
validateResult $groupId:bes-jdbcra:$version

mvn install:install-file -Dfile="$libDir/bes-jdbcra-spring-boot-starter-$version.jar" -DgroupId=$groupId -DartifactId=bes-jdbcra-spring-boot-starter -Dversion=$version -Dpackaging=jar  >> install.log
validateResult $groupId:bes-jdbcra-spring-boot-starter:$version

mvn install:install-file -Dfile="$libDir/bes-lite-spring-boot-2.x-starter-$version.jar" -DgroupId=$groupId -DartifactId=bes-lite-spring-boot-starter -Dversion=$version -Dpackaging=jar  >> install.log
validateResult $groupId:bes-lite-spring-boot-starter:$version

mvn install:install-file -Dfile="$libDir/bes-websocket-$version.jar" -DgroupId=$groupId -DartifactId=bes-websocket -Dversion=$version -Dpackaging=jar  >> install.log
validateResult $groupId:bes-websocket:$version



