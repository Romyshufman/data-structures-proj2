import java.util.Random;

public class LPHashTable extends OAHashTable {

	private ModHash modHash;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.modHash=ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @return h(k,i)=(h'(k)+i) mod m
	 */

	@Override
	public int Hash(long x, int i) {
		int result = (int) ((this.modHash.Hash(x)+i)%m);
		if (result<0) //this line makes sure result>=0
			result+=m;
		return result;
	}
	
}
