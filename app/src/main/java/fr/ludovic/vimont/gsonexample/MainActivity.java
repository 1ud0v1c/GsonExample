package fr.ludovic.vimont.gsonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = (ListView) findViewById(R.id.book_list);
        bookList.setAdapter(new BookAdapter(getApplicationContext(), buildBooksList()));
    }

    private ArrayList<Book> buildBooksList() {
        ArrayList<Book> books = ;
        return books;
    }

    public String readJSONFile(String filename) {
        String result = new String();
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