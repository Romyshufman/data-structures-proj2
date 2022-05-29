import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash modHash;

	public QPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @return h(k,i)=(h'(k)+i^2 )  mod m
	 */
	
	@Override
	public int Hash(long x, int i) {
		int result= (int) ((this.modHash.Hash(x)+Math.pow(i,2))%m);
		if (result<0) //this line makes sure result>=0
			result+=m;
		return result;
	}
}
