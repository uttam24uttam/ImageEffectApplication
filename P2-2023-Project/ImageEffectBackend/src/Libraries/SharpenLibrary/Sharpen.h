#ifndef SHARPEN_H
#define SHARPEN_H
#include "../Pixel.h"
#include<bits/stdc++.h>
using namespace std;
vector<vector<Pixel>> padImage(vector<vector<Pixel>>& image, float paddingSize);
void applySharpenFilter(vector<vector<Pixel>>& imageVector, float amount);
#endif