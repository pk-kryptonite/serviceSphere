package za.co.mhi.service.sphere;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import za.co.mhi.service.sphere.screens.LoginActivity;
import za.co.mhi.service.sphere.screens.SignUpActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginScreen(View view) {
        startActivity(new Intent(view.getContext(), LoginActivity.class));
    }
    public void signUpScreen(View view){
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
    }
}