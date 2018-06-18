# Android-Room-Demo-Example-With-Android-Architecture-Components
This KOTLIN repository is to demonatrate the use of ROOM in android application. Its inspired from this 
( https://codelabs.developers.google.com/codelabs/android-room-with-a-view/ ) google codelabs repository. It inserts 100 words, each at the interval of 500 ms (to demonstrate the ui changes due to LiveData & ViewModel after data is inserted in RoomDatabase). Also you can add your own words and the ui will be updated instantly.

#Note1: There might be some issues/error in the code. I am uploading this repo just because there were hardly any resources related to 'Implementation of room using KotlinX and Architecture Components'

#Note2: that this library uses Anko( https://github.com/Kotlin/anko/wiki ) so some methods like doAsync{}, uiThread{} etc might be confusing for you.

Along with ROOM, it also uses other architecture component like:

1-> WorkManager
2-> LiveData
3-> ViewModel 
4-> DAO,Entities and RoomDatabase
5-> Room library
6-> Android Architecture Components
7-> Anko
