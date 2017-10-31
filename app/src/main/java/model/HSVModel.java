package model;

import java.util.Observable;

/**
 * Created by rileygriffith on 2017-10-25.
 */

public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final Integer MAX_HUE = 359;
    public static final Integer MAX_BRIGHTNESS = 100;
    public static final Integer MAX_SATURATION = 100;

    public static final Integer MIN_HUE = 0;
    public static final Integer MIN_BRIGHTNESS = 0;
    public static final Integer MIN_SATURATION = 0;

    // INSTANCE VARIABLES
    private Integer hue;
    private Integer brightness;
    private Integer saturation;

    //Getters
    public Integer getHue() {
        return hue;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public Integer getSaturation() {
        return saturation;
    }

    //Setters
    public void setHue(Integer hue) {
        this.hue = hue;
        this.updateObservers();
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
        this.updateObservers();
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;
        this.updateObservers();
    }


    //set default values
    public HSVModel() {
        this(MIN_HUE, MIN_BRIGHTNESS, MAX_SATURATION);
    }


    public HSVModel(Integer hue, Integer brightness, Integer saturation) {
        super();

        this.hue = hue;
        this.brightness = brightness;
        this.saturation = saturation;
    }


    // Convenient setter: set H, B, S
    public void setHSV(Integer hue, Integer brightness, Integer saturation) {
        this.hue = hue;
        this.brightness = brightness;
        this.saturation = saturation;

        this.updateObservers();
    }

    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {
        return "HSV [h=" + hue + " b=" + brightness + " s=" + saturation + "]";
    }
}
