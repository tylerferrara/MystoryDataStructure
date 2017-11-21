import java.util.*;
import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;

	public static void main (String[] args) {
		final String cs210XTeamIDForProject4 = "YOUR_LOGIN_ID"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.

		// Fetch the collections whose type you must deduce.
		// Note -- you are free to change the type parameter from Integer to whatever you want. In this
		// case, make sure to replace (over the next 4 lines of code) Integer with whatever class you prefer.
		// In addition, you'll need to pass the method getMysteryDataStructure a "sample" (an instance) of 
		// the class you want the collection to store.
		@SuppressWarnings("unchecked")
		final Collection210X<Integer>[] mysteryDataStructures = (Collection210X<Integer>[]) new Collection210X[NUM_DATA_STRUCTURES_TO_DEDUCE];
		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			mysteryDataStructures[i] = MysteryDataStructure.getMysteryDataStructure(cs210XTeamIDForProject4.hashCode(), i, new Integer(0));
		}

		// Write your code here...
		final Random random = new Random();  // instantiate a random number generator
		final int N = 100000;
		for (int i = 0; i < N; i++) {  // populate the mystery data structure with 100 numbers
			mysteryDataStructures[0].add(new Integer(i));
		}
		final int elementToFind = random.nextInt(N); 

		// This is an example of measuring an operation's time cost *without* averaging -- the times will vary wildly!		
		// You really should average...
		
		final long start = CPUClock.getNumTicks();
		// Time how long it takes to find a single, randomly chosen item stored in the mystery data structure
		final boolean result = mysteryDataStructures[0].contains(elementToFind);
		final long end = CPUClock.getNumTicks();
		final long elapsed = (end - start);
		testForHashMap(mysteryDataStructures);

		// Write a table of numbers (for different N -- here, we are just showing one value for simplicity) showing
		// the relationship between N and the time-cost associated with searching (with the contains method) through
		// a collection of N data.
		System.out.println("N\tT (contains(o))");
		System.out.println(N + "\t" + elapsed);
	}
	public static boolean[] testForHashMap(Collection210X<Integer>[] mds)
	{
		final Random random = new Random();
		final int elementToFind = random.nextInt(mds.length);
		final long[] dataTimes = new long[mds.length];
		boolean[] hashStruct = new boolean[mds.length];
		for(int i = 0; i<mds.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[0].contains(elementToFind);
			final long end = CPUClock.getNumTicks();
			dataTimes[i] = end - start;			
		}
		for(int i =0; i<hashStruct.length; i++)
		{
			if(dataTimes[i] < mds[i].size())
			{
				hashStruct[i]=true;
			}
		}
		for(int i =0; i <hashStruct.length;i++)
		{
			if(hashStruct[i])
			{
				System.out.println(i +": Potential HashMap");
			}
		}
		return hashStruct;
		
	}
}