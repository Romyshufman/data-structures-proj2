/**name1: Romy Shufman
 id1: 209365238
 username1: romyshufman
 name2: Noa Hadash
 id2: 316279264
 username2: noahadash
 */
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected int m;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m=m;
	}

	@Override
	public HashTableElement Find(long key) {
		int result = Find_index(key);
		if (result == -1) {
			return null;
		}
		return table[result];
	}

	/**
	 *
	 * @param key - the key we want to find in the table
	 * @return the index where the key is placed, -1 if we didn't find it
	 */
	public int Find_index(long key) {
		int i=0;
		while(i<table.length){
			int index = Hash(key, i);
			if (table[index]==(null)){ //we arrived to null
				return -1;
			}
			else if (table[index].GetKey()==key) { //we found the key
				return index;
			}
			else{
				i++;
			}
		}
		return -1;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if (this.Find(hte.GetKey()) != null){ //the key is already exist
			throw new KeyAlreadyExistsException(hte);
		}
		else {
			int i = 0;
			boolean inPlace = false; //in place = true iff we inserted hte to the table
			while(i<table.length && ! inPlace){
				int index = Hash(hte.GetKey(), i);
				if (table[index] == null  || table[index].GetKey()<0) { //the place is empty- null or deleted
					table[index] = hte;
					inPlace = true;
				}
				i++;
			}
			if (i==table.length && !inPlace){
				throw new TableIsFullException(hte);
			}
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int index = Find_index(key);
		if (index == -1) { //the index doesn't exist
			throw new KeyDoesntExistException(key);
		} else {
			table[index] = new HashTableElement(-1, -1); //change index to "deleted"
		}
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
