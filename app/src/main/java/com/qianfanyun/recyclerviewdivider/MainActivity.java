package com.qianfanyun.recyclerviewdivider;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.qianfanyun.divider.Divider;
import com.qianfanyun.divider.DividerBuilder;
import com.qianfanyun.divider.DividerItemDecoration;
import com.qianfanyun.divider.SideLine;
import com.qianfanyun.divider.SimpeDivider;
import com.qianfanyun.divider.SimpeGridDivider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("text-->" + i);
        }
        MyAdapter adapter = new MyAdapter(R.layout.item, list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new MyDivider());

    }


    class MyAdapter extends BaseAdapter<String> {

        public MyAdapter(int layoutResId, List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }

    class MyDivider extends DividerItemDecoration {

        private Divider divider1;
        private Divider divider2;

        public MyDivider() {
            divider1 = new DividerBuilder()
                    .setBottomSideLine(Color.parseColor("#666666"), 2, 50, 50)
                    .create();

            divider2 = new DividerBuilder()
                    .setBottomSideLine(Color.parseColor("#666666"), 10, 50, 50)
                    .create();
        }

        @Nullable
        @Override
        public Divider getDivider(int totalCount, int itemPosition) {
            if (itemPosition%2==0){
                return divider1;
            }else{
                return divider2;
            }
        }

    }
}
