package ca.edumedia.rileygriffith.hsvcolorpicker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;

/**
 *  HSV Color Picker allows the picking and displaying of colours based upon inputted HSV colour values.
 *  @author Riley Griffith (grif0193@algonquinlive.com)
 */

public class MainActivity extends Activity implements Observer, SeekBar.OnSeekBarChangeListener {

    private static final String ABOUT_DIALOG_TAG = "About";

    private AboutDialogFragment mAboutDialog;
    private TextView mColorSwatch;
    private HSVModel mModel;

    private SeekBar mHueSB;
    private SeekBar mBrightnessSB;
    private SeekBar mSaturationSB;

    private TextView mHueTV;
    private TextView mBrightnessTV;
    private TextView mSaturationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAboutDialog = new AboutDialogFragment();

        mModel = new HSVModel();
        mModel.setHue(HSVModel.MIN_HUE);
        mModel.setBrightness(HSVModel.MIN_BRIGHTNESS);
        mModel.setSaturation(HSVModel.MAX_SATURATION);
        mModel.addObserver(this);

        // reference each View
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.hueSB);
        mBrightnessSB = (SeekBar) findViewById(R.id.brightnessSB);
        mSaturationSB = (SeekBar) findViewById(R.id.saturationSB);
        //reference the remaining <SeekBar>s: green, blue and alpha
        mHueTV = (TextView) findViewById(R.id.hue);
        mBrightnessTV = (TextView) findViewById(R.id.brightness);
        mSaturationTV = (TextView) findViewById(R.id.saturation);

        // set the domain (i.e. max) for each component
        mHueSB.setMax(HSVModel.MAX_HUE);
        mBrightnessSB.setMax(HSVModel.MAX_BRIGHTNESS);
        mSaturationSB.setMax(HSVModel.MAX_SATURATION);

        // register the event handler for each <SeekBar>
        mHueSB.setOnSeekBarChangeListener(this);
        mBrightnessSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);

        //set the toast message
        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                Context c = getApplicationContext();
                String stringH = Integer.toString(mModel.getHue());
                String stringS = Integer.toString(mModel.getSaturation());
                String stringB = Integer.toString(mModel.getBrightness());
                String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
                String message = stringInt;
                int duration = Toast.LENGTH_LONG;
                Toast t = Toast.makeText(c, message, duration);
                t.show();
                return true;
            }
        });

        // initialize the View to the values of the Model
        this.updateView();
    }

    public void asBlack(View button) {
        mModel.setBrightness(0);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asBlue(View button) {
        mModel.setHue(240);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asCyan(View button) {
        mModel.setHue(180);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asGreen(View button) {
        mModel.setHue(120);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asMagenta(View button) {
        mModel.setHue(300);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asRed(View button) {
        mModel.setHue(0);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asOlive(View button) {
        mModel.setHue(60);
        mModel.setBrightness(50);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asYellow(View button) {
        mModel.setHue(60);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asGray(View button) {
        mModel.setBrightness(50);
        mModel.setSaturation(0);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asMaroon(View button) {
        mModel.setHue(0);
        mModel.setBrightness(50);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asSilver(View button) {
        mModel.setBrightness(75);
        mModel.setSaturation(0);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asTeal(View button) {
        mModel.setHue(180);
        mModel.setBrightness(50);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asPurple(View button) {
        mModel.setHue(300);
        mModel.setBrightness(50);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asLime(View button) {
        mModel.setHue(120);
        mModel.setBrightness(100);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    public void asNavy(View button) {
        mModel.setHue(240);
        mModel.setBrightness(50);
        mModel.setSaturation(100);
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        Context c = getApplicationContext();
        String stringH = Integer.toString(mModel.getHue());
        String stringS = Integer.toString(mModel.getSaturation());
        String stringB = Integer.toString(mModel.getBrightness());
        String stringInt = "H:°" + stringH + "  S:" + stringS + "  B:" + stringB;
        String message = stringInt;
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(c, message, duration);
        t.show();

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.action_about:
                mAboutDialog.show(getFragmentManager(), ABOUT_DIALOG_TAG);
                return true;

            default:
                Toast.makeText(this, "MenuItem: " + item.getTitle(), Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if (fromUser == false) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mModel.setHue(mHueSB.getProgress());
                mHueTV.setText(getResources().getString(R.string.hueProgress, progress).toUpperCase());
                break;

            case R.id.brightnessSB:
                mModel.setBrightness(mBrightnessSB.getProgress());
                mBrightnessTV.setText(getResources().getString(R.string.brightnessProgress, progress).toUpperCase());
                break;

            case R.id.saturationSB:
                mModel.setSaturation(mSaturationSB.getProgress());
                mSaturationTV.setText(getResources().getString(R.string.saturationProgress, progress).toUpperCase());
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHueTV.setText(getResources().getString(R.string.hue));
                break;

            case R.id.brightnessSB:
                mBrightnessTV.setText(getResources().getString(R.string.brightness));
                break;

            case R.id.saturationSB:
                mSaturationTV.setText(getResources().getString(R.string.saturation));
                break;
        }
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    private void updateColorSwatch() {
        //GET the model's hsv values, and SET the background colour of the swatch <TextView>
        float hue = mModel.getHue();
        float saturation = mModel.getSaturation();
        float brightness = mModel.getBrightness();
        float[] hsv = new float[]{hue, (saturation / 100.f), (brightness / 100.f)};

        mColorSwatch.setBackgroundColor(Color.HSVToColor(hsv));
    }

    private void updateHueSB() {
        mHueSB.setProgress(mModel.getHue());
    }

    private void updateBrightnessSB() {
        mBrightnessSB.setProgress(mModel.getBrightness());
    }

    private void updateSaturationSB() {
        mSaturationSB.setProgress(mModel.getSaturation());
    }

    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateBrightnessSB();
        this.updateSaturationSB();
    }

}
