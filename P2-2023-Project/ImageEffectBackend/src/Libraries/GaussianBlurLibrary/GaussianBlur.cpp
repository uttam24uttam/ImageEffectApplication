#include "GaussianBlur.h"
#include "../Pixel.h"
#include<bits/stdc++.h>
using namespace std;

// void applyGaussianBlur(vector<vector<Pixel>>& image, float radius) {
//     int height = image.size();
//     int width = image[0].size();

//     vector<vector<Pixel>> blurredImage(height, vector<Pixel>(width));

//     int intRadius = static_cast<int>(ceil(radius));
//     vector<float> kernel(2 * intRadius + 1, 0.0f);
//     float sigma = radius / 3.0f;
//     float sigmaSquared = 2.0f * sigma * sigma;
//     float sum = 0.0f;

//     for (int x = -intRadius; x <= intRadius; ++x) {
//         float expVal = exp(-(x * x) / sigmaSquared);
//         kernel[x + intRadius] = expVal;
//         sum += expVal;
//     }

//     for (int i = 0; i < kernel.size(); ++i) {
//         kernel[i] /= sum;
//     }

//     vector<vector<Pixel>> tempImage = image;

//     for (int i = 0; i < height; ++i) {
//         for (int j = intRadius; j < width - intRadius; ++j) {
//             Pixel blurValue;
//             for (int x = -intRadius; x <= intRadius; ++x) {
//                 blurValue.r += kernel[x + intRadius] * image[i][j + x].r;
//                 blurValue.g += kernel[x + intRadius] * image[i][j + x].g;
//                 blurValue.b += kernel[x + intRadius] * image[i][j + x].b;
//             }
//             blurredImage[i][j] = blurValue;
//         }
//     }

//     for (int i = intRadius; i < height - intRadius; ++i) {
//         for (int j = 0; j < width; ++j) {
//             Pixel blurValue;
//             for (int y = -intRadius; y <= intRadius; ++y) {
//                 blurValue.r += kernel[y + intRadius] * blurredImage[i + y][j].r;
//                 blurValue.g += kernel[y + intRadius] * blurredImage[i + y][j].g;
//                 blurValue.b += kernel[y + intRadius] * blurredImage[i + y][j].b;
//             }
//             tempImage[i][j] = blurValue;
//         }
//     }

//     image = tempImage;

// }


// #include <vector>
// #include <cmath>
// #include<bits/stdc++.h> 
// using namespace std;

void gaussianBlur(const vector<vector<float>>& imageVector, float radius) {
    int size=static_cast<int>(2*radius+1);
    int halfSize=size/2;

    vector<vector<float>> blurredImage(imageVector.size(), vector<float>(imageVector[0].size(), 0.0));

    vector<vector<float>> kernel(size, vector<float>(size));
    float sigma=radius/3.0;
    float sum=0.0;

    for (int x=-halfSize; x <= halfSize; ++x) {
        for (int y=-halfSize; y <= halfSize; ++y) {
            float exponent=-(x*x+y*y)/(2*sigma*sigma);
            kernel[x+halfSize][y+halfSize]=exp(exponent)/(2*M_PI*sigma*sigma);
            sum += kernel[x+halfSize][y+halfSize];
        }
    }
    for (int i=0; i<size; ++i) {
        for (int j=0; j<size; ++j) {
            kernel[i][j] /= sum;
        }
    }
    for (size_t i=halfSize; i<imageVector.size() - halfSize; ++i) {
        for (size_t j=halfSize; j<imageVector[i].size() - halfSize; ++j) {
            float newValue=0.0;
            for (int x=-halfSize; x <= halfSize; ++x) {
                for (int y=-halfSize; y <= halfSize; ++y) {
                    newValue += imageVector[i+x][j+y]*kernel[x+halfSize][y+halfSize];
                }
            }
            blurredImage[i][j]=newValue;
        }
    }

    
}