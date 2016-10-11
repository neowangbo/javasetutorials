@rem call config-example-1.properties
@rem get current directory %cd% or %~dp0
@rem echo %cd%
@rem echo %~dp0
java -cp ..\target\essential.jar com.martian.apps.javasetutorials.essential.config.ExternalProperties %cd%\src\main\resources\config\config-example-1.properties