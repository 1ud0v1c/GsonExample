package fr.ludovic.vimont.gsonexample;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView errors;
    private Button searchImage, validateBook;
    private EditText bookName, bookAuthor, bookDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        bookName = (EditText) findViewById(R.id.book_name);
        bookAuthor = (EditText) findViewById(R.id.book_author);
        bookDate = (EditText) findViewById(R.id.book_date);

        searchImage = (Button) findViewById(R.id.search_image);
        searchImage.setOnClickListener(this);

        validateBook = (Button) findViewById(R.id.validate_book);
        validateBook.setOnClickListener(this);

        errors = (TextView) findViewById(R.id.errors);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_image:
                buildWebView();
                break;

            case R.id.validate_book:
                break;

            default:
                break;
        }
    }

    private void buildWebView() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Search image cover");

        WebView wv = new WebView(this);
        wv.loadUrl("https://www.google.fr/search?site=imghp&tbm=isch&q=" + bookName.getText());
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        wv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                WebView.HitTestResult hr = ((WebView)v).getHitTestResult();
                String imageURL = hr.getExtra();
                return false;
            }
        });

        alert.setView(wv);
        alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        alert.show();
    }
}
