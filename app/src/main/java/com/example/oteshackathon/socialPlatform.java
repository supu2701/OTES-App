package com.example.oteshackathon;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class socialPlatform extends AppCompatActivity {
    private FusedLocationProviderClient client;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_platform);
        requestPermission();
        client= LocationServices.getFusedLocationProviderClient(this);
        Button whatsapp=findViewById(R.id.whatsapp);
        Button facebook=findViewById(R.id.facebook);
        Button instagram=findViewById(R.id.instagram);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Tracker","Buttom s pressed");
                if (ActivityCompat.checkSelfPermission(socialPlatform.this, ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                client.getLastLocation().addOnSuccessListener(socialPlatform.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if(location!=null){
                            latitude=location.getLatitude();
                            longitude=location.getLongitude();
                            String toNumber = ""; // contains spaces.
                            toNumber = toNumber.replace("+", "").replace(" ", "");

                            Intent sendIntent = new Intent("android.intent.action.MAIN");
                            sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                            sendIntent.putExtra(Intent.EXTRA_TEXT,"https://www.google.com/maps/search/?api=1&query="+latitude+","+longitude+"\n\n"+"PLEASE HELP ME. I AM STUCK IN EMERGENCY!! I HAVE SEND YOU MY GPS LINK. "+"\n\n"+"कृपया मेरी सहायता करे। मैं आपातकालीन स्थिति में हूँ !! मैंने आपको मेरा जीपीएस लिंक भेजा है।");
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.setPackage("com.whatsapp");
                            sendIntent.setType("text/plain");
                            startActivity(sendIntent);
                        }
                    }
                });

            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text ="HELP!! HELP!!, I am struck in a Emergency.  कृपया मेरी सहायता करे। मैं आपातकालीन स्थिति में हूँ !! मैंने आपको मेरा जीपीएस लिंक भेजा है।";
                Intent shareIntent = new Intent("android.intent.action.MAIN");
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.google.com/maps/search/?api=1&query="+latitude+","+longitude+"\n"+text);
                shareIntent.setAction(Intent.ACTION_SEND);
                PackageManager pm = v.getContext().getPackageManager();
                List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
                for (final ResolveInfo app : activityList) {
                    if ((app.activityInfo.name).contains("instagram")) {
                        final ActivityInfo activity = app.activityInfo;
                        final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |             Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                        shareIntent.setComponent(name);
                        v.getContext().startActivity(shareIntent);
                        break;
                    }
                }



            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text ="HELP!! HELP!!, I am struck in a Emergency";
                Intent shareIntent = new Intent("android.intent.action.MAIN");
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.google.com/maps/search/?api=1&query="+latitude+","+longitude+"\n"+"PLEASE HELP ME. I AM STUCK IN EMERGENCY!! I HAVE SEND YOU MY GPS LINK. "+"\n\n"+"कृपया मेरी सहायता करे। मैं आपातकालीन स्थिति में हूँ !!");
                shareIntent.setAction(Intent.ACTION_SEND);
                PackageManager pm = v.getContext().getPackageManager();
                List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
                for (final ResolveInfo app : activityList) {
                    if ((app.activityInfo.name).contains("facebook")) {
                        final ActivityInfo activity = app.activityInfo;
                        final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |             Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                        shareIntent.setComponent(name);
                        v.getContext().startActivity(shareIntent);
                        break;
                    }
                }


            }
        });
    }
    private  void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
    }
}

