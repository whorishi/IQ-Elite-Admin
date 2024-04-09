package com.example.quizapp.Adapters;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizapp.QuestionActivity;
import com.example.quizapp.R;

public class GrideAdapter extends BaseAdapter {

    public int sets = 0;
    private String category;
    private String key;
    private GridListener listener;

    public GrideAdapter(int sets, String category, String key, GridListener listener) {
        this.sets = sets;
        this.category = category;
        this.key = key;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return sets+1;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = null;
        if(view1==null) {
            view1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sets,viewGroup,false);
        }
        else {
            view1 = view;
        }

        if(i==0){
            ((TextView)view1.findViewById(R.id.settt)).setText("Add Set   ");
            ((TextView)view1.findViewById(R.id.setName)).setText("+");
            ((TextView)view1.findViewById(R.id.setName)).setTextSize(45);
            ((TextView)view1.findViewById(R.id.settt)).setTextColor(Color.parseColor("#FFEEFF00"));
            ((TextView)view1.findViewById(R.id.setName)).setTextColor(Color.parseColor("#FFEEFF00"));

        } else {
            ((TextView)view1.findViewById(R.id.setName)).setText(String.valueOf(i));
        }

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0) {
                    listener.addSets();
                }
                else {
                    Intent intent = new Intent(viewGroup.getContext(), QuestionActivity.class);
                    intent.putExtra("setNum",i);
                    intent.putExtra("categoryName",category);
                    viewGroup.getContext().startActivity(intent);
                }
            }
        });
        return view1;
    }

    public interface GridListener{
        public void addSets();
    }

}
