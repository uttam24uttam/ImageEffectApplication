package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;

public class GrayscaleEffect implements PhotoEffect {

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Grayscale", "");
        return GrayscaleInterface.applyGrayscale(image);
    }
}
