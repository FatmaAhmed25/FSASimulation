import java.util.HashMap;
import java.util.Map;

class Problem9 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String startState = "q0";
    private static final String[] acceptingStates = {"q1","q2","q3","q4"};

    static {
        // Define transition table
        transitionTable.put("q0", Map.of('0', "q1", '1', "q3"));
        transitionTable.put("q1", Map.of('0', "q5", '1', "q2"));
        transitionTable.put("q2", Map.of('0', "q1", '1', "q6"));
        transitionTable.put("q3", Map.of('0', "q4", '1', "q7"));
        transitionTable.put("q4", Map.of('0', "q8", '1', "q3"));
        transitionTable.put("q5", Map.of('0', "q5", '1', "q5"));
        transitionTable.put("q6", Map.of('0', "q6", '1', "q6"));
        transitionTable.put("q7", Map.of('0', "q7", '1', "q7"));
        transitionTable.put("q8", Map.of('0', "q8", '1', "q8"));

    }

    @Override
    public boolean isAccepted(String input) {
        String currentState = startState;

        for (char c : input.toCharArray()) {
            if (!transitionTable.containsKey(currentState) || !transitionTable.get(currentState).containsKey(c)) {
                return false; // No valid transition for current state and input symbol
            }
            currentState = transitionTable.get(currentState).get(c);
        }

        // Check if the final state is one of the accepting states
        for (String state : acceptingStates) {
            if (currentState.equals(state)) {
                return true;
            }
        }

        return false;
    }
}