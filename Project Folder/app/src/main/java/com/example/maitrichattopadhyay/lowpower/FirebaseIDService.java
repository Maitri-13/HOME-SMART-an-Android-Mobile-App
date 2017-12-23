package com.example.maitrichattopadhyay.lowpower;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by maitrichattopadhyay on 11/24/17.
 */

public class FirebaseIDService extends FirebaseInstanceIdService
{
    private static final String TAG = "FirebaseIDService";



    @Override
    public void onTokenRefresh()
    {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i(TAG, "Refreshed token: " + refreshedToken);

        // TODO: Implement this method to send any registration to your app's servers.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token)
    {
        // Add custom implementation, as needed.
    }


}
