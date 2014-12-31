package uk.co.timwise.communicationbook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class LibraryAdapter extends BaseAdapter {
    private Context context;

    public LibraryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView!=null){
            return convertView; // use cached
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_launcher);
        return imageView;
    }
}
