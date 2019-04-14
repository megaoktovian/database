package com.example.mahasiswapc.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahasiswapc.database.Adapter.Adapter;
import com.example.mahasiswapc.database.Presenter.Presenter;
import com.example.mahasiswapc.database.entity.AppDatabase;
import com.example.mahasiswapc.database.entity.sekolah;
import com.example.mahasiswapc.database.ui.main.Main2Activity;
import com.example.mahasiswapc.database.ui.main.MainContact;

public class Edit_data extends AppCompatActivity implements MainContact.view {
    private AppDatabase appDatabase;
    private Presenter presenter;
    private Adapter adapter;
    private EditText ET1, ET2, ET3, ET4;
    private Button btn1;
    private String SET_1, SET_2, SET_3, SET_4;
    private boolean edit = false;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ET1 = findViewById(R.id.et_nama);
        ET2 = findViewById(R.id.et_alamat);
        ET3 = findViewById(R.id.et_siswa);
        ET4 = findViewById(R.id.et_guru);
        btn1 = findViewById(R.id.btn_submit);
        presenter = new Presenter(this);
        appDatabase = AppDatabase.iniDb(getApplicationContext());
        SET_1 = getIntent().getStringExtra("nama");
        SET_2 = getIntent().getStringExtra("alamat");
        SET_3 = getIntent().getStringExtra("siswa");
        SET_4 = getIntent().getStringExtra("guru");
        id = getIntent().getIntExtra("id", 99);
        ET1.setText(SET_1);
        ET2.setText(SET_2);
        ET3.setText(SET_3);
        ET4.setText(SET_4);
        btn1.setOnClickListener(this);
    }

    @Override
    public void resetForm() {
        ET1.setText("");
        ET2.setText("");
        ET3.setText("");
        ET4.setText("");
        btn1.setText("Submit");
    }

    @Override
    public void sukses() {
        Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
    }

    @Override
    public void editData(sekolah item) {
        ET1.setText(item.getName());
        ET2.setText(item.getAddress());
        ET3.setText(item.getSiswa());
        ET4.setText(item.getGuru());
        edit = true;
        btn1.setText("Update");
    }

    @Override
    public void onClick(View v) {
        String schoolname,schooladdress,student,teacher;
        schoolname = ET1.getText().toString();
        schooladdress = ET2.getText().toString();
        student = ET3.getText().toString();
        teacher = ET4.getText().toString();
        if(v ==  btn1){
            if(schoolname.equals("") || schooladdress.equals("") || student.equals("") || teacher.equals("")) {
                Toast.makeText(this, "Harap isi semua data!!", Toast.LENGTH_SHORT).show();
            } else {

                presenter.editData(schoolname, schooladdress, student, teacher, id, appDatabase);
                edit = false;
            }
            resetForm();
        }
    }
}


