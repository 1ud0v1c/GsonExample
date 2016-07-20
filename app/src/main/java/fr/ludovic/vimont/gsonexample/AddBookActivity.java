package fr.ludovic.vimont.gsonexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBookActivity extends AppCompatActivity implements View.OnClickListener {
    private String imageURL;
    private TextView showErrors;
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

        showErrors = (TextView) findViewById(R.id.errors);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_image:
                buildWebView();
                break;

            case R.id.validate_book:
                String errors = "";
                if(bookName.getText() == null || bookName.getText().toString().length() == 0) {
                    errors += "Veuillez saisir un nom pour le livre...\n";
                }
                if(bookAuthor.getText() == null || bookAuthor.getText().toString().length() == 0) {
                    errors += "Veuillez saisir un auteur pour le livre...\n";
                }
                if(bookDate.getText() == null || bookDate.getText().toString().length() == 0) {
                    errors += "Veuillez saisir la date de 1ère parution du livre...\n";
                }
                if(imageURL == null) {
                    errors += "Veuillez sélectionner une image...\n";
                }

                if(errors.length() <= 1) {
                    Book newBook = new Book(StringUtils.generateID(), bookName.getText().toString(), bookAuthor.getText().toString(), bookDate.getText().toString(), imageURL);
                    Intent intent = new Intent(AddBookActivity.this, MainActivity.class);
                    intent.putExtra("newBook", newBook);
                    startActivity(intent);
                } else {
                    showErrors.setText(errors);
                    errors = "";
                }
                break;

            default:
                break;
        }
    }

    private void buildWebView() {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Search image cover");
        alertBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        final WebView wv = new WebView(this);
        wv.loadUrl("https://www.google.fr/search?site=imghp&tbm=isch&q=" + bookName.getText());
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url != null) {
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        });

        alertBuilder.setView(wv);
        final AlertDialog alert = alertBuilder.create();

        wv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                WebView.HitTestResult hr = ((WebView)v).getHitTestResult();
                imageURL = hr.getExtra();
                if(StringUtils.isAnImageURL(imageURL)) alert.dismiss();
                return false;
            }
        });

        alert.show();
    }
}
