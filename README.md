# AddFlutter2Existing Android App

Tutorial for adding flutter to your new or existing android app.

[Link to tutorial](https://youtu.be/Gw211RZGVw8)

# Android

## Create a Flutter module

Let's assume you have an existing Android app at some/path/MyApp, and that you want your Flutter project as a sibling:

```
cd some/path/
$ flutter create -t module my_flutter
```

This creates a some/path/my_flutter/ Flutter module project with some Dart code to get you started and a .android/ hidden subfolder that wraps up the module project in an Android library.

(While not required in what follows, if you so desire, you can build that library using Gradle:

```
$ cd .android/
$ ./gradlew flutter:assembleDebug
```

## Make the host app depend on the Flutter module

Include the Flutter module as a sub-project in the host app's settings.gradle:

```
// MyApp/settings.gradle
include ':app'                                     // assumed existing content
setBinding(new Binding([gradle: this]))                                 // new
evaluate(new File(                                                      // new
  settingsDir.parentFile,                                               // new
  'my_flutter/.android/include_flutter.groovy'                          // new
))                                                                      // new
```

The binding and script evaluation allows the Flutter module to include itself (as :flutter) and any Flutter plugins used by the module (as :package_info, :video_player, etc) in the evaluation context of your settings.gradle.

Introduce an implementation dependency on the Flutter module from your app:

```
// MyApp/app/build.gradle
:
dependencies {
  implementation project(':flutter')
  :
}
```

# More in the video

## Getting Started

For help getting started with Flutter, view our online
[documentation](https://flutter.io/).
