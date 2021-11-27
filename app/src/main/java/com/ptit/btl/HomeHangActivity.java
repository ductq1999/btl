package com.ptit.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ptit.btl.adapter.HangAdapter;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Hang;
import com.ptit.btl.repository.HangRepo;

import java.util.List;

public class HomeHangActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "OOOOO";
    List<Hang> list;
    SearchView searchView;
    HangAdapter adapter;
    HangRepo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        RecyclerView recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new HangAdapter();
        recyclerView.setAdapter(adapter);

        MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this);
        repo = new HangRepo(sqLiteHelper);

        list = repo.getAll();
        adapter.setHangList(list);

        adapter.setOnItemClickListener((view, position, isLongClick) -> {
            if (isLongClick) {
                PopupMenu popupMenu = new PopupMenu(HomeHangActivity.this, view);
                popupMenu.getMenu().add("Xóa");
                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getTitle().equals("Xóa")) {
                        repo.delete(list.get(position));
                        list.remove(position);
                        adapter.notifyItemRemoved(position);
                    }
                    return false;
                });
                popupMenu.show();
            } else {
                Intent intent = new Intent(HomeHangActivity.this, UpdateHangActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(EXTRA_KEY, list.get(position));
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        });
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, InsertHangActivity.class);
            startActivity(intent);
            finish();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_laptop, menu);
        searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return true;
    }

}
