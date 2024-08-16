package com.octavioi;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //testingListGenericClass();
        //testingMultipleParameterGenerics();
        //testFunctionalInterface();

        //testBuiltInFunctionalInterfaces();

        testStream();

        


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

        Consumer<Double> printD = (num) -> System.out.println(num);

        Stream.iterate(2D, n -> n + 2)
                .limit(5)
                .forEach(printD);

        List<Movies> movies = List.of(
            new Movies("10", 150, "What", "is", "This"),
            new Movies("12", 300, "This is"),
            new Movies("7", 70, "Late", "Call"),
            new Movies("11", 800, "John", "Jess", "Smith", "Shetty"),
            new Movies("16", 500, "Smithy", "Jessy", "Johny")
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

        System.out.println("Using Compating method");

        movies.stream()
                .sorted(Comparator.comparing(Movies::getLikes))
                .forEach(printMovie);

        System.out.println("Reducing: ");

        var casts = movies.stream()
                .map(Movies::getCast)
                .reduce((a, b) -> {a.addAll(b); return a;})
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
        
        System.out.println("Movie Titles: " + castTitles);

        




        

        

        
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

    Movies(String title, int likes, String... castMembers) {
        this.title = title;
        this.likes = likes;
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

    @Override
    public int compareTo(Movies arg0) {
        return this.likes - arg0.getLikes();
    }
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("The message using class is: " + message);
    }
}
