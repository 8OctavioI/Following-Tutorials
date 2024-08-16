package com.octavioi;

import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        //testingListGenericClass();
        //testingMultipleParameterGenerics();
        //testFunctionalInterface();

        testBuiltInFunctionalInterfaces();


    }

    public static void testingListGenericClass() {
        Integer[] pos = {1,2,5,6};
        List<Integer> n = new List<Integer>(pos);
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

    
    
}


class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("The message using class is: " + message);
    }
}
