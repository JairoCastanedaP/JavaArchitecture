# Factory Method (Método de fábrica)

## ¿En qué consiste?

Define un método de creación en una clase base y permite que las subclases decidan qué clase concreta instanciar. El código que utiliza el producto trabaja con una interfaz común y no necesita conocer la implementación específica.

## Estructura del ejemplo

- `Notification` es la interfaz del producto.
- `EmailNotification` y `SmsNotification` son productos concretos.
- `NotificationCreator` es el creador base; define `createNotification()` y una operación que utiliza el producto.
- `EmailNotificationCreator` y `SmsNotificationCreator` eligen qué producto crear.
- `Main` usa ambos creadores.

## Características

- Encapsula la decisión de qué objeto concreto crear.
- Usa polimorfismo: los creadores concretos redefinen el método de fábrica.
- Separa el código cliente de las clases concretas del producto.
- Facilita agregar otro tipo de notificación mediante un producto y un creador nuevos.

## Modo de uso

El cliente selecciona un creador concreto, por ejemplo `new EmailNotificationCreator()`, y solicita la operación `notify()`. El creador instancia el producto adecuado y lo utiliza a través de `Notification`.

## Cuándo puede servir y precauciones

Conviene cuando una clase no debe decidir directamente entre muchas implementaciones o cuando las subclases deben especializar la creación. Si solo hay una implementación estable y no se espera variación, agregar jerarquías de creadores puede ser innecesario. Factory Method no debe confundirse con una clase simple con métodos estáticos de fábrica: el GoF se apoya en la redefinición polimórfica del método por subclases.

## Ejecutar

```sh
mkdir -p out
javac -d out $(find src -name '*.java')
java -cp out co.edu.patterns.Main
```
