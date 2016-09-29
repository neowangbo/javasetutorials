@rem pass arguments of window shell to java as arguments
@rem %* presents all arguments
@rem %1 presents first argument
@rem %2 presents second argument
@rem %n presents argument at position n 

java -cp target\essential.jar com.martian.apps.javasetutorials.essential.config.CommandLineArguments %*