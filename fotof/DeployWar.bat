@echo off 
xcopy /s "target\fotof-0.0.1-SNAPSHOT.war" "%CAMUNDA_HOME%\server\apache-tomcat-8.0.47\webapps"