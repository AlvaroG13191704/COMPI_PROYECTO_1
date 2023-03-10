package org.proyecto.codeAFD;

import java.util.*;

public class AFDCode {
    // variables to manage the afd
    private Set<String> states;
    Map<String, List<String>> alphabet;
    private Map<String, List<Map<String, String>>> transitions;
    private String initialState;
    private Set<String> finalStates;

    //Constructor
    public AFDCode(Set<String> states, Map<String, List<String>> alphabet, Map<String, List<Map<String, String>>> transitions, String initialState, Set<String> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }


    public boolean accept(String word) {
        String currentState = initialState; // start in the initial state
        // iterate over the word
        for( char c: word.toCharArray()) {
            // First search de intialState in the transitions
            for (Map<String, String> transition : transitions.get(currentState)) {
                // if the transition has the character
                if (transition.containsKey(String.valueOf(c))) {
                    // change the current state
                    currentState = transition.get(String.valueOf(c));
                    break;
                }
            }
        }
        return false;
    }

}
