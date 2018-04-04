package com.fbarrios.dev.movie.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.fbarrios.dev.movie.R;
import com.squareup.picasso.Picasso;

import static com.fbarrios.dev.movie.data.Constant.OVERVIEW;
import static com.fbarrios.dev.movie.data.Constant.POSTER_PATH;
import static com.fbarrios.dev.movie.data.Constant.TITLE;
import static com.fbarrios.dev.movie.data.Constant.URL_PATH;

public class DetailedActivity extends AppCompatActivity {

    private ImageView backDropImageView;
    private TextView overviewTextView;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        backDropImageView = findViewById(R.id.backDropImageView);
        overviewTextView = findViewById(R.id.overviewTextView);
        titleTextView = findViewById(R.id.titleTextView);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String title = bundle.getString(TITLE);
            String overview = bundle.getString(OVERVIEW);
            String poster = bundle.getString(POSTER_PATH);

            titleTextView.setText(title);
            overviewTextView.setText(overview);

            Picasso.get()
                    .load(URL_PATH + poster)
                    .fit()
                    .into(backDropImageView);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
