SET CLASSPATH=.\lib\antlr-4.5.1-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool -visitor -package antlr -o .\src\antlr\ .\src\TheLang.g4
pause