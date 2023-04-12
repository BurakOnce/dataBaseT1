package com.burakonce.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try{

            val veritabani = this.openOrCreateDatabase("Players", MODE_PRIVATE,null )
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY, name VARCHAR, value INT)" )

            //veritabani.execSQL("INSERT INTO players (name ,value) VALUES ('Burak Once', 96)")
            //veritabani.execSQL("INSERT INTO players (name ,value) VALUES ('Emirhan Simsek', 94)")
            //veritabani.execSQL("INSERT INTO players (name ,value) VALUES ('Muhammed Emin Ay', 92)")
            //veritabani.execSQL("INSERT INTO players (name ,value) VALUES ('Ufuk Reis', 94)")

            //veritabani.execSQL("DELETE FROM players WHERE id=4") id si 4 olanı siler
            //veritabani.execSQL("UPDATE players SET value = 95 WHERE value=94")  valuesi 94 olanın valuesini 95 yapar
            //veritabani.execSQL("UPDATE players SET name='Emin Ay' WHERE name='Muhammed Emin Ay'")   ismi değiştirme

            val cursor = veritabani.rawQuery("SELECT * FROM players",null) //En basidi hepsini çağırır

            //val cursor = veritabani.rawQuery("SELECT * FROM players WHERE value = 94",null) valuesi 94 olanları çağırır
            //val cursor = veritabani.rawQuery("SELECT * FROM players WHERE name = 'Muhammed Emin Ay'",null)

            //val cursor = veritabani.rawQuery("SELECT * FROM players WHERE name LIKE 'E%'",null) E ile başlayanları
            //val cursor = veritabani.rawQuery("SELECT * FROM players WHERE name LIKE '%e'",null) e ile bitenleri

            //val cursor = veritabani.rawQuery("SELECT * FROM players WHERE id = 1",null)

            val idColumnIndex = cursor.getColumnIndex("id")
            val nameColumnIndex= cursor.getColumnIndex("name")
            val valueColumnIndex= cursor.getColumnIndex("value")

            while(cursor.moveToNext()){

                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("Name : ${cursor.getString(nameColumnIndex)}")
                println("Value : ${cursor.getInt(valueColumnIndex)}")
            }

            cursor.close()

        }catch (e : Exception){
            e.printStackTrace()
        }


    }
}