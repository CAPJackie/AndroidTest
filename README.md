# Capas de la aplicación y descripción de clases

## Red

La capa de red es la encargada de realizar las peticiónes HTTP al API que se está consumiendo, tambien se encarga de cargar toda los datos de la aplicación.

### Clases asociadas:
- [Network](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/Network.java): Es la interfaz que define los metodos para extraer la información del API. Al crear esta interfaz me aseguré de que la aplicación fuera extensible ya que mas adelante se podría crear una implementacion usando otro tipo de conexión HTTP (que no sea Retrofit).
- [NetworkException](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/NetworkException.java): Maneja las Excepciones relacionadas a la capa de red.
- [NetworkService](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/NetworkService.java): Interfaz que define los metodos HTTP para consumir el API
- [RecyclerAdapter](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RecyclerAdapter.java): Se encarga de configurar el esquema del RecyclerView que contiene la lista de películas
- [RequestCallback](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RequestCallback.java): Interfaz utilizada para implementarla cuando se quieran hacer Callbacks luego de extraer información del API.
- [RetrofitNetwork](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RetrofitNetwork.java): En su implementación crea una conexión de Retrofit y realiza peticiones HTTP para consumir el API, estas llamadas se realizan desde el background para que no afecte al UI Thread.
- [VideoAdapter](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/VideoAdapter.java): Realiza la configuracion para la lista de videos (trailers) de cada una de las peliculas y series.

## Persistencia
Almacena la información que se utiliza en las capas de la aplicación para evitar la repetición de calculos y de esta manera optimizar la extracción de la información estática.

### Clases asociadas:
- [LocalStorage](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/persistence/LocalStorage.java): Contiene información estática utilizada en la aplicación (urls y api keys), su uso es muy similar al archivo de strings.xml generado por android. 

## Vistas
Esta capa se encarga de configurar todos los datos relacionados con cada una de los layouts creados.

### Clases asociadas:
- [LoadingDataActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/LoadingDataActivity.java): Carga los datos de cada una de las categorias de las peliculas, ya sea de los datos almacenados en Cache, o haciendo llamadas sincronas a los datos del API, mientras que se carga esta información se ejecuta una animación de pantalla de carga.
- [ProgramsActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/ProgramsActivity.java): Muestra las categorias de las peliculas y el buscador con su respectivo handler para cargar los datos de las peliculas que coincidan con la busqueda.
- [LoadingDetailsActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/LoadingDetailsActivity.java): Se carga cuando se selecciona alguna película del RecyclerView. Esta actividad corre una animación mientras carga la información especifica de la pelicula seleccionada (detalles y videos) almacenadas en cache, o consumiendolos del API.
- [DetailActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/DetailActivity.java): Actividad que muestra los detalles de la pelicula seleccionada previamente. 
- [DetailsFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/DetailsFragment.java): Fragmento que se carga en el PageView de la actividad del detalle de la pelicula para brindar información adicional de la pelicula seleccionada.
- [VideosFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/VideosFragment.java): Fragmento cargado en el otro TabLayout del PageView de la actividad del detalle de la pelicula que contiene la lista de los trailers y videos de la película seleccionada.
- [ListFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/ListFragment.java): Fragmento encargado de cargar las listas de peliculas que se pueden contemplar en cada una de las categorias de peliculas en la actividad ProgramsActivity.
- [ProgramsTabFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/ProgramsTabFragment.java): Fragmento de Pageview con dos tabs (Peliculas y Series de televisión).

## Modelo
Contiene toda la información de la lógica de la aplicación.

### Clases asociadas:
- [Company](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Company.java): POJO que representa la empresa de produccion de peliculas y de programas de televisión.
- [Country](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Country.java): POJO que representa la información básica de un país.
- [Episode](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Episode.java): POJO que representa la información relacionada a un episodio de una serie de televisión.
- [Genre](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Genre.java): POJO que representa un genero de película o serie.
- [Language](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Language.java): POJO que representa un lenguaje.
- [Movie](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Movie.java): POJO que representa una pelicula.
- [MovieCollection](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/MovieCollection.java): POJO que representa la colección a la que pertenecen varias peliculas del mismo universo.
- [MovieSearch](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/MovieSearch.java): POJO que representa los resultados arrojados por una busqueda de peliculas en el API
- [Network](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Network.java): POJO que representa una cadena de television o de peliculas.
- [Productor](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Productor.java): POJO que representa a un productor de peliculas o de series.
- [Program](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Program.java): POJO que representa un programa (ya sea película o serie de televisión).
- [Search](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Search.java): POJO que representa los resultados arrojados por una busqueda en el API
- [Season](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Season.java): POJO que representa una temporada de una serie de televisión.
- [TvSearch](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/TvSearch.java): POJO que representa los resultados arrojados por una busqueda de series de television en el API
- [TvShow](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/TvShow.java): POJO que representa una serie de televisión.
- [Video](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Video.java): POJO que representa un video


# Principio de responsabilidad Única
Es una buena practica dentro del desarrollo de Software, se refiere a que cada una de las clases o funciones tienen su propia responsabilidad dentro de la construccion del Software, tambien se interpreta como que cada una de las entidades solamente deben conocer y cumplir su responsabilidad asignada.


# Características de un "buen" código o código limpio.
- No se realizan recalculos de operaciones dentro del mismo.
- El nombre de las variables es legíble por otros humanos y tienen un significado (Camel Case)
- Se cumple el principio de responsabilidad única.
- Se abstrae la información para modelar un esquema mas robusto que soporte la extensibilidad del Software.
- Se manejan de manera adecuada las excepciones del módelo y los controladores del Software.
- Las funciones son modulares para facilitar el entendimiento de otros y evitar el llamado "Spaggeti code"
