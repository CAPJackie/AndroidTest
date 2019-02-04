# Preguntas

## Capas de la aplicación

### Red

La capa de red es la encargada de realizar las peticiónes HTTP al API que se está consumiendo, tambien se encarga de cargar toda los datos de la aplicación.

#### Clases asociadas:
- [Network](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/Network.java)
- [NetworkException](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/NetworkException.java)
- [NetworkService](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/NetworkService.java)
- [RecyclerAdapter](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RecyclerAdapter.java)
- [RequestCallback](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RequestCallback.java)
- [RetrofitNetwork](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/RetrofitNetwork.java)
- [VideoAdapter](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/network/VideoAdapter.java)

### Persistencia
Almacena la información que se utiliza en las capas de la aplicación para evitar la repetición de calculos y de esta manera optimizar la extracción de la información estática.

#### Clases asociadas:
- [LocalStorage](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/persistence/LocalStorage.java)

### Vistas
Esta capa se encarga de configurar todos los datos relacionados con cada una de los layouts creados.

#### Clases asociadas:
- [DetailActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/DetailActivity.java)
- [LoadingDataActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/LoadingDataActivity.java)
- [LoadingDetailsActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/LoadingDetailsActivity.java)
- [ProgramsActivity](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/ui/ProgramsActivity.java)
- [DetailsFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/DetailsFragment.java)
- [ListFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/ListFragment.java)
- [ProgramsTabFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/ProgramsTabFragment.java)
- [VideosFragment](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/fragments/VideosFragment.java)

### Modelo
Contiene toda la información de la lógica de la aplicación.

#### Clases asociadas:
- [Company](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Company.java)
- [Country](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Country.java)
- [Episode](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Episode.java)
- [Genre](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Genre.java)
- [Language](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Language.java)
- [Movie](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Movie.java)
- [MovieCollection](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/MovieCollection.java)
- [MovieSearch](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/MovieSearch.java)
- [Network](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Network.java)
- [Productor](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Productor.java)
- [Program](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Program.java)
- [Search](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Search.java)
- [Season](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Season.java)
- [TvSearch](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/TvSearch.java)
- [TvShow](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/TvShow.java)
- [Video](https://github.com/CAPJackie/AndroidTest/blob/master/app/src/main/java/com/rappi/movies/data/entities/Video.java)
