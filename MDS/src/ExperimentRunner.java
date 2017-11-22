import java.util.*;
import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;
	final long[] data_Time_Contains;
	final long[] data_Time_Add;
	final long[] data_Time_Remove;
	public static void main (String[] args) {
		final String cs210XTeamIDForProject4 = "jemushatt"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.

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
		final int N = 10000;
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
		testForHashMapBest(mysteryDataStructures);
		testForHashMapWorst(mysteryDataStructures);

		// Write a table of numbers (for different N -- here, we are just showing one value for simplicity) showing
		// the relationship between N and the time-cost associated with searching (with the contains method) through
		// a collection of N data.
		System.out.println("N\tT (contains(o))");
		System.out.println(N + "\t" + elapsed);
	}
	public static boolean[] testStructures(Collection210X<Integer>[] mds)
	{
		return null;
	}
	public static long[] testAdd(Collection210X<Integer>[] mds)
	{
		
		
	}
	public static boolean[] testForHashMapBest(Collection210X<Integer>[] mds)
	{
		final Random random = new Random();
		final int elementToFind = random.nextInt(mds.length);
		final long[] data_Time_Contains = new long[mds.length];
		final long[] data_Time_Add = new long[mds.length];
		final long[] data_Time_Remove = new long[mds.length];
		boolean[] hashStruct = new boolean[mds.length];
		
		for(int i = 0; i<mds.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[0].contains(elementToFind);
			final long end = CPUClock.getNumTicks();
			data_Time_Contains[i] = end - start;			
		}
		
		for(int i =0; i < data_Time_Add.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[0].add(1);
			final long end = CPUClock.getNumTicks();
			data_Time_Add[i] = end - start;
		}
		for(int i =0; i < data_Time_Remove.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[0].remove(elementToFind);
			final long end = CPUClock.getNumTicks();
			data_Time_Add[i] = end - start;
		}
		
		for(int i =0; i<hashStruct.length; i++)
		{
			if(data_Time_Contains[i] < 1 && data_Time_Add[i] < 1 
					&& data_Time_Remove[i] < 1)
			{
				hashStruct[i]=true;
				System.out.println("Structure " + i + " is a potential HashMap on avg" );
			}	
			
		}
		return hashStruct;
		
	
	}
	public static boolean[] testForHashMapWorst(Collection210X<Integer>[] mds)
	{
		final Random random = new Random();
		final int elementToFind = random.nextInt(mds.length);
		final long[] data_Time_Contains = new long[mds.length];
		final long[] data_Time_Add = new long[mds.length];
		final long[] data_Time_Remove = new long[mds.length];
		boolean[] hashStruct = new boolean[mds.length];
		
		for(int i = 0; i<mds.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[i].contains(10001);
			final long end = CPUClock.getNumTicks();
			data_Time_Contains[i] = end - start;			
		}
		
		for(int i =0; i < data_Time_Add.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[i].add(10001);
			final long end = CPUClock.getNumTicks();
			data_Time_Add[i] = end - start;
		}
		for(int i =0; i < data_Time_Remove.length;i++)
		{
			final long start = CPUClock.getNumTicks();
			mds[i].remove(10000);
			final long end = CPUClock.getNumTicks();
			data_Time_Add[i] = end - start;
		}
		
		for(int i =0; i<hashStruct.length; i++)
		{
			if(data_Time_Contains[i] < mds[i].size() && data_Time_Add[i] < mds[i].size() 
					&& data_Time_Remove[i] < mds[i].size())
			{
				hashStruct[i]=true;
				System.out.println("Structure " + i + " is a potential HashMap worstcase"
						+ "\nCycle time Add 	 = " + data_Time_Add[i]
						+ "\nCycle time Contains = " + data_Time_Contains[i]
						+ "\nCycle time Remove   = " + data_Time_Remove[i]);
			}	
			
		}
		return hashStruct;
		
	
	}
}