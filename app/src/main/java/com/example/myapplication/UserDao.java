//package com.example.myapplication;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.Query;
//import android.arch.persistence.room.Transaction;
//
//import java.util.List;
//
////@Dao
//public interface UserDao {
//
//    @Query("Select * from user")
//    List<User> getAll();
//
////    @Transaction
//    @Query("select * from user where login = :m limit 1")
//    User FindByLogin(int m);
//
//    @Insert
//    void save(User user);
//
//}
