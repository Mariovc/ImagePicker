ImagePicker [Deprecated] (Use <a href="https://developer.android.com/training/camerax">Google API CameraX</a>)
===========

<a href="https://android-arsenal.com/api?level=14">
  <img alt="Min API" src="https://img.shields.io/badge/API-14%2B-orange.svg?style=flat" />
</a>
<a href="https://github.com/Mariovc/ImagePicker/releases/latest">
  <img alt="Latest release" src="https://img.shields.io/github/release/Mariovc/ImagePicker.svg" />
</a>

ImagePicker is an Android library to easily pick an image from gallery or camera app. The users can select their prefered gallery/camera app on a unique Intent. 
Download the APK sample on Google Play:

<a href="https://play.google.com/store/apps/details?id=com.mvc.imagepicker">
  <img alt="Add me to Linkedin" src="./art/GooglePlay.png" />
</a>


Screenshots
-----------

![Sample screenshot][2]


Usage
-----

Add the following code to your *Activity*:

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        // width and height will be at least 600px long (optional).
        ImagePicker.setMinQuality(600, 600);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
        // TODO do something with the bitmap
    }

    public void onPickImage(View view) {
        // Click on image button
        ImagePicker.pickImage(this, "Select your image:");
    }
```


Add it to your project
----------------------

Add this permission to your ``AndroidManifest``:

```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

Add it in your *root* ``build.gradle`` at the end of repositories:

```groovy
allprojects {
  repositories {
    // Add this line
    maven { url "https://jitpack.io" }
  }
}
```

Add ``ImagePicker`` dependency to your *app* ``build.gradle`` file:

```groovy
dependencies{
    compile 'com.github.Mariovc:ImagePicker:x.x.x'
}
```

where `x.x.x` corresponds to latest release version published in [ ![release](https://img.shields.io/github/release/Mariovc/ImagePicker.svg) ](https://github.com/Mariovc/ImagePicker/releases/latest)


Contributing
--------------------------

Feel free to fork and make a pull request with your improvements.


Developed By
------------

* Mario Velasco Casquero - <m3ario@gmail.com>

<a href="https://twitter.com/MVelascoC">
  <img alt="Follow me on Twitter" src="./art/twitter.png" />
</a>
<a href="https://es.linkedin.com/in/mariovc">
  <img alt="Add me to Linkedin" src="./art/linkedin.png" />
</a>

License
-------

    Copyright 2016 Mario Velasco Casquero

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: ./art/GooglePlay.png
[2]: ./art/ImagePickerSample.gif
