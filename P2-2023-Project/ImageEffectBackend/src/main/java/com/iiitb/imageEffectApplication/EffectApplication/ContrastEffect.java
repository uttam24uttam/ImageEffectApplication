
package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class ContrastEffect implements SingleValueParameterizableEffect {
    private float variable = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Contrast", Float.toString(variable));
        return ContrastInterface.applyContrast(image, variable);
    }

    public void setParameterValue(float amount) throws IllegalParameterException {
        if (amount >= 0 && amount <= 255) {
            variable = amount;
        } else {
            throw new IllegalParameterException();
        }
    }
}
