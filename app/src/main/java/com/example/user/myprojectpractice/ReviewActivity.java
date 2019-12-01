package com.example.user.myprojectpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {

    TextView RHTxt;
    EditText ResName;
    EditText ResReviw;
    RatingBar RaBar;
    TextView RaPoint;
    private Button BtnReview;

    //public static String CREDENTIAL = "Credential";
    //public static String RESNAME = "ResName";
    //public static String USERNAME = "UserName";
    //public static String RATING = "Rating";
    //public static String REVIEW = "Review";

    DataBaseCreate db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        RHTxt = (TextView) findViewById(R.id.ReviewPageTxt);
        ResName = (EditText) findViewById(R.id.ResNameET);
        ResReviw = (EditText) findViewById(R.id.ResReviewET);
        RaBar = (RatingBar) findViewById(R.id.RateBar);
        RaPoint = (TextView) findViewById(R.id.RatingPoint);
        BtnReview = (Button) findViewById(R.id.ReviewBtn);

        db = new DataBaseCreate(this);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra(LoginActivity.CREDENTIAL);
        final String userEmail = b.getString(LoginActivity.USEREMAIL);


        RaBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
                RaPoint.setText("Rating Point out of 5 is: " + rating);
            }
        });

        BtnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uName = db.getUserName(userEmail);
                String rName = ResName.getText().toString();
                String review = ResReviw.getText().toString();
                String rate = String.valueOf( RaBar.getRating());

                if(uName.isEmpty() || rName.isEmpty() || review.isEmpty() || rate.isEmpty())
                    Toast.makeText(getApplicationContext(),"Fill all field",Toast.LENGTH_SHORT).show();
                else{
                    db.addReview(rName, uName, review, rate);
                    Toast.makeText(getApplicationContext(),"Review Successfully Added!!!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ReviewActivity.this, MainActivity.class));
                    finish();
                }

            }
        });
    }
}
