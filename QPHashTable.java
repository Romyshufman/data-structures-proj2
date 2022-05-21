import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash modHash;
	private int m;

	public QPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
		this.m = m;
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int) (((this.modHash.Hash(x)+Math.pow(i,2))% this.m)+m)%m;
	}
}
