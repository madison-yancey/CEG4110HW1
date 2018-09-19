# CEG4110 HW1
CEG 4110 Homework 1

Android app that allows user to type text into a textfield and randomize the text color as well as paint over a bitmap

## Prerequisites
Any phone that can run an Android app

## Deployment
1. 
2.
3.

To change the bitmap the user can paint over, place a .png or .jpeg file into the drawable file for the app (feature-> res-> drawable). Set the src image in the Main2Activity XML file to your image (android:src="@drawable/YOUR_IMAGE"). 

## How to Use
The main screen of the app allows the user to type anything into the textfield at the top of the screen. When the user taps the color change button, a random value is generated, creating a random color. This color is then displayed to the user as an HTML color code and an RGB value.

![screen1](https://github.com/madison-yancey/CEG4110HW1/blob/master/Resources/MainScreen.PNG)

![screen2](https://github.com/madison-yancey/CEG4110HW1/blob/master/Resources/MainScreen2.PNG)

At the bottom of the main screen is a button that allows the user to to navigate to the next screen. This screen allows the user to paint over a picture on a canvas. The user can change the drawing color by clicking on the Change Color button and moving the bars, red value bar first, to create a color. The user is also able to undo strokes of color, clear the screen, and save the image. The user can also tap the button at the top of the screen to navigate to the main screen.

![canvas](https://github.com/madison-yancey/CEG4110HW1/blob/master/Resources/BlankCanvas.PNG)

## Built With
Android Studio
FingerPaintView
Android-Material-Color-Picker-Dialog

## Authors
Madison Yancey

## Design & Features
The overall design choice was to create an app that was simple and easy to use. By limiting the background colors of the app, the functionality of allowing the user to create random text colors and paint on a canvas is not diminished. The ActivityMain.kt and activity_main.xml files provide the functionality for the first UI screen, which includes a textfield the user can type in with the device's keboard, a button to randomize a color, and another button to change screens. The Activity2Main.kt and activity_main2.xml files provide the funcitonality for the second UI screen, which has a button to undo and clear any drawing lines over the bitmap, a textfield to type in an HTML code and change the drawing color, a canvas to draw on, and a button that brings up a dialog window to select the color choice.

This app features a canvas painting library, called FingerPaintView (https://github.com/madison-yancey/CEG4110HW1/blob/master/Resources/BlankCanvas.PNG). The library was implemented in the second UI screen. This provided the drawing canvas as well as the undo and clear features. 

Another library, called Android-Material-Color-Picker-Dialog, is implemented in the app to allow the user to choose any color (https://github.com/Pes8/android-material-color-picker-dialog). The library features a pop-up dialog window where three bars allows to user to create a color with RGB values.
