package com.example.mcnutt.inclassdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mcnutt.inclassdemo.entity.User;

import java.lang.ref.WeakReference;
import java.util.List;

public class RoomPersistenceExampleActivity extends AppCompatActivity {

    public TextView email;
    public TextView displayName;
    public TextView photoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_persistence_example);

        email = findViewById(R.id.email);
        displayName = findViewById(R.id.displayName);
        photoUrl = findViewById(R.id.photoUrl);

        new GetUserTask(this, "mcnuttkyle93@gmail.com").execute();
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

        new UpdateUserTask(this, fakeNewUser).execute();
    }

    public void deleteUser(View view) {
        User currentUser = new User();
        currentUser.setEmail(this.email.getText().toString());
        currentUser.setPhotoUrl(this.photoUrl.getText().toString());
        currentUser.setFirstName(this.displayName.getText().toString().split(" ")[0]);
        currentUser.setLastName(this.displayName.getText().toString().split(" ")[1]);

        new DeleteUserTask(this, currentUser).execute();
    }

    private static class DeleteUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private User user;

        public DeleteUserTask(Activity activity, User user) {
            weakActivity = new WeakReference<>(activity);
            this.user = user;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            db.userDao().delete(user);
            return user;
        }

        @Override
        protected void onPostExecute(User user) {
            RoomPersistenceExampleActivity activity = (RoomPersistenceExampleActivity) weakActivity.get();
            if(user == null || activity == null) {
                return;
            }

            activity.email.setText("");
            activity.displayName.setText("");
            activity.photoUrl.setText("");
        }
    }

    private static class UpdateUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private User user;

        public UpdateUserTask(Activity activity, User user) {
            weakActivity = new WeakReference<>(activity);
            this.user = user;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            db.userDao().updateUsers(user);
            return user;
        }

        @Override
        protected void onPostExecute(User user) {
            RoomPersistenceExampleActivity activity = (RoomPersistenceExampleActivity) weakActivity.get();
            if(user == null || activity == null) {
                return;
            }

            activity.email.setText(user.getEmail());
            activity.displayName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            activity.photoUrl.setText(user.getPhotoUrl());
        }
    }

    private static class GetUserTask extends AsyncTask<Void, Void, User> {

        private WeakReference<Activity> weakActivity;
        private String userEmail;

        public GetUserTask(Activity activity, String userEmail) {
            weakActivity = new WeakReference<>(activity);
            this.userEmail = userEmail;
        }

        @Override
        protected User doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            String[] emails = { userEmail };

            List<User> users = db.userDao().loadAllByIds(emails);

            if(users.get(0) == null) {
                return null;
            }
            return users.get(0);
        }

        @Override
        protected void onPostExecute(User user) {
            RoomPersistenceExampleActivity activity = (RoomPersistenceExampleActivity) weakActivity.get();
            if(user == null || activity == null) {
                return;
            }

            activity.email.setText(user.getEmail());
            activity.displayName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            activity.photoUrl.setText(user.getPhotoUrl());
        }
    }
}
