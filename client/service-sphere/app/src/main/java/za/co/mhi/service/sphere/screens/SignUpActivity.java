package za.co.mhi.service.sphere.screens;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import za.co.mhi.service.sphere.R;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtPassword;
    private ImageView ivShowPassword;
    private ImageView ivHidePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtPassword = findViewById(R.id.edtPassword);
        ivShowPassword = findViewById(R.id.imgShowPassword);
        ivHidePassword = findViewById(R.id.imgHidePassword);
    }

    public void loginScreen(View view) {
        startActivity(new Intent(view.getContext(), LoginActivity.class));
        finish();
    }

    public void goToBack(View view) {
        finish();
    }

    public void showPassword(View view) {
        ivShowPassword.setVisibility(View.GONE);
        ivHidePassword.setVisibility(View.VISIBLE);
        int pos  = edtPassword.getSelectionStart();
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edtPassword.setSelection(pos);
    }

    public void hidePassword(View view) {
        ivHidePassword.setVisibility(View.GONE);
        ivShowPassword.setVisibility(View.VISIBLE);
        int pos  = edtPassword.getSelectionStart();
        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtPassword.setSelection(pos);
    }
}