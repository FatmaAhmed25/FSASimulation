import java.util.HashMap;
import java.util.Map;

class Problem1 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String startState = "q0";
    private static final String[] acceptingStates = {"q0","q1"};

    static {
        transitionTable.put("q0", Map.of('a', "q0", 'b', "q1"));
        transitionTable.put("q1", Map.of('a', "q2", 'b', "q1"));
        transitionTable.put("q2", Map.of('a', "q2", 'b', "q2"));
    }

    @Override
    public boolean isAccepted(String input) {
        String currentState = startState;

        for (char c : input.toCharArray()) {
            if (!transitionTable.containsKey(currentState) || !transitionTable.get(currentState).containsKey(c)) {
                return false;
            }
            currentState = transitionTable.get(currentState).get(c);
        }

        for (String state : acceptingStates) {
            if (currentState.equals(state)) {
                return true;
            }
        }

        return false;
    }
}