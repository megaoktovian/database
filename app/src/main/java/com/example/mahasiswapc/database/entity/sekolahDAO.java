package com.example.mahasiswapc.database.entity;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

@Dao
public interface sekolahDAO {
    @Insert
    Long insertData(sekolah Sekolah);

    @Query("Select * from user_db")
    List<sekolah> getData();

    @Update
    int updateData(sekolah item);

    @Delete
    void deleteData(sekolah item);
}
