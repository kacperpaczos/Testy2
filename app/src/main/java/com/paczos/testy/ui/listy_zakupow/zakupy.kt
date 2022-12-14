package com.paczos.testy.ui.listy_zakupow

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.paczos.testy.R


class zakupy : AppCompatActivity() {

    // on below line we are
    // creating variables for listview
    lateinit var programmingLanguagesLV: ListView

    // creating array adapter for listview
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var programmingLanguagesList: ArrayList<String>;

    // creating variable for searchview
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zakupy)

        // initializing variables of list view with their ids.
        programmingLanguagesLV = findViewById(R.id.idLVProgrammingLanguages)
        searchView = findViewById(R.id.idSV)

        // initializing list and adding data to list
        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add("C")
        programmingLanguagesList.add("C#")
        programmingLanguagesList.add("Java")
        programmingLanguagesList.add("Javascript")
        programmingLanguagesList.add("Python")
        programmingLanguagesList.add("Dart")
        programmingLanguagesList.add("Kotlin")
        programmingLanguagesList.add("Typescript")

        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )

        // on below line setting list
        // adapter to our list view.
        Log.i("testTag","set adapter");
        programmingLanguagesLV.adapter = listAdapter

        programmingLanguagesLV.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
            //val intent = Intent(this@zakupy, SendMessage::class.java)
            //val message = "abc"
            //intent.putExtra(EXTRA_MESSAGE, message)
            //startActivity(intent)
            Log.i("Klik", position.toString());
        })
        // on below line we are adding on query
        // listener for our search view.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (programmingLanguagesList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@zakupy, "No Language found..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }

}