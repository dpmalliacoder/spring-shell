# spring-shell
Spring Shell lets you create such a runnable application, where the user enters textual commands that are run until the program terminates. The Spring Shell project provides the infrastructure to create such a REPL (Read, Eval, Print Loop) application, letting you concentrate on implementing commands by using the familiar Spring programming model.

### Building As Native Application
To make our command line application fast and portable, let's build a native application using GraalVM. Configure Logback and Spring Boot properties in application.properties to remove unnecessary logging and disable the Spring Boot banner:

```
logging.level.root=off
spring.main.banner-mode=off
```

Build the native application using Maven:
``` bash
./mvnw -Pnative -DskipTests=true clean package
``` 

### Native Application with Alias
Create an alias for the native application in your shell configuration file (e.g., .bashrc or .zshrc):

``` 
alias myshell = "path/to/your/target/exe"
``` 

Run the native application by typing **myshell** in your command line:
``` bash
myshell
``` 

### Native Application exe

Build the native application using Maven:
``` bash
./mvnw -Pnative native:compile
``` 

