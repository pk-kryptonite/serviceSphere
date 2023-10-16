package za.co.mhi.service.sphere.screens.shared;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.screens.DashboardActivity;
import za.co.mhi.service.sphere.screens.ServicesCategoryActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void showDashboard(View view) {
        startActivity(new Intent(view.getContext(), DashboardActivity.class));
        finish();
    }

    public void showServices(View view) {
        startActivity(new Intent(view.getContext(), ServicesCategoryActivity.class));
        finish();
    }

    public void showBookings(View view) {
    }

    public void showAccount(View view) {
    }

    public void closeMenu(View view) {
        finishAfterTransition();
    }
}