import java.util.Random;

import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

public class StructureTester {
	private final long[] data_Time_Contains;
	private final long[] data_Time_Add;
	private final long[] data_Time_Remove;
	private Collection210X<Integer>[] mds;
	private final int testSize;
	private Random random = new Random();
	public StructureTester(Collection210X<Integer>[] mds, int testSize)
	{
		this.mds = mds;
		this.testSize = testSize;
		data_Time_Contains = new long[this.testSize];
		data_Time_Add = new long[this.testSize];
		data_Time_Remove = new long[this.testSize];	
		this.init();
	}
	
	private void init()
	{
		for(int i =0; i< this.testSize;i++)
		{
			mds[i].add(random.nextInt(testSize));
		}
	}
	public void testHashAverage()
	{
		//test add method time
		for(int i=0; i<this.testSize;i++)
		{
			long start = CPUClock.getNumTicks();
			this.mds[i].add(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Add[i] = start - end;
			
		}
		//test contains method
		for(int i=0; i<this.testSize;i++)
		{
			long start = CPUClock.getNumTicks();
			this.mds[i].add(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Contains[i] = start - end;
			
		}
		//test remove method
		for(int i=0; i<this.testSize;i++)
		{
			long start = CPUClock.getNumTicks();
			this.mds[i].add(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Remove[i] = start - end;
			
		}
	}
	
	public long averageAdd()
	{
		this.testHashAverage();
		long result=0;
		for(int i=0; i<this.testSize;i++)
		{
			result+= this.data_Time_Add[i];
		}
		return result/this.testSize;
		
	}
	public long[] testHashWorst()
	{
		
		
		
		return null;
	}
}
