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
                    context.getApplicationContext(),"us-east-1:4c1e1831-5f3a-4942-9acb-c3e83193b7ca", Regions.US_EAST_1);
        }
        return credentialProvider;
    }
}
