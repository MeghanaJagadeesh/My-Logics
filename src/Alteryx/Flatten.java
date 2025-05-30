package Alteryx;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Problem 1:
// input_map = {
//     "a": "b",
//     "c": {
//         "d": "e",
//         "f": {
//             "g": "h",
//         },
//     },
//     "i": "j"
// }

// output_map = {
//     "a": "b",
//     "c.d": "e",
//     "c.f.g": "h",
//     "i": "j"
// }
 */
public class Flatten {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "b");

		Map<String, Object> child = new HashMap<String, Object>();
		child.put("d", "e");

		Map<String, Object> subChild = new HashMap<String, Object>();
		subChild.put("g", "h");
		child.put("f", subChild);

		map.put("c", child);
		map.put("i", "j");

		Map<String, Object> outputMap = new HashMap<String, Object>();
		getResult("", map, outputMap);
		System.out.println(outputMap);
	}

	private static void getResult(String prefix, Map<String, Object> inputMap, Map<String, Object> outputMap) {
		for (Entry<String, Object> entry : inputMap.entrySet()) {
			String key = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
			Object value = entry.getValue();

			if (entry.getValue() instanceof Map) {
				Map<String, Object> nestedMap = (Map<String, Object>) value;
				getResult(key, nestedMap, outputMap);
			} else {
				outputMap.put(key, value.toString());
			}
		}
	}
}
