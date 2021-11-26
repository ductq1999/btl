package com.ptit.btl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Laptop;
import com.ptit.btl.repository.LaptopRepo;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_laptop);

        Button btnAdd = findViewById(R.id.btn_add_laptop);
        EditText ten = findViewById(R.id.edt_ten);
        EditText loai = findViewById(R.id.edt_loai);
        EditText giaTri = findViewById(R.id.edt_gia_tri);
        EditText kichThuoc = findViewById(R.id.edt_kich_thuoc);
        EditText manHinh = findViewById(R.id.edt_man_hinh);
        EditText chip = findViewById(R.id.edt_chip);
        EditText ram = findViewById(R.id.edt_ram);

        btnAdd.setOnClickListener(v -> {
            MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this);
            LaptopRepo repo = new LaptopRepo(sqLiteHelper);

            Laptop laptop = new Laptop(0, ten.getText().toString(), loai.getText().toString(), Integer.parseInt(giaTri.getText().toString()),
                    kichThuoc.getText().toString(), manHinh.getText().toString(), chip.getText().toString(), ram.getText().toString());
            repo.add(laptop);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}