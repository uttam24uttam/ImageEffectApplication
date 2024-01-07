#include "Invert.h"
#include <vector>
#include <iostream>

using namespace std;

void applyInvert(vector <vector <Pixel> >& imageVector){
    int numRows = imageVector.size();
    int numCols = imageVector[0].size();

    for (int j = 0; j < numCols; j++) {
        for(int k=0;k<numRows;k++){
            imageVector[k][j].r = 255 - imageVector[k][j].r;
            imageVector[k][j].g = 255 - imageVector[k][j].g;
            imageVector[k][j].b = 255 - imageVector[k][j].b;
        }
    }
}