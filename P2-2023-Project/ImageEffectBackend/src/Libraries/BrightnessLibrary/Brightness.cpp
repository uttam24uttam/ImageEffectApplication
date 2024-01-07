#include "Brightness.h"
#include <vector>
#include "../Pixel.h"
using namespace std;

// Function to apply brightness adjustment to an image which is represented by a 2d vector of pixels
void apply_brightness_cpp(vector<vector<Pixel>>& imagevector, float amount) {
    //Shifting brightness range
    amount = amount - 50;
    //iterating through each pixel prsent in each row of the image
    for (auto& row : imagevector) {
        for (auto& pixel : row) {
            // Increase or decrease brightness for each channel (r, g, b)
            pixel.r = static_cast<int>(static_cast<float>(pixel.r)  +  amount);
            pixel.g = static_cast<int>(static_cast<float>(pixel.g) + amount);
            pixel.b = static_cast<int>(static_cast<float>(pixel.b) + amount);

            // Ensure values are within the valid range (0 - 255)
            pixel.r = min(max(pixel.r, 0), 255);
            pixel.b = min(max(pixel.b, 0), 255);
            pixel.g = min(max(pixel.g, 0), 255);
        }
    }
}