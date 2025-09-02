
import java.util.HashMap;
import java.util.Map;

public class SmartHomeLighting {
    public static void main(String[] args) {
        
        interface LightAction {
            void activate();
        }

        
        Map<String, LightAction> lightActions = new HashMap<>();

        lightActions.put("motion", () -> System.out.println("Lights ON with soft glow."));
        lightActions.put("evening", () -> System.out.println("Lights ON with warm yellow tone."));
        lightActions.put("voice:party", () -> System.out.println("Lights flashing in party mode!"));

        
        lightActions.get("motion").activate();
        lightActions.get("evening").activate();
        lightActions.get("voice:party").activate();
    }
}
