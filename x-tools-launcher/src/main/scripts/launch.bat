@echo off

set JAVA_EXE=%JAVA_HOME%\bin\java.exe
setlocal EnableDelayedExpansion

set CP=%CP%;lib/*;
set CP=conf;%CP%;

"%JAVA_EXE%" %JAVA_MODE% -Xms1G -Xmx1G -Xrs -XX:NewRatio=1 -XX:SurvivorRatio=8 -XX:+UseParallelGC -classpath %CP%  com.edifecs.tools.launcher.Launcher%*