package fr.ludovic.vimont.gsonexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Book> books;

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.book_row, parent, false);
        }

        Book currentBook = books.get(position);

        final ImageView bookCover = (ImageView) convertView.findViewById(R.id.book_cover);
        try {
            bookCover.setImageDrawable(Drawable.createFromStream(context.getAssets().open(currentBook.getCover()), null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final TextView bookTitle = (TextView) convertView.findViewById(R.id.book_title);
        bookTitle.setText(currentBook.getName());

        final TextView bookAuthor = (TextView) convertView.findViewById(R.id.book_author);
        bookAuthor.setText(currentBook.getAuthor());

        final TextView bookDate = (TextView) convertView.findViewById(R.id.book_date);
        bookDate.setText(currentBook.getReleaseDate());

        return convertView;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
