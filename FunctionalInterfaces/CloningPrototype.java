// Cloning Prototype Objects using Cloneable marker interface
class PrototypeObject implements Cloneable {
    private String name;
    private int value;

    public PrototypeObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PrototypeObject{name='" + name + "', value=" + value + "}";
    }

    @Override
    public PrototypeObject clone() {
        try {
            return (PrototypeObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should never happen
        }
    }
}

public class CloningPrototype {
    public static void main(String[] args) {
        PrototypeObject original = new PrototypeObject("Original", 100);
        System.out.println("Original: " + original);

        // Create a clone
        PrototypeObject clone = original.clone();
        System.out.println("Clone: " + clone);

        // Modify the clone
        clone.setName("Clone");
        clone.setValue(200);

        System.out.println("After modification:");
        System.out.println("Original: " + original);
        System.out.println("Clone: " + clone);

        // Create multiple clones
        System.out.println("\nCreating multiple clones:");
        for (int i = 1; i <= 3; i++) {
            PrototypeObject newClone = original.clone();
            newClone.setName("Clone-" + i);
            newClone.setValue(original.getValue() + i * 10);
            System.out.println("Clone " + i + ": " + newClone);
        }
    }
}
