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


    private boolean evaluateAlphabet(String character){
        // iterate over the alphabet
        for(Map.Entry<String, List<String>> entry : alphabet.entrySet()){
            // if the character is inside of the alphabet, return true
            if(entry.getValue().contains(character)){
                return true;
            }
        }
        // if the character is not inside of the alphabet, return false
        return false;
    }
    private boolean isFinalState(String state) {
        return finalStates.contains(state);
    }

    public boolean accept(String word) {
        String currentState = initialState; // start in the initial state
        // iterate over the word
        for( char c: word.toCharArray()) {
            // First search de intialState in the transitions
            for(Map<String, String> transition : transitions.get(currentState) ){
                // if the array is equal to 1, evaluate literals
                if(transition.size() == 1){
                    // if the transition contains the current character, change the current state
                    if(transition.containsKey(String.valueOf(c))){
                        currentState = transition.get(String.valueOf(c));
                        System.out.println("Current state: " + currentState + " with character: " + c + " has a one element transition");
                        break;
                    }else {
                        System.out.println("Current state: " + currentState + " with character: " + c + " has a one element transition but doesn't match");
                        return false;
                    }
                } else if (transition.size() > 1 ){
                    // if the key array contains the current character, change the current state
                    if(transition.containsKey(String.valueOf(c))){
                        currentState = transition.get(String.valueOf(c));
                        System.out.println("Current state: " + currentState + " with character: " + c + " has a more than one element transition but match with the key");
                        break;
                    } else {
                        // if the key array doesn't contains the current character, check if the key array contains the current character type
                        if(evaluateAlphabet(String.valueOf(c))){
                            System.out.println("Current state: " + currentState + " with character: " + c + " is on the alphabet");
                        }else {
                            System.out.println("Current state: " + currentState + " with character: " + c + " is not on the alphabet");
                            return false;
                        }
                    }
                }
            }
        }
        // if the current state is a final state, the word is accepted
        return isFinalState(currentState);
    }
}
