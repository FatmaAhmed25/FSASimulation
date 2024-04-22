import java.util.HashMap;
import java.util.Map;

class Problem2 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String START_STATE = "q0";
    private static final String[] ACCEPTING_STATES = {"q1"};

    static {
        // Define transition table
        transitionTable.put("q0", Map.of('1', "q1", '0', "q2"));
        transitionTable.put("q1", Map.of('0', "q3", '1', "q3"));
        transitionTable.put("q2", Map.of('0', "q0", '1', "q3"));
    }

    @Override
    public boolean isAccepted(String input) {
        String currentState = START_STATE;

        for (char c : input.toCharArray()) {
            if (!transitionTable.containsKey(currentState) || !transitionTable.get(currentState).containsKey(c)) {
                return false; // No valid transition for current state and input symbol
            }
            currentState = transitionTable.get(currentState).get(c);
        }

        // Check if the final state is one of the accepting states
        for (String state : ACCEPTING_STATES) {
            if (currentState.equals(state)) {
                return true;
            }
        }

        return false;
    }
}