package za.co.mhi.service.sphere.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.screens.shared.MenuActivity;

public class DashboardActivity extends AppCompatActivity {
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void showMenu(View view) {
        Intent intent = new Intent(view.getContext(), MenuActivity.class);
        // TODO: 2023/09/12 Add serializable object
        intent.putExtra("bookings", "TODO");
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity();
            System.exit(0);
        }

        this.doubleBackToExitPressedOnce = true;
        Toast toast = Toast.makeText(this, "Press again to exit..", Toast.LENGTH_SHORT);
        toast.show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
                toast.cancel();
            }
        }, 500);
    }
}