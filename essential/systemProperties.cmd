@rem read a XML style properties file
@rem call config-example-2.properties
@echo off
set key_1=name
set val_1=Wang Bo
set key_2=id
set val_2=1234567890
set key_3=agender
set val_3=Male

@echo add java start options:
@echo %key_1%=%val_1%
@echo %key_2%=%val_2%
@echo %key_3%=%val_3%

java -cp target\essential.jar -D%key_1%="%val_1%" -D%key_2%="%val_2%" -D%key_3%="%val_3%" com.martian.apps.javasetutorials.essential.config.SystemProperties %key_1% %key_2% %key_3%