# Chiper Reddit Test
 Chiper test for android using reddit API
 
 # Chiper Reddit Test Application:
 - Clean Architecture
- MVVM
- [Koin](https://insert-koin.io/)
- [Data Binding](https://developer.android.com/topic/libraries/data-binding/)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation.html)
- [Paging](https://developer.android.com/topic/libraries/architecture/paging/)
- [Room](https://developer.android.com/topic/libraries/architecture/room)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Retrofit](https://square.github.io/retrofit/)
- [OkHttp](https://square.github.io/okhttp/)
- [Glide](https://bumptech.github.io/glide/)
- [Timber](https://github.com/JakeWharton/timber)
- [Material Design](https://material.io/develop/android/)
 
 # Arquitectura
   * La capa de datos donde se establece la persistencia ya sea a una base de datos local tipo Room, SQLite, Realm o uso de SharedPreferences, así como tambien 
   uso de servicios Web del tipo REST u otros usando Retrofit, Volley u otros para la persistencia en la nube. Ademas se puede aplicar el Repository Pattern
   el cual permite persistir localmente cuando se cuenta con una pobre o inexistente conexion a Internet o se usa una CACHE para eliminar la latencia tanto en 
   el consumo de informacion como en la persistencia de datos. Si se usa el Repository Pattern la persistencia local es mas sencilla usando Room Library.
   
 * La capa de dominio donde se hace uso de Interactors o Use Cases, en la cual se ejecuta la logica de negocio y se controla la persistencia u obtencion de datos, 
   asi como tambien se pueden disparar estas operaciones en segundo plano. Gracias a esta capa se hace una diferenciacion y se añade una capa mas de abstraccion 
   que permite desligar el modelo de datos de las operaciones. Esto permitira al Interactor realizar sus tareas sin responsabilizarse de la capa de datos.
   * La capa de presentación se encarga de mostrar todas las vistas consumiento los casos de uso que se llenan atraves de la data. Sencillamente no existe logica de negocio en esta capa, solo actual como disparador de las vistas.

### Paleta de Colores
    <color name="colorPrimary">#60A3BC</color>
    <color name="colorBrand">#FF4500</color>
### Screenshots

### Licencia
```
   Copyright (C) 2020 Juan Camilo Sandoval Devia

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
