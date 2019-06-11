package com.example.task2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Model extends BaseAdapter
{
    Context context;
    LayoutInflater inflater;

    public Model(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Main3Activity.keys.length - 1;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        TextView name;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list, parent, false);

        name = (TextView) itemView.findViewById(R.id.txt);

        final ImageView graphic = (ImageView) itemView.findViewById(R.id.graphic);

        if (Main3Activity.keys[position].getGraphic() != null)
            Glide.with(context).load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + Main3Activity.keys[position].getGraphic()).into(graphic);

        name.setText(Main3Activity.keys[position].getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Main2Activity.class);

                intent.putExtra("keys", Main3Activity.keys);
                intent.putExtra("position", position);

                context.startActivity(intent);
            }
        });
        return itemView;
    }
}

