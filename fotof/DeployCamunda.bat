@echo off 
xcopy /s /Y "target\fotof.war" "%CAMUNDA_HOME%\server\apache-tomcat-8.0.47\webapps"