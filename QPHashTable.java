/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */
public class QPHashTable extends OAHashTable {
	private ModHash modHash;

	public QPHashTable(int m, long p) {
		super(m);
		this.modHash = ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @return h(k,i)=(h'(k)+i^2) mod m
	 */

	@Override
	public int Hash(long x, int i) {
		long result= (long)(this.modHash.Hash(x)+(i*i))%m;
		return (int) (result < 0 ? result+m : result); //makes sure result>=0



	}


}
