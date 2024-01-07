
package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class RotationEffect implements DiscreteEffect {
    private int variable = 0;
    @Override
    public Pixel[][] apply(Pixel[][] inputImage, String imageName, LoggingService loggingService) {
        loggingService.addLog(imageName, "Rotation", Integer.toString(variable));
        return RotationInterface.applyRotation(inputImage, 90);
    }
    @Override
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        if (optionName.equals("Rotation")) {
            variable = value;
        } else {
            throw new IllegalParameterException();
        }
    }
}
