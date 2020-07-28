# ClothesByWeather Application

2017311608 Jisu Ryou


# Using Open API

- OpenWeatherAPI
    - Temperature, wind, clouds, etc
    - **api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={your api key}**


# Activities

- WeatherActivity
    - Using latitude and longitude, parse JSON from OpenWeather API
    - Show
       - Location, updated time, weather description
       - Temperature (current, min/max)
       - Etc (sunrise/sunset time, wind, pressure, humidity, cloudiness)

- GalleryActivity
    - Show how to wear for the current temperature
    - Get every image data from database.child(current temperature dimension) and get an image from storage by matching the imguri value
       - using gridview & imageadapter
    - When clicking the image, toast memo message shortly

- AddActivity
    - Pick an image from gallery and type memo then upload them
    - Image file (image uri) -> firebase storage
    - Image data (image uri & memo)-> firebase database
    
<div>
    <img width="200" src="https://user-images.githubusercontent.com/38908158/88668490-ab837f80-d11d-11ea-8c3d-f705ace99d97.png">
    <img width="200" src="https://user-images.githubusercontent.com/38908158/88668536-b6d6ab00-d11d-11ea-9354-587a36cfdc0a.png">
    <img width="200" src="https://user-images.githubusercontent.com/38908158/88668552-bb02c880-d11d-11ea-889c-4ce4db3defde.png">
</div>

# Supporting Landscape

```
activity_weather.xml
```
<div>
    <img height="200" src="https://user-images.githubusercontent.com/38908158/88668559-bf2ee600-d11d-11ea-899a-cd2f62f1a516.png">
</div>

```
activity_gallery.xml
```
<div>
    <img height="200" src="https://user-images.githubusercontent.com/38908158/88668567-c1914000-d11d-11ea-9b41-81450309ca59.png">
</div>

```
activity_add.xml
```
<div>
    <img height="200" src="https://user-images.githubusercontent.com/38908158/88668582-c524c700-d11d-11ea-8732-ac1f9d7784ba.png">
</div>


# Back-end Server

- Firebase database
    - After clicking “add image” button in AddActivity, image data structure containing **key** , **imguri** , **memo** is uploaded in database.
    - Database is divided by temperature dimension
       - ~4, 5~8, 9~11, 12~16, 17~19, 20~22, 23~

- Firebase storage
    - Instruction images :
       - how to wear
       - divided by temperature dimension
    - Example images :
       - how the user wants to wear
       - same value with imguri from image data in database


# Challenge & Creativity

- Challenge
    - After adding an image data in database and storage successfully, the grid view was not refreshed.
    - Solved by adapter.notifyDataSetChanged();
- Creativity
    - Using LocationListener (public interface LocationListener, android.location.LocationListener)
    - Used for receiving notifications from the LocationManager when the location has changed. These methods are called if the LocationListener has been registered with the location manager service using the LocationManager#requestLocationUpdates(String, long, float, LocationListener) method.



