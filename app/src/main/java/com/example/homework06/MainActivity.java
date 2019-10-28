package com.example.homework06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements MyProfile.OnFragmentInteractionListener, SelectAvatar.OnFragmentInteractionListener, DisplayMyProfile.OnFragmentInteractionListener {

    int imageId = -1;
    Student student;
    static final String PREFS_NAME = "MyPrefs";
    static final String STUDENT_KEY = "student";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        Gson gson = new Gson();
        String stud = appSharedPrefs.getString(STUDENT_KEY,"");
        Student std =  gson.fromJson(stud,Student.class);
        if(std!=null && std.getStudentId() !=""){
            moveFromProfileToDisplayFragment();
            student = std;
            imageId = std.getImageVal();
        } else {
            goToMyProfileFragment();
        }
    }

    @Override
    public void onImageClickListener() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SelectAvatar(), "SelectAvatar")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public int getMessage() {
        return imageId;
    }

    @Override
    public void setStudent(Student student) {
        Student std = student;
        SharedPreferences appSharedPrefs = PreferenceManager
                .getDefaultSharedPreferences(this.getApplicationContext());
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(student);

        prefsEditor.putString(STUDENT_KEY, json);
        prefsEditor.commit();
        this.student = student;
    }

    @Override
    public void moveFromProfileToDisplayFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new DisplayMyProfile(),"Display")
//                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onImageClicked(int id) {
        imageId =id;
        Log.d("demo",id+"");
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public Student getStudent() {
        return student;
    }

    @Override
    public void goToMyProfileFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MyProfile(),"MyProfile")
                .commit();
    }
}
