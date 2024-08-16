References:

Ultimate Java - Code with Mosh


Progress: 

1. Get the development environment ready: Done.

    Install Java Development Kit
        
        sudo apt install openjdk-21-jdk

    Use openjdk-21-jdk-headless if your program doesn't need a GUI. 

    openjdk-21-jre is just the Java Runtime Environment. 
    
    openjdk-21-jdk is the Java Development Kit.

    Check if jdk is installed correctly

        java --version

        javac --version


2. Write your first program: Done.

    I've copied my previous Java learning Files here into "0. Learning" folder

3. Create a Simple Command Line Based Application: Done. 

    Compile: 

        javac [file-name].java

    Run: 

        java [file-name]

4. Learn Fundamentals of Java: Done.

    Create Project "learn" to learn the fundamentals of Java.

5. Learn OOP, Interfaces and Clean Coding: Done.
    
    Create Project "MyTube App" using above principles.

6. Learn about Exceptions: Done.
    
    Create Project "Simple Bank" to learn about Exceptions.

7. Learn about Generics: Done.

    Implement own List Generic Class to learn generics. 

    A class named "List" was made and tested.
    
    Implement v2 of the "Simple Bank" main function that uses the made List Generic Class.

    Implement a Generic Method - max in UtilFunctions

    Implement multiparameter Generic Class & Method

    Practice Using Wildcards.

8. Learn about Collections Framework: Done.

    Implement Iterator using Iterator and Iterable interface in order to use forEach loop on the List Generic Class.

    Use Iterable, Collection, List, Queue, Set & Map.

9. Learn about Lambda Functions and Functional Interfaces: Done.

    1. Create and use a Functional Interface - "Printer" - Functional Interfaces are interfaces that have only one purpose/method. 

    2. Create and use Anonymous inner classes to implement the same.

    3. Use Lambda Functions to implement the same. - Functional Interfaces can be implemented using lambda functions or anonymous classes.

    4. Use some java built-in Functional Interfaces

    There are 4 types:

        Consumer: Takes in an object - Takes input; No output.

        Supplier: Supplies an object - No input; Gives output.

        Function: Takes in an object and Maps it to another object - Takes Input and Gives Output.

        Predicate: Takes in an object and checks something and returns result - Takes Input and Provides boolean output based on condition. 

10. Learn about Streams: 

        Implement a List2 class that implements collection to be able to practice stream - All subclasses of Collection have the ability to stream.

        Do some stream operations on the list. 

        Generate some streams. 

        Practice Mapping streams.

        Practice FlatMapping.

        Practice Filtering

        Practice Slicing (limit, skip, dropWhile, takeWhile)

        Practice distinct

        Practice peek - Peek is used to find output of intermediate streams and then continuing operations. It is the same as forEach but returns the stream in order to keep making operations. 

        Practice Reducers (count, max, min, findAny, findFirst, anyMatch, allMatch, noneMatch)

        Practice Collect

    

