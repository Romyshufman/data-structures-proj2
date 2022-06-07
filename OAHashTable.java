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
		boolean isInserted=false; //True iff key was inserted during the function
		for(int i=0; i<m ;i++){
			int index = this.Hash(hte.GetKey(), i);

			if (table[index]==null) { //key doesnt exists
				table[index] = hte;
				isInserted=true;
				break;
			}
			else if(table[index].GetKey()<0) { //index is deleted
				if (this.Find(hte.GetKey()) != null) { //key already exists
					throw new KeyAlreadyExistsException(hte);
				}
				else { //key doesnt exists
					table[index] = hte;
					isInserted=true;
					break;
				}
			}
			else if (table[index].GetKey()==hte.GetKey()){ //table[index] == hte
				throw new KeyAlreadyExistsException(hte);
			}
		}
		if(isInserted==false) { //we moved on all the table and didnt inserted hte
			throw new TableIsFullException(hte);
		}
	}

	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		int index = Find_index(key);
		if (index == -1) { //the index  doesn't exist
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
