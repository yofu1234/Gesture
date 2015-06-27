package com.thenewboston.gesture;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {

    private TextView buckysMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buckysMessage = (TextView)findViewById(R.id.buckysMessage);
        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    ///////////////////////////Begin Gestures///////////////////////////////////


    @Override  //You need to Override onTouchEvent. onTouchEvent is the default method called when user touches the screen.
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event); //we want it to detect if the touch is a gesture first
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        buckysMessage.setText("onSingleTapConfirmed");
        return true;  //return true says: touch event is taken care, event is handled of so it doesn't go back.
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        buckysMessage.setText("onDoubleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        buckysMessage.setText("onDoubleTapEventConfirmed");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        buckysMessage.setText("onDownConfirmed");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        buckysMessage.setText("onShowPressConfirmed");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        buckysMessage.setText("onSingleTapUpConfirmed");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        buckysMessage.setText("onScrollConfirmed");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        buckysMessage.setText("onLongPressConfirmed");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        buckysMessage.setText("onFlingConfirmed");
        return true;
    }

    ///////////////////////////End Gestures///////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
