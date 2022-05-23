import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int result;
		if (i%2 == 0){
			result= (int) (this.modHash.Hash(x)+Math.pow(i,2))%m;
		}
		else {
			result = (int) (this.modHash.Hash(x) - Math.pow(i, 2)) % m;

			if (result < 0)
				result += m;
		}
		return result;
	}
}
