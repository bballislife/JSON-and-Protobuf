#!/bin/bash
if [ $1 == "-c" ]
then
    javac ./*/*.java
elif [ $1 == "-s" -a $2 == "-j" ]
then
  java assignment_1.main_class -s -j $3
elif [ $1 == "-d" -a $2 == "-j" ]
then
  java assignment_1.main_class -d -j $3
elif [ $1 == "-s" -a $2 == "-p" ]
then
  java assignment_1.main_class -s -p $3
elif [ $1 == "-d" -a $2 == "-p" ]
then
  java assignment_1.main_class -d -p $3
elif [ $1 == "-t" -a $2 == "-j" ]
then
  java assignment_1.main_class -s -j $3
  java assignment_1.main_class -d -j result.json
elif [ $1 == "-t" -a $2 == "-p" ]
then
  java assignment_1.main_class -s -p $3
  java assignment_1.main_class -d -p result_protobuf
fi



