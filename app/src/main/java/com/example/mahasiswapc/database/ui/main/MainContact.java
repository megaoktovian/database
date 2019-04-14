package com.example.mahasiswapc.database.ui.main;

import android.view.View;

import com.example.mahasiswapc.database.entity.AppDatabase;
import com.example.mahasiswapc.database.entity.sekolah;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener{
        void resetForm();
        void sukses();
        void editData(sekolah item);
    }
    interface datapresenter{
        void editData(String jml_siswa, String jml_guru, String nama_sekolah, String alamat, int id, AppDatabase database);
        void deleteData(sekolah dataDiri, AppDatabase database);
    }
    interface Cetak extends View.OnClickListener{
        void getData(List<sekolah> list);
    }
    interface hapus{
        void sukses();
        void deleteData(sekolah item);
    }
}

