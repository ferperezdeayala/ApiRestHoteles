## APIREST HOTELES
## FERNANDO PEREZ DE AYALA

Se crea una base de datos para ls hoteles, esta seria la tabla con los atributos.

- id
- nombre
- puntuacion
- ubicacion
- barra
- precio


# ENDPOINTS
La raiz seria @RequestMapping("/api/hotel"), con los siguientes endpoints:

- @GetMappping("/") -> Obtiene todos los datos que hay
- @GetMappping("/id/{id}") -> Obtiene todos los datos del hotel con el id indicado
- @GetMappping("/nombre/{nombre}") -> Obtiene todos los datos del hotel con el nombre indicado
- @GetMappping("/puntuacion/{puntuacion}") -> Obtiene todos los datos de los hotel con la puntuación indicada
- @GetMappping("/ubicacion/{ubicacion}") -> Obtiene todos los datos del hotel con la ubicación indicada
- @GetMappping("/barraLibre/{barraLibreBebida}") -> Obtiene todos los datos de los hoteles que se le indique si quiere que tenga barra libre o no
- @GetMappping("/precioMedio/{precioMedio}") -> Obtiene una lista con todos los datos de los hoteles que tengan el precio medio indicado
- @GetMappping("/listaNombres") -> Devuelve una lista con todos los nombres de los hoteles
- @GetMappping("/cantidad") -> Devuelve la cantidad de hoteles que hay en la base de datos
- @GetMappping("/puntuacionMinima/{puntuacionMinima}") -> Devuelve la lista de hoteles que tengan como mínimo la puntuación indicada
- @GetMappping("/precioMaximo/{precioMax}") -> Devuelve la lista de hoteles que tengan como máximo el precio indicado
- @GetMappping("/precioMinimo/{precioMin}") -> Devuelve la lista de hoteles que tengan como mínimo el precio indicado
- @PostMapping("/post") -> Método para añadir un hotel a la lista
- @PutMapping("/{id}") -> Método para modificar los datos de un hotel, en caso de que se ponga un id que no esté en la base de datos, se creará un nuevo hotel
- @DeleteMapping("/{id}") -> Método para borrar un hotel de la lista indicando un id

