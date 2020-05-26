package com.example.mcnutt.inclassdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.entity.User;
import com.example.mcnutt.inclassdemo.viewmodels.UserViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RoomPersistenceExampleActivity extends AppCompatActivity {

    public TextView email;
    public TextView displayName;
    public TextView photoUrl;
    private ImageView photoImageView;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_persistence_example);

        email = findViewById(R.id.email);
        displayName = findViewById(R.id.displayName);
        photoUrl = findViewById(R.id.photoUrl);
        photoImageView = findViewById(R.id.photoImage);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // Create the observer which updates the UI.
        final Observer<List<User>> getUsersObserver = newUsers -> {
            if (newUsers == null || newUsers.size() <= 0) {
                return;
            }

            User user = newUsers.get(0);

            if (user == null) {
                return;
            }

            email.setText(user.getEmail());
            displayName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            photoUrl.setText(user.getPhotoUrl());
            if (user.getPhotoUrl() != null) {
                Picasso.get().load(user.getPhotoUrl()).into(photoImageView);
            }
        };

        String[] emails = { "mcnuttkyle93@gmail.com" };
        userViewModel.loadAllByIds(this, emails).observe(this, getUsersObserver);
    }

    public void updateDatabase(View view) {
        User fakeNewUser = new User();
        String email = this.email.getText().toString();
        if(email.equals("")) {
            email = "fakeuser@google.com";
        }
        fakeNewUser.setEmail(email);
        fakeNewUser.setPhotoUrl("https://i.imgur.com/ZYVZT1d.jpg");
        fakeNewUser.setFirstName("Thisis");
        fakeNewUser.setLastName("afakeuser");

        userViewModel.updateUsers(this, fakeNewUser);

        this.email.setText(fakeNewUser.getEmail());
        displayName.setText(String.format("%s %s", fakeNewUser.getFirstName(), fakeNewUser.getLastName()));
        photoUrl.setText(fakeNewUser.getPhotoUrl());
    }

    public void deleteUser(View view) {
        User currentUser = new User();
        currentUser.setEmail(this.email.getText().toString());
        currentUser.setPhotoUrl(this.photoUrl.getText().toString());
        String[] name = this.displayName.getText().toString().split(" ");
        currentUser.setFirstName(this.displayName.getText().toString().split(" ")[0]);
        if(name.length > 1) {
            currentUser.setLastName(this.displayName.getText().toString().split(" ")[1]);
        }

        userViewModel.deleteUser(this, currentUser);

        email.setText("");
        displayName.setText("");
        photoUrl.setText("");
    }
}
