import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash modHash;

	public QPHashTable(int m, long p) {
		super(m);  //build m size hash table
		this.modHash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {  //hash(x,i) = (modhash(x) + i^2) mod m
		int result= (int) ((this.modHash.Hash(x)+Math.pow(i,2))%m);
		if (result<0) //this line makes sure that result >= 0
			result+=m;
		return result;
	}
}
