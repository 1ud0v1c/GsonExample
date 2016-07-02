package fr.ludovic.vimont.gsonexample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Gson gson = new Gson();
    private ListView bookList;
    private FloatingActionButton addBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = (ListView) findViewById(R.id.book_list);
        bookList.setAdapter(new BookAdapter(getApplicationContext(), buildBooksList()));

        addBook = (FloatingActionButton) findViewById(R.id.add_book);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Book> buildBooksList() {
        Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
        return gson.fromJson(readJSONFile("books.json"), listType);
    }

    private String readJSONFile(String filename) {
        String result = "";
        try {
            InputStream input_stream = getAssets().open(filename);

            byte[] b = new byte[input_stream.available()];
            input_stream.read(b);
            result = new String(b);
        } catch (Exception e) {
            Log.e("Error readJSONFile", e.getMessage());
        }
        return result;
    }
}