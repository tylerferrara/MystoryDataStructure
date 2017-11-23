import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.Callable;

import com.cs210x.*;

/**
  * Class to deduce the identity of mystery data structures.
  */
public class ExperimentRunner {
	private static final int NUM_DATA_STRUCTURES_TO_DEDUCE = 5;
	private static final int[] Ns = { 1, 2, 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
	private static StructureTester[] testers;
	
	public static void main (String[] args) throws FileNotFoundException {
		
		for(int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			createFile(i, "add");
			createFile(i, "remove");
			createFile(i, "contains");
		}

	}
	
	private static void createFile(int index, String command) throws FileNotFoundException {
		
		final String cs210XTeamIDForProject4 = "jemushatt"; // TODO CHANGE THIS TO THE TEAM ID YOU USE TO SUBMIT YOUR PROJECT3 ON INSTRUCT-ASSIST.

		@SuppressWarnings("unchecked")
		final Collection210X<Integer>[] mysteryDataStructures = (Collection210X<Integer>[]) new Collection210X[NUM_DATA_STRUCTURES_TO_DEDUCE];
		for (int i = 0; i < NUM_DATA_STRUCTURES_TO_DEDUCE; i++) {
			mysteryDataStructures[i] = MysteryDataStructure.getMysteryDataStructure(cs210XTeamIDForProject4.hashCode(), i, new Integer(0));
		}
		
		StructureTester[] structCollection = new StructureTester[Ns.length];
 
		for(int i = 0; i < Ns.length; i++) {
			structCollection[i] = new StructureTester(mysteryDataStructures[index], Ns[i]);
		}
		testers = structCollection;
		
		PrintWriter pw = new PrintWriter(new File(command + ".csv"));
        StringBuilder sb = new StringBuilder();
        
        for(int n: Ns) {
        		sb.append(',');
        		sb.append(n);
        }
        sb.append('\n');
		sb.append("T(o)");
        for(StructureTester struct: testers) {
    			sb.append(',');
    			// I would prefer to pass a function as a parameter to avoid going into 
    			// a switch statement each loop, but Java does not offer this.
    			switch (command) {
                case "add": sb.append(struct.averageAdd());
         						break;
                case "remove": sb.append(struct.averageRemove());
         						break;
                case "contains": sb.append(struct.averageContains());
         						break;		
    			}
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("Finished " + command + " for index " + index);
	}
	
	/*public static boolean[] testForHashMapBest(Collection210X<Integer>[] mds)
	{
		final Random random = new Random();
		final int elementToFind = random.nextInt(mds.length);
		data_Time_Contains = new long[mds.length];
		data_Time_Add = new long[mds.length];
		data_Time_Remove = new long[mds.length];
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
		
	
	}*/
}