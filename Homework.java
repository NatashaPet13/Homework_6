import java.util.HashMap;

public class Homework {

    public static void main(final String[] args) {
        var dict = new HashMap<String, String>();
        dict.put("88001122333", "Иван Иванов");
        dict.put("88001662333", "Иван Петухов");
        dict.put("88001112333", "Иван Петухов");
        dict.put("88001122432", "Владлен Безымянный");
        dict.put("88001112453", "Петр Куличкин");
        dict.put("88001632145", "Петр Куличкин");
        dict.put("88001424214", "Петр Петухов");
        dict.put("88001424215", "Петр Петухов");
        dict.put("88001424216", "Петр Петухов");
        dict.put("88001234374", "Владлен Безымянный");

        var a = get(dict);

        a.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }


    public static HashMap<String, Integer> get(HashMap<String, String> dict){
        var result = new HashMap<String, Integer>();
        for (var item : dict.entrySet()) {
            if (result.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = result.get(item.getValue());
                result.replace(key, value + 1);
            } else {
                result.put(item.getValue(), 1);
            }
        }
        return result;
    }
}
