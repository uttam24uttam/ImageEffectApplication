package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.EffectApplication.BrightnessEffect;
import com.iiitb.imageEffectApplication.EffectApplication.FlipEffect;
import com.iiitb.imageEffectApplication.EffectApplication.GaussianBlurEffect;
import com.iiitb.imageEffectApplication.EffectApplication.GrayscaleEffect;
import com.iiitb.imageEffectApplication.EffectApplication.ContrastEffect;
import com.iiitb.imageEffectApplication.EffectApplication.InvertEffect;
import com.iiitb.imageEffectApplication.EffectApplication.RotationEffect;
import com.iiitb.imageEffectApplication.EffectApplication.HueSaturationEffect;
import com.iiitb.imageEffectApplication.EffectApplication.SepiaEffect;
import com.iiitb.imageEffectApplication.EffectApplication.SharpenEffect;
// import com.iiitb.imageEffectApplication.EffectImplementations.FlipEffect.java.com.iiitb.imageEffectApplication.Effectimplementations.GaussianBlurEffect;
// import com.iiitb.imageEffectApplication.effectImplementation.FlipEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            HueSaturationEffect huesaturation = new HueSaturationEffect();
            try{
                huesaturation.setParameter("hueAmt",hueAmount);
                huesaturation.setParameter("satAmt",saturationAmount);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 

            }
            //inputImage = huesaturation.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = huesaturation.apply(inputImage, imageName, loggingService); 


            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();




            // ACTUAL WORK STARTS HERE

            // TODO
            BrightnessEffect brightness = new BrightnessEffect();

            try{
                brightness.setParameterValue(amount);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            //inputImage = brightness.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = brightness.apply(inputImage, imageName, loggingService); 
     

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
           ContrastEffect object1 = new ContrastEffect();
            try{
                object1.setParameterValue(amount);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            //inputImage = object1.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = object1.apply(inputImage, imageName, loggingService); 
         // ACTUAL WORK ENDS HERE



        return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            GaussianBlurEffect blur = new GaussianBlurEffect();
            try{
                blur.setParameterValue(amount);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            //inputImage = blur.apply(inputImage, imageName, loggingService);

            Pixel[][] modifiedImage = blur.apply(inputImage, imageName, loggingService); 
     

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();



            // ACTUAL WORK STARTS HERE

            // TODO
            FlipEffect flip=new FlipEffect();
            try{
                flip.selectOptionValue("Horizontal",horizontalFlipValue);
                flip.selectOptionValue("Vertical",verticalFlipValue);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            
            //inputImage = flip.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = flip.apply(inputImage, imageName,loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
    //     try {
    //         Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
    //         String imageName = imageFile.getOriginalFilename();


    //         // ACTUAL WORK STARTS HERE

    //         // TODO
    //         Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

    //         // ACTUAL WORK ENDS HERE



    //         return processingUtils.postProcessing(modifiedImage);

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE

            // TODO
            GrayscaleEffect object1 = new GrayscaleEffect();
            //inputImage = object1.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = object1.apply(inputImage, imageName, loggingService);
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            InvertEffect object1 = new InvertEffect();
            //inputImage = object1.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = object1.apply(inputImage, imageName, loggingService);

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // public ResponseEntity<byte[]> applyInvertEffect(int value, MultipartFile imageFile) {
    //     try {
            
    //         Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
    //         String imageName = imageFile.getOriginalFilename();


    //         // ACTUAL WORK STARTS HERE

    //         // TODO
    //         InvertEffect object1 = new InvertEffect();
    //         Pixel[][] modifiedImage = object1.apply(inputImage, imageName, loggingService);

    //         // ACTUAL WORK ENDS HERE


    //         return processingUtils.postProcessing(modifiedImage);

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();


            // ACTUAL WORK STARTS HERE
            RotationEffect obj = new RotationEffect();
            try{
                obj.selectOptionValue("Rotation",value);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            inputImage = obj.apply(inputImage, imageName, loggingService);
            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            SepiaEffect obj1 = new SepiaEffect();
            //inputImage = obj1.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = obj1.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
           SharpenEffect object1 = new SharpenEffect();
            try{
                object1.setParameterValue(amount);
            }
            catch(IllegalParameterException e){
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            //
            inputImage = object1.apply(inputImage, imageName, loggingService);
            Pixel[][] modifiedImage = object1.apply(inputImage, imageName, loggingService); // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE
            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();

            // ACTUAL WORK STARTS HERE

            // TODO
            Pixel[][] modifiedImage = inputImage; // Replace this with actual modified image

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
