/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */
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
		long result = (this.modHash.Hash(x)+i)%m;
		if (result<0) //this line makes sure result>=0
			result+=m;
		return (int)result;
	}
	
}
