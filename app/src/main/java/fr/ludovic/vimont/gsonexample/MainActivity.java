package fr.ludovic.vimont.gsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Gson gson = new Gson();
    private ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = (ListView) findViewById(R.id.book_list);
        bookList.setAdapter(new BookAdapter(getApplicationContext(), buildBooksList()));
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
            Log.e("readJSONFile", e.getMessage());
        }
        return result;
    }
}