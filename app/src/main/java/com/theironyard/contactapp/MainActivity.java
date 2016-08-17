package com.theironyard.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> contacts;
    ListView list;
    EditText textName;
    EditText textPhone;
    Button addButton;
    // create variables for each of the controls

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView); // connect variables to views
        textName = (EditText) findViewById(R.id.editText);
        textPhone = (EditText) findViewById(R.id.editText2);
        addButton = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts); // connect listview

        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String item = textName.getText().toString() + " (" + textPhone.getText().toString() + ")";
        // put name and phone together
        contacts.add(item);
        textName.setText("");
        textPhone.setText("");
    }

    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String item = contacts.getItem(position);
        contacts.remove(item);
        return true;
    }
}
