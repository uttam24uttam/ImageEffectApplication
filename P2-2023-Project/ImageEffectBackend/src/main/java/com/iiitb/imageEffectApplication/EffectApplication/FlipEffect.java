// package com.iiitb.imageEffectApplication.EffectImplementations;

// import com.iiitb.imageEffectApplication.service.LoggingService;
// import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
// import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
// import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;
// import com.iiitb.imageEffectApplication.exception.IllegalParameterException;


// public class FlipEffect implements DiscreteEffect{
//     private int v = 0,h=0;

//     loggingService.addLog(fileName, "Flip", parameter);

//     public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
//         return FlipInterface.applyFlip(image,h,v);
//     }
// //public interface DiscreteEffect extends PhotoEffect { 
//     public void selectOptionValue(String optionName, int value) throws IllegalParameterException{
//         if(optionName.equals("Horizontal")){
//             if(value == 1 || value == 0){
//               h=value;}}
//         else if(optionName.equals("Vertical")){
//             if(value == 1 || value == 0){
//               v=value;}}      

//         else
//             throw new IllegalParameterException();

//     }
// }    
        
package com.iiitb.imageEffectApplication.EffectApplication;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class FlipEffect implements DiscreteEffect {
    private int horizontal = 0;
    private int vertical = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        String parameter = "";
        if (horizontal == 1 && vertical == 1) {
            parameter = "Both";
        } else if (horizontal == 1) {
            parameter = "Horizontal";
        } else if (vertical == 1) {
            parameter = "Vertical";
        }
        
        loggingService.addLog(fileName, "Flip", parameter);
        return FlipInterface.applyFlip(image, horizontal, vertical);
    }

    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        if (optionName.equals("Horizontal")) {
            if (value == 1 || value == 0) {
                horizontal = value;
            }
            else{
                throw new IllegalParameterException();
            }
        } else if (optionName.equals("Vertical")) {
            if (value == 1 || value == 0) {
                vertical = value;
            }
            else{
                throw new IllegalParameterException();
            }
        } else {
            throw new IllegalParameterException();
        }
    }
}



