package com.Maktaba.MyBooks.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OperationDao {


    @Insert
    void Insertdata(ModelOfTable modelOfTable);

    @Delete
    void Deletedata(ModelOfTable modelOfTable);

@Query("select * from ModelOfTable ")
   List<ModelOfTable> getalll();


//
//    @Query("DELETE  FROM ModelOfTable")
//    void deleteall();
}
