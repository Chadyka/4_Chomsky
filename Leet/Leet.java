package Leet;

import java.util.*;

public class Leet {
    Map<Character, List<String>> leetChars = new HashMap<Character, List<String>>(24);

    public Leet() {
        leetChars.put('a', Arrays.asList("4", "@", "/-\\"));
        leetChars.put('b', Arrays.asList("8", "|3", "|}"));
        leetChars.put('c', Arrays.asList("(", "<", "{"));
        leetChars.put('d', Arrays.asList("|)", "|]", "|}"));
        leetChars.put('e', Arrays.asList("3", "3", "3"));
        leetChars.put('f', Arrays.asList("|=", "ph", "|#"));
        leetChars.put('g', Arrays.asList("6", "[", "[+"));
        leetChars.put('h', Arrays.asList("#", "|-|", "[-]"));
        leetChars.put('i', Arrays.asList("1", "|", "!"));
        leetChars.put('j', Arrays.asList("7", "_|", "_/"));
        leetChars.put('k', Arrays.asList("|<", "1<", "|{"));
        leetChars.put('l', Arrays.asList("1", "|", "|_"));
        leetChars.put('m', Arrays.asList("44", "(V)", "|\\/|"));
        leetChars.put('n', Arrays.asList("|\\|", "/\\/", "/V"));
        leetChars.put('o', Arrays.asList("0", "()", "[]"));
        leetChars.put('p', Arrays.asList("/o", "|D", "|o"));
        leetChars.put('q', Arrays.asList("9", "O_", "(,)"));
        leetChars.put('r', Arrays.asList("12", "12", "|2"));
        leetChars.put('s', Arrays.asList("5", "$", "$"));
        leetChars.put('t', Arrays.asList("7", "7", "'|'"));
        leetChars.put('u', Arrays.asList("|_|", "(_)", "[_]"));
        leetChars.put('v', Arrays.asList("\\/", "\\/", "\\/"));
        leetChars.put('w', Arrays.asList("VV", "\\/\\/", "(/\\)"));
        leetChars.put('x', Arrays.asList("x" , ")(",  "><"));
        leetChars.put('y', Arrays.asList("'/", "'/", "'/"));
        leetChars.put('z', Arrays.asList("2", "7_", ">_"));
    }

    public Map<Character, List<String>> getLeetChars() {
        return leetChars;
    }
}
