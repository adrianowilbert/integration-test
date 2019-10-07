package FakeRestApi.Utils;

import java.util.HashMap;
import java.util.Map;

public class Builders {

    public static Map<String, Object> getAnexoActvities(Integer ID, String Title,
        String DueDate, Boolean Completed) {
        Map<String, Object> anexoActivities = new HashMap<>();
        anexoActivities.put("ID", ID);
        anexoActivities.put("Title", Title);
        anexoActivities.put("DueDate", DueDate);
        anexoActivities.put("Completed", Completed);
        return anexoActivities;
    }

}
