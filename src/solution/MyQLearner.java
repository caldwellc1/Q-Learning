package solution;

import util.GridCell;
import util.Percept;
import util.QLearner;
import util.State;

/**
 * An agent that uses value iteration to play the game.
 * 
 * @author Cydney Caldwell
 * 
 */
public class MyQLearner extends QLearner
{
    private static final boolean DEBUG = false;
    private static final double NE = 100.0;
    private State s;
    private String a;
    private double r;

    /**
     * The constructor takes the name.
     * 
     * @param name
     *            the name of the player.
     */
    public MyQLearner(String name)
    {
        super(name);
        s = null; //previous state
        a = null; //action
        r = Double.NEGATIVE_INFINITY; //reward
    }

    @Override
    protected double explorationFunction(State state, String action)
    {
        return Double.NEGATIVE_INFINITY;
    }
    
    /**
     * Plays the game using a Q-Learning agent.
     * 
     * @param percept
     *            the percept.
     * @return the desired action.
     */
    public String play(Percept percept)
    {
    	GridCell[][] neighbor = percept.neighborhood(); //Nsa
    	GridCell stateNeighbor = percept.current(); //Q
    	double reward = percept.score();
    	double gamma = percept.gamma();
    	if(s.isTerminal()) {
    		
    	}
    	if(s != null) {
    		
    	}
    	
    	//return a;
        return "N";
    }

}
