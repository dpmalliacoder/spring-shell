package com.springframework.shell.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyShellCommand {
    @ShellMethod(key="hello-world")
    public String helloWorld(@ShellOption(defaultValue = "spring") String arg){
        return "Hello-World " + arg+"!";
    }
}
