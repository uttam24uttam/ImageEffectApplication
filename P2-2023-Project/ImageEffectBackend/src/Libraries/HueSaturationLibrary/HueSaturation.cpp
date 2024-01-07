#include "HueSaturation.h"
#include <bits/stdc++.h>
#include "../Pixel.h"

using namespace std; 

// Function to apply Hue shift and Saturation to an image represented by a 2D vector of Pixels
void HueSaturationImageEffect(vector<vector<Pixel>>& imageVector, float sval, float hval){
    //Calculating hue angle and saturation factor
    float hang = (hval/100)*360 - 180;
    float sfactor = sval/100;
    for(auto& row : imageVector){
        for(auto& pix : row){
            //Identifying r,g and b values 
            float r = pix.r/255.0f;
            float g = pix.g/255.0f;
            float b = pix.b/255.0f;
            //Calculating max and min rgb value
            float hmax;
            float hmin;
            if(pix.r > pix.g && pix.r > pix.b){
                hmax = r;
            }
            else if(pix.g > pix.b){
                hmax = g;
            }
            else{
                hmax = b;
            }

            if(pix.r < pix.g && pix.r < pix.b){
                hmin = r;
            }
            else if(pix.g < pix.b){
                hmin = g;
            }
            else{
                hmin = b;
            }
            //Calculatinf luminosity value
            float lum = hmax - hmin;
            float hue = 0.0f;
            //Calculating hue
            if(lum != 0){
                if(hmax == r){
                    hue = 60*fmodf((g-b)/lum,6.0f);
                }
                else if(hmax == g){
                    hue = 60*(2.0f + (b-r)/lum);
                }
                else{
                    hue = 60*(4.0f + (r-g)/lum);
                }
            }

            else{
                hue = hue + 360.0f;
            }

            float nhue = hue + hang;
            if(nhue<0.0f){
                nhue = nhue + 360.0f;
            }
            
            //Calulating saturation
            float lightness = (hmax + hmin) / 2.0f;
            float sat = 0.0f;
            if(lightness>0.5f){
                sat = lum/(2.0f-hmax-hmin);
            }
            else{
                sat = lum/(hmax+hmin);
            }

            float nsat = sat * sfactor;

            float chroma = (1.0f - fabsf((2.0f * lum - 1.0f))) * nsat;
            float imm_val = chroma * (1.0f - fabsf(fmodf(nhue/60.0f, 2.0f) - 1.0f));
            float shade = lightness - chroma/2.0f;

            float mod_r = 0.0f;
            float mod_g = 0.0f;
            float mod_b = 0.0f;

            if(nhue >=0.0f && nhue<60.0f){
                mod_r = chroma;
                mod_g = imm_val;
                mod_b = 0.0f;
            }

            else if(nhue>=60.0f && nhue<120.0f){
                mod_r = imm_val;
                mod_g = chroma;
                mod_b = 0.0f;
            }

            else if(nhue>=120.0f && nhue<180.0f){
                mod_r = 0.0f;
                mod_g = chroma;
                mod_b = imm_val;
            }

            else if(nhue>=180.0f && nhue<240.0f){
                mod_r = 0.0f;
                mod_g = imm_val;
                mod_b = chroma;
            }

            else if(nhue>=240.0f && nhue<300.0f){
                mod_b = chroma;
                mod_g = 0.0f;
                mod_r = imm_val;
            }

            else if(nhue>=300.0f && nhue<360.0f){
                mod_b = imm_val;
                mod_g = 0.0f;
                mod_r = chroma;
            }

            float fin_r = (mod_r + shade)*255.0f;
            float fin_g = (mod_g + shade)*255.0f;
            float fin_b = (mod_b + shade)*255.0f;

            pix.r = max(0.0f,min(255.0f, fin_r));
            pix.g = max(0.0f,min(255.0f, fin_g));
            pix.b = max(0.0f,min(255.0f, fin_b));

        }
    }
}