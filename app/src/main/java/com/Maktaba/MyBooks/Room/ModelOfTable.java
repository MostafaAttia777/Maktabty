package com.Maktaba.MyBooks.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ModelOfTable")
public class ModelOfTable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "name_of_book")
    String name_of_book;
    @ColumnInfo(name = "link_of_book")
    String linl_of_book;
    @ColumnInfo(name = "image")
    int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_of_book() {
        return name_of_book;
    }

    public void setName_of_book(String name_of_book) {
        this.name_of_book = name_of_book;
    }

    public String getLinl_of_book() {
        return linl_of_book;
    }

    public void setLinl_of_book(String linl_of_book) {
        this.linl_of_book = linl_of_book;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ModelOfTable(String name_of_book, String linl_of_book, int image) {
        this.name_of_book = name_of_book;
        this.linl_of_book = linl_of_book;
        this.image = image;
    }
}
