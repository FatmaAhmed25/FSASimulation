import java.util.HashMap;
import java.util.Map;

class Problem2 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String startState = "q0";
    private static final String[] acceptingStates = {"q1"};

    static {
        transitionTable.put("q0", Map.of('0', "q2", '1', "q1"));
        transitionTable.put("q1", Map.of('0', "q3", '1', "q3"));
        transitionTable.put("q2", Map.of('0', "q0", '1', "q3"));
        transitionTable.put("q3", Map.of('0', "q3", '1', "q3"));
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