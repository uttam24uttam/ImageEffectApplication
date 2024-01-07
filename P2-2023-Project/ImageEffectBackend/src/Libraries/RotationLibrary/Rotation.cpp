#include "Rotation.h"
#include <vector>
#include <iostream>

using namespace std;

// void applyRotation(vector< vector <Pixel> >& imageVector,int value){
//     int numRows = imageVector.size();
//     int numCols = imageVector[0].size();
//     if ( value == 90){
//         vector<vector <Pixel> > arr1(numCols, vector<Pixel>(numRows));
//         for (int j = 0; j < numRows; j++) {

//             for(int k = 0;k < numCols ; k++){
//                 arr1[k][numCols - j] = imageVector[j][k];
//             }
//         }

//        // imageVector.clear();
//         imageVector.resize(numCols,vector<Pixel>(numRows));
//         for (int i = 0; i < arr1.size(); ++i) {
//             for (int j = 0; j < arr1[i].size(); ++j) {
//                 imageVector[i][j] = arr1[i][j];
//             }
//         }

//     }
// 
//     else if( value == 180 ){
//         for (int j = 0; j < numCols; j++) {
//             int start = 0;
//             int end = numRows-1;

//             while (start < end) {
//                 swap(imageVector[start][j], imageVector[end][j]);
//                 start++;
//                 end--;
//             }
//         }
//     }

//     else if (value == 270){
//         vector<vector <Pixel> > arr1(numCols, vector<Pixel>(numRows));
//         for (int j = 0; j < numRows; j++) {

//             for(int k = 0;k < numCols ; k++){
//                 arr1[k][j] = imageVector[j][k];
//             }
//         }

//         for (int j = 0; j < numRows; j++) {
//             int start = 0;
//             int end = numCols-1;

//             while (start < end) {
//                 swap(arr1[start][j], arr1[end][j]);
//                 start++;
//                 end--;
//             }
//         }

//         imageVector.clear();
//         imageVector.resize(numCols,vector<Pixel>(numRows));
//         for (int i = 0; i < arr1.size(); ++i) {
//             for (int j = 0; j < arr1[i].size(); ++j) {
//                 imageVector[i][j] = arr1[i][j];
//             }
//         }
        
//     }
//     else{

//     }

    
// }

// // void applyRotation(vector<vector<Pixel>>& imageVector, int value) {
//     int numRows = imageVector.size();
//     int numCols = imageVector[0].size();

//     if (value == 90) {
//         vector<vector<Pixel>> arr1(numCols, vector<Pixel>(numRows));

//         for (int i = 0; i < numRows; ++i) {
//             for (int j = 0; j < numCols; ++j) {
//                 arr1[j][numRows - 1 - i] = imageVector[i][j];
//             }
//         }

//         imageVector = arr1; // Update imageVector with rotated values
//     } else if (value == 180) {
//         for (int i = 0; i < numRows / 2; ++i) {
//             for (int j = 0; j < numCols; ++j) { 
//                 swap(imageVector[i][j], imageVector[numRows - 1 - i][numCols - 1 - j]);
//             }
//         }
//     } else if (value == 270) {
//         vector<vector<Pixel>> arr1(numCols, vector<Pixel>(numRows));

//         for (int i = 0; i < numRows; ++i) {
//             for (int j = 0; j < numCols; ++j) {
//                 arr1[numCols - 1 - j][i] = imageVector[i][j];
//             }
//         }

//         imageVector = arr1; // Update imageVector with rotated values
//     } else {
//         // Handle other cases or do nothing for invalid value
//     }
// }
// #include <vector>
// #include "Pixel.h" // Assume Pixel structure is defined in Pixel.h

// Function to apply rotation to a 2D image vector based on the given degree


// // void applyRotation(vector<vector<Pixel>>& imageVector, int value) {
//     int numRows = imageVector.size();
//     int numCols = imageVector[0].size();

//     if (value == 90) {
//         // Create a temporary vector to store rotated pixels
//         vector<vector<Pixel>> rotated(numCols, std::vector<Pixel>(numRows));

//         // Apply rotation logic for 90 degrees
//         for (int i = 0; i < numRows; ++i) {
//             for (int j = 0; j < numCols; ++j) {
//                 rotated[j][numRows - 1 - i] = imageVector[i][j];
//             }
//         }

//         // Update the original vector with the rotated pixels
//         imageVector = rotated;
//     } else if (value == 180) {
//         // Apply rotation logic for 180 degrees (flip horizontally and vertically)
//         for (int i = 0; i < numRows / 2; ++i) {
//             for (int j = 0; j < numCols; ++j) {
//                 swap(imageVector[i][j], imageVector[numRows - 1 - i][numCols - 1 - j]);
//             }
//         }
//     } else if (value == 270) {
//         // Create a temporary vector to store rotated pixels
//         vector<vector<Pixel>> rotated(numCols, vector<Pixel>(numRows));

//         // Apply rotation logic for 270 degrees
//         for (int i = 0; i < numRows; ++i) {
//             for (int j = 0; j < numCols; ++j) {
//                 rotated[numCols - 1 - j][i] = imageVector[i][j];
//             }
//         }

//         // Update the original vector with the rotated pixels
//         imageVector = rotated;
//     } else if (value == 0) {
//         // For 0-degree rotation, no changes are needed
//         // You might add handling or leave it as it is
//     } else {
//         // Handle other cases or do nothing for invalid value
//     }
// }
#include "Rotation.h"
#include <vector>
#include "../Pixel.h"
#include<bits/stdc++.h>
#include <cmath> // Include cmath for trigonometric functions like sin and cos

using namespace std;

// Function to rotate an image by a specified angle
void applyRotation(vector<vector<Pixel>>& imageVector, int angle) 
{
    // Convert the angle to radians
    double radians = angle * (M_PI / 180.0);

    int rows = static_cast<int>(imageVector.size());
    int cols = static_cast<int>(imageVector[0].size());

    // Define center of rotation
    double centerX = cols / 2.0;
    double centerY = rows / 2.0;

    // Create a new vector to hold the rotated image
    vector<vector<Pixel>> rotatedImage(rows, vector<Pixel>(cols));

    for (int y = 0; y < rows; ++y) 
    {
        for (int x = 0; x < cols; ++x) 
        {
            // Translate the coordinates to the center
            double translatedX = x - centerX;
            double translatedY = y - centerY;

            // Apply rotation transformation
            int newX = static_cast<int>((translatedX * cos(radians)) - (translatedY * sin(radians)) + centerX);
            int newY = static_cast<int>((translatedX * sin(radians)) + (translatedY * cos(radians)) + centerY);

            // Check bounds to avoid out-of-bounds access
            if (newX >= 0 && newX < cols && newY >= 0 && newY < rows) 
            {
                rotatedImage[newY][newX] = imageVector[y][x];
            }
        }
    }

    // Update the original image vector with the rotated image
    imageVector = rotatedImage;
}