import java.util.HashMap;
import java.util.Map;

class Problem4 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String START_STATE = "q0";
    private static final String[] ACCEPTING_STATES = {"q0","q1","q2"};

    static {
        transitionTable.put("q0", Map.of('a', "q1", 'b', "q2"));
        transitionTable.put("q1", Map.of('a', "q1", 'b', "q3"));
        transitionTable.put("q2", Map.of('a', "q4", 'b', "q2"));
        transitionTable.put("q3", Map.of('a', "q1", 'b', "q3"));
        transitionTable.put("q4", Map.of('a', "q4", 'b', "q2"));

    }

    @Override
    public boolean isAccepted(String input) {
        String currentState = START_STATE;

        for (char c : input.toCharArray()) {
            if (!transitionTable.containsKey(currentState) || !transitionTable.get(currentState).containsKey(c)) {
                return false;
            }
            currentState = transitionTable.get(currentState).get(c);
        }

        for (String state : ACCEPTING_STATES) {
            if (currentState.equals(state)) {
                return true;
            }
        }

        return false;
    }
}