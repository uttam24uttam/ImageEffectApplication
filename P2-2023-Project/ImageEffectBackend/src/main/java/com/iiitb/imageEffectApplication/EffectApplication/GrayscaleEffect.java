package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;

public class GrayscaleEffect implements PhotoEffect {

    // private final LoggingService loggingService;
    // private final String fileName;

    // public GrayscaleEffect(LoggingService loggingService, String fileName) {
    //     this.loggingService = loggingService;
    //     this.fileName = fileName;
    //}

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Grayscale", "");
        return GrayscaleInterface.applyGrayscale(image);
    }
}
