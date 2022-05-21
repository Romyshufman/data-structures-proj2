import java.util.Random;

public class DoubleHashTable extends OAHashTable {

	private long m;
	private ModHash modHash1;
	private ModHash modHash2;


	public DoubleHashTable(int m, long p) {
		super(m);
		this.m=m;
		this.modHash1=ModHash.GetFunc(m,p);
		this.modHash2=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int result  = (int) ((modHash1.Hash(x)+i*modHash2.Hash(x))%m);
		return (int) ((result+m)%m);
	}
	
}
