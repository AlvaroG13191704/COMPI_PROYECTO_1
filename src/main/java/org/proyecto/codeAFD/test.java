package org.proyecto.codeAFD;

import java.util.*;

public class test {

    public static void main(String[] args) {
        // create a set of states
        Set<String> states = new HashSet<>();
        states.add("S0");
        states.add("S1");
        states.add("S2");
        states.add("S3");
        // Create the alphabet
        Map<String, List<String>> alphabet = new HashMap<>();
        alphabet.put("mayus", Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        alphabet.put("minus", Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        alphabet.put("digito", Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        // Transitions
        Map<String, List<Map<String, String>>> transitions = new HashMap<>();
        // S0
        List<Map<String, String>> list0 = new ArrayList<>();
        Map<String, String> map0 = new HashMap<>();
        map0.put("\'", "S1");
        list0.add(map0);
        transitions.put("S0", list0);
        // S1
        List<Map<String, String>> list1 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("\\n", "S2");
        map1.put("minus", "S2");
        map1.put("mayus", "S2");
        map1.put("digito", "S2");
        map1.put(" ", "S2");
        list1.add(map1);
        transitions.put("S1", list1);
        // S2
        List<Map<String, String>> list2 = new ArrayList<>();
        Map<String, String> map2 = new HashMap<>();
        map2.put("\'", "S3");
        map2.put("\\n", "S2");
        map2.put("minus", "S2");
        map2.put("mayus", "S2");
        map2.put("digito", "S2");
        map2.put(" ", "S2");
        list2.add(map2);
        transitions.put("S2", list2);
        // S3
        List<Map<String, String>> list3 = new ArrayList<>();
        Map<String, String> map3 = new HashMap<>();
        list3.add(map3);
        transitions.put("S3", list3);
        // Initial state from states
        String initialState = "S0";
        // Final states
        Set<String> finalStates = new HashSet<>();
        finalStates.add("S3");
        // Create the AFD
        AFDCode afd = new AFDCode(states, alphabet, transitions, initialState, finalStates);

        // PRINT ALL DATA STRUCTURES
        System.out.println("States: " + states);
        System.out.println("Alphabet: " + alphabet);
        System.out.println("Transitions: " + transitions);
        System.out.println("Initial state: " + initialState);
        System.out.println("Final states: " + finalStates);

        // TEST
        boolean result = afd.accept("\'cadena entre comilla simple\'");
        System.out.println("Result: " + result);
    }
}
