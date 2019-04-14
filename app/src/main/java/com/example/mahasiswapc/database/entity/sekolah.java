package com.example.mahasiswapc.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


    @Entity(tableName = "user_db")
    public class sekolah {
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        private int id ;

        @ColumnInfo(name = "sekolah")
        private String name;

        @ColumnInfo(name = "address")
        private String address;

        @ColumnInfo(name = "siswa")
        private String siswa;

        @ColumnInfo(name = "guru")
        private String guru;

        @NonNull
        public int getId() {
            return id;
        }

        public void setId(@NonNull int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String adress) {
            this.address = adress;
        }

        public String getSiswa() {
            return siswa;
        }

        public void setSiswa(String siswa) {
            this.siswa = siswa;
        }

        public String getGuru() {
            return guru;
        }

        public void setGuru(String guru) {
            this.guru = guru;
        }
}
