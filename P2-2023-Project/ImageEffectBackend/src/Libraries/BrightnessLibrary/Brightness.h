#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H
#include <vector>
#include "../Pixel.h"

using namespace std;
// Function prototype for applying brightness adjustment to an image
void apply_brightness_cpp(vector<vector<Pixel>>& imageVector, float amount);
#endif