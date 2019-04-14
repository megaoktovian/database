package com.example.mahasiswapc.database.Presenter;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mahasiswapc.database.entity.AppDatabase;
import com.example.mahasiswapc.database.entity.sekolah;
import com.example.mahasiswapc.database.ui.main.MainContact;

import java.util.List;

public class Presenter implements MainContact.datapresenter {
    MainContact.view view;
    MainContact.hapus viewH;
    public Presenter(MainContact.view view) {
        this.view = view;
    }

    public Presenter(MainContact.hapus viewH) {
        this.viewH = viewH;
    }

    class EditData extends AsyncTask<Void, Void, Integer> {
        private AppDatabase database;
        private sekolah dataSekolah;
        public EditData(AppDatabase database, sekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return database.dao().updateData(dataSekolah);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("integer db", "onPostExecute: " + integer);
            view.sukses();
        }
    }

    @Override
    public void editData(String nama, String address, String siswa, String guru, int id, AppDatabase database) {
        final sekolah dataSekolah = new sekolah();
        dataSekolah.setName(nama);
        dataSekolah.setAddress(address);
        dataSekolah.setSiswa(siswa);
        dataSekolah.setGuru(guru);
        dataSekolah.setId(id);
        new EditData(database, dataSekolah).execute();
    }
    class DeleteData extends AsyncTask<Void, Void, Void>{
        private AppDatabase database;
        private sekolah dataSekolah;
        Context context;
        public DeleteData(AppDatabase database, sekolah dataSekolah) {
            this.database = database;
            this.dataSekolah = dataSekolah;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(dataSekolah);
            return  null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewH.sukses();
        }

    }
    @Override
    public void deleteData(sekolah dataSekolah, AppDatabase database) {
        new DeleteData(database,dataSekolah).execute();
    }
}
