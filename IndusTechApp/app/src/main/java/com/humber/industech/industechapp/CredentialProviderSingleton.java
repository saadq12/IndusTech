package com.humber.industech.industechapp;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;

/**
 * Created by Saad on 2016-11-11.
 */

public class CredentialProviderSingleton {

    static CognitoCachingCredentialsProvider credentialProvider;

    public static CognitoCachingCredentialsProvider getInstance(Context context){
        if (credentialProvider == null){
            credentialProvider = new CognitoCachingCredentialsProvider(
                    context.getApplicationContext(),"us-west-2:0e7ddbfd-a548-43d5-8636-af4ebff8975f", Regions.US_WEST_2);
        }
        return credentialProvider;
    }
}
