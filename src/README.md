# 🚀 Descargas Cuánticas - Gestor de Descargas Multihilo (PSP) Edwyn Lezama Rodríguez

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


problemas de instalador en el main, colocación pregunta a chatgpt le pasé lo que imprimía en pantalla y código
/home/edwyn/.jdks/openjdk-27/bin/java -javaagent:/home/edwyn/.local/share/JetBrains/Toolbox/apps/intellij-idea/lib/idea_rt.jar=35299 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/edwyn/IdeaProjects/Descargas_cuanticas/out/production/Descargas_cuanticas GestorDescargas
Iniciando...
[Instalador] Meditación y mantras listos: instalando...
[Monitor] Descargas en curso: 4
[meditacion.mp4] 10%
[mantras.mp3] 10%
[cuarzo.png] 10%
[musica.mp3] 10%
[musica.mp3] 20%
[meditacion.mp4] 20%
[mantras.mp3] 20%
[musica.mp3] 30%
[cuarzo.png] 20%
[meditacion.mp4] 30%
[Instalador] Instalación terminada
[Monitor] Descargas en curso: 4
[musica.mp3] 40%
[meditacion.mp4] 40%
[mantras.mp3] 30%
[musica.mp3] 50%
[cuarzo.png] 30%
[meditacion.mp4] 50%
[musica.mp3] 60%
[Monitor] Descargas en curso: 4
[mantras.mp3] 40%
[musica.mp3] 70%
[meditacion.mp4] 60%
[cuarzo.png] 40%
[musica.mp3] 80%
[meditacion.mp4] 70%
[mantras.mp3] 50%
[musica.mp3] 90%
[cuarzo.png] 50%
[Monitor] Descargas en curso: 4
[meditacion.mp4] 80%
[musica.mp3] 100%
[mantras.mp3] 60%
[meditacion.mp4] 90%
[cuarzo.png] 60%
[Monitor] Descargas en curso: 3
[meditacion.mp4] 100%
[mantras.mp3] 70%
[cuarzo.png] 70%
[mantras.mp3] 80%
[Monitor] Descargas en curso: 2
[cuarzo.png] 80%
[mantras.mp3] 90%
[cuarzo.png] 90%
[Monitor] Descargas en curso: 2
[mantras.mp3] 100%
[cuarzo.png] 100%
[Monitor] Descargas en curso: 1
[Monitor] No queda ninguna descarga en curso
[Descarga-meditacion.mp4] completada en: 2220ms
[Descarga-musica.mp3] completada en: 1800ms
[Descarga-cuarzo.png] completada en: 3730ms
[Descarga-mantras.mp3] completada en: 3350ms
Tiempo real: 4005ms
El total de ms de los archivos es: 11100

Process finished with exit code 0


creo q esta mal

prompt que le pasé a chatgpt, no me dio la solución exacta ya que le tengo restringido pasarme codigo, me ha dicho que el problema ha sido de estructura
también de la mano tuve une error en la clase Instalador
if (d.getName().equals("Descarga-meditacion.mp4")) { las dos líneas del if, dentro del equals tenía mal puesto solo tenia "meditación.mp4",
eso ocasionaba que el instalador empezara antes y terminaba antes de descargarse meditación y mantras.
Para la clase monitor tuve que preguntar también como podría crear la clase que funcionara, no su estructura, si no la forma
de poner las descargar en curso, sabía que tenia que meter un bucle y más o menos tenia la estructura, ya que es similar a la clase Descarga, 
pero no sabía como recorrer cada descarga para que estuviera en curso, hasta que me dijo que podía hacerlo con una lista y me explicó los pasos con cajas
START
│
├── desc1 ────────────────┐
├── desc2 ────────────────┤
├── desc3 ────────────────┤
├── desc4 ────────────────┤
│                          │
├── Monitor                │
│                          │
└── Instalador ───────────┤
│                    │
├─ espera desc1      │
├─ espera desc4      │
│                    │
└─ instala           │
│
todas siguen independientemente

Así era las soluciones. Esta fueron las dos cosas en donde pude tener más dificultades, en el if(equals(...)) y el metodo
de la clase Monitor, no contaba con que podía hacerlo con una lista
