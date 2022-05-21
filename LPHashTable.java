import java.util.Random;

public class LPHashTable extends OAHashTable {

	private long m;
	private ModHash modHash;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.m=m;
		this.modHash=ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int) ((this.modHash.Hash(x)+i)%m);
	}
	
}
