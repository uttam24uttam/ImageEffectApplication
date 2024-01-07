
package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.GaussianBlurInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class GaussianBlurEffect implements SingleValueParameterizableEffect {
    private float value = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "GaussianBlur", Float.toString(value));
        return GaussianBlurInterface.applyGaussianBlur(image, value);
    }

    public void setParameterValue(float v) throws IllegalParameterException {
        if (v >= 0 && v <= 255) {
            value = v;
        } else {
            throw new IllegalParameterException();
        }
    }
}

