package geometrydash;

import java.util.HashSet;
import java.util.Set;

public class GeometryDash {
    /**
     * Returns whether the given level can be completed using the given play.
     * @param level is not null and not empty
     * @param play is not null and not empty
     * @return true if the play completes the level and false otherwise
     */
    public static boolean isSuccessfulPlay(String level, String play) {
        int position = 0;
        boolean success = true;
        for (char c : play.toCharArray()) {
            if (c == '1') {
                position++;
            } else if (c == '2') {
                position += 2;
            } else if (c == '3') {
                position += 3;
            }
            if (level.toCharArray()[position] == '^') {
                success = false;
            }
        }
        if (position != level.length() - 1) {
            success = false;
        }
        return success;
    }

    /**
     * Returns the subset of plays which can complete the given level ending
     * with the target resting energy
     * @param level is not null and not empty
     * @param possiblePlays is not null
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return a subset of {@code possiblePlays} which complete the level with
     * {@code targetRestingEnergy} units of energy remaining
     */
    public static Set<String> successfulPlays(String level, Set<String> possiblePlays,
                                              int startingEnergy, int targetRestingEnergy) {
        Set<String> successfulPlays = new HashSet<>();
        for (String play : possiblePlays) {
            boolean success = true;
            int position = 0;
            int energy = startingEnergy;
            for (char c : play.toCharArray()) {
                if (c == '0' && energy < 3) {
                    energy++;
                } else if (c == '1') {
                    position++;
                    energy -= 1;
                } else if (c == '2') {
                    position += 2;
                    energy -= 2;
                } else if (c == '3') {
                    position += 3;
                    energy -= 3;
                }
                if (position > level.length() - 1) {
                    success = false;
                    break;
                }
                if (level.toCharArray()[position] == '^') {
                    success = false;
                    break;
                } else if (level.toCharArray()[position] == '*') {
                    position += 4;
                }
            }
            if (success && energy >= targetRestingEnergy && position == level.length() - 1) {
                successfulPlays.add(play);
            }
        }
        return successfulPlays;
    }

    /**
     * Returns the shortest play that completes the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the shortest play that allows a player to complete the given level
     * @throws UnplayableLevelException if no play can complete the level
     */
    public static String shortestPlay(String level, int startingEnergy, int targetRestingEnergy)
            throws UnplayableLevelException {
        // TODO: Implement this method
        return null;
    }

    /**
     * Returns the total number of plays which allow a player to complete the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the total number of plays which allow a player to complete the given level
     * with target resting energy {@code targetRestingEnergy}
     */
    public static int numberOfPlays(String level, int startingEnergy, int targetRestingEnergy) {
        // TODO: Implement this method
        return -1;
    }
}
