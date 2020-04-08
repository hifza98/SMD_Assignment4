package com.example.customcontacts

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import java.util.ArrayList

class Datbase_Helper(context: Context?) : SQLiteOpenHelper(context, "Contacts.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("Create table Contacts(first_name text, last_name text, contact_number text, email_address text primary key)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("Drop table if exists Contacts")
        onCreate(db)
    }

    //inserting in database
    fun insert(fname: String, lname: String, number: String, mail: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("first_name", fname)
        contentValues.put("last_name", lname)
        contentValues.put("contact_number", number)
        contentValues.put("email_address", mail)
        val ins = db.insert("Contacts", null, contentValues)
        return true
    }

    //checking if contact name exists
    // public boolean checkmail(String mail)
    // {
    //    SQLiteDatabase db=this.getReadableDatabase();
    //   Cursor cursor=db.rawQuery("Select * from Contacts where mail=?",new String[] {mail} );
    //   if (cursor.getCount()>0) return false;
    //   else return true;
    //}
    internal fun ReadContact(): List<Contacts> {
        val listContact = ArrayList<Contacts>()
        val selectQuery = "Select * from Contacts"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        db.execSQL(selectQuery)
        var firstName: String
        var lastName: String
        var number: String
        var mail: String
        if (cursor.moveToFirst()) {
            do {
                firstName = cursor.getString(cursor.getColumnIndex("first_name"))
                lastName = cursor.getString(cursor.getColumnIndex("last_name"))
                number = cursor.getString(cursor.getColumnIndex("contact_number"))
                mail = cursor.getString(cursor.getColumnIndex("email_address"))
                //image = cursor.getBlob(cursor.getColumnIndex("image"))
                val contact = Contacts(firstName, lastName, number, mail)
                listContact.add(contact)
            } while (cursor.moveToNext())
        }
        return listContact

    }
}