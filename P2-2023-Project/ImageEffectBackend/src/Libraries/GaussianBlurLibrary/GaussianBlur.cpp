#include "GaussianBlur.h"
#include "../Pixel.h"
#include<bits/stdc++.h>
using namespace std;


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
