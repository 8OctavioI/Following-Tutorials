package com.octavioi;

public class Test {
    public static void main(String[] args) {
        testingListGenericClass();
        //testingMultipleParameterGenerics();


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
    
}
