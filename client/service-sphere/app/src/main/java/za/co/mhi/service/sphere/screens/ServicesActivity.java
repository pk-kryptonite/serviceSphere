package za.co.mhi.service.sphere.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.screens.shared.MenuActivity;

public class ServicesActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private ImageView filterBtn;
    private Spinner ratingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Intent intent = getIntent();
        TextView v = this.findViewById(R.id.txtServiceCategoryTitle);
        layout = this.findViewById(R.id.filterContainer);
        layout.setVisibility(View.GONE);
        filterBtn = this.findViewById(R.id.ivFilterBtn);
        ratingSpinner = this.findViewById(R.id.spRating);
        Integer[] ratings = new Integer[]{1,2,3,4,5};
        v.setText(intent.getStringExtra("category").concat(" Services"));
    }

    public void showMenu(View view) {
        Intent intent = new Intent(view.getContext(), MenuActivity.class);
        intent.putExtra("previous", "services");
        startActivity(intent);
    }

    public void toggleFilter(View view) {
        if (layout != null && layout.getVisibility() != View.VISIBLE) {
            layout.setVisibility(View.VISIBLE);
            filterBtn.setImageResource(R.drawable.cross__1_);
        } else if (layout != null && layout.getVisibility() == View.VISIBLE) {
            layout.setVisibility(View.GONE);
            filterBtn.setImageResource(R.drawable.settings_sliders);
        }
    }

    public void resetFilter(View view) {
        EditText location = findViewById(R.id.edtFilterlocation);
        EditText minimumJobs = findViewById(R.id.edtFilterJobs);

        location.setText("");
        minimumJobs.setText("");
    }
}