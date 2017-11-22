import com.cs210x.Collection210X;

public class StructureTester {
	private final long[] data_Time_Contains;
	private final long[] data_Time_Add;
	private final long[] data_Time_Remove;
	private Collection210X<Integer>[] mds;
	public StructureTester(Collection210X<Integer>[] mds, int testSize)
	{
		this.mds = mds;
		data_Time_Contains = new long[testSize];
		data_Time_Add = new long[testSize];
		data_Time_Remove = new long[testSize];	
	}
	
	public long[] testHashAverage()
	{
		
		return null;
	}
}
