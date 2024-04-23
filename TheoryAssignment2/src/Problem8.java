import java.util.HashMap;
import java.util.Map;

class Problem8 extends DFASimulation {
    private static final Map<String, Map<Character, String>> transitionTable = new HashMap<>();
    private static final String startState = "q1";
    private static final String[] acceptingStates = {"q1q2q4", "q1q4q5", "q1q3q4q5", "q1q2q4q6"};

    static {
        transitionTable.put("q1", Map.of('0', "q1q2", '1', "q1q5"));
        transitionTable.put("q1q2", Map.of('0', "q1q2q4", '1', "q1q3q5"));
        transitionTable.put("q1q2q4", Map.of('0', "q1q2q4", '1', "q1q3q4q5"));
        transitionTable.put("q1q5", Map.of('0', "q1q2q6", '1', "q1q5"));
        transitionTable.put("q1q3q5", Map.of('0', "q1q2q4q6", '1', "q1q5"));
        transitionTable.put("q1q4q5", Map.of('0', "q1q2q4q6", '1', "q1q4q5"));
        transitionTable.put("q1q3q4q5", Map.of('0', "q1q2q4q6", '1', "q1q4q5"));
        transitionTable.put("q1q2q6", Map.of('0', "q1q2", '1', "q1q3q4q5"));
        transitionTable.put("q1q2q4q6", Map.of('0', "q1q2q4", '1', "q1q3q4q5"));
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
