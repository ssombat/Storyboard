package com.example.neema.storyboard;
import android.app.Activity;
import android.app.Fragment;
import android.view.View;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ProfileFragment extends Fragment {
    ImageView profilePic;
    EditText bio;
    Button button;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //TODO fill in the stuff for the layout for the profile fragment
        View view = inflater.inflate(R.layout.profile,container,false);
        profilePic = view.findViewById(R.id.profilePicture);
        bio = view.findViewById(R.id.bio);
        button = view.findViewById(R.id.settings);
        return view;

    }
    protected void settingFrag(View v) {
        Intent intent = new Intent(getActivity(),ProfileSetting.class);
        startActivity(intent);
    }
}
