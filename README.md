# HOME-SMART-an-Android-Mobile-App

The android app which lets users remotely send commands and receive notifications from their IOT devices installed at their home. The IOT device sends images and voice recordings to the AWS and the app uses asynchronous tasks to fetch them and displlay on the phone. The app also has the capability to display the most recent 10 notifications. There are three backend AWS servers supporting these features. One is dedicated to push notifications the phone, one for the for storing the image and audio files form the IOT device while the other is for doing SQL queries to display history of notifications. The app is compatibility with android version 4.0 (API 14) to present (API 26).
