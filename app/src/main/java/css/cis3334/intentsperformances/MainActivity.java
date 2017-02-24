package css.cis3334.intentsperformances;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    Button btn1Web, but1Calendar, btn1Map;
    TextView textViewStatus;

    Button btn2Web, but2Calendar, btn2Map;
    Button btn3Web, but3Calendar, btn3Map;
    TextView textViewStatus2, textViewStatus3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        textViewStatus2 = (TextView) findViewById(R.id.textViewStatus2);
        textViewStatus3 = (TextView) findViewById(R.id.textViewStatus3);
        setupButtonClickEvents();



    }


    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Web = (Button) findViewById(R.id.button1WebInfo);
        btn1Web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Uri webpage = Uri.parse("http://www.css.edu/about/news-center/calendar-of-events.html?trumbaEmbed=view%3devent%26eventid%3d122420167");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                textViewStatus.setText("Code should display website for performance 1");
            }
        });

        /**
         *   Set up button click event listener for the celendar button for the first performance
         *       Use the calendar intent to set an event reminder on the calendar
         */
        but1Calendar = (Button) findViewById(R.id.button1Calendar);
        but1Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                textViewStatus.setText("Code should set a calendar event for performance 1");
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "SAL Colloquium 'The Robot Next Door'");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Tower Hall 4119");
                GregorianCalendar begDate = new GregorianCalendar(2017, 2, 24, 15, 40);
                GregorianCalendar endDate = new GregorianCalendar(2017, 2, 24, 16, 40);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                if (calIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(calIntent);
                }

            }
        });

        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Map = (Button) findViewById(R.id.button1map);
        btn1Map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Uri uri = Uri.parse("geo:46.81612, -92.10624");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                textViewStatus.setText("Code should display map for performance 1");
            }
        });

        //btn2Web = (Button) findViewById(R.id.button2WebInfo);
        //btn2Web.setOnClickListener();

    }

    //http://www.css.edu/about/news-center/calendar-of-events.html?trumbaEmbed=view%3devent%26eventid%3d119983186  choirsathome
    //http://www.css.edu/about/news-center/calendar-of-events.html?trumbaEmbed=view%3devent%26eventid%3d119980577  choralproject
}
