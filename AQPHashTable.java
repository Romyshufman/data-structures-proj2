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
		long result= (long) ((modHash.Hash(x) + (i % 2 == 0 ? 1 : -1) * Math.pow(i,2)) % m); //check if (-1)^i==1 or -1
		return (int) (result < 0 ? result+m : result); //makes sure result>=0


	}
}
