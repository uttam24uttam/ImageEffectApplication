// package com.iiitb.imageEffectApplication.effectImplementation;  

// import com.iiitb.imageEffectApplication.service.LoggingService;
// import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
// import com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface;
// import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
// import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// public class HueSaturationEffect implements ParameterizableEffect{
//     private float val = 0.0f;
//     loggingService.addLog(imageName, "HueSaturation", "hueAmount:" + Float.toString(hueAmount) + " saturationAmount:" + Float.toString(saturationAmount));

//     public Pixel[][] apply(Pixel[][] image, float hueval, float satval){
//         return HueSaturationInterface.HueSaturationImageEffect(image, hueval, satval);
//     }

//     public void setParameter(String paramName, float value) throws IllegalParameterException{
//         if(paramName.equals("hueAmt")){
//             if(value>=0 && value<=100){
//                 val = value;
//             }
//             else{
//                 throw new IllegalParameterException();
//             }
//         }
//         else if(paramName.equals("satAmt")){
//             if(value>=0 && value<=100){
//                 val = value;
//             }
//             else{
//                 throw new IllegalParameterException();
//             }
//         }
//         else{
//             throw new IllegalParameterException();
//         }
//     }                 
// }
package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel; 
import com.iiitb.imageEffectApplication.libraryInterfaces.HueSaturationInterface;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class HueSaturationEffect implements ParameterizableEffect{
    private float hueval, satval;
    @Override
    public Pixel[][] apply(Pixel[][] image, String filename, LoggingService loggingService){
      //  LoggingService loggingService = ...; // Instantiate or inject your LoggingService
     //   String imageName;
        loggingService.addLog(filename, "HueSaturation", "hueAmount:" + Float.toString(hueval) + " saturationAmount:" + Float.toString(satval));
        return HueSaturationInterface.applyHueSaturation(image, satval, hueval);
    }

    @Override
    public void setParameter(String paramName, float value) throws IllegalParameterException{
        if(paramName.equals("hueAmt")){
            if(value>=0 && value<=100){
                this.hueval = value;
            }
            else{ 
                throw new IllegalParameterException();
            }
        }
        else if(paramName.equals("satAmt")){
            if(value>=0 && value<=100){
                this.satval = value;
            }
            else{
                throw new IllegalParameterException();
            }
        }
        else{
            throw new IllegalParameterException();
        }
    }                 
}
