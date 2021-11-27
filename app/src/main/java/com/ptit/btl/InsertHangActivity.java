package com.ptit.btl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Hang;
import com.ptit.btl.repository.HangRepo;

public class InsertHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_hang);

        Button btnAdd = findViewById(R.id.btn_add_hang);
        EditText ten = findViewById(R.id.edt_ten_hang);
        EditText danhGia = findViewById(R.id.edt_danh_gia_hang);


        btnAdd.setOnClickListener(v -> {
            MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this);
            HangRepo repo = new HangRepo(sqLiteHelper);

            Hang hang = new Hang(0, ten.getText().toString(), danhGia.getText().toString());
            repo.add(hang);
            Intent intent = new Intent(this, HomeHangActivity.class);
            startActivity(intent);
            finish();
        });
    }

}
