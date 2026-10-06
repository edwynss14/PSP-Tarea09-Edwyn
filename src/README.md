# Documentación y pruebas

| Ejecución | Descarga más lenta | Tiempo real (ms) | Suma (ms) |
| :---: | :---: | :---: | :---: |
| 1 | meditacion.mp4 | 4674 | 15860 |
| 2 | cuarzo.png | 3693 | 9250 |
| 3 | musica.mp3 | 4599 | 12590 |
El tiempo real es siempre el apróximado de la descarga mas lenta entres todas las descargas.
Esto se debe a que ambas ejecutan sus hilos de forma concurrente,
mientras que la suma total representa el total de ms que habría tardado si se ejecutarán una después de la otra
