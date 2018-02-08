package com.nu2k18.nitrutsav;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nu2k18.nitrutsav.models.Users;
import com.nu2k18.nitrutsav.utils.Constants;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    SignInButton button;
    protected FirebaseAuth mAuth;
    private static final int RC_SIGN_IN= 2 ;
    protected GoogleApiClient mGoogleApiClient;
    FirebaseAuth.AuthStateListener mAuthListener;
    Animation fromBottom;
    Animation fromTop;
    ImageView par;
    protected FirebaseUser firebaseUser;
    private ProgressDialog mprogressDialog;
    private static final String TAG=MainActivity.class.getSimpleName();
    //private GoogleSignInOptions ngso;

    SharedPreferences sharedpreferences;
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    protected void onStop()
    {
        super.onStop();
        if (mAuthListener != null
                ) {

            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


 //        sharedpreferences = getSharedPreferences("nu", getApplicationContext().MODE_PRIVATE);

        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            startActivity(new Intent(MainActivity.this,MenuActivity.class));
            finish();
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        par=(ImageView)findViewById(R.id.imageView2);
        button=(SignInButton)findViewById(R.id.googleBtn);
        mAuth = FirebaseAuth.getInstance();

        if(mAuth!=null)
        {
           firebaseUser=mAuth.getInstance().getCurrentUser();
            //startActivity(new Intent(MainActivity.this,MenuActivity.class));
        }
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        button.setAnimation(fromBottom);

        fromTop=AnimationUtils.loadAnimation(this, R.anim.fromtop);
        par.setAnimation(fromTop);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             showProgressDialog();
                signIn();
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient=new GoogleApiClient.Builder(this)

                .enableAutoManage(this,new GoogleApiClient.OnConnectionFailedListener()
                {

                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                })

                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
               if(firebaseAuth.getCurrentUser()!=null)
               { /*startActivity(new Intent(MainActivity.this,MenuActivity.class));*/}
               if(firebaseUser!=null) {
                   if (firebaseUser != null) {
                       if (BuildConfig.DEBUG) {

                       } else {

                       }
                   }
               }
            }
        };




    }

    protected void showProgressDialog()
    {
            if(mprogressDialog==null)
            {
                mprogressDialog=new ProgressDialog(this);
                mprogressDialog.setMessage(getString(R.string.loading));
                mprogressDialog.setIndeterminate(true);
            }
            mprogressDialog.show();
    }

    protected  void hideProgressDialog()
    {
        if(mprogressDialog!=null && mprogressDialog.isShowing())
        {
            mprogressDialog.hide();
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    protected void signOut()
    {
        mAuth.signOut();

        Auth.GoogleSignInApi.signOut(mGoogleApiClient)
                            .setResultCallback(new ResultCallback<Status>() {
                                @Override
                                public void onResult(@NonNull Status status) {

                                }
                            });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        hideProgressDialog();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if(resultCode== Activity.RESULT_OK)
        {
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if(result.isSuccess())
            {
                GoogleSignInAccount account=result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            }
            else
            {
                hideProgressDialog();
                Toast.makeText(MainActivity.this,"Authorization went wrong", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            hideProgressDialog();

        }}
        else
            {
                hideProgressDialog();

            }
    }

    private void firebaseAuthWithGoogle(final GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            firebaseUser = mAuth.getCurrentUser();
                            
                            String photoUrl=null;
                            if(account.getPhotoUrl() != null)
                            {
                                photoUrl=account.getPhotoUrl().toString();
                            }
                          final Users user=new Users(
                                  account.getDisplayName(),
                                  account.getEmail(),
                                  photoUrl,
                                  FirebaseAuth.getInstance().getCurrentUser().getUid()
                             );
                            FirebaseDatabase database= FirebaseDatabase.getInstance();
                            DatabaseReference userRef=database.getReference(Constants.USER_KEY);
                            userRef.child(account.getEmail().replace(".",","))
                                    .setValue(user, new DatabaseReference.CompletionListener() {
                                        @Override
                                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
/*
                                            SharedPreferences.Editor edit=sharedpreferences.edit();
                                            edit.putString("login","1");
                                            edit.putString("email_id",user.getEmail());
                                            edit.putString("image_url",user.getPhotoUrl());
                                            edit.putString("name",user.getUser());

                                            edit.apply();*/
                                           startActivity(new Intent(MainActivity.this,MenuActivity.class));
                                        }
                                    });

                            if(BuildConfig.DEBUG);
                            else
                            {
                               // hideProgressDialog();
                               // Toast.makeText(MainActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                               // signOut();
                            }

                        } else {
                            // If sign in fails, display a message to the user.

                           // Toast.makeText(MainActivity.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }


                    }
                });
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

