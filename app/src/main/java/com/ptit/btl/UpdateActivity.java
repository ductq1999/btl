package com.ptit.btl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Laptop;
import com.ptit.btl.repository.LaptopRepo;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText ten = findViewById(R.id.edt_ten);
        EditText loai = findViewById(R.id.edt_loai);
        EditText giaTri = findViewById(R.id.edt_gia_tri);
        EditText kichThuoc = findViewById(R.id.edt_kich_thuoc);
        EditText manHinh = findViewById(R.id.edt_man_hinh);
        EditText chip = findViewById(R.id.edt_chip);
        EditText ram = findViewById(R.id.edt_ram);
        Button btn = findViewById(R.id.btn_update_laptop);

        Laptop laptop = (Laptop) getIntent().getExtras().get(HomeActivity.EXTRA_KEY);

        ten.setText(laptop.getTen());
        loai.setText(laptop.getLoai());
        giaTri.setText(String.valueOf(laptop.getGiaTri()));
        kichThuoc.setText(String.valueOf(laptop.getKichThuoc()));
        manHinh.setText(laptop.getManHinh());
        chip.setText(laptop.getChip());
        ram.setText(laptop.getRam());


        btn.setOnClickListener(v -> {
            MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this);
            LaptopRepo repo = new LaptopRepo(sqLiteHelper);

            Laptop laptop1 = new Laptop(laptop.getId(),
                    ten.getText().toString(), loai.getText().toString(), Integer.parseInt(giaTri.getText().toString()),
                    Float.parseFloat(kichThuoc.getText().toString()), manHinh.getText().toString(), chip.getText().toString(), ram.getText().toString());
            repo.update(laptop1);

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }

}