#include "Flip.h"
#include <bits/stdc++.h>
using namespace std;

// Function to apply flipping operations to the image
void applyImageFlip(vector<vector<Pixel>>& imageVector, int horizontalFlipValue, int verticalFlipValue) {
    //Horizontal flip
	if (horizontalFlipValue!=0){
        for (auto& row : imageVector) {
            int start=0;
            int end=row.size()-1;
            while (start<end) {
                //Swapping pixels horizontally within each row
                swap(row[start], row[end]);
                start++;end--;}                
           }
        }
        //Vertical flip
        if (verticalFlipValue!=0) {
        int start=0;
        int end=imageVector.size()-1;
        while (start<end) {
            //Swapping rows to do vertical flip
            swap(imageVector[start],imageVector[end]);
            start++;end--;
        }
    }
} 

