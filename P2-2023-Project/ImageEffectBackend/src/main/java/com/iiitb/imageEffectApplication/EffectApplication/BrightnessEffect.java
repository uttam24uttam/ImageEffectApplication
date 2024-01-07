// package com.iiitb.imageEffectApplication.EffectImplementations;

// import com.iiitb.imageEffectApplication.service.LoggingService;
// import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
// import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
// import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
// import com.iiitb.imageEffectApplication.exception.IllegalParameterException;


// public class BrightnessEffect implements SingleValueParameterizableEffect{
//     private float value = 0;
//     public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
//         loggingService.addLog(fileName, "Brightness", Float.toString(value));

//         public void addLog(String fileName, String effectName, String optionValues) {
//         return BrightnessInterface.applyBrightness(image,value);

//     }
//     public void setParameterValue(float v) throws IllegalParameterException{
//         if(v >=0 && v <=255){
//             value = v;
//         }
//         else{
//             throw new IllegalParameterException();
//         }
//     }
// }
package com.iiitb.imageEffectApplication.EffectApplication;

import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class BrightnessEffect implements SingleValueParameterizableEffect {
    private float value = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Brightness", Float.toString(value));
        return BrightnessInterface.applyBrightness(image, value);
    }

    public void setParameterValue(float v) throws IllegalParameterException {
        if (v >= 0 && v <= 255) {
            value = v;
        } else {
            throw new IllegalParameterException();
        }
    }
}


