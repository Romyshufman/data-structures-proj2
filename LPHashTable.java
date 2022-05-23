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
		int result = (int) ((this.modHash.Hash(x)+i)%m);
		if (result<0)
			result+=m;
		return result;
	}
	
}
