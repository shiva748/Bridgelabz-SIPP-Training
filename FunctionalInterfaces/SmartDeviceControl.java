
interface SmartDevice {
    void turnOn();

    void turnOff();
}

class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light turned off");
    }
}

class AC implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("AC turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("AC turned off");
    }
}

class TV implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("TV turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned off");
    }
}

public class SmartDeviceControl {
    public static void main(String[] args) {
        SmartDevice light = new Light();
        SmartDevice ac = new AC();
        SmartDevice tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        System.out.println("---");

        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}
