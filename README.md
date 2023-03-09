# 📽️ Projector Class in Java
## Variant: 25
This is a Java class that defines a projector and its properties, including model, resolution, lamp hours, and connected device. It also includes methods for adding an input device, disconnecting a device, and increasing the lamp hours.

## 🚀 Usage

To use this class, simply import it into your Java project and create instances of the `Projector` class.


    Projector projector1 = new Projector("Model A", "1920x1080", 500, "HDMI");
    Projector projector2 = new Projector();

You can also use the `getInstance()` method to create instances of the class:

    Projector projector3 = Projector.getInstance();
    Projector projector4 = Projector.getInstance();

The `addInputDevice(String device)` method can be used to add a new input device and overwrite the previous value. The `disconnectDevice()` method can be used to disconnect the connected device. The `increaseLampHours(int hours)` method can be used to increase the number of lamp hours by a specified number of hours.


    projector1.addInputDevice("VGA");
    projector1.disconnectDevice();
    projector1.increaseLampHours(100);

## 🎯 Static Method and Field

This class includes a public static method `getInstance()` and a static field `instance`. The `getInstance()` method returns an instance of the `Projector` class.


    Projector projector5 = Projector.getInstance(); 

## 🏗️ Constructor

This class includes a constructor that accepts all parameters and a default constructor.


    Projector projector6 = new Projector("Model B", "1280x720", 300, "USB");
    Projector projector7 = new Projector();

## 📊 Output

To output the identifiers of all objects from the array to the console, you can use a loop with a prerequisite:

    Projector[] projectors = {projector1, projector2, projector3, projector4, projector5, projector6, projector7};
    
    for (Projector p : projectors) {
        System.out.println(p.toString());
    }

## 💡 Lombok Library

This class uses the Lombok library to generate the `set` and `get` methods, constructors with arguments, and the `toString()` method.
