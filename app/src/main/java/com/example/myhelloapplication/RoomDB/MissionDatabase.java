package com.example.myhelloapplication.RoomDB;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myhelloapplication.Model.LaunchDetail;
import com.example.myhelloapplication.RoomDB.Dao.MisssionDao;

@Database(entities = {LaunchDetail.class}, version = 6)
public abstract class MissionDatabase extends RoomDatabase {

    private static volatile MissionDatabase obj;
    public abstract MisssionDao misssionDao();


    public static synchronized MissionDatabase getInstance(Context context){
        if(obj ==null) {
            obj = Room.databaseBuilder(context.getApplicationContext(),
                            MissionDatabase.class, "Mission_Db")
                    .addCallback(callback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
            return obj;

    }


    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AsynTask(obj);
        }
    };
    static class AsynTask extends AsyncTask<Void,Void,Void>
    {
        private MisssionDao misssionDao;
        AsynTask(MissionDatabase actorDatabase)
        {
            misssionDao=actorDatabase.misssionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            misssionDao.deleteAll();
            return null;
        }
    }


}
