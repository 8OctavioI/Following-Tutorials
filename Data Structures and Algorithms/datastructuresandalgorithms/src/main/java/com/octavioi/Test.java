package com.octavioi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;

public class Test {
    public static void main(String []args) {
        //testLinkedList();
        //testStack();
        testQueues();
    }

    public static void testLinkedList() {
        LinkedList2<Integer> list = new LinkedList2<Integer>();
        System.out.println(list);
        list.addLast(10);
        System.out.println(list);
        
        System.out.println(list);
        list.addLast(20);
        System.out.println(list);
        list.deleteLast();
        System.out.println(list);
        list.addFirst(5);
        list.addFirst(2);
        System.out.println(list);
        System.out.println(list.size());

        list.deleteFirst();
        System.out.println(list);
        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(20));
        System.out.println(list.contains(10));
        list.deleteLast();
        System.out.println(list);
        list.deleteFirst();
        System.out.println(list);
        System.out.println(list.size());
        list.addFirst(5);
        list.addLast(30);
        list.addFirst(1);
        System.out.println(list);
        System.out.println(list.size());

        System.out.println("Iterable test");
        for (var ele : list) {
            System.out.println(ele.value);
        }
        System.out.println(list);
        list.reverse();
        System.out.println(list);
        LinkedList2<Integer> list2 = new LinkedList2<Integer>();
        System.out.println(list2);
        System.out.println("New: ");
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.addLast(40);
        list2.addLast(50);
        System.out.println(list2);
        System.out.println(list2.kThNodeFromEnd(1).value);
        System.out.println(list2.kThNodeFromEnd(2).value);
        System.out.println(list2.kThNodeFromEnd(3).value);
        System.out.println("next:");
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(1).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(2).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(3).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(0).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(5).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(7).value);
        System.out.println(list2.kThNodeFromEndWithoutUsingSize(6).value);
        System.out.println("barrier");
        System.out.println(list2.kThNodeFromEnd(0).value);
        System.out.println(list2.kThNodeFromEnd(5).value);
        System.out.println(list2.kThNodeFromEnd(7).value);
        System.out.println(list2.kThNodeFromEnd(6).value);

        // System.out.println(list.toArray());
        // Integer[] arr = list.toArray();
        // for (var i: arr) System.out.println(i);
    }

    public static void testStack() {
        Stack1<Integer> stack = new Stack1<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        String string = "What is this?";
        String s2 = "((1 {+} [2]))";
        System.out.println(String.format("Reverse of %s is: %s", string, reverseStringUsingStack(string)));
        System.out.println(String.format("is %s balanced or not: %s", s2, hasBalancedBrackets(s2)));

        

    }

    public static String reverseStringUsingStack(String s) {
        Stack<Character> stack2 = new Stack<Character>();

        for (var i: s.toCharArray()) stack2.push(i);

        StringBuffer res = new StringBuffer();

        while (! stack2.isEmpty() ) {
            res.append(stack2.pop());
        }
        return res.toString();
    }

    public static boolean hasBalancedBrackets(String s) {
        ArrayList<Character> openers = new ArrayList<Character>(Arrays.asList('[', '{', '(','<'));
        ArrayList<Character> closers = new ArrayList<Character>(Arrays.asList(']', '}', ')','>'));

        Stack<Character> stack = new Stack<>();

        for (var i : s.toCharArray()) {
            if (openers.contains(i)) stack.push(i);
            else if(closers.contains(i)) {
                if (!stack.isEmpty() 
                    && stack.peek().equals(
                                    openers.get(closers.indexOf(i)))) {
                                        stack.pop();
                                    }
                else return false;
            } 
        }
        return stack.empty();
    }

    public static void testQueues() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        System.out.println(queue);
        Integer removed = queue.poll();
        System.out.println(removed);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);

        ArrayQueue1<Integer> queue1 = new ArrayQueue1<>(5);
        queue1.enqueue(40);
        queue1.enqueue(50);
        queue1.enqueue(60);
        queue1.enqueue(70);
        System.out.println(queue1);
        System.out.println(queue1.peek());
        System.out.println(queue1.deque());
        System.out.println(queue1);
        queue1.enqueue(90);
        System.out.println(queue1);
        queue1.deque();
        System.out.println(queue1);
        queue1.enqueue(100);
        queue1.enqueue(110);
        System.out.println(queue1);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.add(queue.remove());
        }
        while(!stack.isEmpty()) {
            queue.add(stack.pop());
        }

    }
}
