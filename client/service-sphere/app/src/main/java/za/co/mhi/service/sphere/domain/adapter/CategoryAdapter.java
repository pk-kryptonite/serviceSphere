package za.co.mhi.service.sphere.domain.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import za.co.mhi.service.sphere.R;
import za.co.mhi.service.sphere.domain.modal.ServiceCategory;

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private List<ServiceCategory> categories = new ArrayList<>();
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<ServiceCategory> categories) {
        this.context = context;
        this.categories = categories;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_category, null);
        ImageView category = view.findViewById(R.id.imgCategory);
        TextView textView = view.findViewById(R.id.txtCategory);
        ServiceCategory serviceCategory = categories.get(i);
        textView.setText(serviceCategory.getCategory());
        category.setImageResource(getIcon(serviceCategory.getPictureName()));
        return view;
    }


    private int getIcon(String name) {
        switch (name) {
            case "yard-work":
                return R.drawable.mower;
            case "cleaning":
                return R.drawable.cleaning;
            case "plumbing":
                return R.drawable.plumbing;
            case "painting":
                return R.drawable.paint_brush;
            case "support-care":
                return R.drawable.care;
            default:
                return -1;

        }
    }
}
