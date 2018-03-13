@echo off 
xcopy /s /Y "target\fotof.war" "%CAMUNDA_HOME%\server\wildfly-11.0.0.Final\standalone\deployments\"