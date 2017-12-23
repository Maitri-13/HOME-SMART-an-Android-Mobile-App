package com.example.maitrichattopadhyay.lowpower;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;


/**
 * Created by maitrichattopadhyay on 11/24/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO: Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend w on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated.

        Log.i(TAG, "got a log lol");

        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getData().get("default"));


        String input = remoteMessage.getData().get("default");
        Intent intent = new Intent();
        String value ="";
        JSONObject my_json = null;
        try {
            my_json = new JSONObject(input);
            intent.putExtra("extra", my_json.toString());
            Log.i("my jason", my_json.toString());
            value = my_json.getJSONObject("data").get("key-1").toString();
        } catch (Throwable t) {
            Log.d("oops json error", t.toString());
        }
        intent.setAction("com.my.app.onMessageReceived");
        sendBroadcast(intent);

        CharSequence channelName = "my chanel";
        String NOTIFICATION_CHANNEL_ID = "4655";
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.RED);
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});

        Context context = this;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);



        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(remoteMessage.getFrom())
                .setSmallIcon(R.drawable.h)
                .setSound(null)
                .setContentText(value)
                .setAutoCancel(false);


        notificationManager.notify(4655 /* ID of notification */, builder.build());
    }

}
