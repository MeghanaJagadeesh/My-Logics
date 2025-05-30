package google;

import java.util.List;
import java.util.Map;

/*
 * Assume we a file system which contains two kind of entity that is file or a directiory, if it is a directory  
 * it contains list od children's id , and if it is a file it contains a size
 * 
 * ex 
 * root (id=1)
 * 		dir (id=2)
 * 			filel (id=4): 1000mb
 * 			File2 (id=5): 200mb
 * 			file3 (id=3): 300mb
 * 		file(id=6): 300mb


Filrsystem looks like this 
Filesystem =
{1: { type: 'directory', name:
2: { type: directory, name:
4: { type: 'file', name: "file"
5: { type: 'file', name:
3: { type: 'file', name: fil

find a entity size 
	int getEntitySize(int entityId, Map<Integer, Entity> filesystem) 
 *
 */

//given class
class Entity {
	int entityId;
	String type;
	String name;
	int size;
	List<Integer> childrenEntityIds;
}

public class TreeRound1 {
	// first level of coding
	int getEntitySize(int entityId, Map<Integer, Entity> filesystem) {
		Entity entity = filesystem.get(entityId);
		if (entity.type.equals("file")) {
			return entity.size;
		}
		int totalSize = 0;
		for (int childid : entity.childrenEntityIds) {
			totalSize += getEntitySize(childid, filesystem);
		}
		return totalSize;
	}

	// question: if we get the multiple request to fetch the size what u will do
	// instead of running and returning the same response
	// answer: we can create a global variable map which stores both id and size of
	// the entity

	Map<Integer, Integer> size;

	int getEntitySizeOpt(int entityId, Map<Integer, Entity> filesystem) {
		if (size.containsKey(entityId)) { // chechong if it exists
			return size.get(entityId);
		}
		Entity entity = filesystem.get(entityId);
		if (entity.type.equals("file")) {
			return entity.size;
		}
		int totalSize = 0;
		for (int childid : entity.childrenEntityIds) {
			totalSize += getEntitySize(childid, filesystem);
		}
		size.put(entityId, totalSize);
		return totalSize;
	}

	// SP = O(n) as we created the call stack
	// Tc=O(n)
	// it belongs to which DS? : Tree

}
