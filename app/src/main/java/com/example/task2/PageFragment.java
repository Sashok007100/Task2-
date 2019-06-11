package com.example.task2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PageFragment extends Fragment {


    private Keys key;

    public PageFragment() {}

    public static PageFragment newInstance(Keys key) {
        PageFragment pr=new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putParcelable("key",key);
        pr.setArguments(arguments);
        return  pr;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        key=getArguments().getParcelable("key");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        ImageView imageGraphic = view.findViewById(R.id.graphic);

        if(this.key.getGraphic() != null)
            Glide.with(this).load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + this.key.getGraphic()).into(imageGraphic);

        TextView txt = (TextView) view.findViewById(R.id.displayText);
        if(this.key.getHelptext() != null)
            txt.setText(this.key.getHelptext());
        else
            txt.setText("Not found");

        return view;
    }
}
