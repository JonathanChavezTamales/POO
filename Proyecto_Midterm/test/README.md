## Instrucciones de uso del test

El script `crear_archivo.py` permite crear un archivo con operaciones en formato Numerote, el actual genera 30,000 operaciones.
Además nos creará otro archivo con sus respuestas.

Para usarlo se ejecuta con el nombre del archivo donde queremos nuestras operaciones
 `python crear_archivo.py operaciones.txt`.

Este script nos va a crear dos archivos, `operaciones.txt` que tiene las operaciones y `operaciones-resultado.txt` que tiene los resultados.

El archivo `operaciones.txt` lo metemos a nuestro programa numerote, que después nos arrojará un archivo con los resultados, por ejemplo: `resultados.txt`

Ahora con el programa `comparar_resultados.py` podemos pasarle como argumentos de linea de comando los resultados de python y los de nuestro programa Numerote de java.

`python comparar_resultados.py operaciones-resultado.txt resultados.txt`

Al ejecutar tendremos un reporte con la precisión de nuestras funciones, y un archivo con cada operación; si es 1 fue correcto, 0 incorrecto.
 


Para crear un archivo con operaciones 
