# Strategy (Estrategia)

## Propósito

Define una familia de algoritmos intercambiables y permite seleccionar uno en tiempo de ejecución. El contexto delega el trabajo en la estrategia elegida.

## Estructura del ejemplo

`PaymentStrategy` es el contrato; `CardPayment` y `WalletPayment` son algoritmos concretos. `Checkout` usa la estrategia actual y permite reemplazarla sin cambiar el proceso de compra.

## Características y uso

- Sustituye condicionales por implementaciones polimórficas.
- Facilita probar algoritmos por separado.
- Úsalo cuando existan variantes de una política o algoritmo.
- El cliente debe elegir una estrategia; evita crear muchas variantes sin necesidad real.

## Ejecución

Desde esta carpeta: `mkdir -p out && javac -d out $(find src -name '*.java') && java -cp out co.edu.patterns.Main`.
