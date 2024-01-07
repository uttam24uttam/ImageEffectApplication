// package com.iiitb.imageEffectApplication.effectImplementation;

// import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
// import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
// import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
// import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
// import com.iiitb.imageEffectApplication.service.LoggingService;

// public class sharpenEffect implements SingleValueParameterizableEffect{
//     private float variable = 0;
//     loggingService.addLog(fileName, "Sharpen", Float.toString(value));
//     public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
//         return SharpenInterface.applySharpen(image,variable);
//     }
//     public void setParameterValue(float amount) throws IllegalParameterException{
//         if(amount >=0 && amount <=255){
//             variable = amount;
//         }
//         else{
//             throw new IllegalParameterException();
//         }
//     }
// }

package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SharpenInterface;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SharpenEffect implements SingleValueParameterizableEffect {
    private float value = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        loggingService.addLog(fileName, "Sharpen", Float.toString(value));
        return SharpenInterface.applySharpen(image, value);
    }

    public void setParameterValue(float amount) throws IllegalParameterException {
        if (amount >= 0 && amount <= 255) {
            value = amount;
        } else {
            throw new IllegalParameterException();
        }
    }
}
