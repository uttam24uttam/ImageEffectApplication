package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.InvertInterface;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;

public class InvertEffect implements PhotoEffect{
    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName, "Invert", "");
        return InvertInterface.applyInvert(image);
    } 
}