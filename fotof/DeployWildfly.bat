@echo off 
xcopy /s /Y "target\fotof.war" "%JBOSS_HOME%\standalone\deployments"