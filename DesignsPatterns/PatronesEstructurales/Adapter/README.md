# Adapter (Adaptador)

## Propósito

Convierte la interfaz de una clase existente en otra que el cliente necesita. Permite colaborar a tipos que no eran compatibles, sin cambiar el código del proveedor legado ni el cliente.

## Estructura del ejemplo

`TemperatureService` es la interfaz esperada y entrega Celsius. `LegacySensor` solo informa Fahrenheit. `SensorAdapter` envuelve el sensor y realiza la conversión, de modo que el cliente usa el servicio esperado.

## Características y uso

- Media entre interfaces incompatibles.
- Puede implementarse mediante composición (adaptador de objeto) o herencia (adaptador de clase, cuando el lenguaje lo permite).
- Úsalo al integrar bibliotecas, APIs antiguas o sistemas externos con contratos distintos.
- El adaptador debe traducir el contrato; conviene evitar que acumule lógica de negocio ajena.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
