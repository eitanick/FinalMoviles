package com.example.anthony.clinicplace;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.amazonaws.mobile.auth.core.DefaultSignInResultHandler;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.amazonaws.mobile.auth.core.StartupAuthErrorDetails;
import com.amazonaws.mobile.auth.core.signin.AuthException;
import com.amazonaws.mobile.auth.ui.AuthUIConfiguration;
import com.amazonaws.mobile.auth.ui.SignInActivity;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.auth.core.StartupAuthResult;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final IdentityManager identityManager =
                IdentityManager.getDefaultIdentityManager();
        Context appContext = getApplicationContext();
        AWSConfiguration awsConfig = new AWSConfiguration(appContext);

        identityManager.doStartupAuth(this, new StartupAuthResultHandler() {
            @Override
            public void onComplete(final StartupAuthResult authResults) {

                // User identity is ready as unauthenticated user or previously signed-in user.
                if (authResults.isUserSignedIn()) {
                    final IdentityProvider provider =
                            identityManager.getCurrentIdentityProvider();

                    // If the user was  signed in previously with a provider,
                    // indicate that to them with a toast.
                    Toast.makeText(
                            SplashActivity.this, String.format("Signed in with %s",
                                    provider.getDisplayName()), Toast.LENGTH_LONG).show();
                    goMain(SplashActivity.this);
                    return;

                } else {
                    // Either the user has never signed in with a provider before
                    // or refresh failed with a previously signed in provider.

                    // Optionally, you may want to check if refresh
                    // failed for the previously signed in provider.

                    final StartupAuthErrorDetails errors =
                            authResults.getErrorDetails();

                    if (errors.didErrorOccurRefreshingProvider()) {
                        final AuthException providerAuthException =
                                errors.getProviderRefreshException();

                        // Credentials for previously signed-in provider could not be refreshed
                        // The identity provider name is available here using:
                        //     providerAuthException.getProvider().getDisplayName()

                    }

                    doSignIn(IdentityManager.getDefaultIdentityManager());
                    return;
                }

            }
        });

        // Go to the main activity
        final Intent intent = new Intent(this, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();

    }


    private void doSignIn(final IdentityManager identityManager) {

        identityManager.setUpToAuthenticate(
                SplashActivity.this, new DefaultSignInResultHandler() {

                    @Override
                    public void onSuccess(Activity activity, IdentityProvider identityProvider) {
                        if (identityProvider != null) {

                            // Sign-in succeeded
                            // The identity provider name is available here using:
                            //     identityProvider.getDisplayName()

                        }

                        // On Success of SignIn go to your startup activity
                        activity.startActivity(new Intent(activity, MainActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    }

                    @Override
                    public boolean onCancel(Activity activity) {
                        // Return false to prevent the user from dismissing
                        // the sign in screen by pressing back button.
                        // Return true to allow this.

                        return false;
                    }
                });

        AuthUIConfiguration config =
                new AuthUIConfiguration.Builder()
                        .userPools(true)
                        // .signInButton(FacebookButton.class)
                        // .signInButton(GoogleButton.class)
                        .build();

        Context context = SplashActivity.this;
        SignInActivity.startSignInActivity(context, config);
        SplashActivity.this.finish();
    }

    /**
     * Go to the main activity.
     */
    private void goMain(final Activity callingActivity) {
        callingActivity.startActivity(new Intent(callingActivity, MainActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        callingActivity.finish();
    }

}