package za.co.mhi.service.sphere.screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import za.co.mhi.service.sphere.MainActivity;
import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.service.UserServices;
import za.co.mhi.service.sphere.service.exception.ApplicationException;
import za.co.mhi.service.sphere.service.exception.InvalidEmailOrPasswordException;

public class LoginActivity extends AppCompatActivity {
    private EditText edtPassword;
    private EditText edtEmailAddress;
    private TextView txtErrorMessage;
    private ImageView ivShowPassword;
    private ImageView ivHidePassword;
    private TextView txtInvalidEmail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setLinkToUI();
        setBehaviour();
    }

    private void setLinkToUI() {
        edtPassword = findViewById(R.id.edtPassword);
        edtEmailAddress = findViewById(R.id.edtEmail);
        txtErrorMessage = findViewById(R.id.txtErrorMessage);
        ivShowPassword = findViewById(R.id.imgShowPassword);
        ivHidePassword = findViewById(R.id.imgHidePassword);
        txtInvalidEmail = findViewById(R.id.txtInvalidEmail);
    }

    private void setBehaviour() {
        edtEmailAddress.setOnFocusChangeListener((view, b) -> {
            if (b) {
                txtErrorMessage.setVisibility(View.INVISIBLE);
            }else{
                validateEmail(edtEmailAddress.getText().toString());
            }

        });
        edtPassword.setOnFocusChangeListener(((view, b) -> {
            if (b) {
                txtErrorMessage.setVisibility(View.INVISIBLE);
            }
        }));
    }

    public void goToBack(View view) {
        finish();
    }

    public void goToSignUpScreen(View view) {
        startActivity(new Intent(view.getContext(), SignUpActivity.class));
        finish();
    }

    public void goToForgotScreen(View view) {
        startActivity(new Intent(view.getContext(), MainActivity.class));
    }

    public void verifyAndLogin(View view) {
        UserServices services = new UserServices();
        if(edtEmailAddress.getText().toString().isEmpty()|| edtPassword.getText().toString().isEmpty()|| txtInvalidEmail.getVisibility() == View.VISIBLE)
            txtErrorMessage.setVisibility(View.VISIBLE);
        else
            services.Login(this, edtEmailAddress.getText().toString(), edtPassword.getText().toString());
    }


    public void showPassword(View view) {
        ivShowPassword.setVisibility(View.GONE);
        ivHidePassword.setVisibility(View.VISIBLE);
        int pos = edtPassword.getSelectionStart();
        edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        edtPassword.setSelection(pos);
    }

    public void hidePassword(View view) {
        ivHidePassword.setVisibility(View.GONE);
        ivShowPassword.setVisibility(View.VISIBLE);
        int pos = edtPassword.getSelectionStart();
        edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtPassword.setSelection(pos);
    }

    private void validateEmail(String emailAddress) {
        boolean valid = true;
        if (!emailAddress.contains("@") || !emailAddress.contains(".co")|| emailAddress.length() < 7)
            valid = false;

        if (!valid)
            txtInvalidEmail.setVisibility(View.VISIBLE);
        else
            txtInvalidEmail.setVisibility(View.INVISIBLE);

    }
}