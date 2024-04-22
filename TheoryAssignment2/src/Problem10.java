import java.util.HashMap;
import java.util.Map;

class Problem10 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String startState = "A";
    private static final String[] acceptingStates = {"AC","BC","ABC"};

    static {
        // Define transition table
        transitionTable.put("A", Map.of('0', "B", '1', "AC"));
        transitionTable.put("B", Map.of('0', "D", '1', "BC"));
        transitionTable.put("D", Map.of('0', "D", '1', "D"));
        transitionTable.put("AC", Map.of('0', "B", '1', "ABC"));
        transitionTable.put("BC", Map.of('0', "B", '1', "BC"));
        transitionTable.put("ABC", Map.of('0', "B", '1', "ABC"));
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