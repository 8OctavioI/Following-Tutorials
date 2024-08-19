package com.octavioi;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;

import com.octavioi.Movies.Genre;

public class Test {
    public static void main(String[] args) {
        //testingListGenericClass();
        //testingMultipleParameterGenerics();
        //testFunctionalInterface();

        //testBuiltInFunctionalInterfaces();

        //testStream();

        //testMultiThreads();

        //testMultiThreads2();

        testMultiThreads3_SolveRaceCondition();

        //testMultiThreads3_SolveVisibilityProblem();


        


    }

    public static void testingListGenericClass() {
        Integer[] pos = {1,2,5,6};
        List1<Integer> n = new List1<Integer>(pos);
        System.out.println(n);
        System.out.println("Length = " + n.length());

        n.add(10);
        n.add(20);
        n.add(30);

        System.out.println(n);
        System.out.println("Length = " + n.length());

        n.add(60);
        n.add(70);
        n.add(30);

        System.out.println(n);
        System.out.println("Length = " + n.length());
        n.add(50);
        n.add(10);
        n.add(50);

        System.out.println(n);
        System.out.println("Length = " + n.length());
        n.add(60);
        n.add(340);
        n.add(15);
        n.add(14);

        System.out.println(n);
        System.out.println("Length = " + n.length());

        n.remove(5);

        System.out.println(n);
        System.out.println("Length = " + n.length());

        n.remove(Integer.valueOf(50));
        System.out.println(n);
        System.out.println("Length = " + n.length());

        System.out.println(n.get(12));

        n.add(60);
        n.add(70);
        n.add(30);

        System.out.println(n.indexOf(340));

        System.out.println(n);
        System.out.println("Length = " + n.length());
        n.add(50);
        n.add(10);
        n.add(50);

        System.out.println(n);
        System.out.println("Length = " + n.length());
        n.add(60);
        n.add(340);
        n.add(15);
        n.add(14);

        System.out.println(n);
        System.out.println("Length = " + n.length());
    }

    public static void testingMultipleParameterGenerics() {
        KeyValuePair kvp= new KeyValuePair<Integer, String>(Integer.valueOf(1), "Man");
        KeyValuePair<Integer, String> kvp2= new KeyValuePair(Integer.valueOf(1), "ManMan");
        System.out.println(kvp + "\n" + kvp2);
        UtilFunctions.printAsKeyValuePair(2, "Jess");

    }

    public static void testFunctionalInterface() {
        greet(new ConsolePrinter());
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println("The message using anonymous inner class is: " + message);
            }
        }); // Anonymous Inner Class
        greet((String message) -> {System.out.println("The message using lambda functions is: " + message);});
        greet(message -> {System.out.println("The message using lambda functions is: " + message);});

        greet2((String s1, String s2) -> {System.out.println("The message using lambda Function with 2 parameters is: " + s1 + " - " + s2);});

        greet3((String... strings) -> {
            System.out.print("The message using other arguments is: ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }, "Is", "this", "Jess", "?\n");


        Printer printer = message -> System.out.println(message);
        Printer3 printer3 = strings -> {
            for (String string : strings) {
                System.out.print(string + " ");
            }
        };

        greet(printer);
        greet(System.out::println); // This is the same as greet(message -> System.out.println(message))
                                    // We can do this if we just call another method in the lambda function

        greet3(printer3,  "this is", "printed using", "lambda function", "as variable.");

    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public static void greet2(Printer2 printer) {
        printer.print("1", "One");
    }

    public static void greet3(Printer3 printer, String... strings) {
        printer.printAll(strings);
    }

    public static void testBuiltInFunctionalInterfaces() {

        Consumer<String> print = str -> System.out.println(str);
        Consumer<String> printUpperCase = str -> System.out.println("Uppercase: " + str.toUpperCase());

        Function<String, String> replaceColon = (str) -> str.replace(":", "=");
        Function<String, String> addBraces = (str) -> "{" + str + "}";

        System.out.println(replaceColon
                            .andThen(addBraces)
                            .apply("Key: Value")
                            );

        Function<String, String> both = replaceColon
                                        .andThen(addBraces);

        System.out.println(both.apply("Key2: Value2"));


        Supplier<Double> random = () -> Math.random() * 10;

        Function<Integer, String> multiplyBy10 = val -> val + " x 10 = " + val * 10; 

        Function<Double, Integer> convertToInt = (val) -> {
            System.out.println(val + " -> " + Math.round(val));
            return (int) Math.round(val);
        };
        var a = convertToInt
                .andThen(multiplyBy10)
                .apply(random.get());
        
        System.out.println("a = " + a);

        print.andThen(printUpperCase).accept(a);

        System.out.println("Second Attempt: ");

        printUpperCase
        .andThen(print)
        .accept(convertToInt
                .andThen(multiplyBy10)
                .apply(random.get())
                );


        // Primitive Functional Interfaces

        DoubleToIntFunction round = (decimal) -> (int) Math.round(decimal);

        System.out.println(round.applyAsInt(random.get()));

        Predicate<Double> isPositive  = (num) -> num > 0;
        Predicate<Double> isGreaterThan5 = (num) -> num >= 5;

        System.out.println(isPositive.test(2.3));
        System.out.println(isPositive.test(-0.3));

        System.out.println(isPositive.test(5D));
        print
        .andThen(printUpperCase)
        .accept(Boolean.toString(
                    isPositive
                    .and(isGreaterThan5)
                    .test(6D)
                    )
                );

        var both2 = isPositive
                    .and(isGreaterThan5)
                    .negate();

        System.out.println(both2.test(3D));

        both2 = isPositive
                .or(isGreaterThan5);

        System.out.println(both2.test(3D));

        
        

        




        
    }

    
    public static void testStream() {
        List2<Integer> list2 = new List2<Integer>();
        list2.add(5);
        list2.add(15);
        list2.add(43);
        list2.add(55);
        list2.add(52);
        list2.add(85);

        Predicate<Integer> divisibleBy5 = num -> num % 5 == 0;

        System.out.println(list2
                            .stream()
                            .filter(divisibleBy5)
                            .count()
                            );

        // This is a form of declarative programming, you tell it what to do instead of how to do it. 

        // This is a substitute for its imperative programming counterpart:
        int count = 0;
        for (var item: list2) {
            if (item % 5 == 0) count++;
        }
        System.out.println(count);
        
        list2
            .stream()
            .filter(divisibleBy5.negate())
            .forEach(num -> {System.out.println(num);});

        Stream.generate(() -> Math.random())
                .limit(10) // If limit is not used, it will generate/iterate infinitely. 
                .forEach(num -> System.out.println(num));

        IntStream.generate(() -> (int) (Math.random() * 10))
                    .limit(20)
                    .forEach(System.out::println);

        IntStream.rangeClosed(1, 5)
                    .forEach(System.out::println);

        Consumer<Double> printD = (num) -> System.out.println(num);

        Stream.iterate(2D, n -> n + 2)
                .limit(5)
                .forEach(printD);

        List<Movies> movies = List.of(
            new Movies("10", 150, Genre.ACTION, "What", "is", "This"),
            new Movies("12", 300, Genre.COMEDY, "This is"),
            new Movies("7", 70, Genre.ACTION, "Late", "Call"),
            new Movies("11", 800, Genre.THRILLER, "John", "Jess", "Smith", "Shetty"),
            new Movies("16", 500, Genre.THRILLER, "Smithy", "Jessy", "Johny")
        );

        Function<Movies, String> getTitle = (movie) -> movie.getTitle();
        movies.stream()
                .map(getTitle)
                .forEach((title) -> System.out.println(title));

        Function<Movies, ArrayList<String>> getCast = (movie) -> movie.getCast();

        // Map maps each object from the stream to another; Here we are printing all the titles. 

        movies.stream()
                .filter(movie -> movie.getLikes() > 300)
                .map(getCast)
                .forEach((cast) -> System.out.println(cast));

        movies.stream()
                .filter(movie -> movie.getLikes() > 200)
                .flatMap(movie -> movie.getCast().stream())
                .forEach((cast) -> System.out.println(cast));

        // Flat Maps flatters dimensional streams by mapping each object to a stream. 

        Predicate<Movies> hasJohn = (Movies movie) -> {return movie.getCast().contains("John");};

        Consumer<Movies> printMovie = movie -> System.out.println("Title: " + movie.getTitle() + "\tLikes: " + movie.getLikes() + "\tCast: " + movie.getCast());
        
        System.out.println("TakeWhile: ");
        movies.stream()
                .skip(2) // Skips the given number of elements
                .takeWhile(hasJohn.negate())
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("DropWhile: ");

        movies.stream()
                .dropWhile(hasJohn.negate())
                .forEach(movie -> System.out.println(movie.getTitle()));

        System.out.println("Sorting using Comparable: ");
        movies.stream()
                .sorted()
                .forEach(printMovie);

                // Default implemented in Movies class
        
        Comparator<Movies> castSizeComparator = (x, y) -> x.getCast().size() - y.getCast().size();

                // Sort by number of cast members
        System.out.println("Sorting using lamba comparator");
        movies.stream()
                .sorted(castSizeComparator)
                .forEach(printMovie);

                // Sort by title
        System.out.println("Sorting using class comparator");
        movies.stream()
                .sorted(new TitleComparator())
                .forEach(printMovie);

        System.out.println("Using Comparing method");

        movies.stream()
                .sorted(Comparator.comparing(Movies::getLikes))
                .forEach(printMovie);

        System.out.println("Reducing: ");

        var casts = movies.stream()
                .map(Movies::getCast)
                .reduce((a, b) -> { 
                    ArrayList<String> res = new ArrayList<>(); 
                    res.addAll(a); 
                    res.addAll(b); 
                    return res;
                })
                .get();

        System.out.println(casts);

        movies.stream().forEach(printMovie);

        List<String> movieTitles = movies.stream()
                                            .map(Movies::getTitle)
                                            .collect(Collectors.toList());
        
        System.out.println("Movie Titles: " + movieTitles);

        var castTitles = movies.stream()
                                            .flatMap(m -> m.getCast().stream())
                                            .collect(Collectors.joining(", "));
        
        System.out.println("Movie Castmembers: " + castTitles);
        
        System.out.println("Collected as Key: Value: " + movies.stream()
                                    .collect(Collectors.toMap(Movies::getTitle, Movies::getCast)));


        System.out.println("Summary statistics of the likes: " + movies.stream()
                                    .collect(Collectors.summarizingInt(Movies::getLikes)));

        System.out.println("Summary statistics of the number of cast members: " + movies.stream()
                                    .map(m -> m.getCast().size())
                                    .collect(Collectors.summarizingInt(l -> l)));

        
        System.out.println("Grouped by Genre: " + movies.stream()
                                    .collect(Collectors.groupingBy(Movies::getGenre, 
                                            Collectors.mapping(Movies::getTitle, Collectors.toSet()))));


        System.out.println("Grouped by Genre: " + movies.stream()
                                                        .map(m -> m.getTitle()  + "=" + m.getGenre())
                                                        .collect(Collectors.groupingBy(s -> s.split("=")[1])));

        System.out.println("Partitioned by number of cast members: " + 
                            movies.stream()
                                    .collect(Collectors.partitioningBy(m -> m.getCast().size() >= 3, 
                                                            Collectors.mapping(Movies::getTitle, 
                                                                                Collectors.joining(", ")))));
        




        

        

        
    }
    
    public static void testMultiThreads() {
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Runtime.getRuntime().availableProcessors());

        startingAThread:;

        Thread thread = new Thread(new DownloadFile());

        
        // A thread class takes in a object of a class that implements the Runnable interface. 

        // The Runnable interface has one method - run() that gets executed in a new thread when the thread is started. 

        System.out.println("1st Command");
        thread.start();

        Thread thread2 = new Thread(() -> 
                                    {
                                        System.out.println("Current thread: " + Thread.currentThread().getName());
                                        System.out.println("Downloading a file from thread 2.");
                                        try {
                                            Thread.sleep(5000);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("Thread 2 Download complete. " + Thread.currentThread().getName());
                                    });

        // Alternatively a lambda function can also be used to initiate a thread. 

        System.out.println("2nd Command");
        for (int i = 0; i < 5; i++) {
            thread2 = new Thread(() -> 
                                    {
                                        System.out.println("2: Downloading a file from " + Thread.currentThread().getName());
                                        try {
                                            Thread.sleep(10000);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("2: Download complete. " + Thread.currentThread().getName());
                                    });
            thread2.start();
        }
        // 5 Downloads will start and complete simultaneously. 
        System.out.println("Command before downloads of thread 2");
        try {
            thread2.join(); // Here it only waits for the completion of the last initialized thread2
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("command after waitign for download to complete");
        for (int i = 0; i < 5; i++) {
            System.out.println("3: Downloading a file from " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("3: Download complete. " + Thread.currentThread().getName());
            }
        // Alternatively, doing it in the same thread downloads them one after the other thus wasting time. 


        System.out.println("3rd command");
        System.out.println(Thread.activeCount());






    }

    public static void testMultiThreads2() {
        Thread thread1 = new Thread(new DownloadFile2());
        thread1.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        thread1.interrupt(); // The program will be interrupted after 1 second

    }

    public static void testMultiThreads3_SolveRaceCondition() {
        
        Status statusA = new Status();
        LockedStatus statusC = new LockedStatus();
        SynchronizedStatus statusD = new SynchronizedStatus();
        AtomicStatus statusE = new AtomicStatus();
        AdderStatus statusF = new AdderStatus();

        ArrayList<DownloadFile3a> sharedStatusDownloadFiles = new ArrayList<>();
        ArrayList<DownloadFile3a> lockedStatusDownloadFiles = new ArrayList<>();
        ArrayList<DownloadFile3b> confinedStatusDownloadFiles = new ArrayList<>();
        ArrayList<DownloadFile3a> SynchronizedStatusDownloadFiles = new ArrayList<>();
        ArrayList<DownloadFile3a> atomicStatusDownloadFiles = new ArrayList<>();
        ArrayList<DownloadFile3a> adderStatusDownloadFiles = new ArrayList<>();

        

        ArrayList<Thread> threadsWithSharedMemory = new ArrayList<>();
        ArrayList<Thread> threadsWithLockedMemory = new ArrayList<>();
        ArrayList<Thread> threadsWithConfinedMemory = new ArrayList<>();
        ArrayList<Thread> threadsWithSynchronizedMemory = new ArrayList<>();
        ArrayList<Thread> threadsWithAtomicMemory = new ArrayList<>();
        ArrayList<Thread> threadsWithAdderMemory = new ArrayList<>();

        for (int index = 0; index < 5; index++) {
            DownloadFile3a tempDownloadFileA = new DownloadFile3a(statusA);
            DownloadFile3b tempDownloadFileB = new DownloadFile3b();
            DownloadFile3a tempDownloadFileC = new DownloadFile3a(statusC);
            DownloadFile3a tempDownloadFileD = new DownloadFile3a(statusD);
            DownloadFile3a tempDownloadFileE = new DownloadFile3a(statusE);
            DownloadFile3a tempDownloadFileF = new DownloadFile3a(statusF);


            sharedStatusDownloadFiles.add(tempDownloadFileA);
            lockedStatusDownloadFiles.add(tempDownloadFileC);
            confinedStatusDownloadFiles.add(tempDownloadFileB);
            SynchronizedStatusDownloadFiles.add(tempDownloadFileD);
            atomicStatusDownloadFiles.add(tempDownloadFileD);
            adderStatusDownloadFiles.add(tempDownloadFileF);

            

            Thread tempA = new Thread(tempDownloadFileA);
            Thread tempB = new Thread(tempDownloadFileB);
            Thread tempC = new Thread(tempDownloadFileC);
            Thread tempD = new Thread(tempDownloadFileD);
            Thread tempE = new Thread(tempDownloadFileE);
            Thread tempF = new Thread(tempDownloadFileF);

            tempA.start();
            tempB.start();
            tempC.start();
            tempD.start();
            tempE.start();
            tempF.start();

            threadsWithSharedMemory.add(tempA);
            threadsWithConfinedMemory.add(tempB);
            threadsWithLockedMemory.add(tempC);
            threadsWithSynchronizedMemory.add(tempD);
            threadsWithAtomicMemory.add(tempE);
            threadsWithAdderMemory.add(tempF);
        }
        
        Consumer<ArrayList<Thread>> joinArrayOfThreads = (threads) -> {
            for (var thread : threads) {
                try {
                    thread.join();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };

        joinArrayOfThreads.accept(threadsWithSharedMemory);
        joinArrayOfThreads.accept(threadsWithConfinedMemory);
        joinArrayOfThreads.accept(threadsWithLockedMemory);
        joinArrayOfThreads.accept(threadsWithSynchronizedMemory);
        joinArrayOfThreads.accept(threadsWithAtomicMemory);
        joinArrayOfThreads.accept(threadsWithAdderMemory);
        
        
        System.out.println("Logged: ");
        System.out.println("Bytes Logged from ThreadA (Race Condition): " + statusA.getBytes() + " - This also starts working correctly when other solutions were run with it"); // Example of race confinement
        System.out.println("Bytes Loggen from ThreadB (Confinement): " + confinedStatusDownloadFiles.stream()
                                                                                        .map(t -> t.getStatus().getBytes())
                                                                                        .reduce(0, Integer::sum)); // How to solve it.
        System.out.println("Bytes Logged from ThreadC (Synchronization using locks): " + statusC.getBytes());
        System.out.println("Bytes Logged from ThreadA (Synchronization using synchronized keyword): " + statusD.getBytes()); 
        System.out.println("Bytes Logged from ThreadA (Atomic variables): " + statusE.getBytes()); 
        System.out.println("Bytes Logged from ThreadA (Adder variables): " + statusF.getBytes()); 



    }

    public static void testMultiThreads3_SolveVisibilityProblem() {
        DownloadStatus status = new DownloadStatus();

        Thread thread1 = new Thread(new DownloadFile4(status));

        Thread thread2 = new Thread(() -> {
            if (!status.isDone()) {
                synchronized (status) {
                    try {
                    status.wait(); // Waits for the object to notify. All objects have this functionality. Java requires it to be in a synchronized block.
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getBytes() + ": " + Thread.currentThread().getName());
        });



        thread1.start();
        thread2.start();


    }
}


class AtomicStatus implements StatusTrackable{
    private AtomicInteger bytes = new AtomicInteger();

    AtomicStatus() {
        this.bytes.set(0);
    }

    @Override
    public int getBytes() {
        return bytes.get();
    }

    @Override
    public void incrementBytes() {
        bytes.incrementAndGet();
    }
}

class AdderStatus implements StatusTrackable{
    private LongAdder bytes = new LongAdder();

    AdderStatus() {
        
    }

    @Override
    public int getBytes() {
        return bytes.intValue();
    }

    @Override
    public void incrementBytes() {
        bytes.increment();
    }
}

interface StatusTrackable {
    int getBytes();
    void incrementBytes();
}

class DownloadStatus {

    private int bytes;
    private volatile boolean isDone;

    DownloadStatus() {
        this.bytes = 0;
        this.isDone = false;
    }

    public void incrementBytes() {
        this.bytes++;
    }

    public int getBytes() {
        return this.bytes;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void done() {
        this.isDone = true;
    }
}

class DownloadFile4 implements Runnable {
    private DownloadStatus status;

    DownloadFile4(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());
        for (int i = 0; i < 10_240; i++) {
            status.incrementBytes();
            for (int j = 0; j < 10_240; j++);
        }
        status.done();

        synchronized (status) {
            try {status.notifyAll();} catch (Exception e) {e.printStackTrace();}
        }
        System.out.println("Downloading complete: " + Thread.currentThread().getName());

    }

    public DownloadStatus getStatus() {
        return this.status;
    }


}

class Status implements StatusTrackable {
    private int bytes;

    Status() {
        this.bytes = 0;
    }

    @Override
    public int getBytes() {
        return bytes;
    }

    @Override
    public void incrementBytes() {
        bytes++;
    }
}

class LockedStatus implements StatusTrackable {
    private int bytes;
    private Lock lock = new ReentrantLock();

    LockedStatus() {
        this.bytes = 0;
    }
    @Override
    public int getBytes() {
        return bytes;
    }
    @Override
    public void incrementBytes() {
        lock.lock();
        try {
            bytes++;
        } 
        finally {
            lock.unlock(); // Locks should always be unlocked. So, it is wrapped in a finally block.
        }
    }
}



class SynchronizedStatus implements StatusTrackable {
    private int bytes;
    private Object byteLock = new Object();

    SynchronizedStatus() {
        this.bytes = 0;
    }

    public int getBytes() {
        return bytes;
    }

    public void incrementBytes() {
        synchronized (byteLock) { // byteLock object is used here as a monitor object. This is used as a key to monitor the access. 
            bytes++;
        }
    }

    // public synchronized void incrementBytes() {
    //     bytes++;
    // }
    // Can also be written like this. But this would equate to using synchronized (this) which is bad practice since it also won't allow other threads to access other fields of same object.
}

class DownloadFile implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10240; i++)
            for (int j = 0; j < 10240; j++);

        System.out.println(Thread.currentThread().getName());
        
        System.out.println("Downloading a file.");
    }
}

class DownloadFile2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading from " + Thread.currentThread().getName());
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " Interrupted");
                return;
            };
            System.out.println("Downloading byte " + i);
        }
    }
}

class DownloadFile3a implements Runnable {
    private StatusTrackable status;

    DownloadFile3a(StatusTrackable status) {
        this.status = status;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            status.incrementBytes();
        }
    }

    public StatusTrackable getStatus() {
        return this.status;
    }

}

class DownloadFile3b implements Runnable {
    private StatusTrackable status;

    DownloadFile3b() {
        this.status = new Status();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            status.incrementBytes();
        }
    }

    public StatusTrackable getStatus() {
        return this.status;
    }

}
class TitleComparator implements Comparator<Movies>{
    @Override
    public int compare(Movies a, Movies b) {
        return Integer.parseInt(a.getTitle()) - Integer.parseInt(b.getTitle());
    }
}

class Movies implements Comparable<Movies> {
    private String title;
    private int likes;
    private ArrayList<String> cast = new ArrayList<>();
    private Genre genre;

    Movies(String title, int likes, Genre genre, String... castMembers) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
        for (var member: castMembers) cast.add(member);
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public Genre getGenre(){
        return genre;
    }

    @Override
    public int compareTo(Movies arg0) {
        return this.likes - arg0.getLikes();
    }

    // @Override
    // public String toString() {
    //     Function<Movies, String> toString = (movie) -> movie.getTitle() + ": " + movie.getLikes();
    //     return toString.apply(this);
    // }

    enum Genre {
        COMEDY,
        ACTION,
        THRILLER
    } 
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("The message using class is: " + message);
    }
}
