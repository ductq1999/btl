package com.ptit.btl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.ptit.btl.helper.MySQLiteHelper;
import com.ptit.btl.model.Hang;
import com.ptit.btl.repository.HangRepo;

public class UpdateHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hang);

        EditText ten = findViewById(R.id.edt_ten_hang);
        EditText danhGia = findViewById(R.id.edt_danh_gia_hang);
        Button btn = findViewById(R.id.btn_update_hang);

        Hang hang = (Hang) getIntent().getExtras().get(HomeActivity.EXTRA_KEY);

        ten.setText(hang.getTen());
        danhGia.setText(hang.getDanhGia());



        btn.setOnClickListener(v -> {
            MySQLiteHelper sqLiteHelper = new MySQLiteHelper(this);
            HangRepo repo = new HangRepo(sqLiteHelper);

            Hang hang1 = new Hang(hang.getId(),
                    ten.getText().toString(), danhGia.getText().toString());
            repo.update(hang1);

            Intent intent = new Intent(this, HomeHangActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
