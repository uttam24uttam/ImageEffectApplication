// package com.iiitb.imageEffectApplication.effectImplementation;

// import com.iiitb.imageEffectApplication.service.LoggingService;
// import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
// import com.iiitb.imageEffectApplication.libraryInterfaces.RotaionInterface;
// import com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface;
// import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
// import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
// import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
// public class RotationEffect implements DiscreteEffect{
//     int variable = 0;
//     loggingService.addLog(fileName, "Rotation", Int.toString(value));

//     public Pixel[][] apply(Pixel [][]inputImage, String imageName,LoggingService loggingService){
//         return RotationInterface.applyRotation(inputImage,variable);
//     }
//     public void selectOptionValue(String optionName, int value) throws IllegalParameterException{
//         if (value instanceof Float){
//             throw new IllegalParameterException();
//         }
//         else{
//             variable = value;
//         }
//     }

// }

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
