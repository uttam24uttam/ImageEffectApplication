#include "Contrast.h"
#include "../Pixel.h"
#include<bits/stdc++.h>
using namespace std;
void applyContrast(vector<vector<Pixel>> &imageVector, float amount){
    float factor = (259.0 * (amount + 255.0)) / (255.0 * (259.0 - amount));
    
    for(auto &row : imageVector){
        for(auto &element : row){
            element.r = static_cast<int>(clamp(factor * (element.r - 128) + 128, 0.0f, 255.0f));
            element.g = static_cast<int>(clamp(factor * (element.g - 128) + 128, 0.0f, 255.0f));
            element.b = static_cast<int>(clamp(factor * (element.b - 128) + 128, 0.0f, 255.0f));
        }
    }
}

