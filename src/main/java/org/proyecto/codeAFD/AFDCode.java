package org.proyecto.codeAFD;

import java.util.*;

public class AFDCode {
    // variables to manage the afd
    private Set<String> states;
    Map<String, List<String>> alphabet;
    private Map<String, List<Map<String, String>>> transitions;
    private String initialState;
    private Set<String> finalStates;

    private String setName;
    //Constructor
    public AFDCode(Set<String> states, Map<String, List<String>> alphabet, Map<String, List<Map<String, String>>> transitions, String initialState, Set<String> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.setName = "";
    }


    private boolean evaluateAlphabet(String character){
        // iterate over the alphabet
        for(Map.Entry<String, List<String>> entry : alphabet.entrySet()){
            // if the character is inside of the alphabet, return true
            if(entry.getValue().contains(character)){
                // print the name of the key
                setName = entry.getKey();
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
                        break;
                    }else {
                        // Evaluate if that character is on the alphabet
                        if(evaluateAlphabet(String.valueOf(c))){
                            // find the key that contains the current character type to change the current state
                            if( setName != null && transition.containsKey(setName)) {
                                currentState = transition.get(setName);
                                break;
                            }else {

                            }
                        }
                        return false;
                    }
                } else if (transition.size() > 1 ){
                    // if the key array contains the current character, change the current state
                    if(transition.containsKey(String.valueOf(c))){
                        currentState = transition.get(String.valueOf(c));
                        break;
                    } else {
                        // if the key array doesn't contains the current character, check if the key array contains the current character type
                        if(evaluateAlphabet(String.valueOf(c))){
                            // find the key that contains the current character type to change the current state
                            if( setName != null && transition.containsKey(setName)) {
                                currentState = transition.get(setName);
                                break;
                            }
                        }else {
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
