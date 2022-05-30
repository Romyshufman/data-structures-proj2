/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */


public class AQPHashTable extends OAHashTable {
	private ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @return h(k,i)=(h'(k)+(-1)^i⋅i^2) mod m
	 */

	@Override
	public int Hash(long x, int i) {
		int result;
		if (i%2 == 0){ //if (-1)^i==1
			result= (int) (this.modHash.Hash(x)+Math.pow(i,2))%m;
		}
		else { //if (-1)^i==-1
			result = (int) (this.modHash.Hash(x) - Math.pow(i, 2)) % m;

			if (result < 0) //this line makes sure result>=0
				result += m;
		}
		return result;
	}
}
