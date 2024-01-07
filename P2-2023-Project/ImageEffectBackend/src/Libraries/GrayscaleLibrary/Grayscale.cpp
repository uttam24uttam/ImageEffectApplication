#include "Grayscale.h"
#include "../Pixel.h"
#include <vector>

using namespace std;

// Function to apply the grayscale effect to an image represented by a 2D vector of Pixels
void GrayscaleImageEffect(vector<vector<Pixel>>& imageVector){
	for(auto& row:imageVector){
		for(auto& pix:row){
			//Calculating the value of grayscale
			int grayscale = static_cast<int>(0.2989*pix.r + 0.5870*pix.g + 0.1140*pix.b);

			//Setting grayscale value for each channel of the pixel
			pix.r = grayscale;
			pix.g = grayscale;
			pix.b = grayscale;
		}
	}
}

