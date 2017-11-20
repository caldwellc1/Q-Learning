package solution;

import util.Percept;
import util.QLearner;
import util.State;
import java.util.List;

/**
 * An agent that uses value iteration to play the game.
 * 
 * @author Cydney Caldwell
 * 
 */
public class MyQLearner extends QLearner
{
    //private static final boolean DEBUG = false;
    //private static final double NE = 100.0;
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
        a = null; //previous action
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
    	MyState statePrime = new MyState(percept);
    	double gamma = percept.gamma();
    	double rewardPrime = percept.current().reward();
    	List<String> actions = percept.actions();
    	
    	if(statePrime.isTerminal()) {
    		putValue(getQ(), statePrime, a, rewardPrime);
    	}
    	if(s != null) {
    		addValue(getN(), s, a, 1);
    		double sa = value(getQ(), s, a);
    		double alpha = 1/value(getN(), s, a);
    		double max = maxValue(statePrime, actions);
    		double newQ = sa + alpha * (r + gamma * max - sa);
    		putValue(getQ(), s, a, newQ);
    	}
        if(statePrime.isTerminal()) {
    		s = null;
    		a = null;
    		r = Double.NEGATIVE_INFINITY;
    	}else {
    		s = statePrime;
            a = maxExplorationAction(statePrime, actions);
            r = rewardPrime;
    	}
    	return a;
    }

}
