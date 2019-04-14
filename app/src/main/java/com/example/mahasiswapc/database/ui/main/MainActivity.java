package com.example.mahasiswapc.database.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahasiswapc.database.R;
import com.example.mahasiswapc.database.entity.AppDatabase;
import com.example.mahasiswapc.database.entity.sekolah;

public class MainActivity extends AppCompatActivity {
    private EditText ET_1, ET_2, ET_3, ET_4;
    private Button btn_1, btn_2;
    private String SET_1, SET_2, SET_3, SET_4;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_1 = findViewById(R.id.et_nama);
        ET_2 = findViewById(R.id.et_alamat);
        ET_3 = findViewById(R.id.et_siswa);
        ET_4 = findViewById(R.id.et_guru);
        btn_1 = findViewById(R.id.btn_submit);
        btn_2 = findViewById(R.id.btn_lihat);
        appDatabase = AppDatabase.iniDb(getApplicationContext());
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input();
                Intent x = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(x);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(x);
            }
        });
    }
    public void input(){
        SET_1 = ET_1.getText().toString();
        SET_2 = ET_2.getText().toString();
        SET_3 = ET_3.getText().toString();
        SET_4 = ET_4.getText().toString();
        final sekolah dataSekolah = new sekolah();
        dataSekolah.setName(SET_1);
        dataSekolah.setAddress(SET_2);
        dataSekolah.setSiswa(SET_3);
        dataSekolah.setGuru(SET_4);

        new InsertData(appDatabase, dataSekolah).execute();
    }
    class InsertData extends AsyncTask<Void, Void, Long> {
        private AppDatabase database;
        private sekolah dataSekolah;

        public InsertData(AppDatabase database, sekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return database.dao().insertData(dataSekolah);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

        }

    }

}
