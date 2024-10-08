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

10. Learn about Streams: Done.

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

        Practice Collect (Partition, Grouping)

        Practice using Collectors static class.

11. Learn about Multithreading: Done.

        Initialize a Thread - Thread thread1 = new Thread(Runnable target);

        Start a thread - thread1.start()

        You do not need to keep track of the number of threads you use - The JVM takes care of sharing resources and processing units with all threads you create. 

        Pause a thread to give other threads time for execution - Thread.sleep(<time in milliseconds>)

        Join Threads - thread1.join() // The main thread waits for the thread1 to complete processing before proceeding

        Interrupt a thread - thread1.interrupt() // The Runnable object should be programmed to handle the interruption. If it doesn't handle the exception, it will keep executing

        Practice Thread Safety - Race Conditions and Visibility Problem

            Discussion:

                Don't share data between Threads - confinement

                Sharing Immutable objects is fine. 

                Data Access could be locked to one Thread at a time - synchronization

                Synchronization is against the principles of concurrency - can cause deadlock - 2 Threads waiting for each other endlessly. 

                Use Atomic objects - Atomic objects do any modifications in one step, instead of multi steps - JVM makes sure of it.

                Unatomic objects are data that take more than one step to modify:

                    ex: To increment a value by 1, the value has to be read from memory, then incremented by 1 and then stored in memory.

                Partitioning - Multiple threads can access the same collection of data, but can only access a segment of it. Segments won't be shared. 

                Use volatile keyword to avoid Visibility Problem

                Use Atomic Objects

                Use Adders - LongAdded, DoubleAdder - They maintain an array of counters (possibly, one for each thread)that produce a cummulative value when output is asked // This is faster than Synchronization, Atomic Objects, etc., 

                Use Synchronized Collections to make collections that don't face race condition - Again Synchronized  are bad for performance since other threads have to wait for one thread using it. 

                Use Concurrent Collections

        Practice Thread Signalling:

            object.wait() - Pauses current thread till this object notifies the current thread from another thread

            object.notify() / object.notifyAll() - Notifies any waiting thread that the object is done. 

12. Learn about Executive Framework - MultiThreading: 

        Create a Thread Pool - Executors.newFixedThreadPool(2)

        Submit a Runnable to the executor to add to the queue and execute at its convenience - executor.submit(Runnable Task) 

        // Executive Framework does not stop us from having concurrency problems that were discussed earlier. It just simplifies Thread Manipulation.

        Use a callable object instead of a runnable object to get an output - var future = executor.submit(Callable<T>)

        Practice Asynchronous Programming - without blocking main thread:

            Create CompletableFuture Object

            Run a Supplier as ASync - runASync()  / supplyASync()

            Trigger other programs after one is completed - thenApply() / thenAccept() / thenApplyASync()

            handle exceptions using .exceptionally

            Wait for multiple functions to complete - .allOf / .anyOf

            Use timeouts - .completeOnTimeout / .orTimeout



        




    

