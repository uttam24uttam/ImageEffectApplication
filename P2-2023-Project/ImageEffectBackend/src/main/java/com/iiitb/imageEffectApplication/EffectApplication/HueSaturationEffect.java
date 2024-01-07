
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
