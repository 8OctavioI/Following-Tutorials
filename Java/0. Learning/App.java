import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;




public class App {
    static void printHello(){
        try {
            File res = new File("_Resources/hello_unicode.txt"); 
            Scanner scanner = new Scanner(res);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
    
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    static void maths(){
        int x;
        x = 2;
        int y = 234;
        float z = x * y;
        System.out.println(String.format("z = %d + %d = %.2f = %d", x, y, z, (int)z));
        int[] l = {2, 3, 4};
        System.out.println(String.format("%d + %d + %d = %d\n%d x %d x %d = %d", 2, 3, 4, (int)add(l), 2, 3, 4, (int)multiply(l)));
    }

    static int add(int args[]){
        int sum = 0;
        for(int i: args){
            sum += i;
        }
        return sum; 
    }

    static int multiply(int[] args){
        int sum = 1;
        for(int i: args){
            sum *= i;
        }
        return sum; 

    }

    static void comparisons(int a, int b){
        if (a > b) System.out.println(String.format("%d is greater than %d", a, b));
        else if (a < b) System.out.println(String.format("%d is lesser than %d", a, b));
        else if (a == b) System.out.println(String.format("%d is equal to %d", a, b));

    }

    static void classes(){
        Point a = new Point(2, 3);
        Point b = new Point(3, 4);
        Point c = new Point(2, 3);
        Point d = new Point();
        System.out.println(String.format("(%d, %d) is %.2f units away from (%d, %d)", a.getX(), a.getY(), a.distanceFrom(b), b.getX(), b.getY()));
        System.out.println(String.format("(%d, %d) is %.2f units away from (%d, %d)", a.getX(), a.getY(), a.distanceFrom(c), c.getX(), c.getY()));
        System.out.println(String.format("(%d, %d) is %.2f units away from (%d, %d)", b.getX(), b.getY(), b.distanceFrom(a), a.getX(), a.getY()));
        System.out.println(String.format("(%d, %d) is %.2f units away from (%d, %d)", d.getX(), d.getY(), d.distanceFrom(a), a.getX(), a.getY()));


    }

    static void forEach() {
        int[] a = {1, 2, 3, 4, 5};
        for (int i : a) {
            System.out.println(String.format("%d x 5 = %d", i, i*5));

        }

    }
// -3,3 -4,-3 4,-2 6,5
    static void shapes() {
        Shape s1 = new Shape();
        s1.dispDetails();
        Point[] p = {new Point(), new Point(2, 3), new Point(4, 5)};
        s1.addPoint(p[0]);
        s1.dispDetails();
        s1.addPoint(p[1]);
        s1.dispDetails();
        s1.addPoint(p[2]);
        s1.dispDetails();
        
        Shape s2 = new Shape(p);
        s2.dispDetails();

        s1.addPoint(new Point(6, 7));
        s1.dispDetails();
        s1.addPoint(new Point(36, 40));
        s1.dispDetails();
        Point[] p2 = {new Point(-3, 3), new Point(-4, -3), new Point(4, -2), new Point(6, 5)};
        Shape s3 = new Shape(p2);
        s3.dispDetails();

    }
//TAG TGA TAA
    static void strings(String a){
        a = a.toUpperCase();
        int start = 0;
        int end = start;
        int end1, end2, end3;
        ArrayList<String> DNAs = new ArrayList<String>();

        while (a.indexOf("ATG", start) != -1){
            start = a.indexOf("ATG", end);
            end = start;
            end1 = start;
            end2 = start;
            end3 = start;

            //System.out.println((a.indexOf("TAA", end) - start) % 3);
            end1 = a.indexOf("TAA", end);
            end2 = a.indexOf("TAG", end);
            end3 = a.indexOf("TGA", end);

            while ((end1 - start) % 3 > 0 && (end2 - start) % 3 > 0 && (end3 - start) % 3 > 0) {
                if ((end1 - start) % 3 != 0) end1 = a.indexOf("TAA", end1 + 1);
                if ((end2 - start) % 3 != 0) end2 = a.indexOf("TAG", end2 + 1);
                if ((end3 - start) % 3 != 0) end3 = a.indexOf("TGA", end3 + 1);


            }
            
            if (end == -1 || start == -1) break;
            end = Math.max(end1, Math.max(end2, end3));
            if ((end1 - start) % 3 == 0 && end1 > 0) {
                end = end1;
            }
            if ((end2 - start) % 3 == 0) if (end2 <= end && end2 > 0){
                end = end2;
            }

            if ((end3 - start) % 3 == 0) if (end3 <= end && end3 > 0) {
                end = end3;
            }

            DNAs.add(a.substring(start, end + 3));


        }

        System.out.println(DNAs);

    }

    static void strings2(String a) {
        ArrayList<String> DNAs = new ArrayList<String>();

        //String b = a;
        
        ArrayList<String> strs = new ArrayList<String>();
        for (int i = 3; i < a.length(); i += 3){
        strs.add(a.substring(i - 3, i));
        }
        int count = 0;
        for (int i = 0; i < strs.size(); i++) {
            
            if (strs.get(i).equalsIgnoreCase("ATG")){
                DNAs.add(strs.get(i));
                for (;!strs.get(i).equalsIgnoreCase("TAA") && i < strs.size(); i++){
                    DNAs.set(count, DNAs.get(count) + strs.get(i));
                }
                DNAs.set(count, DNAs.get(count) + strs.get(i));
                if (!strs.get(i).equalsIgnoreCase("TAA")) {
                    DNAs.removeLast();
                    count -= 1;
                }
                count += 1;
            }
        }
        System.out.println(DNAs);
    }

    static String encrypt(StringBuilder s, int n) {

        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) s.setCharAt(i, (char)((s.charAt(i) + n)%97%26 + 97));
            else s.setCharAt(i, s.charAt(i)); 
        }

        return s.toString();
    }

    static String encrypt2(String input, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encryptAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        String encrypt = "";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                encrypt += encryptAlphabet.charAt(alphabet.indexOf(input.charAt(i)));
            } else encrypt += input.charAt(i);
        }
        return encrypt;
    }

    static void decrypt(String s) {
        int[] count = new int[26];
        String[] strs = new String[26];
        for (int i = 0; i < 26; i++) {
            strs[i] = encrypt(new StringBuilder(s), i);
            for(int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == 'e') {
                    count[i]++;
                }
            }
        }
        String max = "";
        int maxi = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxi) {
                maxi = count[i];
                max = strs[i];
            }
        }
        System.out.println(max);
    }

    static void countAlphabets(String s) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int[] arr2 = new int[26];

        for (char i : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(i))
                arr2[alphabets.indexOf(i)]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(String.format("%c: %d", alphabets.charAt(i), arr2[i]));
        }
    }
    
    static void countAlphabets2(String s) {
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        //letters.values()
        for (char i : s.toCharArray()) {
            Integer x = letters.putIfAbsent(i, 1);
            if(x != null) {
                letters.put(i, x + 1);
            }
        }
        letters.forEach((k, v) -> {System.out.println(String.format("%c: %d",k, v));});
    }

    static void findKthLargest(int[] nums, int k) {
        int[] arr = new int[k];
        
        arr[0] = nums[0];
        int j;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count < k) {
                for (int l = 0; l < k; l++){
                    if (arr[l] > nums[i]) {
                        int m;
                        for(m = k - 1; m > l && arr[m - 1] > nums[i]; m--) {
                            arr[m] = arr[m - 1];
                        }
                        arr[m] = nums[i];
                        count++;
                        break;
                        
                    }
                    if (arr[l] < nums[i]) {
                        int m = l;
                        for (; m < k - 1 && arr[m + 1] < nums[i]; m++) {
                            arr[m] = arr[m + 1];
                        }
                        arr[m] = nums[i];
                        count++;
                        break;
                    }
                }
            }
            else if(arr[0] < nums[i] || arr[k - 1] < nums[i]) {
                for (int l = 0; l < k; l++){
                    if (arr[l] > nums[i]) {
                        int m;
                        for(m = k - 1; m > l && arr[m - 1] > nums[i]; m--) {
                            arr[m] = arr[m - 1];
                        }
                        arr[m] = nums[i];
                        break;
                        
                    }
                    if (arr[l] < nums[i]) {
                        int m = l;
                        for (; m < k - 1 && arr[m + 1] < nums[i]; m++) {
                            arr[m] = arr[m + 1];
                        }
                        arr[m] = nums[i];
                        break;
                    }
                }
            }

        }

    }

    static int findKthLargest2(int[] nums, int k){
        int[] arr = new int[k];
        int max;
        int min = -10000;

        for (int i = 0; i < k; i++) {
            max = -10000;
            int index = 0;
            for(int j = 0; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            arr[i] = max;
            nums[index] = min;
        }

        return arr[k - 1];
    }

    static int findKthLargest3(int[] nums, int k){
        int[] arr = new int[k + 1];
        Arrays.fill(arr, -10000);
        arr[k] = +10000;

        for (int i = 0; i < nums.length; i++) {
            int j;
            for(j = 0; arr[j] <= nums[i]; j++);
            for (int l = 0; l < j - 1; l++) {
                arr[l] = arr[l + 1];
            }
            if (arr[j] >= nums[i] && j != 0) arr[j - 1] = nums[i];
        }
        

        return arr[0];
    }

    static void moveZeroes(int[] nums) {
        //int count = 0;
        
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                if (i != count) {
                    nums[i] = nums[count];
                    nums[count] = temp;
                }
                count++;
            }
        }
    }

    static int deleteGreatestValue(int[][] grid) {
        int final1 = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (;n > 0;) {
            int maxi = 0;
            for (int i = 0; i < m; i++) {
                int max = 0;
                int index = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        index = j;
                    }
                }
                if (max > maxi) maxi = max;
                grid[i][index] = grid[i][n - 1];
            }
            final1 += maxi;
            n--;
        }
        return final1;
    }

    static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = 0;
        if (nums[high] < target) return high + 1;
        if (nums[0] >= target) return 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                if (nums[mid + 1] >= target) return mid + 1;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return (mid);
    }

    static int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                curr = nums[i];
                int temp = nums[count];
                nums[count] = nums[i];
                nums[i] = temp;
                count++;
            }
        }
        return count;
    }

    static int minOperations(String[] logs) {
        int depth = 0;
        for (String log: logs) {
            if (log.indexOf(".") == -1) depth++;// = Math.max(0,depth--);
            else if (log.indexOf("..") != -1) depth = Math.max(0,--depth);
        }
        return depth;
    }

    static int clumsy(int n) {
        int i = n, count = 0, test = 1;
        if (n >= 4) {
            count =  n * (n - 1) / (n - 2) + (n - 3);
            i = n - 4;
            test = -1;
        }
        for (; i >= 4; i -= 4) {
            count += - i * (i - 1) / (i - 2) + (i - 3);
        }
        if (i == 3) count += test * i * (i - 1) / (i - 2);
        else if (i == 2) count += test * i * (i - 1);
        else if (i == 1) count += test * i;
        return count;
    }

    static void nto1(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        else {
            System.out.print(n + " ");
            nto1(n - 1);
        }
    }

    static void onetoN(int n) {
        onetoN(n, 1);
    }
    static void onetoN(int n, int i) {
        if (i > n) return;
        else {
            System.out.print(i + " ");
            onetoN(n, ++i);
        }
    }

    static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    static int factorial2(int n, int i) {
        if (n == 0) return i;
        else {
            return factorial2(n - 1, i*n);
        }

    }

    static int palindrome(String s, int i) {
        int x;
        if (i > s.length()/2) return 1;
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return -1;
        else return palindrome(s, i + 1);   
    }
    static Boolean palindrome2(String s, int n) {
        if (n == s.length()/2) return true;
        else if (s.charAt(n) == s.charAt(s.length() - 1 - n)){
            return palindrome2(s, n + 1);
        }
        else {
            return false;
        }
    }

    static Boolean palindrome3(String s) {
        //StringBuilder sb = ;
        return s.equals((new StringBuilder(s)).reverse().toString());
    }
    


    static String shortestPalindrome(String s) {
        String s2 = longestPalindrome2(s);
        int n = s.indexOf(s2);
        int l = s2.length();
        int l1 = s.length();
        for (int i = n + l; i < l1; i+=2) {
            s = s.charAt(i) + s;
            l1++;
        }
        return s;
    }
    static String longestPalindrome2(String s) {
        int low = 0, high = s.length();
        //n = high;
        if (high == 0) return "";
        char ele = s.charAt(0);
        for (int i = high - 1; i > 0; i--) {
            if (s.charAt(i) == ele) {
                if (palindrome3(s.substring(0, i + 1))) {
                    return s.substring(0, i + 1);
                }
            }
        }
        return "" + s.charAt(0);
        
    }

    static String longestPalindrome(String s) {
        int low = 0, high = s.length();
        //n = high;
        for (int i = high; i > 0; i--) {
            for (int j = 0; i + j <= high; j++) {
                if (palindrome2(s.substring(j, i + j), 0)) {
                    return s.substring(j, i + j);
                }
            }
        }
        return "" + s.charAt(0);
    }

    static String longestPalindrome3(String s) {
        int low = 0, high = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        //n = high;
        for (int i = high; i > 0; i--) {
            for (int j = 0; i + j <= high; j++) {
                if (s.substring(j, i + j).equals(sb.substring(high - (i + j), high - j))) {
                    return s.substring(j, i + j);
                }
            }
        }
        return "" + s.charAt(0);
    }

    static int sumOfDigits(int n) {
        if (n / 10 == 0) return n;
        return n % 10 + sumOfDigits(n / 10);
    }

    static int addDigits(int num) {
        if (num / 10 == 0) return num;
        return addDigits(sumOfDigits(num));
    }

    static int cuts(int num, int a, int b, int c) {
        int m1 = 1, m2 = 1, m3 = 1;
        if (num - a >= 0) {
            m1 = m1 + cuts(num - a, a, b, c);
        }
        if (num - b >= 0) {
            m2 = m2 + cuts(num - b, a, b, c);
        }
        if (num - c >= 0) {
            m3 = m3 + cuts(num - c, a, b, c);
        }
        return Math.max(m1, Math.max(m2, m3));    
    }

    static void recursive(String s, String curr, int n) {
        if (n >= s.length()) {
            System.out.println(curr);
        }
        else {
            recursive(s, curr, n + 1);
            recursive(s, curr + s.charAt(n), n + 1); 
        }
    }

    static void TOH(int n, String a, String b, String c) {
        if (n == 0) return;
        TOH(n - 1, a, c, b);
        System.out.println("Move Disk " + n + " from " + a + " to " + c);
        TOH(n - 1, b, a, c);
    }

    static long[] distance(int[] nums) {
        ArrayList<Integer> m1 = new ArrayList<Integer>();
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            m1.add(nums[i]);
            m1.addAll(m1);

        }
        return arr;
    }

    static int reverse(int x) {
        long y = x;
        int i = 0;
        int j = 0;
        for (;x/10 > 0; x = x / 10, j++);
        x = (int)y;
        y = 0;
        for (;x/10 > 0; x = x / 10, i++) {
            y += Math.pow(10, j - i) * (x % 10);
        }
        y += Math.pow(10, j - i) * (x % 10);
        if (y > Math.pow(2, 31) - 1 || y < - Math.pow(2, 31)) return 0;
        return (int)y;
    }

    static long[] kthPalindrome(int[] queries, int intLength) {
        long[] arr = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int z = 0;
            if (intLength%2 == 0) z = 1;
            long num = (long)Math.pow(10,(intLength - 1)/2);
            num = num + (queries[i] - 1);
            if (num >= Math.pow(10, (intLength + 1)/2)) num = -1;
            else if (intLength > 1) num = num*(long)Math.pow(10,(intLength+z - 1)/2) + Integer.parseInt((new StringBuilder((num + "").substring(0, (intLength+z - 1)/2))).reverse().toString());
            arr[i] = num;
        }
        return arr;
    }

    static String reverseParentheses(String s) {
        StringBuilder str = new StringBuilder(s);
        int h, l;
        while (true) {
            l = str.lastIndexOf("(");
            h = str.indexOf(")", l);
            if (h == -1 || l == -1) break;
            //if (h != l + 1) 
            str.replace(l, h + 1, (new StringBuilder(str.substring(l + 1, h))).reverse().toString());
            //else str.replace(l, h + 1, "");
        }
        return str.toString();
    }

    static int myAtoi(String s) {
        int count = 0, z = 1;
        long res = 0;
        int start = 0;
        char c = ' ';
        for (char i : s.toCharArray()) {
            count++;
            if (i != c) {
                c = '0';
                if (i == '-' && start == 0) { 
                    z = -1; 
                    start = 1;
                }
                else if (i == '+' && start == 0) start = 1;
                else {
                    
                    if (!Character.isDigit(i)) break; 
                    res += Integer.parseInt(i + "") * Math.pow(10, s.length() - count);
                }
            }
        }
        res = z * res;
        if (res >= Math.pow(2,31)) return (int)Math.pow(2, 31) - 1;
        if (res < -Math.pow(2, 31)) return (int)-Math.pow(2, 31);
        return (int)res;
    }

    static Pattern p = Pattern.compile("-?\\d+");
    static boolean areNumbersAscending(String s) {
        Matcher m = p.matcher(s);
        m.find();
        int n = Integer.parseInt(m.group());
        return areNumbersAscending1(s.substring(m.end()), n);
    }
    static boolean areNumbersAscending1(String s, int n) {
        Matcher m = p.matcher(s);
        if (m.find() != true) return true;
        int n1 = Integer.parseInt(m.group());
        if (n > n1) return false;
        else return areNumbersAscending1(s.substring(m.end()), n1);
    }

    static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int max = 0;
        
        for (int i: nums) {
            if (m.get(i) > max) {
                max = m.get(i);
            }
        }
        int count = 0;
        for (int e: m.values()) if (e == max) count += max;
        return count;


    }
    static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()) {
            if (m1.containsKey(c)) {
                m1.put(c, m1.get(c) + 1);
            }
            else {
                m1.put(c, 1);
            }
            
        }
        System.out.println(m1);
        

        for(char c: t.toCharArray()) {
            if (m1.containsKey(c)) {
                m1.put(c, m1.get(c) - 1);
            }
            else return false;
            
        }
        //m1.containsValue(m1)
        
        for (int c: m1.values()) {
            if (c != 0) return false;
        }
        return true;
    }

    static boolean isAnagram2(String s, String t) {
        for (int j = 0; j < s.length(); j++) {
            int sc = 0, st = 0;
            if (s.indexOf(s.charAt(j), 0, j) == -1) {
                for (int i = s.indexOf(s.charAt(j)); i != -1; i = s.indexOf(s.charAt(j), i + 1))sc++;
                for (int i = t.indexOf(s.charAt(j)); i != -1; i = t.indexOf(s.charAt(j), i + 1))st++;
                if (sc != st) return false;
            }
            

        }
/*
        for (char c: s.toCharArray()) {
            int sc = 0, st = 0;
            for (int i = 0; i != -1; i = s.indexOf(c + "", i + 1))sc++;
            for (int i = 0; i != -1; i = s.indexOf(c + "", i + 1))st++;
            if (sc != st) return false;
        }
            */
        return true;
    }

    static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
    static int lexiRank(String s) {
        int l = s.length();
        StringBuilder asc = new StringBuilder(sortString(s));
        int count = 1;
        for (int i = 0; i < l - 1; i++) {
            int n = asc.indexOf(s.charAt(i) + "", i);
            count += (n - i) * factorial(l - i - 1);
            asc = asc.replace(n, n+1, "").insert(i, s.charAt(i) + "");
        }
        return count;
    }

    static int accountRepeating(String s) {
        int[] count = new int[123];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        int c = 1;
        for (int i = 65; i < 123; i++) {
            if (count[i]>1)c*=count[i];
        }
        return c;

    }

    static int countAnagrams(String s) {
        int total = 0;
        String[] arr = s.split(" ");
        for (String s1 : arr) {
            total = (total + factorial(s1.length()))/accountRepeating(s1);
        }
        total *= factorial(arr.length);
        //total -= 2;
        
        return (int)(total %(Math.pow(10, 9) + 7));
    }

    static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static boolean isValid(String s) {
        StringBuilder str = new StringBuilder(s);
        //Character[] opening = {'{', '[', '('};
        //Character[] closing = {'}', ']', ')'};
        String opening = "{[(";
        String closing = "}])";
        int i = 0;
        
        while(str.length() > i) {
            for (int l = 0; l < 3; l++) {
                if (str.charAt(i) == opening.charAt(l)){
                    int x = i;
                    while (str.charAt(x) != closing.charAt(l)) {
                        if (closing.contains(str.charAt(x) + "")) {
                            return false;
                        }
                        x++;
                    }
                }
                
            }
        i++;  
        }
        return true;
    }

    static int maximumGain(String s, int x, int y) {
        String t1 = "ab", t2 = "ba";
        if (y > x) {
            t2 = "ab";
            t1 = "ba";
            int temp = y;
            y = x;
            x = temp;
        }
        

        int score = 0;
        int n, z;
        z  = s.length();
        do {  
            n = s.length();
            s = s.replaceAll(t1, "");
        } while (n != s.length());
        score += (z - n)/2 * x;
        z = n;
        do {  
            n = s.length();
            s = s.replaceAll(t2, "");
        } while (n != s.length());
        score += (z - n)/2 * y;
        
       
        return score;
    }

    static int maximumGain2(String s, int x, int y) {
        //A. *B|B. *A
        s = s.replaceAll("[^a. *b+|b. *a+]+", "z");
        StringBuilder s2 = new StringBuilder(s);
        String t1 = "ab", t2 = "ba";
        if (y > x) {
            t2 = "ab";
            t1 = "ba";
            int temp = y;
            y = x;
            x = temp;


        }

        int score = 0;
        int n, p, q;
        while (s2.indexOf(t1) != -1) {  
            p  = s2.indexOf(t1);
            q = p + 1; 
            for(;p >= 0 && q < s2.length() && s2.charAt(p) == t1.charAt(0) && s2.charAt(q) == t1.charAt(1); p--, q++, score += x) ;
                s2.replace(p + 1, q, "");

        }
        
        while (s2.indexOf(t2) != -1) { 
            p  = s2.indexOf(t2);
            q = p + 1;  
            for(;p >= 0 && q < s2.length() && s2.charAt(p) == t2.charAt(0) && s2.charAt(q) == t2.charAt(1); p--, q++, score += y);
                s2.replace(p + 1, q, "");

        }

        return score;
    }

    static double maxAverageRatio(int[][] classes, int extraStudents) {
        int index = 0;
        double minDiff = 100000;
        for (int i = 0; i < classes.length; i++) {
            double diff = ((double)classes[i][0])/((double)classes[i][1]);
            if (diff  < minDiff) {
                minDiff = diff;
                index = i;
            }
        }
        classes[index][0] += extraStudents;
        classes[index][1] += extraStudents;
        double avg = 0;
        for (int i = 0; i < classes.length; i++) {
            avg += (classes[i][0]/(double)classes[i][1]);
        }
        return avg/classes.length;
    }

    static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        StringBuilder directions2 = new StringBuilder(directions);
        ArrayList<Robot> robots = new ArrayList<Robot>();
        for (int i = 0; i < positions.length; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
        }
        while (directions2.indexOf("R") != -1 && directions2.indexOf("L") != -1) {
            int c = 0;
            for (int i = 0; i < (robots).size() - 1; i++) {
                c = 0;
                if (robots.get(i).moveCheck() == robots.get(i + 1).moveCheck() || (robots.get(i).moveCheck() == robots.get(i + 1).position && robots.get(i + 1).moveCheck() == robots.get(i).position)) {
                    if (robots.get(i).health > robots.get(i + 1).health) {
                        robots.get(i).health--;
                        robots.get(i).move();
                        robots.remove(i + 1);
                        directions2.replace(i + 1, i + 2, "");
                        i--;
                    }
                    else if (robots.get(i).health == robots.get(i + 1).health) {
                        robots.remove(i);
                        directions2.replace(i, i + 1, "");
                        robots.remove(i);
                        directions2.replace(i, i + 1, "");
                        i--;
                    }
                    else {
                        robots.get(i + 1).health--;
                        robots.get(i + 1).move();
                        robots.remove(i);
                        directions2.replace(i, i + 1, "");
                        i--;
                    }
                    c = 1;
                }
                else {
                    robots.get(i).move();
                }
            }
            if (c != 1) {
                robots.get(robots.size() - 1).move();
            }


        } 

        List<Integer> x = new ArrayList<Integer>();
        for (Robot r: robots) {
            x.add(r.health);
        }

        return x;
    }



    public static void main(String[] args){
        //printHello();
        //maths();
        //comparisons(0, 0);
        //comparisons(24, 45);
        //comparisons(45, 24);

        //classes();
        //forEach();
        //shapes();
        //strings("ttggctaattgagctgcggcatgtggccggctcgcatccctctcccggtctgtgggaatttgggctaacaatgaggttggaacctatcataaaactaagtcaccggtatcatgaatagttgacacgactgagaaatactctgatagcgtaggcggcatctggtcacgagttggagtctttataccgtgactcgtgcggatctacgcctacgaccatgttttattaaccccagattgcgctagtttacatgcactttagttccggctccaaggtttgttgacgctcactcattccctcgagcggattaatcggtgtataccggtttcaatattcattccgcgcatcggagcgccttagctcctctcaatattttgcgaagactagatgcagtaacgtcgtgtagcgtactggactcaattaacctgcgccctcgtctaatatggcctcctaaaggcttcaaaaagcagagacttcactccctttgtggtgacgaagaccctgctttttactgacgttccaatccggaaggcgcggccccccagcaatttaaatccagagaaaggttccaattatcgcacctccgttcccggacaccgtgtcatgctcatgaactaggggtctcttcaatcatccacatgctcacgtatgtcctactcgcggtctttcggatggagttatgtaatcttgtggctcccagcgtatacattctcccataatgctcccttacggggagttgcccacttcacttaaggcccatgtagtagttgccatcatgctcatagcggtgagaacgatttcagcggccccggtcacttcgaacgcataatctggatgagcgcagcatttattaacgtgggtctgtgagggacatgcctgcctttgcgtgataggcggattgactcgtcggatcaattctaactaggtcccagtgacaagctgaagtgcaatgccaagtacggcgaatcctcggtaacctagtggctacatgcgccctagcacg");
        //strings("AAATGCCCTAACTAGATTAAGAAACC");
        //String text = encrypt(new StringBuilder("Our goal is to unlock or decrypt an encrypted message. We don't have the key used to decrypt. We're not that fortunate. However, we do have the key used to encrypt from the class Caesar cipher. Using that, we can try all 26 keys. To decrypt using a human or eyeball approach, we'll create a CaesarCipher object. We'll try all 26 keys from 0 to 25. We'll use our CaesarCipher object, named cipher to shift the message with each of the 26 keys, then we'll print the result of the shift. As we'll see, we can decrypt the message if we recognize words.".toLowerCase()), 19);
        //decrypt(text);
        //encrypt2("".toLowerCase(), 19);
        //countAlphabets2("Our goal is to unlock or decrypt an encrypted message. We don't have the key used to decrypt. We're not that fortunate. However, we do have the key used to encrypt from the class Caesar cipher. Using that, we can try all 26 keys. To decrypt using a human or eyeball approach, we'll create a CaesarCipher object. We'll try all 26 keys from 0 to 25. We'll use our CaesarCipher object, named cipher to shift the message with each of the 26 keys, then we'll print the result of the shift. As we'll see, we can decrypt the message if we recognize words.".toLowerCase());
        int[] x = {-1,0,3,5,9,12};
        int[] y = {2, 5, 6};
        //findKthLargest3(x, 2);
        //moveZeroes(x);
        //int[][] grid = {{35,52,74,92,25},{65,77,1,73,32},{43,68,8,100,84},{80,14,88,42,53},{98,69,64,40,60}};
        //deleteGreatestValue(grid);
        //System.out.println({1, x});
        //searchInsert(x, 2);
        //removeDuplicates(x);
        //minOperations(x);
        //clumsy(1);
        //onetoN(5);
        //System.out.println(palindrome2("civoc", 0));
        //System.out.println(cuts(5, 2, 5, 1) - 1);
        //recursive("ABCD", "", 0);
        //TOH(1, "A", "B", "C");
        //reverse(123);
        //distance(x);
        //longestPalindrome3("abb");
        //System.out.println(shortestPalindrome("ababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab"));
        //reverseParentheses("ta()usw((((a))))");
        //myAtoi("+1");
        //areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
        //maxFrequencyElements(x);
        //isAnagram("a","ab");
        //isAnagram2("rat", "car");
        //List<Integer> nums;
        //nums.add(0, null);
        //System.out.println(lexiRank("STRING"));
        //System.out.println(countAnagrams("ptx cccbhbq"));
        //search(x, 9);
        //isValid("()[]{}");
        //System.out.println(("Done.\n" + maximumGain2(null, 0, 0)));
        //int[][] c = {{2,4},{3,9},{4,5},{2,10}};
        //maxAverageRatio(c, 4);

        int [] pos = {1,2,5,6};
        int[] hel = {10,10,11,11};
        String dirs = "RLRL";

        System.out.println(survivedRobotsHealths(pos, hel, dirs));

    }

    
}

class Robot {
    public int position;
    public int health;
    public char direction;

    Robot(int pos, int heal, char dir) {
        this.position = pos;
        this.health = heal;
        this.direction = dir;
    }

    public int move() {
        if (this.direction == 'R') {
            this.position++;
        }
        else this.position--;

        return this.position;
    }

    public int moveCheck() {
        if (this.direction == 'R') {
            return this.position + 1;
        }
        else return this.position - 1;

    }
}

