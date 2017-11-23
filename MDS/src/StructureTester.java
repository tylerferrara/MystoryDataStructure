import java.util.Random;

import com.cs210x.CPUClock;
import com.cs210x.Collection210X;

public class StructureTester {
	private final long[] data_Time_Contains;
	private final long[] data_Time_Add;
	private final long[] data_Time_Remove;
	private long data_Time_Contains_Average;
	private long data_Time_Add_Average;
	private long data_Time_Remove_Average;
	private Collection210X<Integer> mds;
	private final int testSize;
	private Random random = new Random();
	/**
	 * Build tester
	 * Create a test for a single data structure
	 * Can run add, contains, and remove on the structure to determine time complexity
	 * @param mds list of data structures
	 * @param testSize size of data to test on
	 */
	public StructureTester(Collection210X<Integer> mds, int testSize)
	{
		this.mds = mds;
		this.testSize = testSize;
		
		this.data_Time_Contains = new long[this.testSize];
		this.data_Time_Add = new long[this.testSize];
		this.data_Time_Remove = new long[this.testSize];	
		
		this.init();
		this.testStrctureTimes();
	}
	
	/**
	 * Initialize the data with random numbers
	 */
	private void init() {
		for(int j = 0; j < this.testSize;j++) {
				mds.add(random.nextInt(testSize));
			}
	}
			
	/** 
	 * Test the average cpu cycle on contain add and remove
	 */
	private void testAdd() {
		for(int j = 0; j<this.testSize;j++) {
			long start = CPUClock.getNumTicks();
			this.mds.add(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Add[j] = end - start;
		}
		init();
	}
	
	private void testContains() {
		for(int j = 0; j<this.testSize;j++) {
			long start = CPUClock.getNumTicks();
			this.mds.contains(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Contains[j] = end - start;
		}
		init();
	}
	
	private void testRemove() {
		for(int j = 0; j<this.testSize;j++) {
			long start = CPUClock.getNumTicks();
			this.mds.remove(random.nextInt(testSize));
			long end = CPUClock.getNumTicks();
			data_Time_Remove[j] = end - start;
			init();
		}
	}
	
	private void testStrctureTimes() {
		//test add method time
		averageAdd();
		//test contains method
		//testContains();
		//test remove method
		//testRemove();	
	}
	
	//------TODO------
	//AVERAGE AFTER MULTIPLE TIMES (e.g. 5 times)
	public long averageAdd() {
		long times = 5;
		long result = 0;
		for(int i = 0; i < times; i++) {
			for(int j=0; j < this.testSize; j++) {
				result += this.data_Time_Add[j];
			}
			testAdd();
		}
		return result/times;
	}
	
	//------TODO------
		//AVERAGE AFTER MULTIPLE TIMES (e.g. 5 times)
	public long averageContains() {
		long times = 5;
		long result = 0;
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < this.testSize; j++) {
				result += this.data_Time_Contains[j];
			}
			testContains();
		}
		return result/times;
	}
		//------TODO------
		//AVERAGE AFTER MULTIPLE TIMES (e.g. 5 times)
	public long averageRemove() {
		long times = 5;
		long result = 0;
		for(int i = 0; i < times; i++) {
			for(int j = 0; j < this.testSize; j++) {
				result+= this.data_Time_Remove[j];
			}
		}
		return result/times;
	}
	
	public long[] testHashWorst() {

		return null;
	}
}
