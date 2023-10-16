package za.co.mhi.service.sphere.screens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.domain.adapter.CategoryAdapter;
import za.co.mhi.service.sphere.domain.modal.ServiceCategory;
import za.co.mhi.service.sphere.screens.shared.MenuActivity;

public class ServicesCategoryActivity extends AppCompatActivity {
    private BaseAdapter adapter;
    private GridView gridView;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_category);
        gridView = (GridView) findViewById(R.id.gvServices);
        adapter = new CategoryAdapter(this, categories());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, ServicesActivity.class);
            TextView textView = view.findViewById(R.id.txtCategory);
            intent.putExtra("category", textView.getText());

            startActivity(intent);

        });
    }

    public void showMenu(View view) {
        Intent intent = new Intent(view.getContext(), MenuActivity.class);
        intent.putExtra("previous", "services");
        startActivity(intent);
    }

    public void goToService(View view) {
        Intent intent = new Intent(getApplicationContext(), ServicesActivity.class);
        intent.putExtra("category", "");
        startActivity(intent);
    }

    private List<ServiceCategory> categories() {
        return new ArrayList(Arrays.asList(
                new ServiceCategory("Yard work", "yard-work"),
                new ServiceCategory("Cleaning", "cleaning"),
                new ServiceCategory("Plumbing", "plumbing"),
                new ServiceCategory("Painting", "painting"),
                new ServiceCategory("Care support", "support-care")));
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