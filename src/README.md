# Documentación y pruebas

| Ejecución | Descarga más lenta | Tiempo real (ms) | Suma (ms) |
| :---: | :---: | :---: | :---: |
| 1 | meditacion.mp4 | 4674 | 15860 |
| 2 | cuarzo.png | 3693 | 9250 |
| 3 | musica.mp3 | 4599 | 12590 |
El tiempo real es siempre el apróximado de la descarga mas lenta entres todas las descargas.
Esto se debe a que ambas ejecutan sus hilos de forma concurrente,
mientras que la suma total representa el total de ms que habría tardado si se ejecutarán una después de la otra
En mi programa en el main "GestorDescargas" no hice bucle, pero igualmente lo hice en el mismo try por orden de
ejecución
Lo que pude comprobar es que cada descarga e completa primero una tras de otra, es decir, que cuarzo primero llega al
100% y luego empieza la otra descarga en consola. Otra cosa a recalcar es que el tiempo real y el tiempo total,
es decir, la suma es practicamente idéntica, en mi caso ha dado un Tiempo real de: 7051ms y la suma de: 7030,
esto se debe a que hemos roto la concurrencia.